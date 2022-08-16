package com.example.jpademo.RBAC.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 使用@ManyToMany或者@OneToMany时，不能使用@Data注解，否则会出问题。因为@Data注解会自动生成hash。
 * @Author: BaBy
 * @Date: 2022/8/16 22:35
 */
@Getter
@Setter
@Entity
@Table(name = "tb_role")
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = 30)
    private String roleName;

    @ManyToMany(cascade = {CascadeType.REFRESH},
            targetEntity = Permission.class,
            fetch = FetchType.EAGER)
    @JoinTable(name = "m_role_permission",
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id")})
    private Set<Permission> permissions = new HashSet<>();

    @ManyToMany(targetEntity = User.class, mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    public Role(String roleName) {
        this.roleName = roleName;
    }
}