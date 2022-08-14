package com.example.jpademo.controller;

import com.example.jpademo.OneToMany.entity.Player;
import com.example.jpademo.OneToMany.entity.Team;
import com.example.jpademo.OneToMany.repository.PlayerRepo;
import com.example.jpademo.OneToMany.repository.TeamRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class TeamPlayerControllerTest {
    @Autowired
    private MockMvc client;

    @Autowired
    private TeamRepo teamRepo;

    @Autowired
    private PlayerRepo playerRepo;

    @BeforeEach
    void setUp(){
        playerRepo.deleteAll();
        teamRepo.deleteAll();
    }

    @Test
    void saveTeamAndPlayer(){
        Team team = new Team();
        Player player = new Player();

        Team savedTeam = teamRepo.save(team);
        player.setTeam(savedTeam);
        Player savedPlayer = playerRepo.save(player);
    }

    @Test
    void findTeamByPlayer(){
        Team team = new Team();
        Player player = new Player();

        Team savedTeam = teamRepo.save(team);
        player.setTeam(savedTeam);
        Player savedPlayer = playerRepo.save(player);

        Player foundPlayer = playerRepo.findById(savedPlayer.getId()).orElseThrow();
        assertEquals(savedTeam.getId(), foundPlayer.getTeam().getId());
    }
}