package com.psl.gems.Entities;

import java.util.*;

public class PackOfCards {

    public static List<Card> fullPack = new ArrayList<>();

    public void setFullPack()
    {
        System.out.println("fn called");

        String[] rankList= {
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine",
                "ten",
                "jack",
                "queen",
                "king",
                "ace"};


        List<String> suitList = new ArrayList<>();
        suitList.add("club");
        suitList.add("diamond");
        suitList.add("heart");
        suitList.add("spade");

        for(int i=0 ; i<4 ; i++)
        {
            for(int j=0 ; j<=12 ; j++)
            {
                Card card = new Card();

                card.setRank(j);
                card.setSuit(i);

//                String picName = "\\" + "images" + "\\" + suitList.get(i) + "\\" + rankList[i] + ".jpg";
                String picName = "images" + "/" + suitList.get(i) + "/" + rankList[j] + ".png";
                card.setPictureName(picName);
                System.out.println(picName);

                card.setValue(card.getSuit()+ card.getRank()*4);

                fullPack.add(card);
            }
        }
    }

    public PackOfCards() {

        System.out.println("PackOfCards Constructor Called");

//        String[] rankList= {
//                "two",
//                "three",
//                "four",
//                "five",
//                "six",
//                "seven",
//                "eight",
//                "nine",
//                "ten",
//                "jack",
//                "queen",
//                "king",
//                "ace"};
//
//
//        List<String> suitList = new ArrayList<>();
//        suitList.add("club");
//        suitList.add("diamond");
//        suitList.add("heart");
//        suitList.add("spade");
//
//        for(int i=0 ; i<4 ; i++)
//        {
//            for(int j=0 ; j<=12 ; j++)
//            {
//                Card card = new Card();
//
//                card.setRank(j);
//                card.setSuit(i);
//
//                String picName = "\\" + "images" + "\\" + suitList.get(i) + "\\" + rankList[i] + ".jpg";
//                card.setPictureName(picName);
//
//                card.setValue(card.getSuit()+ card.getRank()*4);
//
//                fullPack.add(card);
//            }
//        }
    }

    public int compareCard(Card o1, Card o2) {
        if (o1.getValue() < o2.getValue())
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }

    public void shuffleCards()
    {
        Collections.shuffle(fullPack);
    }

    public Card getTopCard()
    {
        return fullPack.get(0);
    }

    public void addCard(Card card)
    {
        if(!fullPack.contains(card))
        {
            fullPack.add(card);
        }
    }

    public Card getRandomCard()
    {
        Random rand = new Random();
        int index = rand.nextInt(fullPack.size()); // generate a random index between 0 (inclusive) and list.size() (exclusive)

        return fullPack.get(index);
    }

    public int sizeOfPack()
    {
        return fullPack.size();
    }

    public void resetFullPack()
    {
        fullPack.sort(Comparator.comparingInt(Card::getValue));
    }
}
