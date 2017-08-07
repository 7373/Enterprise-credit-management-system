/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.ndrc.credit.mapper.TempDriveLicenceInfoMapper;
import com.icinfo.ndrc.credit.model.TempBusinessLicenceInfo;
import com.icinfo.ndrc.credit.model.TempDriveLicenceInfo;
import com.icinfo.ndrc.credit.service.ITempDriveLicenceInfoService;
import com.icinfo.ndrc.util.DateUtil;
import com.icinfo.ndrc.util.FileUtil;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:  temp_drive_licence_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月29日
 */
@Service
public class TempDriveLicenceInfoServiceImpl extends MyBatisServiceSupport implements ITempDriveLicenceInfoService {

    @Autowired
    private TempDriveLicenceInfoMapper tempDriveLicenceInfoMapper;
    
    private final static String TITLE=",学校名称,社会信用代码/组织机构代码/工商注册号,许可证书,法人代表,地址,信用等级";

    
    
    /**
	 * 读取Excel存取
	 * 
	 * @author zhuyong
	 * @date 20170629
	 * @param deptCode
	 * @param sheet
	 * @param bacthNO
	 * @return
	 * @throws Exception
	 */
	public String record(String deptCode,HSSFSheet sheet,String bacthNO) throws Exception{
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
        TempDriveLicenceInfo info = new TempDriveLicenceInfo();
		try {
			for(i=1;i<=rowNum;i++){
				row = sheet.getRow(i);
				if(StringUtils.isBlank(FileUtil.getCell(row.getCell(0))))
					return "error,sheet名为"+sheet.getSheetName()+"的第"+(i+1)+"行第1列数据不能为空";
				
				info.setSchoolName(FileUtil.getCell(row.getCell(0)));
				info.setUnicode(FileUtil.getCell(row.getCell(1)));
				info.setLicence(FileUtil.getCell(row.getCell(2)));
				info.setLegalPerson(FileUtil.getCell(row.getCell(3)));
				info.setAddress(FileUtil.getCell(row.getCell(4)));
				info.setCreditClass(FileUtil.getCell(row.getCell(5)));
				
				info.setBatchNO(bacthNO);
				info.setImportDept(deptCode);
				info.setImportTime(new Date());
				info.setIsUse("0");
				tempDriveLicenceInfoMapper.insert(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error,sheet名为"+sheet.getSheetName()+"的第"+(i+1)+"行数据格式不正确";
		}
		return "success,上传成功";
	}


	@Override
	public void deleteByBatchNo(String batchNO) throws Exception {
		Example example = new Example(TempDriveLicenceInfo.class);
		example.createCriteria().andEqualTo("batchNO",batchNO);
		tempDriveLicenceInfoMapper.deleteByExample(example);
	}
}