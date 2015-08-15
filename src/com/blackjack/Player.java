package com.blackjack;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by Валерій on 8/15/2015.
 */
public class Player {

    private String playerName;

    private int cash;

    private LinkedList<Card> hand = new LinkedList<Card>();

    public String getPlayerName() {
        return playerName;
    }

    public int getCash() {
        return cash;
    }

    public void changeCash(int value) {
        cash += value;
    }

    public Player (String playerName, int cash) {
        this.playerName = playerName;
        this.cash = cash;
        if (!hand.isEmpty()) {
            for (int cardIndex = 0; cardIndex < hand.size(); cardIndex++) {
                hand.remove();
            }
        }
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public void showHand(boolean isDealer) {
        if (hand.isEmpty()) {
            System.out.println("Hand is empty.");
        }
        else {
            if(isDealer) {
                System.out.println("Hidden card");
                for (int cardIndex = 1; cardIndex < hand.size(); cardIndex++) {
                    System.out.println("Card # " + (cardIndex + 1) + " : " + hand.get(cardIndex).toString());
                }
            }
            else {
                for (int cardIndex = 0; cardIndex < hand.size(); cardIndex++) {
                    System.out.println("Card # " + (cardIndex + 1) + " : " + hand.get(cardIndex).toString());
                }
            }
        }
    }

    public int getHandSum() {
        int handSum = 0;
        int aceNumber = 0;
        if (hand.isEmpty()) {
            return handSum;
        }
        for (int cardIndex = 0; cardIndex < hand.size(); cardIndex++) {
            if (hand.get(cardIndex).getCardValue() == 11) {
                aceNumber++;
            }
            handSum += hand.get(cardIndex).getCardValue();
        }
        while (handSum > 21 && aceNumber > 0) {
            handSum -= 10;
            aceNumber--;
        }
        return handSum;
    }


}
