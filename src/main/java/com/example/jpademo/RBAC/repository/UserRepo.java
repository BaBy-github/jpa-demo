package com.example.jpademo.RBAC.repository;

import com.example.jpademo.RBAC.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: BaBy
 * @Date: 2022/8/14 15:58
 */
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}
