package com.psl.gems.Entities;

public class Card {

    int rank;
    int suit;
    String pictureName;
    int value;

    public Card() {
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public Card(int rank, int suit, String pictureName, int value) {
        this.rank = rank;
        this.suit = suit;
        this.pictureName = pictureName;
        this.value = value;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


}
