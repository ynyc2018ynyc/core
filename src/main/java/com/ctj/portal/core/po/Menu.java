package com.ctj.portal.core.po;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * 菜单
 */
@Entity
@Table(name = "sys_menu")
public class Menu {
    /**
     * 菜单id
     */
    private String id;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 父菜单
     */
    private Menu parent;
    /**
     * 子菜单
     */
    private Set<Menu> children;
    /**
     * 跳转地址
     */
    private String url;
    /**
     * 图标
     */
    private String icon;

    private String type;
    private String creTime;
    private String sortNum;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "uuid")
    @Column(name = "menu_id", length = 32)
    public String getId() {
        return id;
    }

    @Column(name = "menu_name", length = 128, nullable = false)
    public String getName() {
        return name;
    }

    @ManyToOne
    @JoinColumn(name = "parent_menu_id")
    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    @OneToMany(mappedBy = "parent")
    public Set<Menu> getChildren() {
        return children;
    }

    public void setChildren(Set<Menu> children) {
        this.children = children;
    }

    public String getUrl() {
        return url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "menu_type", length = 1)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "cre_time", length = 19)
    public String getCreTime() {
        return creTime;
    }

    public void setCreTime(String creTime) {
        this.creTime = creTime;
    }

    @Column(name = "sort_num", length = 4)
    public String getSortNum() {
        return sortNum;
    }

    public void setSortNum(String sortNum) {
        this.sortNum = sortNum;
    }
}
