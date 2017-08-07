/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.ndrc.credit.mapper.TempPublicSchoolInfoMapper;
import com.icinfo.ndrc.credit.model.TempPublicSchoolInfo;
import com.icinfo.ndrc.credit.service.ITempPublicSchoolInfoService;
import com.icinfo.ndrc.util.FileUtil;

/**
 * 描述:    temp_public_school_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月28日
 */
@Service("tempPublicSchoolInfoService")
public class TempPublicSchoolInfoServiceImpl extends MyBatisServiceSupport implements ITempPublicSchoolInfoService {
										
	private static final String TITLE = ",单位名称,社会信用代码/工商注册号/组织机构代码,单位地址,法人名称,联系电话";
	
	@Autowired
	private TempPublicSchoolInfoMapper tempPublicSchoolInfoMapper;
	@Override
	public void deleteByBatchNo(String batchNO) throws Exception {
		tempPublicSchoolInfoMapper.DeleteByBatchNo(batchNO);
		
	}
	@Override
	public String record(String deptName, HSSFSheet sheet, String bacthNO) throws Exception {
		int rowNum = sheet.getLastRowNum();
		HSSFRow row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        TempPublicSchoolInfo info = new TempPublicSchoolInfo();
        
        String msg = "";
        for(int j=0;j<colNum;j++){
        	if(StringUtils.isNotBlank(FileUtil.getCell(row.getCell(j))))
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
				info.setUnitAddr(FileUtil.getCell(row.getCell(2)));
				info.setLegalName(FileUtil.getCell(row.getCell(3)));
				info.setTel(FileUtil.getCell(row.getCell(4)));
				
				info.setImportDept(deptName);
				info.setImportTime(new Date());
				info.setBatchNO(bacthNO);
				tempPublicSchoolInfoMapper.insert(info);	
			}
		} catch (Exception e) {
			return "error,sheet名为"+sheet.getSheetName()+"的第"+(i+1)+"行数据格式不正确";
		}
		return "success,上传成功";
	}
}