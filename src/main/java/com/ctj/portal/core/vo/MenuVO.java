package com.ctj.portal.core.vo;

import com.ctj.portal.core.po.Menu;

public class MenuVO {
    private String id;
    private String name;
    private String parentId;
    private String url;
    private String icon;
    private String type;
    private String creTime;
    private String sortNum;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuVO() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MenuVO(Menu menu) {
        this.id = menu.getId();
        this.name = menu.getName();
        this.url = menu.getUrl();
        this.icon = menu.getIcon();
        this.type = menu.getType();
        this.sortNum = menu.getSortNum();
        this.creTime = menu.getCreTime();
        Menu parent = menu.getParent();
        if (parent != null) {
            this.parentId = parent.getId();
        } else {
            this.parentId = null;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreTime() {
        return creTime;
    }

    public void setCreTime(String creTime) {
        this.creTime = creTime;
    }

    public String getSortNum() {
        return sortNum;
    }

    public void setSortNum(String sortNum) {
        this.sortNum = sortNum;
    }

    public MenuVO(Menu menu, String rootId) {
        this(menu);
        if (rootId != null && rootId.length() > 0) {
            if (this.parentId == null) {
                this.parentId = rootId;
            }
        }
    }


    @Override
    public String toString() {
        return "MenuVO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", parentId='" + parentId + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", type='" + type + '\'' +
                ", creTime='" + creTime + '\'' +
                ", sortNum='" + sortNum + '\'' +
                '}';
    }
}
