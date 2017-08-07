/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.ndrc.credit.dto.TempRedBlackListDto;
import com.icinfo.ndrc.credit.mapper.TempRedBlackListMapper;
import com.icinfo.ndrc.credit.model.TempRedBlackList;
import com.icinfo.ndrc.credit.service.ITempRedBlackListService;
import com.icinfo.ndrc.util.FileUtil;
import com.icinfo.ndrc.util.UploadUtil;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    temp_redblack_list 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月16日
 */
@Service("tempRedBlackListService")
public class TempRedBlackListServiceImpl extends MyBatisServiceSupport implements ITempRedBlackListService {

	public final static String TITLE = ",当事人姓名/单位名称,身份证号/社会信用代码/组织机构代码/工商注册号,列入红/黑名单事由,发生时间,列入名单时间";
	public final static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	private TempRedBlackListMapper tempRedBlackListMapper;
	/**
	 * 解析Excel为红黑名单时保存到数据库中
	 * @author fanzhen
	 * @date 20170616
	 * @param sheet
	 * @throws Exception
	 */
	public String record(String depName,HSSFSheet sheet,String bacthNO,String listType) throws Exception {
		int rowNum = sheet.getLastRowNum();
		HSSFRow row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        TempRedBlackList info = new TempRedBlackList();
        String msg = "";
        for(int j=0;j<colNum;j++){
        	msg = msg+","+FileUtil.getCell(row.getCell(j));
        }
        if(!TITLE.equals(msg)){
        	return "error,"+sheet.getSheetName()+"的第一行内容格式不正确";
        }
        int i=1;
		try {
			for(i=1;i<=rowNum;i++){
				row = sheet.getRow(i);
				if("".equals(FileUtil.getCell(row.getCell(0))))
					return "error,sheet名为"+sheet.getSheetName()+"的第"+(i+1)+"行第1列数据不能为空";
				
				info.setPartyName(FileUtil.getCell(row.getCell(0)));
				info.setCertNO(FileUtil.getCell(row.getCell(1)));
				info.setInclusion(FileUtil.getCell(row.getCell(2)));
				info.setOccurrDate(FileUtil.getCell(row.getCell(3))==""?null:SDF.parse(FileUtil.getCell(row.getCell(3))));
				
				info.setIncludeListDate(FileUtil.getCell(row.getCell(4))==""?null:SDF.parse(FileUtil.getCell(row.getCell(4))));
				info.setImportDept(depName);
				info.setImportTime(new Date());
				info.setBatchNO(bacthNO);
				info.setPartyType(UploadUtil.transQyOrGr(FileUtil.getCell(row.getCell(0))));
				
				info.setListType(listType);
				tempRedBlackListMapper.insert(info);
			}
		} catch (Exception e) {
			return "error,sheet名为"+sheet.getSheetName()+"的第"+(i+1)+"行数据格式不正确";
		}
		return "success,上传成功";
	}
	
	@Override
	public void deleteByBatchNo(String batchNO) throws Exception {
		tempRedBlackListMapper.deleteByBatchNo(batchNO);
	}

	/**
	 * dataTable 分页查询
	 * @author fanzhen
	 * @date 20170620
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TempRedBlackList> findMsg(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return tempRedBlackListMapper.findMsg(request.getParams());
	}

	/**
	 * 根据红黑名单dto来删除信息
	 * @author fanzhen
	 * @date 20170620
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@Override
	public int deleteByDto(TempRedBlackListDto dto) throws Exception {

		return tempRedBlackListMapper.delete(dto);
	}
}