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
import com.icinfo.ndrc.credit.mapper.TempSuperviseInspectDeceptionInfoMapper;
import com.icinfo.ndrc.credit.model.TempSuperviseInspectDeceptionInfo;
import com.icinfo.ndrc.credit.service.ITempSuperviseInspectDeceptionInfoService;
import com.icinfo.ndrc.util.FileUtil;

/**
 * 描述:    temp_supervise_inspect_deception_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月30日
 */
@Service("tempSuperviseInspectDeceptionInfoService")
public class TempSuperviseInspectDeceptionInfoServiceImpl extends MyBatisServiceSupport implements ITempSuperviseInspectDeceptionInfoService {

	@Autowired
	private TempSuperviseInspectDeceptionInfoMapper tempSuperviseInspectDeceptionInfoMapper;

	public final static String TITLE = ",单位（组织）名称,社会信用代码/组织机构代码/工商注册号,查处时间,查处情况";
	
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
	 * @throws Exception
	 */
	@Override
	public String record(String deptName, HSSFSheet sheet, String bacthNO) throws Exception {
		int rowNum = sheet.getLastRowNum();
		HSSFRow row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        TempSuperviseInspectDeceptionInfo info = new TempSuperviseInspectDeceptionInfo();
        
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
				info.setUniscid(FileUtil.getCell(row.getCell(1)));
				if(FileUtil.getCell(row.getCell(2)).trim()!="")
					info.setDealTime(SDF.parse(FileUtil.getCell(row.getCell(2))));
				info.setDealSituation(FileUtil.getCell(row.getCell(3)));
				
				info.setBatchNO(bacthNO);
				info.setImportDept(deptName);
				info.setImportTime(new Date());
				info.setIsUse("0");
				tempSuperviseInspectDeceptionInfoMapper.insert(info);
			}
		} catch (Exception e) {
			return "error,sheet名为"+sheet.getSheetName()+"的第"+(i+1)+"行数据格式不正确";
		}
		return "success,上传成功";
	}
}