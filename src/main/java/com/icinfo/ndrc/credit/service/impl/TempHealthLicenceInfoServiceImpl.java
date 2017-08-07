/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.ndrc.credit.mapper.TempHealthLicenceInfoMapper;
import com.icinfo.ndrc.credit.model.TempHealthLicenceInfo;
import com.icinfo.ndrc.credit.model.TempPeopleQualiInfo;
import com.icinfo.ndrc.credit.service.ITempHealthLicenceInfoService;
import com.icinfo.ndrc.util.DateUtil;
import com.icinfo.ndrc.util.FileUtil;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:  temp_health_licence_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月29日
 */
@Service
public class TempHealthLicenceInfoServiceImpl extends MyBatisServiceSupport implements ITempHealthLicenceInfoService {

    @Autowired
    private TempHealthLicenceInfoMapper tempHealthLicenceInfoMapper;
    
    private final static String TITLE_YL = ",医疗机构名称,社会信用代码/组织机构代码/工商注册号,医疗机构地址,所有制形式,医疗机构执业许可证登记号,医疗机构类别,诊疗科目,法人代表,主要负责人";
    private final static String TITLE_MY = ",机构名称,社会信用代码/组织机构代码/工商注册号,地址,许可项目,执业许可证登记号,法人代表,负责人,有效期开始日期,有效期截止日期,发证机关,发证日期";

	private final static String SHEETNAME_YL = "县级注册的医疗卫生机构设置执业许可";
	private final static String SHEETNAME_MY = "县级注册的母婴保健专项技术服务许可";


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
		TempHealthLicenceInfo info = new TempHealthLicenceInfo();
		try {
			for (i = 1; i <= rowNum; i++) {
				row = sheet.getRow(i);
				if (StringUtils.isBlank(FileUtil.getCell(row.getCell(0))))
					return "error,sheet名为" + sheetName + "的第" + (i + 1) + "行第1列数据不能为空";
				
				info.setUnName(FileUtil.getCell(row.getCell(0)));
				info.setUniscid(FileUtil.getCell(row.getCell(1)));
				info.setAddress(FileUtil.getCell(row.getCell(2)));
				if(sheetName.equals(SHEETNAME_YL)){
					info.setOpForm(FileUtil.getCell(row.getCell(3)));
					info.setLicNO(FileUtil.getCell(row.getCell(4)));
					info.setUnType(FileUtil.getCell(row.getCell(5)));
					info.setSpeType(FileUtil.getCell(row.getCell(6)));
					info.setLeRep(FileUtil.getCell(row.getCell(7)));
					info.setChargePeo(FileUtil.getCell(row.getCell(8)));
				}else if(sheetName.equals(SHEETNAME_MY)){
					info.setLicPro(FileUtil.getCell(row.getCell(3)));
					info.setLicNO(FileUtil.getCell(row.getCell(4)));
					info.setLeRep(FileUtil.getCell(row.getCell(5)));
					info.setChargePeo(FileUtil.getCell(row.getCell(6)));
					info.setValDateStart(DateUtil.stringToDate(FileUtil.getCell(row.getCell(7)), "yyyy-MM-dd"));
					info.setValDateEnd(DateUtil.stringToDate(FileUtil.getCell(row.getCell(8)), "yyyy-MM-dd"));
					info.setCerIssue(FileUtil.getCell(row.getCell(9)));
					info.setCerDate(DateUtil.stringToDate(FileUtil.getCell(row.getCell(10)), "yyyy-MM-dd"));
				}
				
				info.setSource(sheetName);
				
				info.setBatchNO(bacthNO);
				info.setImportDept(depCode);
				info.setImportTime(new Date());
				info.setIsUse("0");

				tempHealthLicenceInfoMapper.insert(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error,sheet名为" + sheetName + "的第" + (i + 1) + "行数据格式不正确";
		}
		return "success,上传成功";
	}
	
	
	@Override
	public void deleteByBatchNo(String batchNO) throws Exception {
		Example example = new Example(TempHealthLicenceInfo.class);
		example.createCriteria().andEqualTo("batchNO", batchNO);
		tempHealthLicenceInfoMapper.deleteByExample(example);	
	}
}