package com.example.demo.Control;

import com.example.demo.Game.GameService;
import com.example.demo.Game.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;


@SpringBootTest
@AutoConfigureMockMvc
class GameControlTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    GameService gameService;



  @BeforeEach
  public void addPlayer(){
      Player player = new Player("test1");
      Player player2 = new Player("test2");
      gameService.addPlayer(player);
      gameService.addPlayer(player2);
  }
  @Test
  void createPlayer() throws Exception{
      this.mockMvc
                      .perform(post("/demo/start")
                              .contentType(MediaType.APPLICATION_JSON));
                       assertThat(gameService.getPlayer("test1").getNazwa()).isEqualTo("test1");
  }
    @Test
    void guessTry() throws Exception {

        this.mockMvc
                .perform(get("/demo/guess/test1/4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"));


    }
    @Test
    void najwiekszyWynik() throws Exception {
        this.mockMvc
                .perform(get("/demo/highscores"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));


    }
}