package com.ctj.portal.core.service;

import com.ctj.portal.core.vo.MenuVO;

import java.util.List;

/**
 * 菜单service接口
 */
public interface IMenuService {
    void add(MenuVO vo);

    MenuVO findById(String id);

    List<MenuVO> findTreeAll();

    List<MenuVO> getRoots();

    /**
     * 根据节点id获取子节点树
     *
     * @param parentId 父节点id
     * @return 符合条件的所有子节点
     */
    List<MenuVO> getChildren(String parentId);

    /**
     * 根据节点id获取直接子节点
     *
     * @param parentId 父节点id
     * @return 符合条件的直接子节点
     */
    List<MenuVO> getChild(String parentId);
}
