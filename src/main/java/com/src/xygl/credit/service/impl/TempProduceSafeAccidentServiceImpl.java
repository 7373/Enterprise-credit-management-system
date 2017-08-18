/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.dto.TempProduceSafeAccidentDto;
import com.icinfo.ndrc.credit.mapper.TempProduceSafeAccidentMapper;
import com.icinfo.ndrc.credit.model.TempProduceSafeAccident;
import com.icinfo.ndrc.credit.service.ITempProduceSafeAccidentService;
import com.icinfo.ndrc.util.FileUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    temp_produce_safe_accident 对应的Service实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月22日
 */
@Service
public class TempProduceSafeAccidentServiceImpl extends MyBatisServiceSupport implements ITempProduceSafeAccidentService {
	@Autowired 
	TempProduceSafeAccidentMapper tempProduceSafeAccidentMapper;
	private final static String TITLE = ",事故名称,发生日期,伤亡情况（死亡人数）,伤亡情况（重伤人数）,处理结果,累计发生事故次数";
	private final static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
	
	
	@Override
	public List<TempProduceSafeAccidentDto> selectListByMap(PageRequest request) {
		PageHelper.startPage(request.getPageNum(),request.getLength());
		return tempProduceSafeAccidentMapper.selectListByMap(request.getParams());
	}
	@Override
	public String record(String deptName, HSSFSheet sheet, String bacthNO) throws Exception {
		int rowNum = sheet.getLastRowNum();
		HSSFRow row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        TempProduceSafeAccident info = new TempProduceSafeAccident();
        
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
				
				info.setAccidentName(FileUtil.getCell(row.getCell(0)));
				info.setOccurDate(FileUtil.getCell(row.getCell(1))==""?null:SDF.parse(FileUtil.getCell(row.getCell(1))));
				info.setDeathNum(FileUtil.getCell(row.getCell(2)));
				info.setInjuredNum(FileUtil.getCell(row.getCell(3)));
				info.setHandleResult(FileUtil.getCell(row.getCell(4)));
				info.setAccidentCountAll(FileUtil.getCell(row.getCell(5)));
				info.setBatchNO(bacthNO);
				info.setImportDept(deptName);
				info.setImportTime(new Date());
				
				tempProduceSafeAccidentMapper.insert(info);
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