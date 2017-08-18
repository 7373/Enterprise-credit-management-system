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
import com.icinfo.ndrc.credit.mapper.TempAdminPunishMapper;
import com.icinfo.ndrc.credit.model.TempAdminPunish;
import com.icinfo.ndrc.credit.service.ITempAdminPunishService;
import com.icinfo.ndrc.util.FileUtil;

/**
 * 描述:    temp_admin_punish 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月29日
 */
@Service("tempAdminPunishService")
public class TempAdminPunishServiceImpl extends MyBatisServiceSupport implements ITempAdminPunishService {

	public static final String TITLE = ",行政处罚决定文书号,处罚名称,处罚类别,处罚事由,处罚依据,行政相对人名称,处罚结果,处罚决定日期,处罚机关";
	@Autowired
	private TempAdminPunishMapper tempAdminPunishMapper;

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
        TempAdminPunish info = new TempAdminPunish();
        
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
				
				info.setPunishDocNO(FileUtil.getCell(row.getCell(0)));
				info.setPunishName(FileUtil.getCell(row.getCell(1)));
				info.setPunishType(FileUtil.getCell(row.getCell(2)));
				info.setPunishReason(FileUtil.getCell(row.getCell(3)));
				info.setPunishBasis(FileUtil.getCell(row.getCell(4)));
				
				info.setAdminCounterpartName(FileUtil.getCell(row.getCell(5)));
				info.setPunishResult(FileUtil.getCell(row.getCell(6)));
				if(FileUtil.getCell(row.getCell(7)).trim()!=""){
					info.setPunishDate(SDF.parse(FileUtil.getCell(row.getCell(7))));
				}
				info.setPunishOffice(FileUtil.getCell(row.getCell(8)));
				
				info.setBatchNO(bacthNO);
				info.setImportDept(deptName);
				info.setImportTime(new Date());
				info.setIsUse("0");
				tempAdminPunishMapper.insert(info);
			}
		} catch (Exception e) {
			return "error,sheet名为"+sheet.getSheetName()+"的第"+(i+1)+"行数据格式不正确";
		}
		return "success,上传成功";
	}
}