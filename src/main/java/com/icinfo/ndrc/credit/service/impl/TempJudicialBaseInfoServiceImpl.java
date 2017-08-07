/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.ndrc.credit.mapper.TempJudicialBaseInfoMapper;
import com.icinfo.ndrc.credit.model.TempJudicialBaseInfo;
import com.icinfo.ndrc.credit.service.ITempJudicialBaseInfoService;
import com.icinfo.ndrc.util.FileUtil;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    temp_judicial_base_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月30日
 */
@Service
public class TempJudicialBaseInfoServiceImpl extends MyBatisServiceSupport implements ITempJudicialBaseInfoService {

	@Autowired
	TempJudicialBaseInfoMapper tempJudicialBaseInfoMapper;

	 private final static String TITLE = ",姓名,身份证号,执业证号,执业机构";
	 private final static String TITLE_GZ = ",姓名,身份证号,执业证号,职称级别,执业范围";
	 
	 private final static String SHEETNAME_LS = "律师基本信息";
	 private final static String SHEETNAME_JC = "基层法律服务工作者基本信息";
	 private final static String SHEETNAME_GZ = "公证员基本信息";
	
	@Override
	public String record(String depCode, HSSFSheet sheet, String bacthNO) throws Exception {
		String title = "";
		String sheetName = sheet.getSheetName();
		int rowNum = sheet.getLastRowNum();
		HSSFRow row = sheet.getRow(0);
		int colNum = row.getPhysicalNumberOfCells();

		String msg = "";
		for (int j = 0; j < colNum; j++) {
			msg = msg + "," + FileUtil.getCell(row.getCell(j));
		}

		if (sheetName.equals(SHEETNAME_LS)) {
			title = TITLE;
		} else if (sheetName.equals(SHEETNAME_JC)) {
			title = TITLE;
		} else if (sheetName.equals(SHEETNAME_GZ)) {
			title = TITLE_GZ;
		} 
		
		if (!title.equals(msg)) {
			return "error," + sheet.getSheetName() + "的第一行内容格式不正确";
		}

		int i = 1;
		TempJudicialBaseInfo info = new TempJudicialBaseInfo();
		try {
			for (i = 1; i <= rowNum; i++) {
				row = sheet.getRow(i);
				if (StringUtils.isBlank(FileUtil.getCell(row.getCell(0))))
					return "error,sheet名为" + sheetName + "的第" + (i + 1) + "行第1列数据不能为空";
				
				info.setName(FileUtil.getCell(row.getCell(0)));
				info.setIdCard(FileUtil.getCell(row.getCell(1)));
				info.setWorkCertNO(FileUtil.getCell(row.getCell(2)));
				
				if(sheetName.equals(SHEETNAME_LS) || sheetName.equals(SHEETNAME_JC)){
					info.setWorkUnit(FileUtil.getCell(row.getCell(3)));
				}else if(sheetName.equals(SHEETNAME_GZ)){
					info.setTitleLevel(FileUtil.getCell(row.getCell(3)));
					info.setWorkRange(FileUtil.getCell(row.getCell(4)));
				}
				
				info.setBatchNO(bacthNO);
				info.setImportDept(depCode);
				info.setImportTime(new Date());
				info.setIsUse("0");

				tempJudicialBaseInfoMapper.insert(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error,sheet名为" + sheetName + "的第" + (i + 1) + "行数据格式不正确";
		}
		return "success,上传成功";
	}

	@Override
	public void deleteByBatchNo(String batchNO) throws Exception {
		// TODO Auto-generated method stub
		
	}
}