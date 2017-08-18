/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.ndrc.credit.mapper.TempHealthYearcheckInfoMapper;
import com.icinfo.ndrc.credit.model.TempHealthYearcheckInfo;
import com.icinfo.ndrc.credit.service.ITempHealthYearcheckInfoService;
import com.icinfo.ndrc.util.DateUtil;
import com.icinfo.ndrc.util.FileUtil;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:  temp_health_yearcheck_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月29日
 */
@Service
public class TempHealthYearcheckInfoServiceImpl extends MyBatisServiceSupport implements ITempHealthYearcheckInfoService {

    @Autowired
    private TempHealthYearcheckInfoMapper tempHealthYearcheckInfoMapper;

    private final static String TITLE = ",医疗机构名称,社会信用代码/组织机构代码/工商注册号,下一校验日期,有效期开始日期,有效期截止日期";

	@Override
	public String record(String depCode, HSSFSheet sheet, String bacthNO) throws Exception {
		String sheetName = sheet.getSheetName();
		int rowNum = sheet.getLastRowNum();
		HSSFRow row = sheet.getRow(0);
		int colNum = row.getPhysicalNumberOfCells();

		String msg = "";
		for (int j = 0; j < colNum; j++) {
			msg = msg + "," + FileUtil.getCell(row.getCell(j));
		}

		if (!TITLE.equals(msg)) {
			return "error," + sheet.getSheetName() + "的第一行内容格式不正确";
		}

		int i = 1;
		TempHealthYearcheckInfo info = new TempHealthYearcheckInfo();
		try {
			for (i = 1; i <= rowNum; i++) {
				row = sheet.getRow(i);
				if (StringUtils.isBlank(FileUtil.getCell(row.getCell(0))))
					return "error,sheet名为" + sheetName + "的第" + (i + 1) + "行第1列数据不能为空";
				
				info.setUnName(FileUtil.getCell(row.getCell(0)));
				info.setUniscid(FileUtil.getCell(row.getCell(1)));
				info.setNextCheckDate(DateUtil.stringToDate(FileUtil.getCell(row.getCell(2)), "yyyy-MM-dd"));
				info.setValDateStart(DateUtil.stringToDate(FileUtil.getCell(row.getCell(3)), "yyyy-MM-dd"));
				info.setValDateEnd(DateUtil.stringToDate(FileUtil.getCell(row.getCell(4)), "yyyy-MM-dd"));
				
				
				info.setBatchNO(bacthNO);
				info.setImportDept(depCode);
				info.setImportTime(new Date());
				info.setIsUse("0");

				tempHealthYearcheckInfoMapper.insert(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error,sheet名为" + sheetName + "的第" + (i + 1) + "行数据格式不正确";
		}
		return "success,上传成功";
	}
	
	@Override
	public void deleteByBatchNo(String batchNO) throws Exception {
		Example example = new Example(TempHealthYearcheckInfo.class);
		example.createCriteria().andEqualTo("batchNO", batchNO);
		tempHealthYearcheckInfoMapper.deleteByExample(example);			
	}
}