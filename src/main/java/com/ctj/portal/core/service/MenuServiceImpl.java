package com.ctj.portal.core.service;

import com.ctj.portal.core.dao.IMenuDao;
import com.ctj.portal.core.po.Menu;
import com.ctj.portal.core.vo.MenuVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * 菜单service接口实现类
 */
@Service("menuService")
public class MenuServiceImpl implements IMenuService {
    @Resource
    private IMenuDao menuDao;


    @Override
    public void add(MenuVO vo) {
        if ("root".equals(vo.getParentId())) {
            vo.setParentId(null);
        }
        Menu menu = new Menu();
        BeanUtils.copyProperties(vo, menu);
        if (vo.getParentId() != null) {
            Menu p = menuDao.findById(vo.getParentId()).get();
            menu.setParent(p);
        }
        menuDao.save(menu);
    }

    @Transactional
    public List<MenuVO> findTreeAll() {
        List<MenuVO> list = new ArrayList<MenuVO>();
        try {
            List<Menu> all = menuDao.findAll();
            for (Menu m : all) {
                list.add(new MenuVO(m, "root"));
            }
            MenuVO vo = new MenuVO();
            vo.setId("root");
            vo.setName("菜单树");
            list.add(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获取菜单中的根节点
     *
     * @return List<Menu>
     */
    @Transactional
    public List<MenuVO> getRoots() {
        List<MenuVO> list = new ArrayList<MenuVO>();
        try {
            List<Menu> roots = menuDao.getRoots();
            if (roots != null && roots.size() > 0) {
                for (Menu menu : roots) {
                    MenuVO vo = new MenuVO(menu);
                    list.add(vo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    @Transactional
    public List<MenuVO> getChildren(String parentId) {
        List<MenuVO> list = new ArrayList<MenuVO>();
        try {
            List<Menu> menus = menuDao.getChildren(parentId);
            recursionMenu(list, menus);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 递归菜单
     *
     * @param result 接受结果的list
     * @param list   来源list
     */
    private void recursionMenu(List<MenuVO> result, List<Menu> list) {
        if (list != null && list.size() > 0) {
            for (Menu m : list) {
                result.add(new MenuVO(m));
                Set<Menu> children = m.getChildren();
                if (children != null) {
                    recursionMenu(result, new ArrayList<Menu>(children));
                }
            }
        }
    }

    @Override
    public List<MenuVO> getChild(String parentId) {
        List<MenuVO> list = new ArrayList<MenuVO>();
        try {
            List<Menu> menus = menuDao.getChildren(parentId);
            if (menus != null && menus.size() > 0) {
                for (Menu m : menus) {
                    MenuVO vo = new MenuVO(m);
                    list.add(vo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public MenuVO findById(String id) {

        Menu menu = menuDao.findById(id).get();
        MenuVO vo = new MenuVO(menu);

        return vo;
    }
}
