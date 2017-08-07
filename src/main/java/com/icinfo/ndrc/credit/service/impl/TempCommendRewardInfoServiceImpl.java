/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.ndrc.credit.mapper.TempCommendRewardInfoMapper;
import com.icinfo.ndrc.credit.model.TempCommendRewardInfo;
import com.icinfo.ndrc.credit.service.ITempCommendRewardInfoService;
import com.icinfo.ndrc.util.FileUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    temp_commend_reward_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月30日
 */
@Service
public class TempCommendRewardInfoServiceImpl extends MyBatisServiceSupport implements ITempCommendRewardInfoService {

	private final static String TITLE = ",表彰名称,表彰等级,表彰文件（号）,表彰部门全称,表彰时间,累计表彰次数";
	private final static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	TempCommendRewardInfoMapper tempCommendRewardInfoMapper;
	
	@Override
	public String record(String deptName, HSSFSheet sheet, String bacthNO) throws Exception {
		int rowNum = sheet.getLastRowNum();
		HSSFRow row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        TempCommendRewardInfo info = new TempCommendRewardInfo();
        
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
				
				info.setCommendName(FileUtil.getCell(row.getCell(0)));
				info.setCommendGrade(FileUtil.getCell(row.getCell(1)));
				info.setCommendFileNO(FileUtil.getCell(row.getCell(2)));
				info.setCommendDeptName(FileUtil.getCell(row.getCell(3)));
				info.setCommendTime(FileUtil.getCell(row.getCell(4))==""?null:SDF.parse(FileUtil.getCell(row.getCell(4))));
				info.setCommendCount(FileUtil.getCell(row.getCell(5)));
				
				info.setBatchNO(bacthNO);
				info.setImportDept(deptName);
				info.setImportTime(new Date());
				
				tempCommendRewardInfoMapper.insert(info);
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