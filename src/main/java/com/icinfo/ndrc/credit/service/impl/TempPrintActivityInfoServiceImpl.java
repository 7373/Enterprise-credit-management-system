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
import com.icinfo.ndrc.credit.mapper.TempPrintActivityInfoMapper;
import com.icinfo.ndrc.credit.model.TempPrintActivityInfo;
import com.icinfo.ndrc.credit.service.ITempPrintActivityInfoService;
import com.icinfo.ndrc.util.FileUtil;

/**
 * 描述:    temp_print_activity_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月30日
 */
@Service("tempPrintActivityInfoService")
public class TempPrintActivityInfoServiceImpl extends MyBatisServiceSupport implements ITempPrintActivityInfoService {
	
	@Autowired
	private TempPrintActivityInfoMapper tempPrintActivityInfoMapper;

	public final static String TITLE1 = ",企业名称,社会信用代码/组织机构代码/工商注册号,许可证证号,许可证发证日期,许可证说明,地址,负责人,负责人身份证号,联系电话";
	
	public final static String TITLE2 = ",企业名称,社会信用代码/组织机构代码/工商注册号,许可证证号,许可证发证日期,许可证说明,地址,法人代表,法人代表身份证号,联系电话";
	
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
	public String record(String deptName, HSSFSheet sheet, String bacthNO ) throws Exception {
		int rowNum = sheet.getLastRowNum();
		HSSFRow row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        TempPrintActivityInfo info = new TempPrintActivityInfo();
        String sheetType="";
        
        String msg = "";
        for(int j=0;j<colNum;j++){
        	msg=msg+","+FileUtil.getCell(row.getCell(j));
        }
        if(TITLE1.equals(msg) && "个人从事其他印刷品印刷经营活动信息".equals(sheet.getSheetName())){
        	sheetType = "个人从事其他印刷品印刷经营活动信息";
        }else if(TITLE2.equals(msg) && "设立从事包装装潢印刷品和其他印刷品印刷经营活动的企业信息".equals(sheet.getSheetName())){
        	sheetType = "设立从事包装装潢印刷品和其他印刷品印刷经营活动的企业信息";
        }else{
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
				info.setLicenseNo(FileUtil.getCell(row.getCell(2)));
				if(FileUtil.getCell(row.getCell(3)).trim()!="")
					info.setLicenseStartDate(SDF.parse(FileUtil.getCell(row.getCell(3))));
				info.setLicenseInStruction(FileUtil.getCell(row.getCell(4)));
				
				info.setAddr(FileUtil.getCell(row.getCell(5)));
				info.setHeadName(FileUtil.getCell(row.getCell(6)));
				info.setHeadIdCard(FileUtil.getCell(row.getCell(7)));
				info.setPhone(FileUtil.getCell(row.getCell(8)));
				info.setSheetType(sheetType);
				
				info.setBatchNO(bacthNO);
				info.setImportDept(deptName);
				info.setImportTime(new Date());
				info.setIsUse("0");
				tempPrintActivityInfoMapper.insert(info);
			}
		} catch (Exception e) {
			return "error,sheet名为"+sheet.getSheetName()+"的第"+(i+1)+"行数据格式不正确";
		}
		return "success,上传成功";
	}
}