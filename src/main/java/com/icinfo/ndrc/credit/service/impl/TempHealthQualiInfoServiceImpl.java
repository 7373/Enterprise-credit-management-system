/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.ndrc.credit.mapper.TempHealthQualiInfoMapper;
import com.icinfo.ndrc.credit.model.TempHealthLicenceInfo;
import com.icinfo.ndrc.credit.model.TempHealthQualiInfo;
import com.icinfo.ndrc.credit.service.ITempHealthQualiInfoService;
import com.icinfo.ndrc.util.DateUtil;
import com.icinfo.ndrc.util.FileUtil;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:  temp_health_quali_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月29日
 */
@Service
public class TempHealthQualiInfoServiceImpl extends MyBatisServiceSupport implements ITempHealthQualiInfoService {

    @Autowired
    private TempHealthQualiInfoMapper tempHealthQualiInfoMapper;
    
    private final static String TITLE_YL = ",姓名,性别,身份证号,执业类别,执业范围,执业机构名称,医师/护士执业证书编号";
    private final static String TITLE_MY = ",姓名,性别,身份证号,技术专业,技术职称,许可项目";

	private final static String SHEETNAME_YL = "县级注册的医护人员执业注册信息";
	private final static String SHEETNAME_MY = "县级注册的母婴保健专项技术服务人员资格信息";

	@Override
	public String record(String depCode, HSSFSheet sheet, String bacthNO) throws Exception {
		String title = "";
		String sheetName = sheet.getSheetName();
		int rowNum = sheet.getLastRowNum();
		HSSFRow row = sheet.getRow(0);
		int colNum = row.getPhysicalNumberOfCells();

		String msg = "";
		for (int j = 0; j < colNum; j++) {
			msg = msg + "," + FileUtil.getCell(row.getCell(j));
		}

		if (sheetName.equals(SHEETNAME_YL)) {
			title = TITLE_YL;
		} else if (sheetName.equals(SHEETNAME_MY)) {
			title = TITLE_MY;
		} 
		
		if (!title.equals(msg)) {
			return "error," + sheet.getSheetName() + "的第一行内容格式不正确";
		}

		int i = 1;
		TempHealthQualiInfo info = new TempHealthQualiInfo();
		try {
			for (i = 1; i <= rowNum; i++) {
				row = sheet.getRow(i);
				if (StringUtils.isBlank(FileUtil.getCell(row.getCell(0))))
					return "error,sheet名为" + sheetName + "的第" + (i + 1) + "行第1列数据不能为空";
				
				info.setPeoName(FileUtil.getCell(row.getCell(0)));
				info.setSex(FileUtil.getCell(row.getCell(1)));
				info.setIdNO(FileUtil.getCell(row.getCell(2)));
				if(sheetName.equals(SHEETNAME_YL)){
					info.setPraType(FileUtil.getCell(row.getCell(3)));
					info.setPraScope(FileUtil.getCell(row.getCell(4)));
					info.setUnName(FileUtil.getCell(row.getCell(5)));
					info.setCerNO(FileUtil.getCell(row.getCell(6)));
				}else if(sheetName.equals(SHEETNAME_MY)){
					info.setTecType(FileUtil.getCell(row.getCell(3)));
					info.setTecName(FileUtil.getCell(row.getCell(4)));
					info.setLicPro(FileUtil.getCell(row.getCell(5)));
				}
				
				info.setSource(sheetName);
				
				info.setBatchNO(bacthNO);
				info.setImportDept(depCode);
				info.setImportTime(new Date());
				info.setIsUse("0");

				tempHealthQualiInfoMapper.insert(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error,sheet名为" + sheetName + "的第" + (i + 1) + "行数据格式不正确";
		}
		return "success,上传成功";
	}
	
	@Override
	public void deleteByBatchNo(String batchNO) throws Exception {
		Example example = new Example(TempHealthQualiInfo.class);
		example.createCriteria().andEqualTo("batchNO", batchNO);
		tempHealthQualiInfoMapper.deleteByExample(example);			
	}
}