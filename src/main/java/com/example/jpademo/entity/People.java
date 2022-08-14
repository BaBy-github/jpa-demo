package com.example.jpademo.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: BaBy
 * @Date: 2022/8/14 16:02
 */
@Data
@Entity
@Table(name="tb_people") // 自定义实体在数据库的表名 默认值为类名小写
public class People {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="first_name")  // 自定义属性在数据库的列名  默认值为属性名驼峰转下划线小写
    private String name;
}
