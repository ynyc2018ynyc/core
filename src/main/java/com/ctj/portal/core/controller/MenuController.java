package com.ctj.portal.core.controller;

import com.ctj.portal.core.po.Menu;
import com.ctj.portal.core.service.IMenuService;
import com.ctj.portal.core.vo.MenuVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单Controller
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    private IMenuService menuService;

    @Resource(name = "menuService")
    public void setMenuService(IMenuService menuService) {
        this.menuService = menuService;
    }

    /**
     * 跳转到左侧导航树，并加载accordion
     *
     * @param model    model
     * @param request  request
     * @param parentId 父节点id
     * @return String
     */
    @RequestMapping("/toLeft")
    public String toLeft(Model model, HttpServletRequest request, String parentId) {
        List<MenuVO> list = new ArrayList<MenuVO>();
        try {
            String path = request.getContextPath();
            String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
            model.addAttribute("path", path);
            model.addAttribute("basePath", basePath);
            list = menuService.getChild(parentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("lists", list);
        return "left";
    }

    @RequestMapping("/toAdd")
    public String toAdd(Model model, HttpServletRequest request, String pId) {
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
        model.addAttribute("path", path);
        model.addAttribute("basePath", basePath);
        model.addAttribute("pId", pId);
        try {
            MenuVO vo = new MenuVO();
            if (pId == null || "root".equals(pId)) {
                vo.setName("菜单树");
                vo.setId("root");
            } else {
                vo = menuService.findById(pId);
            }

            model.addAttribute("vo", vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "menu/add";
    }

    /**
     * 加载主页面top导航菜单
     *
     * @param model   model
     * @param request request
     * @return String
     */
    @RequestMapping("/toTop")
    public String toTop(Model model, HttpServletRequest request) {
        List<MenuVO> list = new ArrayList<MenuVO>();
        try {
            String path = request.getContextPath();
            String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
            model.addAttribute("path", path);
            model.addAttribute("basePath", basePath);
            list = menuService.getRoots();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("lists", list);
        return "top";
    }

    /**
     * 获取所有的菜单
     *
     * @return List<MenuVO>
     */
    @RequestMapping("/getTreeAll")
    @ResponseBody
    public List<MenuVO> getTreeAll() {
        return menuService.findTreeAll();
    }

    /**
     * 跳转到菜单管理列表
     *
     * @return String
     */
    @RequestMapping("/toList")
    public String toList(Model model, HttpServletRequest request) {
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
        model.addAttribute("path", path);
        model.addAttribute("basePath", basePath);
        return "menu/list";
    }

    /**
     * 根据节点id获取子节点树
     *
     * @param pId 父菜单id
     * @return List<MenuVO>
     */
    @RequestMapping("/getTree")
    @ResponseBody
    public List<MenuVO> getChildren(String pId) {
        return menuService.getChildren(pId);
    }

    /**
     * 根据节点id获取，直接子节点
     *
     * @param pId 父节点id
     * @return 直接子节点列表
     */
    @RequestMapping("/getChild")
    @ResponseBody
    public List<MenuVO> getChild(String pId) {
        if (pId == null || pId.length() == 0 || "root".equals(pId)) {
            return menuService.getRoots();
        }
        return menuService.getChild(pId);
    }

    @RequestMapping("/add")
    @ResponseBody
    public Map<String, String> add(MenuVO vo) {
        Map<String, String> map = new HashMap<String, String>();
        try {
            menuService.add(vo);
            map.put("status", "success");
        } catch (BeansException e) {
            e.printStackTrace();
            map.put("status", "fail");
        }
        return map;
    }

}
