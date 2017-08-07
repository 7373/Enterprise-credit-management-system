/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.dto.TempSeedManagePermitDto;
import com.icinfo.ndrc.credit.mapper.TempSeedManagePermitMapper;
import com.icinfo.ndrc.credit.model.TempSeedManagePermit;
import com.icinfo.ndrc.credit.service.ITempSeedManagePermitService;
import com.icinfo.ndrc.util.FileUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    temp_seed_manage_permit 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月20日
 */
@Service("tempSeedManagePermitService")
public class TempSeedManagePermitServiceImpl extends MyBatisServiceSupport implements ITempSeedManagePermitService {

	@Autowired
	TempSeedManagePermitMapper tempSeedManagePermitMapper;
	
	public final static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
	public final static String TITLE = ",企业名称（自然人姓名）,法人社会信用代码/组织机构代码/工商注册号或工商登记号（自然人身份证号）,许可证编号,发证日期,有效期限,生产地点,生产种类";
	
	@Override
	public void deleteByBatchNo(String batchNO) throws Exception {
		Example example = new Example(TempSeedManagePermit.class);
		example.createCriteria().andEqualTo("batchNO",batchNO);
		tempSeedManagePermitMapper.deleteByExample(example);
		
	}

	@Override
	public String record(String deptName, HSSFSheet sheet, String bacthNO) throws Exception {
		int rowNum = sheet.getLastRowNum();
		HSSFRow row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        TempSeedManagePermit info = new TempSeedManagePermit();
        
        String msg = "";
        for(int j=0;j<colNum;j++){
        	msg=msg+","+FileUtil.getCell(row.getCell(j));
        }
        if(!TITLE.equals(msg))
        	return "error,"+sheet.getSheetName()+"的第一行内容格式不正确";
        
        int i=1;
		try {
			for(i=1;i<=rowNum;i++){
				row = sheet.getRow(i);
				if("".equals(FileUtil.getCell(row.getCell(0))))
					return "error,sheet名为"+sheet.getSheetName()+"的第"+(i+1)+"行第1列数据不能为空";
				
				info.setEntName(FileUtil.getCell(row.getCell(0)));
				info.setUnicode(FileUtil.getCell(row.getCell(1)));
				info.setLicenceNO(FileUtil.getCell(row.getCell(2)));
				info.setIssueTime(FileUtil.getCell(row.getCell(3))==""?null:SDF.parse(FileUtil.getCell(row.getCell(3))));
				info.setTermEnd(FileUtil.getCell(row.getCell(4))==""?null:SDF.parse(FileUtil.getCell(row.getCell(4))));
				
				info.setProduceLoc(FileUtil.getCell(row.getCell(5)));
				info.setManageType(FileUtil.getCell(row.getCell(6)));
				info.setImportTime(new Date());
				info.setImportDept(deptName);
				info.setBatchNO(bacthNO);
			
				tempSeedManagePermitMapper.insert(info);
			}
		} catch (Exception e) {
			return "error,sheet名为"+sheet.getSheetName()+"的第"+(i+1)+"行数据格式不正确";
		}
		return "success,上传成功";
	}

	/**
	 * dataTable分页查询
	 * @author fanzhen
	 * @date 20170620
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TempSeedManagePermit> findMsg(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return tempSeedManagePermitMapper.findByMap(request.getParams());
	}

	/**
	 * 根据dto来删除记录
	 * @author fanzhen
	 * @date 20170620
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@Override
	public int deleteByDto(TempSeedManagePermitDto dto) throws Exception {

		return tempSeedManagePermitMapper.delete(dto);
	}
}