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
import com.icinfo.ndrc.credit.mapper.TempHotelSpecialtyApproveInfoMapper;
import com.icinfo.ndrc.credit.model.TempHotelSpecialtyApproveInfo;
import com.icinfo.ndrc.credit.service.ITempHotelSpecialtyApproveInfoService;
import com.icinfo.ndrc.util.FileUtil;

/**
 * 描述:    temp_hotel_specialty_approve_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月29日
 */
@Service("tempHotelSpecialtyApproveInfoService")
public class TempHotelSpecialtyApproveInfoServiceImpl extends MyBatisServiceSupport implements ITempHotelSpecialtyApproveInfoService {

	@Autowired
	private TempHotelSpecialtyApproveInfoMapper tempHotelSpecialtyApproveInfoMapper;

	public final static String TITLE = ",旅馆名称,旅馆地址,社会信用代码/工商注册号/组织机构代码,旅馆联系电话,开设日期,法人代表姓名";
	
	public final static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");	
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
	 * */
	@Override
	public String record(String deptName, HSSFSheet sheet, String bacthNO) throws Exception {
		int rowNum = sheet.getLastRowNum();
		HSSFRow row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        TempHotelSpecialtyApproveInfo info = new TempHotelSpecialtyApproveInfo();
        
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
				
				info.setHotelName(FileUtil.getCell(row.getCell(0)));
				info.setHotelAddr(FileUtil.getCell(row.getCell(1)));
				info.setUniscid(FileUtil.getCell(row.getCell(2)));
				info.setHotelPhone(FileUtil.getCell(row.getCell(3)));
				if(FileUtil.getCell(row.getCell(4)).trim()!=""){
					info.setStartTime(SDF.parse(FileUtil.getCell(row.getCell(4))));
				}

				info.setLegalPersonName(FileUtil.getCell(row.getCell(5)));
				info.setBatchNO(bacthNO);
				info.setImportDept(deptName);
				info.setImportTime(new Date());
				info.setIsUse("0");
				tempHotelSpecialtyApproveInfoMapper.insert(info);
			}
		} catch (Exception e) {
			return "error,sheet名为"+sheet.getSheetName()+"的第"+(i+1)+"行数据格式不正确";
		}
		return "success,上传成功";
	}
}