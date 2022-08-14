package com.example.jpademo.OneToMany.repository;

import com.example.jpademo.OneToMany.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: BaBy
 * @Date: 2022/8/14 15:58
 */
@Repository
public interface PlayerRepo extends JpaRepository<Player, Long> {
}
