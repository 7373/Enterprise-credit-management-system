/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.ndrc.system.controller;

import com.icinfo.ndrc.support.Constants;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.security.shiro.ShiroChainReloadService;
import com.icinfo.framework.tools.utils.StringUtils;
import com.icinfo.ndrc.system.dto.PermisionTreeNode;
import com.icinfo.ndrc.system.dto.SysPermisionDto;
import com.icinfo.ndrc.system.model.SysPermision;
import com.icinfo.ndrc.system.service.ISysPermisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述:  系统权限控制器.<br>
 *
 * @author xiajunwei
 * @date 2016年05月06日
 */
@Controller
@RequestMapping("/gateway/system/syspermision")
public class GateWaySysPermisionController extends BaseController {
    @Autowired
    private ISysPermisionService sysPermisionService;

    @Autowired
    private ShiroChainReloadService shiroChainReloadService;

    /**
     * 进入系统权限页面
     *
     * @return 系统权限页面
     * @throws Exception
     */
    @RequestMapping("/list")
    public String list() throws Exception {
        return "gateway/system/syspermision/list";
    }

    /**
     * 返回权限JSON数据
     *
     * @return 权限数据
     * @throws Exception
     */
    @RequestMapping({"/list.json", "list.xml"})
    @ResponseBody
    public AjaxResult listJSON() throws Exception {
        //查询所有权限
        List<SysPermision> permisions = sysPermisionService.selectAllByPermisionSysType(Constants.GATEWAY_USER_TYPE);
        //构造ztree节点数据
        List<PermisionTreeNode> treeNodes = new ArrayList<PermisionTreeNode>();
        for (SysPermision p : permisions) {
            PermisionTreeNode treeNode = new PermisionTreeNode();
            treeNode.setId(p.getUid());
            if (StringUtils.isNotEmpty(p.getParentId())) {
                treeNode.setpId(p.getParentId());
            } else {
                treeNode.setpId("0");
            }
            treeNode.setName(p.getName());
            treeNodes.add(treeNode);
        }
        return AjaxResult.success("加载权限数据成功", treeNodes);
    }

    /**
     * 显示系统权限维护
     *
     * @param id  编辑权限ID
     * @param sid 权限树选中权限ID
     * @return 权限维护页面
     * @throws Exception
     */
    @RequestMapping("/show")
    public ModelAndView show(String id, String sid) throws Exception {
        ModelAndView view = new ModelAndView("gateway/system/syspermision/edit");
        SysPermision sysPermision = null;
        System.out.println(id);
        System.out.println(sid);
        if (StringUtils.isNotEmpty(id)) {
            //修改是加载原权限信息
            sysPermision = sysPermisionService.selectByPrimaryKey(id);
            if (sysPermision != null) {
                view.addObject("sysPermision", sysPermision);
                
                if (StringUtils.isNotEmpty(sysPermision.getParentId())) {
                    //如果是修改，需要显示父权限名称
                    SysPermision parent = sysPermisionService.selectByPrimaryKey(sysPermision.getParentId());
                    view.addObject("parentName", parent.getName());
                }
            }
        }
        if (sysPermision == null) {
            //新增权限处理
            if (StringUtils.isNotEmpty(sid)) {
                SysPermision _temp = sysPermisionService.selectByPrimaryKey(sid);
                if (_temp != null) {
                    view.addObject("parentIdForSub", _temp.getUid());
                    view.addObject("parentIdForSibling", _temp.getParentId());
                }
            }
        }
        return view;
    }

    /**
     * 获取系统权限资源
     *
     * @param id 资源id
     * @return 资源数据
     * @throws Exception
     */
    @RequestMapping("/query")
    @ResponseBody
    public AjaxResult load(String id) throws Exception {
        if (StringUtils.isEmpty(id)) {
            return AjaxResult.error("系统权限不存在");
        }
        SysPermision sysPermision = sysPermisionService.selectByPrimaryKey(id);
        if (sysPermision != null) {
            return AjaxResult.success("加载成功", sysPermision);
        } else {
            return AjaxResult.error("系统权限不存在");
        }
    }

    /**
     * 保存系统权限信息
     *
     * @param sysPermision 权限对象
     * @return 保存结果
     * @throws Exception
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult save(@Valid SysPermisionDto sysPermision, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            //参数验证错误
            AjaxResult error = AjaxResult.error("参数验证错误");
            error.addErrorInfo(result.getAllErrors());
            return error;
        }
        if (StringUtils.isNotEmpty(sysPermision.getUid())) {
            if (sysPermisionService.update(sysPermision) > 0) {
                return AjaxResult.success("更新系统权限成功", sysPermision);
            }
            return AjaxResult.error("更新系统权限失败");
        }
        if (sysPermisionService.insert(sysPermision) > 0) {
            return AjaxResult.success("新增系统权限成功", sysPermision);
        }
        return AjaxResult.error("新增系统权限失败");
    }

    /**
     * 删除系统权限
     *
     * @param id 权限ID
     * @return 操作结果
     * @throws Exception
     */
    @RequestMapping("/delete")
    @ResponseBody
    public AjaxResult delete(String id) throws Exception {
        if (StringUtils.isEmpty(id)) {
            return AjaxResult.error("删除的权限不存在!");
        }
        if (sysPermisionService.deleteByPrimaryKey(id) > 0) {
            return AjaxResult.success("删除系统权限成功");
        }
        return AjaxResult.error("删除的权限失败!");
    }

    @RequestMapping("/reload")
    @ResponseBody
    public AjaxResult reload() throws Exception {
        shiroChainReloadService.reloadChainDefinitions();
        return AjaxResult.success("系统权限定义刷新成功！");
    }
}
