/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.ndrc.credit.mapper.TempEnvirEffectCheckInfoMapper;
import com.icinfo.ndrc.credit.mapper.TempMarriageInfoMapper;
import com.icinfo.ndrc.credit.model.TempEnvirEffectCheckInfo;
import com.icinfo.ndrc.credit.model.TempMarriageInfo;
import com.icinfo.ndrc.credit.service.ITempMarriageInfoService;
import com.icinfo.ndrc.util.FileUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    temp_marriage_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月29日
 */
@Service
public class TempMarriageInfoServiceImpl extends MyBatisServiceSupport implements ITempMarriageInfoService {
	
	@Autowired
	private TempMarriageInfoMapper tempMarriageInfoMapper;
	public final static String TITLE = ",民政局内码,男方姓名,男方证件类型,男方证件号码,男方常驻户口所在地,女方姓名,女方证件类别,女方证件号码,女方常驻户口所在地,登记日期,证字号,承办机构";
	public final static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public String record(String deptName, HSSFSheet sheet, String bacthNO) throws Exception {
		int rowNum = sheet.getLastRowNum();
		HSSFRow row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        TempMarriageInfo info = new  TempMarriageInfo();
        
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
				info.setCivilAdminUnitCode(FileUtil.getCell(row.getCell(0)));
				info.setManName(FileUtil.getCell(row.getCell(1)));
				info.setManCertType(FileUtil.getCell(row.getCell(2)));
				info.setManCertNO(FileUtil.getCell(row.getCell(3)));
				info.setManResidenceLoc(FileUtil.getCell(row.getCell(4)));
				info.setWoManName(FileUtil.getCell(row.getCell(5)));
				info.setWoManCertType(FileUtil.getCell(row.getCell(6)));
				info.setWoManCertNO(FileUtil.getCell(row.getCell(7)));
				info.setWoManResidenceLoc(FileUtil.getCell(row.getCell(8)));
				info.setRegistDate(FileUtil.getCell(row.getCell(9))==""?null:SDF.parse(FileUtil.getCell(row.getCell(9))));
				info.setCertNum(FileUtil.getCell(row.getCell(10)));
				info.setUndertakeUnit(FileUtil.getCell(row.getCell(11)));
				info.setBatchNO(bacthNO);
				info.setImportDept(deptName);
				info.setImportTime(new Date());
				info.setIsUse("0");
				tempMarriageInfoMapper.insert(info);
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