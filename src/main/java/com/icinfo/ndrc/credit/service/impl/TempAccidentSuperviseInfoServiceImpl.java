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

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.dto.TempAccidentSuperviseInfoDto;
import com.icinfo.ndrc.credit.mapper.TempAccidentSuperviseInfoMapper;
import com.icinfo.ndrc.credit.model.TempAccidentSuperviseInfo;
import com.icinfo.ndrc.credit.service.ITempAccidentSuperviseInfoService;
import com.icinfo.ndrc.util.FileUtil;

/**
 * 描述:    temp_accident_supervise_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月15日
 */
@Service("tempAccidentSuperviseInfoService")
public class TempAccidentSuperviseInfoServiceImpl extends MyBatisServiceSupport implements ITempAccidentSuperviseInfoService {

	public final static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	private TempAccidentSuperviseInfoMapper tempAccidentSuperviseInfoMapper;
	public final static String TITLE = ",隐患具体信息,整改期限,整改完成情况";
	
	@Override
	public int Insert(TempAccidentSuperviseInfo info) throws Exception {
		
		return tempAccidentSuperviseInfoMapper.insert(info);
	}
	
	/**
	 * 读取Excel存储
	 * @author fanzhen
	 * @date 20170616
	 * @param sheet
	 * @throws Exception
	 */
	@Override
	public String record(String deptName,HSSFSheet sheet,String bacthNO) throws Exception {
		int rowNum = sheet.getLastRowNum();
		HSSFRow row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        TempAccidentSuperviseInfo info = new TempAccidentSuperviseInfo();
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
				
				info.setDangerDetail(FileUtil.getCell(row.getCell(0)));
				info.setChangeCompleteInfo(FileUtil.getCell(row.getCell(2)));
				info.setChangeTerm(FileUtil.getCell(row.getCell(1))==""?null:SDF.parse(FileUtil.getCell(row.getCell(1))));
				info.setImportTime(new Date());
				info.setImportDept(deptName);
				info.setBatchNO(bacthNO);
			
				Insert(info);
			}
		} catch (Exception e) {
			return "error,sheet名为"+sheet.getSheetName()+"的第"+(i+1)+"行数据格式不正确";
		}
		return "success,上传成功";
	}

	@Override
	public void deleteByBatchNo(String batchNO) throws Exception {
		
		tempAccidentSuperviseInfoMapper.deleteByBatchNo(batchNO);
	}

	/**
	 * 查询
	 * @author fanzhen
	 * @date 20170619
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TempAccidentSuperviseInfo> findMsg(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return tempAccidentSuperviseInfoMapper.findMsg(request.getParams());
	}

	/**
	 * 删除
	 * @author fanzhen
	 * @date 20170620
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@Override
	public int deleteByDto(TempAccidentSuperviseInfoDto dto) throws Exception {
		
		return tempAccidentSuperviseInfoMapper.delete(dto);
	}
    

}














