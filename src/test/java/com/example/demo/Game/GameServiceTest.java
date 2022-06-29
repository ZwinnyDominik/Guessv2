package com.example.demo.Game;

import com.example.demo.Game.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.demo.Game.Player;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class GameServiceTest {
    @Autowired
    GameService gameService;
    @Test
    @BeforeEach
    void addPlayer() {
        Player player = new Player("test1");
        Player player2 = new Player("test2");
        player.setNumer(1);

        gameService.addPlayer(player);
        gameService.addPlayer(player2);
        gameService.addGames(addGame());

    }

    @Test
    void guessHigh() {

        String nazwa = "test1";
        Player player = gameService.getPlayer(nazwa);

        String wiadomosc = gameService.guess(nazwa, 555);
        assertThat(player.getNazwa()).isEqualTo(nazwa);
    }
    @Test
    void guessLow() {

        String nazwa = "test1";
        Player player = gameService.getPlayer(nazwa);

        String wiadomosc = gameService.guess(nazwa, -5);
        assertThat(player.getNazwa()).isEqualTo(nazwa);
    }
    @Test
    public void SearchPlayer() {
        String name = "test1";
        Player player = gameService.getPlayer(name);

        assertThat(player.getNazwa())
                .isEqualTo(name);
    }
    @Test
    void top10() {

        List<Game> testGame = new ArrayList<>();
        Game game1 = new Game(1);
        Game game2 = new Game(3);
        Game game3 = new Game(3);
        Game game4 = new Game(4);
        Game game5 = new Game(4);
        Game game6 = new Game(5);
        Game game7 = new Game(5);
        Game game8 = new Game(6);
        Game game9 = new Game(7);
        Game game10 = new Game(23);



        testGame.add(game1);
        testGame.add(game2);
        testGame.add(game3);
        testGame.add(game4);
        testGame.add(game5);
        testGame.add(game6);
        testGame.add(game7);
        testGame.add(game8);
        testGame.add(game9);
        testGame.add(game10);

        assertThat(testGame)
                .isEqualTo(gameService.najwiekszyWynik());

        assertThat(gameService.najwiekszyWynik()).hasSize(10);

    }
    public static List<Game> addGame(){
        List<Game> testGame = new ArrayList<>();
        Game game1 = new Game(1);
        Game game2 = new Game(2);
        Game game3 = new Game(3);
        Game game4 = new Game(4);
        Game game5 = new Game(5);
        Game game6 = new Game(6);
        testGame.add(game1);
        testGame.add(game2);
        testGame.add(game3);
        testGame.add(game4);
        testGame.add(game5);
        testGame.add(game6);
        return  testGame;
    }


}