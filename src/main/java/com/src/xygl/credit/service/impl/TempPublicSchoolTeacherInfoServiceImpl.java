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
import com.icinfo.ndrc.credit.mapper.TempPublicSchoolTeacherInfoMapper;
import com.icinfo.ndrc.credit.model.TempPublicSchoolTeacherInfo;
import com.icinfo.ndrc.credit.service.ITempPublicSchoolTeacherInfoService;
import com.icinfo.ndrc.util.FileUtil;

/**
 * 描述:    temp_public_school_teacher_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月28日
 */
@Service("tempPublicSchoolTeacherInfoService")
public class TempPublicSchoolTeacherInfoServiceImpl extends MyBatisServiceSupport implements ITempPublicSchoolTeacherInfoService {

	private final static String TITLE = ",姓名,身份证信息,资格种类,发证机构,发证时间,所获临安市级及以上荣誉和颁布时间";
	@Autowired
	private TempPublicSchoolTeacherInfoMapper tempPublicSchoolTeacherInfoMapper;
	private final static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
	@Override
	public void deleteByBatchNo(String batchNO) throws Exception {

		tempPublicSchoolTeacherInfoMapper.deleteByBatchNo(batchNO);	
	}

	public String record(String deptName, HSSFSheet sheet, String bacthNO) throws Exception {
		int rowNum = sheet.getLastRowNum();
		HSSFRow row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        TempPublicSchoolTeacherInfo info = new TempPublicSchoolTeacherInfo();
        
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
				
				info.setName(FileUtil.getCell(row.getCell(0)));
				info.setIdCard(FileUtil.getCell(row.getCell(1)));
				info.setQuaType(FileUtil.getCell(row.getCell(2)));
				info.setIssueUnit(FileUtil.getCell(row.getCell(3)));
				if(FileUtil.getCell(row.getCell(4)).trim()!=""){
					info.setIssueDate(SDF.parse(FileUtil.getCell(row.getCell(4))));
				}
				if(FileUtil.getCell(row.getCell(5)).trim()!=""){
					info.setGainHonorDate(SDF.parse(FileUtil.getCell(row.getCell(5))));
				}
				info.setBatchNO(bacthNO);
				info.setImportDept(deptName);
				info.setImportTime(new Date());
				
				tempPublicSchoolTeacherInfoMapper.insert(info);
			}
		} catch (Exception e) {
			return "error,sheet名为"+sheet.getSheetName()+"的第"+(i+1)+"行数据格式不正确";
		}
		return "success,上传成功";
	}
}