/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.ndrc.credit.mapper.TempJudicialUnitInfoMapper;
import com.icinfo.ndrc.credit.model.TempJudicialUnitInfo;
import com.icinfo.ndrc.credit.service.ITempJudicialUnitInfoService;
import com.icinfo.ndrc.util.FileUtil;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    temp_judicial_unit_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月30日
 */
@Service
public class TempJudicialUnitInfoServiceImpl extends MyBatisServiceSupport implements ITempJudicialUnitInfoService {

	 private final static String TITLE_JC = ",机构名称,执业许可证号码,社会信用代码/组织机构代码,负责人,地址";
	 private final static String TITLE_LS = ",机构名称,社会信用代码/工商注册号/组织机构代码,执业许可证号码,负责人,地址";
	 private final static String TITLE_GZ = ",机构名称,社会信用代码/工商注册号/组织机构代码,主要职能,法人代表,机构地址";
	 
	 private final static String SHEETNAME_JC = "基层法律服务所信息";
	 private final static String SHEETNAME_LS = "律师事务所信息";
	 private final static String SHEETNAME_GZ = "公证机构基本信息";
	
	 @Autowired
	 TempJudicialUnitInfoMapper tempJudicialUnitInfoMapper;
	
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

		if (sheetName.equals(SHEETNAME_JC)) {
			title = TITLE_JC;
		} else if (sheetName.equals(SHEETNAME_LS)) {
			title = TITLE_LS;
		} else if (sheetName.equals(SHEETNAME_GZ)) {
			title = TITLE_GZ;
		} 
		
		if (!title.equals(msg)) {
			return "error," + sheet.getSheetName() + "的第一行内容格式不正确";
		}

		int i = 1;
		TempJudicialUnitInfo info = new TempJudicialUnitInfo();
		try {
			for (i = 1; i <= rowNum; i++) {
				row = sheet.getRow(i);
				if (StringUtils.isBlank(FileUtil.getCell(row.getCell(0))))
					return "error,sheet名为" + sheetName + "的第" + (i + 1) + "行第1列数据不能为空";
				
				info.setUnitName(FileUtil.getCell(row.getCell(0)));
				if(sheetName.equals(SHEETNAME_JC)){
					info.setLicenceNO(FileUtil.getCell(row.getCell(1)));
					info.setUnicode(FileUtil.getCell(row.getCell(2)));
					info.setLegalPerson(FileUtil.getCell(row.getCell(3)));
				}else if(sheetName.equals(SHEETNAME_LS)){
					info.setUnicode(FileUtil.getCell(row.getCell(1)));
					info.setLicenceNO(FileUtil.getCell(row.getCell(2)));
					info.setLegalPerson(FileUtil.getCell(row.getCell(3)));
				}else if(sheetName.equals(SHEETNAME_GZ)){
					info.setUnicode(FileUtil.getCell(row.getCell(1)));
					info.setMainFunction(FileUtil.getCell(row.getCell(2)));
					info.setLegalPerson(FileUtil.getCell(row.getCell(3)));
				}
				info.setUnitAddr(FileUtil.getCell(row.getCell(4)));
				info.setUnitType(sheetName);
				
				info.setBatchNO(bacthNO);
				info.setImportDept(depCode);
				info.setImportTime(new Date());
				info.setIsUse("0");

				tempJudicialUnitInfoMapper.insert(info);
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