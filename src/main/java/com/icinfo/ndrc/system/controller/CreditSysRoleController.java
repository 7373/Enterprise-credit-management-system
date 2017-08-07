/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.ndrc.system.controller;

import com.icinfo.ndrc.support.Constants;
import com.icinfo.ndrc.system.dto.SysRoleDto;
import com.icinfo.ndrc.system.model.SysRole;
import com.icinfo.ndrc.system.model.SysRolePermision;
import com.icinfo.ndrc.system.service.ISysRolePermisionService;
import com.icinfo.ndrc.system.service.ISysRoleService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 描述:  系统用户角色控制器.<br>
 *
 * @author xiajunwei
 * @date 2016年04月29日
 */
@Controller
@RequestMapping("/credit/system/sysrole")
public class CreditSysRoleController extends BaseController {
    @Autowired
    private ISysRoleService sysRoleService;
    @Autowired
    private ISysRolePermisionService sysRolePermisionService;

    /**
     * 进入系统用户角色列表
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/list")
    public String list() throws Exception {
        return "credit/system/sysrole/list";
    }

    /**
     * 返回系统用户角色列表数据
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping({"/list.json", "list.xml"})
    @ResponseBody
    public PageResponse<SysRole> listJSON(PageRequest request) throws Exception {
        List<SysRole> data = sysRoleService.queryPage(request, Constants.CREDIT_USER_TYPE);
        return new PageResponse<SysRole>(data);
    }

    /**
     * 显示角色编辑对话框
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/show")
    public ModelAndView show(String id) throws Exception {
        ModelAndView view = new ModelAndView("credit/system/sysrole/edit");
        if (StringUtils.isNotEmpty(id)) {
            SysRole sysRole = sysRoleService.selectByUID(id);
            if (sysRole != null) {
                view.addObject("sysRole", sysRole);
            }
        }
        return view;
    }

    /**
     * 角色信息保存
     *
     * @param sysRole
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult save(@RequestBody SysRoleDto sysRole) throws Exception {
        if (StringUtils.isNotEmpty(sysRole.getUid())) {
            if (sysRoleService.update(sysRole, sysRole.getPermisions()) > 0) {
                return AjaxResult.success("更新角色信息成功");
            }
            return AjaxResult.error("更新角色信息失败!");
        }
        
	        if (sysRoleService.insert(sysRole, sysRole.getPermisions()) > 0) {
	            return AjaxResult.success("创建角色成功.");
	        }
	        return AjaxResult.error("创建角色失败!");
        
    }

    /**
     * 删除用户角色
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete")
    @ResponseBody
    public AjaxResult delete(String uid) throws Exception {
        if (StringUtils.isEmpty(uid)) {
            return AjaxResult.error("未选择删除角色!");
        }
        if (sysRoleService.deleteByPrimaryKey(uid) > 0) {
            return AjaxResult.success("删除角色成功.");
        }
        return AjaxResult.error("删除角色失败!");
    }

    /**
     * 查询角色权限
     *
     * @param roleId
     * @return
     */
    @RequestMapping("/permisions.json")
    @ResponseBody
    public AjaxResult listRolePermisionJSON(String roleId) throws Exception {
        List<SysRolePermision> privilege = sysRolePermisionService.selectAllRolePermision(roleId);
        return AjaxResult.success("加载角色权限成功", privilege);
    }
}
