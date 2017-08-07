/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.mapper.TempRewardInfoMapper;
import com.icinfo.ndrc.credit.model.NdEntOweTaxInfo;
import com.icinfo.ndrc.credit.model.TempRewardInfo;
import com.icinfo.ndrc.credit.service.ITempRewardInfoService;
import com.icinfo.ndrc.util.FileUtil;

/**
 * 描述:    temp_reward_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月30日
 */
@Service("tempRewardInfoService")
public class TempRewardInfoServiceImpl extends MyBatisServiceSupport implements ITempRewardInfoService {
	
	@Autowired
	private TempRewardInfoMapper tempRewardInfoMapper;
	
	public final static String TITLE = ",获奖单位（场所）名称,单位（场所）类型,地址,所在区域,奖励名称,奖励级别,奖励时间,颁奖单位";
	
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
        TempRewardInfo info = new TempRewardInfo();
        
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
				
				info.setRewardUnitName(FileUtil.getCell(row.getCell(0)));
				info.setUnitType(FileUtil.getCell(row.getCell(1)));
				info.setAddress(FileUtil.getCell(row.getCell(2)));
				info.setTheArea(FileUtil.getCell(row.getCell(3)));
				info.setRewardName(FileUtil.getCell(row.getCell(4)));
				
				info.setRewardClass(FileUtil.getCell(row.getCell(5)));
				if(FileUtil.getCell(row.getCell(6))!="")
					info.setRewardTime(SDF.parse(FileUtil.getCell(row.getCell(6))));
				info.setAwardUnit(FileUtil.getCell(row.getCell(7)));
				
				info.setBatchNO(bacthNO);
				info.setImportDept(deptName);
				info.setImportTime(new Date());
				info.setIsUse("0");
				tempRewardInfoMapper.insert(info);
			}
		} catch (Exception e) {
			return "error,sheet名为"+sheet.getSheetName()+"的第"+(i+1)+"行数据格式不正确";
		}
		return "success,上传成功";
	}
	public List<TempRewardInfo> selectList(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return tempRewardInfoMapper.selectList(request.getParams());
	}
}