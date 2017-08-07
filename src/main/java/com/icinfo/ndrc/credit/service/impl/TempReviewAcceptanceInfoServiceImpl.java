/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.ndrc.credit.mapper.TempReviewAcceptanceInfoMapper;
import com.icinfo.ndrc.credit.model.TempReviewAcceptanceInfo;
import com.icinfo.ndrc.credit.service.ITempReviewAcceptanceInfoService;
import com.icinfo.ndrc.util.FileUtil;

/**
 * 描述:    temp_review_acceptance_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月29日
 */
@Service("tempReviewAcceptanceInfoService")
public class TempReviewAcceptanceInfoServiceImpl extends MyBatisServiceSupport implements ITempReviewAcceptanceInfoService {
	
	@Autowired
	private TempReviewAcceptanceInfoMapper tempReviewAcceptanceInfoMapper;

	public final static String TITLE = ",企业名称,企业社会信用代码/工商注册号/组织机构代码,项目名称,新增变压器容量,项目年综合能耗,项目单位增加值能耗";
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
        TempReviewAcceptanceInfo info = new TempReviewAcceptanceInfo();
        
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
				info.setUniscid(FileUtil.getCell(row.getCell(1)));
				info.setProjectName(FileUtil.getCell(row.getCell(2)));
				info.setNewTransFormerCapacity(FileUtil.getCell(row.getCell(3)));
				info.setEnergyConsumption(FileUtil.getCell(row.getCell(4)));
				
				info.setAddValue(FileUtil.getCell(row.getCell(5)));
				info.setBatchNO(bacthNO);
				info.setImportDept(deptName);
				info.setImportTime(new Date());
				info.setIsUse("0");
				tempReviewAcceptanceInfoMapper.insert(info);
			}
		} catch (Exception e) {
			return "error,sheet名为"+sheet.getSheetName()+"的第"+(i+1)+"行数据格式不正确";
		}
		return "success,上传成功";
	}
}