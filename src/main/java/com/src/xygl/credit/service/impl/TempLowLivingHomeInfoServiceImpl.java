/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.ndrc.credit.mapper.TempEnvirEffectCheckInfoMapper;
import com.icinfo.ndrc.credit.mapper.TempLowLivingHomeInfoMapper;
import com.icinfo.ndrc.credit.model.TempEnvirEffectCheckInfo;
import com.icinfo.ndrc.credit.model.TempLowLivingHomeInfo;
import com.icinfo.ndrc.credit.service.ITempLowLivingHomeInfoService;
import com.icinfo.ndrc.util.FileUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    temp_low_living_home_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月29日
 */
@Service
public class TempLowLivingHomeInfoServiceImpl extends MyBatisServiceSupport implements ITempLowLivingHomeInfoService {
	@Autowired
	private TempLowLivingHomeInfoMapper tempLowLivingHomeInfoMapper;
	public final static String TITLE = ",户编号,户主姓名,户主身份证号,家庭居住地址,家庭户籍地址,救助类别,救助证号,家庭享受待遇人数,家庭人口,本次救助待遇享受期限,最近一次审批时间";
	public final static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public String record(String deptName, HSSFSheet sheet, String bacthNO) throws Exception {
		int rowNum = sheet.getLastRowNum();
		HSSFRow row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        TempLowLivingHomeInfo info = new TempLowLivingHomeInfo();
        
        String msg = "";
        for(int j=0;j<colNum;j++){
        	msg=msg+","+FileUtil.getCell(row.getCell(j));
        }
        if(!TITLE.equals(msg))
        {
        	return "error,"+sheet.getSheetName()+"的第一行内容格式不正确";
        }
        int i=1;
		try {
			for(i=1;i<=rowNum;i++){
				row = sheet.getRow(i);
				if("".equals(FileUtil.getCell(row.getCell(0))))
					return "error,sheet名为"+sheet.getSheetName()+"的第"+(i+1)+"行第1列数据不能为空";
				
				info.setHomeNO(FileUtil.getCell(row.getCell(0)));
				info.setName(FileUtil.getCell(row.getCell(1)));
				info.setCertNO(FileUtil.getCell(row.getCell(2)));
				info.setHomeAddr(FileUtil.getCell(row.getCell(3)));
				info.setPermanentAddr(FileUtil.getCell(row.getCell(4)));
				info.setHelpType(FileUtil.getCell(row.getCell(5)));
				info.setHelpCertNO(FileUtil.getCell(row.getCell(6)));
				info.setBenefitsNum(FileUtil.getCell(row.getCell(7)));
				info.setFamilyPopulation(FileUtil.getCell(row.getCell(8)));
				info.setEnjoyHelpDate(FileUtil.getCell(row.getCell(9))==""?null:SDF.parse(FileUtil.getCell(row.getCell(9))));
				info.setRecentCheckDate(FileUtil.getCell(row.getCell(10))==""?null:SDF.parse(FileUtil.getCell(row.getCell(10))));
				info.setBatchNO(bacthNO);
				info.setImportDept(deptName);
				info.setImportTime(new Date());
				info.setIsUse("0");
				tempLowLivingHomeInfoMapper.insert(info);
			}
		} catch (Exception e) {
			return "error,sheet名为"+sheet.getSheetName()+"的第"+(i+1)+"行数据格式不正确";
		}
		return "success,上传成功";
	}

	@Override
	public void deleteByBatchNo(String batchNO) throws Exception {
		// TODO Auto-generated method stub
		
	}
}