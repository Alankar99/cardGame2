package com.psl.gems.client.TestClient;

import com.psl.gems.Entities.Card;
import com.psl.gems.Entities.Game;
import com.psl.gems.Entities.PackOfCards;
import com.psl.gems.Entities.Player;
//import com.psl.gems.frontEnd.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");

        String player1 = "Kit";
        String player2 = "Kut";

//        System.out.println("step1");
        PackOfCards deck = new PackOfCards();
        deck.setFullPack();
//        System.out.println("step2");

        Game game = new Game();
//        System.out.println("Step3");
        game.play(player1 , player2);
//        System.out.println("Step4");

        game.displayCardsInHand();
        System.out.println("---------");
//        game.displayFullPack();
//        System.out.println("Step5");
        // Call game.showHighCard when button(Show high cards) is clicked in front-end after all cards are opened

        List<Card> highCardsList = game.showHighCard();
        for(Card card : highCardsList)
        {
            System.out.println(card.getSuit() +" "+ card.getRank());
            System.out.println("Value = "+card.getValue());
            System.out.println("---------");
        }

        System.out.println("Results");
        // Call game.displayWinner when button(Show Winner) is clicked in front-end.
        System.out.println(game.DisplayWinner().getName());


        //--------------HTML-------------


        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>\n");
        html.append("<html lang=en>\n");
        html.append("<head>\n");
        html.append("<title>Card Game</title>");
        html.append("<link rel = stylesheet href=cardgame.css>\n");
        html.append("<script src=cardgame.js></script>\n");
        html.append("</head>\n");
        html.append("<body>\n");
        html.append("<div class =container>\n");
        int i=0;
        int j=0;
        for (Player player : game.getPlayers()) {
            html.append("<div class=player>\n");
            html.append("<div class=player-name><h2>" + player.getName() + "</h2></div>\n");
            html.append("<div class = cards>\n");
            for (Card card : player.getCardsInHand()) {
                html.append("<div class=card" + card.getSuit() + card.getRank() + " onclick=flipCard(this.id," + i + ")>\n");
                html.append("<div class=card-inner>\n");
                html.append("<div class=card-back><img src=images/back.jpeg alt=\"back of card\"></div>\n");
                // html.append("<div class=\"card-back\"><img src=\"images/" + card.getSuit() + card.getRank() + ".png\" alt=\"front of card\" >\n");
                html.append("<div class=card-front><img src="+ card.getPictureName()+"></div>\n");
                html.append("</div></div></div>\n");
            }
            html.append("</div>\n");
            html.append("<button class=show-highest-card disabled id=btn"+ i + "onclick= showHighestCard(" + highCardsList.get(j++) + ")>Show Highest Card</button>\n");
            html.append("</div>\n");
            i++;
        }

        html.append("<button class=decide-winner disabled id = btnwinner onclick= decideWinner(btnwinner)>Decide Winner</button>\n");
        html.append("</div>\n");
        html.append("</body>\n");
        html.append("</html>\n");

        try
        {
            FileWriter fileWriter = new FileWriter("cardgame1.html");
            fileWriter.write(html.toString());
            fileWriter.flush();
            fileWriter.close();
            System.out.println("HTML file successfully created.");

        }
        catch (IOException e) {
            System.out.println("An error occurred while writing the HTML file.");
            e.printStackTrace();
        }


    }
}