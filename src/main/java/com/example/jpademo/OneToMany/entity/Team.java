package com.example.jpademo.OneToMany.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

/**
 * @Author: BaBy
 * @Date: 2022/8/14 15:15
 */
@Data
@Entity
public class Team implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String teamName;

    @OneToMany(mappedBy = "team") // 一端
    private Collection<Player> players;

    public Team() {
        players = new HashSet<>();
    }
}