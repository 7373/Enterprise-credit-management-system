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
import com.icinfo.ndrc.credit.mapper.TempQyServeyQualiInfoMapper;
import com.icinfo.ndrc.credit.model.TempQyServeyQualiInfo;
import com.icinfo.ndrc.credit.service.ITempQyServeyQualiInfoService;
import com.icinfo.ndrc.util.FileUtil;

/**
 * 描述:    temp_qy_servey_quali_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月29日
 */
@Service("tempQyServeyQualiInfoService")
public class TempQyServeyQualiInfoServiceImpl extends MyBatisServiceSupport implements ITempQyServeyQualiInfoService {

	public final static String TITLE = ",测绘单位名称,测绘单位法人代表,测绘单位地址,测绘资质等级及编号,测绘资质有效期";
										
	public final static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	private TempQyServeyQualiInfoMapper tempQyServeyQualiInfoMapper;
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
        TempQyServeyQualiInfo info = new TempQyServeyQualiInfo();
        
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
				info.setQyName(FileUtil.getCell(row.getCell(0)));
				info.setQyLegalPerson(FileUtil.getCell(row.getCell(1)));
				info.setQyAddr(FileUtil.getCell(row.getCell(2)));
				info.setQualifyLevelAndNO(FileUtil.getCell(row.getCell(3)));
				if(FileUtil.getCell(row.getCell(4)).trim()!=""){
					info.setQualifyPeriod(SDF.parse(FileUtil.getCell(row.getCell(4))));
				}
				info.setBatchNO(bacthNO);
				info.setImportDept(deptName);
				info.setImportTime(new Date());
				info.setIsUse("0");
				tempQyServeyQualiInfoMapper.insert(info);
			}
		} catch (Exception e) {
			return "error,sheet名为"+sheet.getSheetName()+"的第"+(i+1)+"行数据格式不正确";
		}
		return "success,上传成功";
	}
	
	
}