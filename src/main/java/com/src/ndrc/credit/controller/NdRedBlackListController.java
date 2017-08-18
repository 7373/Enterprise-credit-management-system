/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.ndrc.credit.dto.NdRedBlackListDto;
import com.icinfo.ndrc.credit.model.NdRedBlackList;
import com.icinfo.ndrc.credit.service.INdRedBlackListService;

/**
 * 描述:    nd_red_black_list 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年06月19日
 */
@Controller
@RequestMapping({"/credit/redBlackList","/gateway/reception/redBlackList"})
public class NdRedBlackListController extends BaseController {
	
	@Autowired
	INdRedBlackListService ndRedBlackListService;
	/**
	 * 查询企业黑白名单
	 * 
	 * @author ranah
	 * @when 2017年6月12日下午4:59:07
	 */

	@RequestMapping({ "/data.json" })
	@ResponseBody
	public PageResponse<NdRedBlackListDto> doGetList(PageRequest request) throws Exception {
		List<NdRedBlackListDto> data = ndRedBlackListService.getRedBlackList(request);
		return new PageResponse<NdRedBlackListDto>(data);
	}

    /**
     * 查询信用红名单-qy-gr
     *
     * @author ylr
     * @when 2017年6月12日下午4:59:07
     */
    @RequestMapping({ "/qygrredblacklist.json" })
    @ResponseBody
    public PageResponse<NdRedBlackListDto> qygrredblacklist(PageRequest request) throws Exception {
        List<NdRedBlackListDto> data = ndRedBlackListService.getQyGrRedBlackList(request);

        return new PageResponse<NdRedBlackListDto>(data);
    }
    
    /**
     * 获取红黑名单详细信息
     * @author liuguangju
     * @date 2017-06-21
     * @param menu
     * @param uid
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/getRedBlackListDetail",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getRedBlackListDetail(String menu,String item,String uid,String name)throws Exception{
    	ModelAndView mv = new ModelAndView("gateway/biz/reception/publish_platform");
    	mv.addObject("menu", menu);
    	mv.addObject("item", item);
    	mv.addObject("uid", uid);
    	mv.addObject("name", name);
    	return mv;
    }
	
}