package com.ctj.portal.core.service;

import com.ctj.portal.core.po.Menu;
import com.ctj.portal.core.vo.MenuVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
public class MenuServiceImplTest {
    private IMenuService menuService;

    @Resource(name = "menuService")
    public void setMenuService(IMenuService menuService) {
        this.menuService = menuService;
    }

    @Test
    public void add() {
        MenuVO vo = new MenuVO();
        vo.setName("其他设置");
        menuService.add(vo);
    }

    @Test
    public void findAll() {
        menuService.findTreeAll();
    }

    @Test
    public void getRoots() {
        List<MenuVO> list = menuService.getRoots();
        for(MenuVO m:list){
            System.out.println(m);
        }
    }

    @Test
    public void getChildren() {
        String parentId = "40289ff665b30ded0165b30df5b50000";
        List<MenuVO> children = menuService.getChildren(parentId);
        for(MenuVO vo :children){
            System.out.println(vo);
        }
    }
}