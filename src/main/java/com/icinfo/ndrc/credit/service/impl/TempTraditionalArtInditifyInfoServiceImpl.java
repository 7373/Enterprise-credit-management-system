/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.ndrc.credit.mapper.TempTraditionalArtInditifyInfoMapper;
import com.icinfo.ndrc.credit.model.TempTraditionalArtInditifyInfo;
import com.icinfo.ndrc.credit.service.ITempTraditionalArtInditifyInfoService;
import com.icinfo.ndrc.util.FileUtil;

/**
 * 描述:    temp_traditional_arts_inditify_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月29日
 */
@Service("tempTraditionalArtInditifyInfoService")
public class TempTraditionalArtInditifyInfoServiceImpl extends MyBatisServiceSupport implements ITempTraditionalArtInditifyInfoService {

	@Autowired
	private TempTraditionalArtInditifyInfoMapper tempTraditionalArtInditifyInfoMapper;

	public final static String TITLE = ",项目名称,项目内容,大师姓名,大师身份证号码,性别,技艺门类";
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
        TempTraditionalArtInditifyInfo info = new TempTraditionalArtInditifyInfo();
        
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
				
				info.setProjectName(FileUtil.getCell(row.getCell(0)));
				info.setProjectContent(FileUtil.getCell(row.getCell(1)));
				info.setTeacherName(FileUtil.getCell(row.getCell(2)));
				info.setTeacherIdCard(FileUtil.getCell(row.getCell(3)));
				info.setSex(FileUtil.getCell(row.getCell(4)));
				
				info.setSkillCategory(FileUtil.getCell(row.getCell(5)));
				info.setBatchNO(bacthNO);
				info.setImportDept(deptName);
				info.setImportTime(new Date());
				info.setIsUse("0");
				tempTraditionalArtInditifyInfoMapper.insert(info);
			}
		} catch (Exception e) {
			return "error,sheet名为"+sheet.getSheetName()+"的第"+(i+1)+"行数据格式不正确";
		}
		return "success,上传成功";
	}
	
	
}