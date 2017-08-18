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
import com.icinfo.ndrc.credit.mapper.TempMajorFireInfoMapper;
import com.icinfo.ndrc.credit.model.TempMajorFireInfo;
import com.icinfo.ndrc.credit.service.ITempMajorFireInfoService;
import com.icinfo.ndrc.util.FileUtil;

/**
 * 描述:    temp_major_fire_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月30日
 */
@Service("tempMajorFireInfoService")
public class TempMajorFireInfoServiceImpl extends MyBatisServiceSupport implements ITempMajorFireInfoService {

	@Autowired
	private TempMajorFireInfoMapper tempMajorFireInfoMapper;

	public static final String TITLE = ",单位名称,单位社会信用代码/工商注册号/组织机构代码,存在重大火灾隐患内容,认定时间,认定依据,销案时间";
	
	public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");	
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
        TempMajorFireInfo info = new TempMajorFireInfo();
        
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
				info.setFireHiddenContent(FileUtil.getCell(row.getCell(2)));
				if(FileUtil.getCell(row.getCell(3)).trim()!=""){
					info.setAffirmDate(SDF.parse(FileUtil.getCell(row.getCell(3))));
				}
				info.setAffirmBasis(FileUtil.getCell(row.getCell(4)));
				
				if(FileUtil.getCell(row.getCell(5)).trim()!=""){
					info.setCloseCaseDate(SDF.parse(FileUtil.getCell(row.getCell(5))));
				}
				info.setBatchNO(bacthNO);
				info.setImportDept(deptName);
				info.setImportTime(new Date());
				info.setIsUse("0");
				tempMajorFireInfoMapper.insert(info);
			}
		} catch (Exception e) {
			return "error,sheet名为"+sheet.getSheetName()+"的第"+(i+1)+"行数据格式不正确";
		}
		return "success,上传成功";
	}
}