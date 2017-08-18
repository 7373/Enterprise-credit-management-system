/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.ndrc.credit.mapper.TempBusinessLicenceInfoMapper;
import com.icinfo.ndrc.credit.model.TempBusinessLicenceInfo;
import com.icinfo.ndrc.credit.model.TempSafeProduceLincence;
import com.icinfo.ndrc.credit.model.TempTaxCreditLevel;
import com.icinfo.ndrc.credit.service.ITempBusinessLicenceInfoService;
import com.icinfo.ndrc.util.DateUtil;
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
 * 描述:  temp_business_licence_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月29日
 */
@SuppressWarnings("all")
@Service
public class TempBusinessLicenceInfoServiceImpl extends MyBatisServiceSupport implements ITempBusinessLicenceInfoService {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(TempBusinessLicenceInfoServiceImpl.class);

    @Autowired
    private TempBusinessLicenceInfoMapper tempBusinessLicenceInfoMapper;
    
    private final static String TITLE=",业户名称,社会信用代码/组织机构代码/工商注册号,经营许可证书,法人代表,注册地址,经营资质,注册日期（开业）,有效期起,有效期止,经营范围";
    
    
	/**
	 * 读取Excel存取
	 * 
	 * @author zhuyong
	 * @date 20170629
	 * @param deptName
	 * @param sheet
	 * @param bacthNO
	 * @return
	 * @throws Exception
	 */
	public String record(String deptName,HSSFSheet sheet,String bacthNO) throws Exception{
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
        TempBusinessLicenceInfo info = new TempBusinessLicenceInfo();
		try {
			for(i=1;i<=rowNum;i++){
				row = sheet.getRow(i);
				if(StringUtils.isBlank(FileUtil.getCell(row.getCell(0))))
					return "error,sheet名为"+sheet.getSheetName()+"的第"+(i+1)+"行第1列数据不能为空";
				
				info.setOwnerName(FileUtil.getCell(row.getCell(0)));
				info.setUnicode(FileUtil.getCell(row.getCell(1)));
				info.setBusinessLicence(FileUtil.getCell(row.getCell(2)));
				info.setLegalPerson(FileUtil.getCell(row.getCell(3)));
				info.setRegistAddr(FileUtil.getCell(row.getCell(4)));
				
				info.setManageQualify(FileUtil.getCell(row.getCell(5)));
				info.setRegistDate(DateUtil.stringToDate(FileUtil.getCell(row.getCell(6)), "yyyy-MM-dd"));
				info.setValidTermStart(DateUtil.stringToDate(FileUtil.getCell(row.getCell(7)), "yyyy-MM-dd"));
				info.setValidTermEnd(DateUtil.stringToDate(FileUtil.getCell(row.getCell(8)), "yyyy-MM-dd"));
				info.setManageRange(FileUtil.getCell(row.getCell(9)));
				
				info.setLicenceType(sheet.getSheetName());
				info.setBatchNO(bacthNO);
				info.setImportDept(deptName);
				info.setImportTime(new Date());
				info.setIsUse("0");
				tempBusinessLicenceInfoMapper.insert(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error,sheet名为"+sheet.getSheetName()+"的第"+(i+1)+"行数据格式不正确";
		}
		return "success,上传成功";
	}


	
	@Override
	public void deleteByBatchNo(String batchNO) throws Exception {
		Example example = new Example(TempBusinessLicenceInfo.class);
		example.createCriteria().andEqualTo("batchNO",batchNO);
		tempBusinessLicenceInfoMapper.deleteByExample(example);
	}
}