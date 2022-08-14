package com.example.jpademo.OneToMany.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: BaBy
 * @Date: 2022/8/14 15:12
 */
@Data
@Entity
public class Player {
    @Id
    @GeneratedValue
    private Long id;

    private String lastName;

    @ManyToOne // 多端
    private Team team;

    public String getLastName() {
        return this.lastName;
    }
}
