package com.example.demo.Game;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@EqualsAndHashCode
@Getter
@Setter
@Component
public class Game {


    private String nazwa;
    private int wynik;
    public Game(){}
    public Game(int wynik){this.wynik = wynik;}
    public int najwiekszyWynik(){
        return wynik;
    }



}

