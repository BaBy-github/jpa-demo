package com.example.jpademo.RBAC.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: BaBy
 * @Date: 2022/8/16 23:03
 */
@Getter
@Setter
@Entity
@Table(name = "tb_permission")
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = 30)
    private String code;

    @ManyToMany(targetEntity = Role.class, mappedBy = "permissions")
    private Set<Role> roles = new HashSet<>();

    public Permission(String code) {
        this.code = code;
    }
}
