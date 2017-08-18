package com.icinfo.ndrc.gateway.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.ndrc.credit.dto.NdRedBlackListDto;
import com.icinfo.ndrc.credit.model.NdRedBlackList;
import com.icinfo.ndrc.credit.service.INdRedBlackListService;
import com.icinfo.ndrc.gateway.dto.NdLicenseDto;
import com.icinfo.ndrc.gateway.dto.NdPunishDto;
import com.icinfo.ndrc.gateway.dto.NdrcNewsPublishDto;
import com.icinfo.ndrc.gateway.model.NdCountCatalog;
import com.icinfo.ndrc.gateway.model.NdLicense;
import com.icinfo.ndrc.gateway.model.NdPunish;
import com.icinfo.ndrc.gateway.service.INdLicenseService;
import com.icinfo.ndrc.gateway.service.INdPunishService;
import com.icinfo.ndrc.gateway.service.INdrcNewsPublishService;
import com.icinfo.ndrc.support.Constants;
import com.icinfo.ndrc.support.SevenDoubleEnum;

/**
 * Created by Administrator on 2017-06-09.
 */
@Controller
@RequestMapping({"/gateway/reception","gateway/backstage"})
public class NrdcIndexController extends BaseController {
	
	@Autowired
	INdrcNewsPublishService ndNewsPublishService;
	@Autowired
	INdRedBlackListService ndRedBlackListService;
	@Autowired
	INdLicenseService ndLicenseService;
	@Autowired
	INdPunishService ndPunishService;
	
	@RequestMapping("/doEnOrganStruct")
	@ResponseBody
	public ModelAndView doEnOrganStruct(String menu){
		ModelAndView mv = new ModelAndView("gateway/biz/reception/organ_struct");
		mv.addObject("menu", menu);
		return mv;
	}
	
    /**
     * 进入信用临安前台信用动态
     * @return
     */
    @RequestMapping("/doEnCreditDynamic")
    @ResponseBody
    public ModelAndView doEnCreditDynamic(String menu) throws Exception {
        ModelAndView mv = new ModelAndView("gateway/biz/reception/credit_dynamic");
        mv.addObject("menu",menu);
        return mv;
    }

    /**
     * 进入信用临安政策法规
     *
     * @return
     */
    @RequestMapping("/doEnPolicyRule")
    @ResponseBody
    public ModelAndView doEnPolicyRule(String menu) throws Exception {
        ModelAndView mv = new ModelAndView("gateway/biz/reception/policy_rule");
        mv.addObject("menu",menu);
        return mv;
    }
    /**
     * 进入信用临安信用研究
     *
     * @return
     */
    @RequestMapping("/doEnCreditResearch")
    @ResponseBody
    public ModelAndView doEnCreditResearch(String menu) throws Exception {
        ModelAndView mv = new ModelAndView("gateway/biz/reception/credit_research");
        mv.addObject("menu",menu);
        return mv;
    }
    /**
     * 进入信用临安信用查询
     *
     * @return
     */
    @RequestMapping("/doEnCreditSearch")
    @ResponseBody
    public ModelAndView doEnCreditSearch(String menu) throws Exception {
        ModelAndView mv = new ModelAndView("gateway/biz/reception/credit_search");
        mv.addObject("menu",menu);
        return mv;
    }
    /**
     * 进入信用临安发布平台
     *
     * @return
     */
    @RequestMapping("/doEnPublishPlatform")
    @ResponseBody
    public ModelAndView doEnPublishPlatform(String menu) throws Exception {
        ModelAndView mv = new ModelAndView("gateway/biz/reception/publish_platform");
        mv.addObject("menu",menu);
        return mv;
    }
    /**
     * 进入信用临安互动交流
     *
     * @return
     */
    @RequestMapping("/doEnInterCommunion")
    @ResponseBody
    public ModelAndView doEnInterCommunion(String menu) throws Exception {
        ModelAndView mv = new ModelAndView("gateway/biz/reception/inter_communion");
        mv.addObject("menu",menu);
        return mv;
    }

    /**
     * 获取session中的校验码
     * @return
     */
    @RequestMapping("/doGetSessionValidateCode")
    @ResponseBody
    public AjaxResult doGetSessionValidateCode(HttpSession session) throws Exception {
        Object obj = session.getAttribute(Constants.SESSION_NDRC_VALIDATE_KEY);
        String code = obj!=null?obj.toString():"";
        return AjaxResult.success("validatecode",code);
    }

    /**
     * 进入信用咨询页面
     */
    @RequestMapping("/doEnCreditConsult")
    @ResponseBody
    public ModelAndView doEnCreditConsult() throws Exception {
        ModelAndView mv = new ModelAndView("gateway/biz/reception/inter_consult");
        return mv;
    }

    /**
     * 进入信用申诉页面
     */
    @RequestMapping("/doEnCreditAppeal")
    @ResponseBody
    public ModelAndView doEnCreditAppeal() throws Exception {
        ModelAndView mv = new ModelAndView("gateway/biz/reception/inter_appeal");
        return mv;
    }

