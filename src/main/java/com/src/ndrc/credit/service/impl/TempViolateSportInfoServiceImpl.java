/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.ndrc.credit.mapper.TempViolateSportInfoMapper;
import com.icinfo.ndrc.credit.model.TempViolateSportInfo;
import com.icinfo.ndrc.credit.service.ITempViolateSportInfoService;
import com.icinfo.ndrc.util.FileUtil;

/**
 * 描述:    temp_violate_sport_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月30日
 */
@Service("tempViolateSportInfoService")
public class TempViolateSportInfoServiceImpl extends MyBatisServiceSupport implements ITempViolateSportInfoService {

	@Autowired
	private TempViolateSportInfoMapper tempViolateSportInfoMapper;

	public static final String TITLE = ",处理时间,处理事由,处理情况,当事人姓名,身份证号";
	
	public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public void deleteByBatchNo(String batchNO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 读取Excel存取
	 * @author fanzhen
	 * @date 20170629
	 * @param deptName
	 * @param sheet
	 * @param bacthNO
	 * @return
	 * @throws Exception
	 */
	@Override
	public String record(String deptName, HSSFSheet sheet, String bacthNO) throws Exception {
		int rowNum = sheet.getLastRowNum();
		HSSFRow row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        TempViolateSportInfo info = new TempViolateSportInfo();
        
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
				if("".equals(FileUtil.getCell(row.getCell(1))))
					return "error,sheet名为"+sheet.getSheetName()+"的第"+(i+1)+"行第2列数据不能为空";
				
				if(FileUtil.getCell(row.getCell(0))!=""){
					info.setDealTime(SDF.parse(FileUtil.getCell(row.getCell(0))));
				}
				info.setDealReson(FileUtil.getCell(row.getCell(1)));
				info.setDealSituation(FileUtil.getCell(row.getCell(2)));
				info.setPartyName(FileUtil.getCell(row.getCell(3)));
				info.setIdCard(FileUtil.getCell(row.getCell(4)));
				
				info.setBatchNO(bacthNO);
				info.setImportDept(deptName);
				info.setImportTime(new Date());
				info.setIsUse("0");
				tempViolateSportInfoMapper.insert(info);
			}
		} catch (Exception e) {
			return "error,sheet名为"+sheet.getSheetName()+"的第"+(i+1)+"行数据格式不正确";
		}
		return "success,上传成功";
	}
}