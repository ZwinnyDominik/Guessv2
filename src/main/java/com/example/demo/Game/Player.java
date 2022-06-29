package com.example.demo.Game;


import lombok.*;
import org.springframework.stereotype.Component;


@EqualsAndHashCode
@Component
@Getter
@Setter
public class Player {

    private String nazwa;
    private String wynik;
    private int numer;
    private String wiadomosc;
    private int proba;

    public Player() {
        numer =0;
    }

    public Player(String nazwa) {
        this.nazwa = nazwa;
    }

    public void liczProby() {
        proba++;
    }

}