    /**
     * 进入信用反馈结果页
     */
    @RequestMapping("/doEnCreditFeedback")
    @ResponseBody
    public ModelAndView doEnCreditFeedback() throws Exception {
        ModelAndView mv = new ModelAndView("gateway/biz/reception/inter_feedback");
        return mv;
    }


    /**
     * 进入信用红名单
     */
    @RequestMapping("/doEnCreditRed")
    @ResponseBody
    public ModelAndView doEnCreditRed(String uid,String name) throws Exception {
        ModelAndView mv = new ModelAndView("gateway/biz/reception/publish_platform_red");
        mv.addObject("uid", uid);
        mv.addObject("name", name);
        return mv;
    }

    /**
     * 进入信用黑名单
     */
    @RequestMapping("/doEnCreditBlack")
    @ResponseBody
    public ModelAndView doEnCreditBlack(String uid,String name) throws Exception {
        ModelAndView mv = new ModelAndView("gateway/biz/reception/publish_platform_black");
        mv.addObject("uid", uid);
        mv.addObject("name", name);
        return mv;
    }

    /**
     * 进入部门公示
     */
    @RequestMapping("/doEnCreditDept")
    @ResponseBody
    public ModelAndView doEnCreditDept() throws Exception {
        ModelAndView mv = new ModelAndView("gateway/biz/reception/publish_platform_dept");
        return mv;
    }

    /**
     * 进入七天双公示
     */
    @RequestMapping("/doEnCreditDouble")
    public ModelAndView doEnCreditDouble(String uid,String type,String name) throws Exception {
        ModelAndView mv = new ModelAndView("gateway/biz/reception/publish_platform_double");
        if(type.equals(SevenDoubleEnum.XK.getType())){
    		mv.addObject("type", SevenDoubleEnum.XK.getCode());
    	}else if(type.equals(SevenDoubleEnum.CF.getType())){
    		mv.addObject("type", SevenDoubleEnum.CF.getCode());
    	}
        mv.addObject("uid", uid);
        mv.addObject("name", name);
        return mv;
    }
    

    /**
     * 进入临安门户后台首页
     */
    @RequestMapping("/mainpage")
    @ResponseBody
    public ModelAndView mainpage() throws Exception {
        ModelAndView mv = new ModelAndView("gateway/biz/backstage/backstage_main");
       
        NdCountCatalog ndCountCatalog = new NdCountCatalog();
        NdrcNewsPublishDto ndrcNewsPublishDto = new NdrcNewsPublishDto();
        //信用动态
        ndrcNewsPublishDto = ndNewsPublishService.selectCountPublishByType1Code("1000");
        ndCountCatalog.setCountCreditDynamic(ndrcNewsPublishDto.getCount());
        ndCountCatalog.setTimeCreditDynamic(ndrcNewsPublishDto.getUpdateTime());
        //政策法规
        ndrcNewsPublishDto = ndNewsPublishService.selectCountPublishByType1Code("1001");
        ndCountCatalog.setCountPolicy(ndrcNewsPublishDto.getCount());
        ndCountCatalog.setTimePolicy(ndrcNewsPublishDto.getUpdateTime());
        //信用研究
        ndrcNewsPublishDto = ndNewsPublishService.selectCountPublishByType1Code("1002");
        ndCountCatalog.setCountCreditRule(ndrcNewsPublishDto.getCount());
        ndCountCatalog.setTimeCreditRule(ndrcNewsPublishDto.getUpdateTime());
        //视频资料
        ndrcNewsPublishDto = ndNewsPublishService.selectCountPublishByType2Code("2008");
        ndCountCatalog.setCountVideo(ndrcNewsPublishDto.getCount());
        ndCountCatalog.setTimeVideo(ndrcNewsPublishDto.getUpdateTime());
        //红名单
        NdRedBlackListDto ndRedBlackListDto = ndRedBlackListService.selectCountRedBlack("r");
        ndCountCatalog.setCountRedList(ndRedBlackListDto.getCountRedBlack());
        ndCountCatalog.setTimeRedList(ndRedBlackListDto.getIncludeListDate());
        //黑名单
        ndRedBlackListDto = ndRedBlackListService.selectCountRedBlack("b");
        ndCountCatalog.setCountBlackList(ndRedBlackListDto.getCountRedBlack());
        ndCountCatalog.setTimeBlackList(ndRedBlackListDto.getIncludeListDate());
       
        //七天双公示
        NdLicenseDto ndLicenseDto = ndLicenseService.selectCountAndTime();
        if(ndLicenseDto!=null){
        ndCountCatalog.setCountSevenDouble(Integer.valueOf(ndLicenseDto.getCountNum()));
        ndCountCatalog.setTimeSevenDouble(ndLicenseDto.getInputDate());
        }
        mv.addObject("ndCountCatalog", ndCountCatalog);
        return mv;
    }





}
