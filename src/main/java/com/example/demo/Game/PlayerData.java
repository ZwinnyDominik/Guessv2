package com.example.demo.Game;




import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlayerData {

    private static final List<Player> playerList = new ArrayList<>();

    public List<Player> getPlayerList() {
        return playerList;
    }
}
