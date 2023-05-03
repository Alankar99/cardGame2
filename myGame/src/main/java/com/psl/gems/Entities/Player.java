package com.psl.gems.Entities;

import java.util.*;

public class Player extends PackOfCards{
    String name;

    List<Card> cardsInHand = new ArrayList<>();

    int highCardValue;
//List<Card> cardsInHand = Arrays.asList();


    public Player() {
    }

    public Player(String name, List<Card> cardsInHand) {
        this.name = name;
        this.cardsInHand = cardsInHand;
        this.highCardValue = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getCardsInHand() {
        return cardsInHand;
    }

    public void setCardsInHand(List<Card> cardsInHand) {
        this.cardsInHand = cardsInHand;
    }

    public int getHighCardValue() {
        return highCardValue;
    }

    public void setHighCardValue(int highCardValue) {
        this.highCardValue = highCardValue;
    }

}
