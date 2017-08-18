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
import com.icinfo.ndrc.credit.mapper.TempManyQyBaseInfoMapper;
import com.icinfo.ndrc.credit.model.TempManyQyBaseInfo;
import com.icinfo.ndrc.credit.service.ITempManyQyBaseInfoService;
import com.icinfo.ndrc.util.FileUtil;

/**
 * 描述:    temp_many_qy_base_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月29日
 */
@Service("tempManyQyBaseInfoService")
public class TempManyQyBaseInfoServiceImpl extends MyBatisServiceSupport implements ITempManyQyBaseInfoService {

	@Autowired
	private TempManyQyBaseInfoMapper tempManyQyBaseInfoMapper;
	public final static String TITLE = ",企业名称,社会信用代码/组织机构代码/工商注册号,法人代表,地址,邮政编码,企业资质等级,资质证书编号,有效期开始时间,有效期结束时间";
	public final static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
	@Override
	public void deleteByBatchNo(String batchNO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String record(String deptName, HSSFSheet sheet, String bacthNO) throws Exception {
		int rowNum = sheet.getLastRowNum();
		HSSFRow row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        TempManyQyBaseInfo info = new TempManyQyBaseInfo();
        
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
				
				info.setQyName(FileUtil.getCell(row.getCell(0)));
				info.setUniscid(FileUtil.getCell(row.getCell(1)));
				info.setLegalPersonName(FileUtil.getCell(row.getCell(2)));
				info.setAddr(FileUtil.getCell(row.getCell(3)));
				info.setZipCode(FileUtil.getCell(row.getCell(4)));
				
				info.setQualifyLevel(FileUtil.getCell(row.getCell(5)));
				info.setQualifyNo(FileUtil.getCell(row.getCell(6)));
				if(FileUtil.getCell(row.getCell(7)).trim()!=""){
					info.setValidityBegin(SDF.parse(FileUtil.getCell(row.getCell(7))));
				}
				if(FileUtil.getCell(row.getCell(8)).trim()!=""){
					info.setValidtyEnd(SDF.parse(FileUtil.getCell(row.getCell(8))));
				}
				info.setBatchNO(bacthNO);
				
				info.setImportDept(deptName);
				info.setImportTime(new Date());
				info.setIsUse("0");
				tempManyQyBaseInfoMapper.insert(info);
			}
		} catch (Exception e) {
			return "error,sheet名为"+sheet.getSheetName()+"的第"+(i+1)+"行数据格式不正确";
		}
		return "success,上传成功";
	}
}