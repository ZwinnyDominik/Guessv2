package com.example.demo.Game;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GameService {


    PlayerData playerData = new PlayerData();
    List<Player> playerList = playerData.getPlayerList();

    Game game = new Game();
    List<Game> gameList = new ArrayList<>();

    public Player addPlayer(Player player) {

        Player newPlayer = new Player();
        newPlayer.setNazwa(player.getNazwa());

        for (Player gamer : playerList) {
            if (newPlayer.getNazwa().equals(gamer.getNazwa())) {
                System.out.println("Gamer już istnieje ");
                return null;
            }
        }
        playerList.add(newPlayer);
        return newPlayer;
    }

    public Player getPlayer(String nazwa) {
        return Optional.of(playerData.getPlayerList()
                        .stream()
                        .filter(player -> player.getNazwa().equals(nazwa))
                        .findFirst()
                        .get())
                .orElse(null);
    }

    public String guess(String nazwa, Integer numer) {


        Player player = getPlayer(nazwa);
        player.setWiadomosc("gracz");
        Random random = new Random();

        if (player.getNumer() == 0) {
            int newNumer = random.nextInt(101);
            player.setNumer(newNumer);
            player.setProba(1);
            System.out.println("numer gry: " + player.getNumer());

            game = new Game();
        }

        if (player.getNumer() > numer) {
            player.setWiadomosc("Za mało ");
            player.liczProby();
        }

        if (player.getNumer() < numer) {
            player.setWiadomosc("Za dużo ");
            player.liczProby();
        }

        if (player.getNumer() == numer) {
            player.setWiadomosc("Wygrałeś ");
            game.setWynik(player.getProba());
            gameList.add(game);
        }

        return player.getWiadomosc();
    }
    public List<Game> addGames(List<Game> list) {
        gameList = list;
        return gameList;
    }
    public List<Game> najwiekszyWynik() {

        return gameList.stream()
                .sorted(Comparator.comparingInt(Game::najwiekszyWynik))
                .limit(10)
                .collect(Collectors.toList());
    }
}
