package com.example.demo.Control;



import com.example.demo.Game.Game;
import com.example.demo.Game.GameService;
import com.example.demo.Game.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(path = "/demo")
public class GameControl {

    @Autowired
   GameService gameService;

    @GetMapping("/start/{nazwa}")
    public ResponseEntity<Player> getPlayer(@PathVariable String nazwa) {
        return ResponseEntity.ok(gameService.getPlayer(nazwa));
    }

    @PostMapping("/start/{nazwa}")
    public ResponseEntity<Player> addPlayer(@PathVariable Player nazwa) {
        return ResponseEntity.ok(gameService.addPlayer(nazwa));
    }
    @GetMapping( "/guess/{nazwa}/{numer}")
    public ResponseEntity<String> guess(@PathVariable String nazwa, @PathVariable Integer numer) {
        return ResponseEntity.ok(gameService.guess(nazwa, numer));
    }
    @GetMapping( "/highscores")
    public ResponseEntity<List<Game>> najwiekszyWynik() {

        return ResponseEntity.ok(gameService.najwiekszyWynik());
    }

}
