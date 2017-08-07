/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.dto.TempAdminForceInfoDto;
import com.icinfo.ndrc.credit.mapper.TempAdminForceInfoMapper;
import com.icinfo.ndrc.credit.model.TempAdminForceInfo;
import com.icinfo.ndrc.credit.service.ITempAdminForceInfoService;
import com.icinfo.ndrc.util.FileUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    temp_admin_force_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月22日
 */
@Service
public class TempAdminForceInfoServiceImpl extends MyBatisServiceSupport implements ITempAdminForceInfoService {
	private final static String TITLE = ",行政强制文书号,行政强制决定日期,查封扣押清单内容";
	private final static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	TempAdminForceInfoMapper tempAdminForceInfoMapper;
	
	@Override
	public List<TempAdminForceInfoDto> selectListByMap(PageRequest request) {
		PageHelper.startPage(request.getPageNum(),request.getLength());
		return tempAdminForceInfoMapper.selectListByMap(request.getParams());
	}
	@Override
	public String record(String deptName, HSSFSheet sheet, String bacthNO) throws Exception {
		int rowNum = sheet.getLastRowNum();
		HSSFRow row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        TempAdminForceInfo info = new TempAdminForceInfo();
        
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
				
				info.setAdminForceNO(FileUtil.getCell(row.getCell(0)));
				info.setAdminForceTime(FileUtil.getCell(row.getCell(1))==""?null:SDF.parse(FileUtil.getCell(row.getCell(1))));
				info.setSequeDetail(FileUtil.getCell(row.getCell(2)));
				info.setBatchNO(bacthNO);
				info.setImportDept(deptName);
				info.setImportTime(new Date());
				
				tempAdminForceInfoMapper.insert(info);
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