/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.ndrc.credit.mapper.TempEnvirEffectCheckInfoMapper;
import com.icinfo.ndrc.credit.mapper.TempManyQyBaseInfoMapper;
import com.icinfo.ndrc.credit.model.TempEnvirEffectCheckInfo;
import com.icinfo.ndrc.credit.model.TempManyQyBaseInfo;
import com.icinfo.ndrc.credit.service.ITempEnvirEffectCheckInfoService;
import com.icinfo.ndrc.util.FileUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    temp_envir_effect_check_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月29日
 */
@Service
public class TempEnvirEffectCheckInfoServiceImpl extends MyBatisServiceSupport implements ITempEnvirEffectCheckInfoService {
	@Autowired
	private TempEnvirEffectCheckInfoMapper tempEnvirEffectCheckInfoMapper;
	public final static String TITLE = ",企业名称,社会信用代码/组织机构代码/工商注册号,项目类型,审批（批准）文号,审批（批准）事项,审批（批准）机关,审批（批准）日期";
	public final static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public String record(String deptName, HSSFSheet sheet, String bacthNO) throws Exception {
		int rowNum = sheet.getLastRowNum();
		HSSFRow row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        TempEnvirEffectCheckInfo info = new TempEnvirEffectCheckInfo();
        
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
				info.setEntName(FileUtil.getCell(row.getCell(0)));
				info.setUnicode(FileUtil.getCell(row.getCell(1)));
				info.setProjectType(FileUtil.getCell(row.getCell(2)));
				info.setCheckNO(FileUtil.getCell(row.getCell(3)));
				info.setCheckMatter(FileUtil.getCell(row.getCell(4)));
				info.setCheckUnit(FileUtil.getCell(row.getCell(5)));
				info.setCheckDate(FileUtil.getCell(row.getCell(6))==""?null:SDF.parse(FileUtil.getCell(row.getCell(6))));
				info.setBatchNO(bacthNO);
				info.setImportDept(deptName);
				info.setImportTime(new Date());
				info.setIsUse("0");
				tempEnvirEffectCheckInfoMapper.insert(info);
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