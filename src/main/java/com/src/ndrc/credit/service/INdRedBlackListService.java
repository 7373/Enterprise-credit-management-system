/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service;

import java.util.List;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.dto.NdRedBlackListDto;
import com.icinfo.ndrc.credit.model.NdRedBlackList;

/**
 * 描述:    nd_red_black_list 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月19日
 */
public interface INdRedBlackListService extends BaseService {
	
	/**
	 * 查询红黑名单信息 
	 * @author zjj
	 */
	public List<NdRedBlackListDto> getRedBlackList(PageRequest request)throws Exception;

	/**
	 * 查询红黑名单信息
	 * @author ylr
	 */
	public List<NdRedBlackListDto> getQyGrRedBlackList(PageRequest request)throws Exception;

	/**
	 * 获取红黑名单详细信息
     * @author liuguangju
     * @date 2017-06-21
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	public NdRedBlackList getRedBlackListDetail(String uid)throws Exception;
	
	/**
	 * 红黑名单数统计
	 * @author liuguangju
	 * @date 2017-06-23
	 * @param listType
	 * @return
	 * @throws Exception
	 */
	public NdRedBlackListDto selectCountRedBlack(String listType) throws Exception;
}