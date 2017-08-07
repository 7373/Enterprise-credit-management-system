/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.ndrc.credit.mapper.TempSociaOrganInfoMapper;
import com.icinfo.ndrc.credit.model.TempSociaOrganInfo;
import com.icinfo.ndrc.credit.service.ITempSociaOrganInfoService;
import com.icinfo.ndrc.util.FileUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    temp_socia_organ_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月29日
 */
@Service
public class TempSociaOrganInfoServiceImpl extends MyBatisServiceSupport implements ITempSociaOrganInfoService {
	@Autowired
	private TempSociaOrganInfoMapper tempSociaOrganInfoMapper;
	public final static String TITLE = ",社会信用代码/组织机构代码,登记证号,单位名称,法定代表人(负责人),法定代表人(负责人)身份证件号,注册地址,电话号码,邮编,业务范围,开办资金,发证日期,是否注销,注销原因,注销文件,注销登记日期";
	public final static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public String record(String deptName, HSSFSheet sheet, String bacthNO) throws Exception {
		int rowNum = sheet.getLastRowNum();
		HSSFRow row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        TempSociaOrganInfo info = new  TempSociaOrganInfo();
        
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
				info.setUnicode(FileUtil.getCell(row.getCell(0)));
				info.setRegistNO(FileUtil.getCell(row.getCell(1)));
				info.setUnitName(FileUtil.getCell(row.getCell(2)));
				info.setLegalPerson(FileUtil.getCell(row.getCell(3)));
				info.setLegalPersonCertNO(FileUtil.getCell(row.getCell(4)));
				info.setRegistAddr(FileUtil.getCell(row.getCell(5)));
				info.setTel(FileUtil.getCell(row.getCell(6)));
				info.setZipCode(FileUtil.getCell(row.getCell(7)));
				info.setBusinessRange(FileUtil.getCell(row.getCell(8)));
				info.setStartFund(FileUtil.getCell(row.getCell(9)));
				info.setIsCancel(FileUtil.getCell(row.getCell(10)));
				info.setCancelReason(FileUtil.getCell(row.getCell(11)));
				info.setCancelFile(FileUtil.getCell(row.getCell(12)));
				info.setCancelRegistDate(FileUtil.getCell(row.getCell(13))==""?null:SDF.parse(FileUtil.getCell(row.getCell(13))));
				
				
				info.setBatchNO(bacthNO);
				info.setImportDept(deptName);
				info.setImportTime(new Date());
				info.setIsUse("0");
				tempSociaOrganInfoMapper.insert(info);
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