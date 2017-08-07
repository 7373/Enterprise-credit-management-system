/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.ndrc.credit.mapper.TempRepairLicenceInfoMapper;
import com.icinfo.ndrc.credit.model.TempDriveLicenceInfo;
import com.icinfo.ndrc.credit.model.TempRepairLicenceInfo;
import com.icinfo.ndrc.credit.service.ITempRepairLicenceInfoService;
import com.icinfo.ndrc.util.FileUtil;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:  temp_repair_licence_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月29日
 */
@Service
public class TempRepairLicenceInfoServiceImpl extends MyBatisServiceSupport implements ITempRepairLicenceInfoService {

    @Autowired
    private TempRepairLicenceInfoMapper tempRepairLicenceInfoMapper;
    
    private final static String TITLE=",企业名称,社会信用代码/组织机构代码/工商注册号,法定代表人,地址,道路运输经营许可证书";


	@Override
	public String record(String deptCode, HSSFSheet sheet, String bacthNO) throws Exception {
		int rowNum = sheet.getLastRowNum();
		HSSFRow row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();

        String msg = "";
        for(int j=0;j<colNum;j++){
        	msg=msg+","+FileUtil.getCell(row.getCell(j));
        }
        
        if(!TITLE.equals(msg)){
        	return "error,"+sheet.getSheetName()+"的第一行内容格式不正确";
        }
        
        int i=1;
        TempRepairLicenceInfo info = new TempRepairLicenceInfo();
		try {
			for(i=1;i<=rowNum;i++){
				row = sheet.getRow(i);
				if(StringUtils.isBlank(FileUtil.getCell(row.getCell(0))))
					return "error,sheet名为"+sheet.getSheetName()+"的第"+(i+1)+"行第1列数据不能为空";
				
				info.setEntName(FileUtil.getCell(row.getCell(0)));
				info.setUnicode(FileUtil.getCell(row.getCell(1)));
				info.setLegalperson(FileUtil.getCell(row.getCell(2)));
				info.setAddress(FileUtil.getCell(row.getCell(3)));
				info.setRoadTransportLicence(FileUtil.getCell(row.getCell(4)));
				
				info.setBatchNO(bacthNO);
				info.setImportDept(deptCode);
				info.setImportTime(new Date());
				info.setIsUse("0");
				tempRepairLicenceInfoMapper.insert(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error,sheet名为"+sheet.getSheetName()+"的第"+(i+1)+"行数据格式不正确";
		}
		return "success,上传成功";
	}
	
	
	@Override
	public void deleteByBatchNo(String batchNO) throws Exception {
		Example example = new Example(TempRepairLicenceInfo.class);
		example.createCriteria().andEqualTo("batchNO",batchNO);
		tempRepairLicenceInfoMapper.deleteByExample(example);
	}
}