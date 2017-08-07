/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.ndrc.credit.mapper.TempPeopleQualiInfoMapper;
import com.icinfo.ndrc.credit.model.TempCreditLevelResult;
import com.icinfo.ndrc.credit.model.TempPeopleQualiInfo;
import com.icinfo.ndrc.credit.service.ITempPeopleQualiInfoService;
import com.icinfo.ndrc.util.DateUtil;
import com.icinfo.ndrc.util.FileUtil;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:  temp_people_quali_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月29日
 */
@Service
public class TempPeopleQualiInfoServiceImpl extends MyBatisServiceSupport implements ITempPeopleQualiInfoService {

    @Autowired
    private TempPeopleQualiInfoMapper tempPeopleQualiInfoMapper;

    private final static String TITLE_CZC = ",人员姓名,资格证书,身份证号,新增时间,有效期起,有效期止,信用评价,服务车号";
    private final static String TITLE_HY = ",人员姓名,从业种类,资格证书,身份证号,新增时间,有效期起,有效期止,信用评价（省）";
	private final static String TITLE_WX = ",姓名,身份证号,证件编号";

	private final static String SHEETNAME_CZC = "道路运输从业人员资格信息及信用评价结果（出租车人员）";
	private final static String SHEETNAME_HY = "道路运输从业人员资格信息及信用评价结果（客、货运从业人员）";
	private final static String SHEETNAME_WX = "道路运输从业人员资格信息（维修）";


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
		} else if (sheetName.equals(SHEETNAME_WX)) {
			title = TITLE_WX;
		}

		if (!title.equals(msg)) {
			return "error," + sheet.getSheetName() + "的第一行内容格式不正确";
		}

		int i = 1;
		TempPeopleQualiInfo info = new TempPeopleQualiInfo();
		try {
			for (i = 1; i <= rowNum; i++) {
				row = sheet.getRow(i);
				if (StringUtils.isBlank(FileUtil.getCell(row.getCell(0))))
					return "error,sheet名为" + sheetName + "的第" + (i + 1) + "行第1列数据不能为空";
				
				if(sheetName.equals(SHEETNAME_CZC)){
					info.setPeoName(FileUtil.getCell(row.getCell(0)));
					info.setCertFile(FileUtil.getCell(row.getCell(1)));
					info.setIdNO(FileUtil.getCell(row.getCell(2)));
					info.setNewDate(DateUtil.stringToDate(FileUtil.getCell(row.getCell(3)), "yyyy-MM-dd"));
					info.setValDateStart(DateUtil.stringToDate(FileUtil.getCell(row.getCell(4)), "yyyy-MM-dd"));
					info.setValDateEnd(DateUtil.stringToDate(FileUtil.getCell(row.getCell(5)), "yyyy-MM-dd"));
					info.setCreEvaluate(FileUtil.getCell(row.getCell(6)));
					info.setServerNO(FileUtil.getCell(row.getCell(7)));
				}else if(sheetName.equals(SHEETNAME_HY)){
					info.setPeoName(FileUtil.getCell(row.getCell(0)));
					info.setIndType(FileUtil.getCell(row.getCell(1)));
					info.setCertFile(FileUtil.getCell(row.getCell(2)));
					info.setIdNO(FileUtil.getCell(row.getCell(3)));
					info.setNewDate(DateUtil.stringToDate(FileUtil.getCell(row.getCell(4)), "yyyy-MM-dd"));
					info.setValDateStart(DateUtil.stringToDate(FileUtil.getCell(row.getCell(5)), "yyyy-MM-dd"));
					info.setValDateEnd(DateUtil.stringToDate(FileUtil.getCell(row.getCell(6)), "yyyy-MM-dd"));
					info.setCreEvaluate(FileUtil.getCell(row.getCell(7)));
				}else if(sheetName.equals(SHEETNAME_WX)){
					info.setPeoName(FileUtil.getCell(row.getCell(0)));
					info.setIdNO(FileUtil.getCell(row.getCell(1)));
					info.setCerNO(FileUtil.getCell(row.getCell(2)));
				}
				
				info.setCertType(sheetName);
				
				info.setBatchNO(bacthNO);
				info.setImportDept(deptCode);
				info.setImportTime(new Date());
				info.setIsUse("0");

				tempPeopleQualiInfoMapper.insert(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error,sheet名为" + sheetName + "的第" + (i + 1) + "行数据格式不正确";
		}
		return "success,上传成功";
	}
	
	
	@Override
	public void deleteByBatchNo(String batchNO) throws Exception {
		Example example = new Example(TempPeopleQualiInfo.class);
		example.createCriteria().andEqualTo("batchNO", batchNO);
		tempPeopleQualiInfoMapper.deleteByExample(example);		
	}
}