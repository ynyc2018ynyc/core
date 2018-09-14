package com.ctj.portal.core.po;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 栏目频道
 */
@Entity
@Table(name = "sys_channel")
public class Channel {
    private String id;
    private String name;

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name="generator",strategy = "uuid")
    @Column(name = "channel_id", length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "channel_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
