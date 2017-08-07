/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.ndrc.credit.mapper.TempCreditLevelResultMapper;
import com.icinfo.ndrc.credit.model.TempCreditLevelResult;
import com.icinfo.ndrc.credit.service.ITempCreditLevelResultService;
import com.icinfo.ndrc.util.FileUtil;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述: temp_credit_level_result 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月29日
 */
@Service
public class TempCreditLevelResultServiceImpl extends MyBatisServiceSupport implements ITempCreditLevelResultService {

	@Autowired
	private TempCreditLevelResultMapper tempCreditLevelResultMapper;
	private final static String TITLE_HY = ",企业名称,社会信用代码/组织机构代码/工商注册号,考核等级（省）";
	private final static String TITLE_CZC = ",企业名称,社会信用代码/组织机构代码/工商注册号,考核等级";
	private final static String TITLE_JPXX = ",学校名称,社会信用代码/组织机构代码/工商注册号,信用等级";
	private final static String TITLE_WXQY = ",企业名称,社会信用代码/组织机构代码/工商注册号,信用考核等级";
	private final static String TITLE_ZLQY = ",业户名称,社会信用代码/组织机构代码/工商注册号,信用等级,备案证书";

	private final static String SHEETNAME_HY = "交通企业信用等级考核结果信息（客、货运、场站）";
	private final static String SHEETNAME_CZC = "交通企业信用等级考核结果信息（出租车）";
	private final static String SHEETNAME_JPXX = "交通企业信用等级考核结果信息（驾培学校）";
	private final static String SHEETNAME_WXQY = "交通企业信用等级考核结果信息（维修企业）";
	private final static String SHEETNAME_ZLQY = "交通企业信用等级考核结果信息（租赁企业）";

	@Override
	public String record(String deptCode, HSSFSheet sheet, String bacthNO) throws Exception {
		String title = "";
		String sheetName = sheet.getSheetName();
		int rowNum = sheet.getLastRowNum();
		HSSFRow row = sheet.getRow(0);
		int colNum = row.getPhysicalNumberOfCells();

		String msg = "";
		for (int j = 0; j < colNum; j++) {
			msg = msg + "," + FileUtil.getCell(row.getCell(j));
		}

		if (sheetName.equals(SHEETNAME_HY)) {
			title = TITLE_HY;
		} else if (sheetName.equals(SHEETNAME_CZC)) {
			title = TITLE_CZC;
		} else if (sheetName.equals(SHEETNAME_JPXX)) {
			title = TITLE_JPXX;
		} else if (sheetName.equals(SHEETNAME_WXQY)) {
			title = TITLE_WXQY;
		} else if (sheetName.equals(SHEETNAME_ZLQY)) {
			title = TITLE_ZLQY;
		}

		if (!title.equals(msg)) {
			return "error," + sheet.getSheetName() + "的第一行内容格式不正确";
		}

		int i = 1;
		TempCreditLevelResult info = new TempCreditLevelResult();
		try {
			for (i = 1; i <= rowNum; i++) {
				row = sheet.getRow(i);
				if (StringUtils.isBlank(FileUtil.getCell(row.getCell(0))))
					return "error,sheet名为" + sheetName + "的第" + (i + 1) + "行第1列数据不能为空";
				info.setEntName(FileUtil.getCell(row.getCell(0)));
				info.setUnicode(FileUtil.getCell(row.getCell(1)));
				info.setCreditLevel(FileUtil.getCell(row.getCell(2)));
				
				if(sheetName.equals(SHEETNAME_ZLQY)){
					info.setCertificate(FileUtil.getCell(row.getCell(3)));
				}
				
				info.setCertType(sheetName);
				
				info.setBatchNO(bacthNO);
				info.setImportDept(deptCode);
				info.setImportTime(new Date());
				info.setIsUse("0");

				tempCreditLevelResultMapper.insert(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error,sheet名为" + sheetName + "的第" + (i + 1) + "行数据格式不正确";
		}
		return "success,上传成功";
	}

	@Override
	public void deleteByBatchNo(String batchNO) throws Exception {
		Example example = new Example(TempCreditLevelResult.class);
		example.createCriteria().andEqualTo("batchNO", batchNO);
		tempCreditLevelResultMapper.deleteByExample(example);
	}
}