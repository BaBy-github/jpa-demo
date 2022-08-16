package com.example.jpademo.RBAC.repository;

import com.example.jpademo.RBAC.entity.Permission;
import com.example.jpademo.RBAC.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: BaBy
 * @Date: 2022/8/14 15:58
 */
@Repository
public interface PermissionRepo extends JpaRepository<Permission, Integer> {
}
