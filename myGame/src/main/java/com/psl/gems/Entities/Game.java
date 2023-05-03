package com.psl.gems.Entities;

import java.util.*;
import java.math.*;

public class Game extends PackOfCards {

    List<Player> players = new ArrayList<>();
    Player player1 = new Player();
    Player player2 = new Player();
    List<Card> deck = new ArrayList<>();

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setPlayerNames(String playerName1 , String playerName2)
    {
        player1.setName(playerName1);
        player2.setName(playerName2);
    }

    public void play(String playerName1 , String playerName2)
    {
        shuffleCards();
        displayFullPack();
        setPlayerNames(playerName1 , playerName2);

        List<Card> p1 = new ArrayList<>();
        List<Card> p2 = new ArrayList<>();

        for (int i=0 ; i<6 ; i++)
        {
            if(i%2 == 0)
            {
                p1.add((fullPack).get(i));
            }
            else
            {
                p2.add((fullPack).get(i));
            }
        }
        player1.setCardsInHand(p1);
        player2.setCardsInHand(p2);

        players.add(player1);
        players.add(player2);
    }

    public List<Card> showHighCard()
    {
        Card highCardOfPlayer1 = player1.getCardsInHand().get(0);
        Card highCardOfPlayer2 = player2.getCardsInHand().get(0);

//      Collections.max(player1.getCardsInHand())

        for(int i=0 ; i<3 ; i++)
        {
            Card temp1 = player1.getCardsInHand().get(i);
            if( temp1.getValue() > highCardOfPlayer1.getValue())
            {
                highCardOfPlayer1 = temp1;
            }
        }

        for(int i=0 ; i<3 ; i++)
        {
            Card temp2 = player2.getCardsInHand().get(i);
            if( temp2.getValue() > highCardOfPlayer2.getValue())
            {
                highCardOfPlayer2 = temp2;
            }
        }

        List<Card> highCardList = new ArrayList<>();
        highCardList.add(highCardOfPlayer1);
        highCardList.add(highCardOfPlayer2);

        player1.setHighCardValue(highCardOfPlayer1.getValue());
        player2.setHighCardValue(highCardOfPlayer2.getValue());

        return highCardList;
    }

    public Player DisplayWinner()
    {
        if(player1.getHighCardValue() > player2.getHighCardValue())
        {
            return player1;
        }
        else
        {
            return player2;
        }
    }

    public void displayCardsInHand()
    {
        for(Card card : player1.getCardsInHand())
        {
            System.out.println(card.getSuit() +" "+card.getRank());
        }

        System.out.println("--------")
        ;
        for(Card card : player2.getCardsInHand())
        {
            System.out.println(card.getSuit() +" "+card.getRank());
        }
    }

    public void displayFullPack()
    {
//        resetFullPack();
        for(Card card : fullPack)
        {
            System.out.println(card.getSuit() +" "+ card.getRank());
        }
        System.out.println("Size= "+fullPack.size());
    }
}
