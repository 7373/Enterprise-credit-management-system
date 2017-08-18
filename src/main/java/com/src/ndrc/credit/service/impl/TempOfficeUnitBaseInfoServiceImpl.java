/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.ndrc.credit.mapper.TempOfficeBaseInfoMapper;
import com.icinfo.ndrc.credit.mapper.TempOfficeUnitBaseInfoMapper;
import com.icinfo.ndrc.credit.model.TempOfficeBaseInfo;
import com.icinfo.ndrc.credit.model.TempOfficeUnitBaseInfo;
import com.icinfo.ndrc.credit.service.ITempOfficeUnitBaseInfoService;
import com.icinfo.ndrc.util.FileUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    temp_office_unit_base_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月29日
 */
@Service
public class TempOfficeUnitBaseInfoServiceImpl extends MyBatisServiceSupport implements ITempOfficeUnitBaseInfoService {
	@Autowired
	private TempOfficeUnitBaseInfoMapper tempOfficeUnitBaseInfoMapper;
	public final static String TITLE = ",单位名称,社会信用代码/组织机构代码,单位性质,单位地址";
	public final static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public String record(String deptName, HSSFSheet sheet, String bacthNO) throws Exception {
		int rowNum = sheet.getLastRowNum();
		HSSFRow row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        TempOfficeUnitBaseInfo info = new  TempOfficeUnitBaseInfo();
        
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
				info.setUnitName(FileUtil.getCell(row.getCell(0)));
				info.setUnicode(FileUtil.getCell(row.getCell(1)));
				info.setUnitNature(FileUtil.getCell(row.getCell(2)));
				info.setUnitAddr(FileUtil.getCell(row.getCell(3)));
				info.setBatchNO(bacthNO);
				info.setImportDept(deptName);
				info.setImportTime(new Date());
				info.setIsUse("0");
				tempOfficeUnitBaseInfoMapper.insert(info);
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