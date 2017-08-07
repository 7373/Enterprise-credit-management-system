/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.dto.TempSafeProduceLincenceDto;
import com.icinfo.ndrc.credit.mapper.TempSafeProduceLincenceMapper;
import com.icinfo.ndrc.credit.model.TempSafeProduceLincence;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.ndrc.credit.service.ITempSafeProduceLincenceService;
import com.icinfo.ndrc.util.FileUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

/**
 * 描述:    temp_safe_produce_licence 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月20日
 */
@Service("tempSafeProduceLincenceService")
public class TempSafeProduceLincenceServiceImpl extends MyBatisServiceSupport implements ITempSafeProduceLincenceService {

	public final static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	private TempSafeProduceLincenceMapper tempSafeProduceLincenceMapper;
	
	/**
	 * dataTable分页
	 * @author fanzhen
	 * @date 20170620
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TempSafeProduceLincence> findMsg(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(),request.getLength());
		
		return tempSafeProduceLincenceMapper.findByMap(request.getParams());
	}

	public final static String TITLE = ",企业名称,社会信用代码/组织机构代码/工商注册号,是否需要申请安全生产许可证,许可证号码,许可范围,许可证有效期";
	
	/**
	 * 根据dto来删除信心
	 * @author fanzhen
	 * @date 20170620
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@Override
	public int deleteByDto(TempSafeProduceLincenceDto dto) throws Exception {
		
		return tempSafeProduceLincenceMapper.delete(dto);
	}
	
	@Override
	public String record(String deptName, HSSFSheet sheet, String bacthNO) throws Exception {
		int rowNum = sheet.getLastRowNum();
		HSSFRow row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        TempSafeProduceLincence info = new TempSafeProduceLincence();
        
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
				if("".equals(FileUtil.getCell(row.getCell(1))))
					return "error,sheet名为"+sheet.getSheetName()+"的第"+(i+1)+"行第2列数据不能为空";
				info.setEntName(FileUtil.getCell(row.getCell(0)));
				info.setUnicode(FileUtil.getCell(row.getCell(1)));
				info.setIsNeedLicence(FileUtil.getCell(row.getCell(2)));
				info.setLicenceNO(FileUtil.getCell(row.getCell(3)));
				info.setLicenceRange(FileUtil.getCell(row.getCell(4)));
				info.setLicenceEndTime(FileUtil.getCell(row.getCell(5))==""?null:SDF.parse(FileUtil.getCell(row.getCell(5))));
				info.setImportTime(new Date());
				info.setImportDept(deptName);
				info.setBatchNO(bacthNO);
			
				tempSafeProduceLincenceMapper.insert(info);
			}
		} catch (Exception e) {
			return "error,sheet名为"+sheet.getSheetName()+"的第"+(i+1)+"行数据格式不正确";
		}
		return "success,上传成功";
	}

	/**
	 * 删除同一批次号数据
	 * @author zjj
	 */
	@Override
	public void deleteByBatchNo(String batchNO) throws Exception {
		
		Example example = new Example(TempSafeProduceLincence.class);
		example.createCriteria().andEqualTo("batchNO",batchNO);
		tempSafeProduceLincenceMapper.deleteByExample(example);
	}
	
}