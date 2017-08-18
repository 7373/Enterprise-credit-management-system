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
import com.icinfo.ndrc.credit.mapper.TempAdminPermitMapper;
import com.icinfo.ndrc.credit.model.TempAdminPermit;
import com.icinfo.ndrc.credit.service.ITempAdminPermitService;
import com.icinfo.ndrc.util.FileUtil;

/**
 * 描述:    temp_admin_permit 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月29日
 */
@Service("tempAdminPermitService")
public class TempAdminPermitServiceImpl extends MyBatisServiceSupport implements ITempAdminPermitService {
	
	@Autowired
	private TempAdminPermitMapper tempAdminPermitMapper;
	
	public final static String TITLE=",行政许可决定书文号,项目名称,审批类别,行政相对人名称,许可内容,许可决定日期,许可截止日期,许可机关";

	public final static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
	@Override
	public void deleteByBatchNo(String batchNO) throws Exception {
		
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
        TempAdminPermit info = new TempAdminPermit();
        
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
				
				info.setAdminDocNO(FileUtil.getCell(row.getCell(0)));
				info.setProjectName(FileUtil.getCell(row.getCell(1)));
				info.setCheckType(FileUtil.getCell(row.getCell(2)));
				info.setAdminCounterpartName(FileUtil.getCell(row.getCell(3)));
				info.setLicenceContent(FileUtil.getCell(row.getCell(4)));
				
				if(FileUtil.getCell(row.getCell(5)).trim()!=""){
					info.setLicenceDecideDate(SDF.parse(FileUtil.getCell(row.getCell(5))));
				}
				if(FileUtil.getCell(row.getCell(6)).trim()!=""){
					info.setLicenceEndDate(SDF.parse(FileUtil.getCell(row.getCell(6))));
				}
				info.setLicenceUnit(FileUtil.getCell(row.getCell(7)));
				
				info.setBatchNO(bacthNO);
				info.setImportDept(deptName);
				info.setImportTime(new Date());
				info.setIsUse("0");
				tempAdminPermitMapper.insert(info);
			}
		} catch (Exception e) {
			return "error,sheet名为"+sheet.getSheetName()+"的第"+(i+1)+"行数据格式不正确";
		}
		return "success,上传成功";
	}
	
	
}