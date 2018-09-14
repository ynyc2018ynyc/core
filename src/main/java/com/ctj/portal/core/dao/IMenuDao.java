package com.ctj.portal.core.dao;


import com.ctj.portal.core.po.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 菜单dao接口
 */
public interface IMenuDao extends JpaSpecificationExecutor<Menu>, JpaRepository<Menu, String> {
    @Query("from Menu m where m.parent is null order by m.type asc,m.sortNum asc")
    List<Menu> getRoots();

    @Query("from Menu m where m.parent.id = ?1 order by m.type asc,m.sortNum asc")
    List<Menu> getChildren(String parentId);
}
