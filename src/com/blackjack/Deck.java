package com.blackjack;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Валерій on 8/14/2015.
 */
public class Deck {

    LinkedList<Card> cardList = new LinkedList<Card>();

    public Deck(int numberOfDecks ) {
        if (numberOfDecks > 0 && numberOfDecks <= 8) {
            for (int decksIndex = 0; decksIndex < numberOfDecks; decksIndex++) {
                for(int suitsIndex = 0; suitsIndex < 4; suitsIndex++) {
                    for (int nameIndex = 0; nameIndex < 13; nameIndex++) {
                        cardList.add(new Card(CardSuit.values()[suitsIndex], CardName.values()[nameIndex]));
                    }
                }
            }
        }
        else {
            System.err.println("ERROR: " + numberOfDecks + " is not valid number of decks!");
            System.exit(1);
        }
    }

    public void shuffleDeck() {
        Random randomGenerator = new Random();
        for (int cardIndex = 0; cardIndex < cardList.size(); cardIndex++) {
            int cardToSwap = randomGenerator.nextInt(cardList.size());
            System.out.println("Before Swap: " + cardIndex + " " + cardList.get(cardIndex).toString() + " and " + cardToSwap + " " + cardList.get(cardToSwap).toString());
            Collections.swap(this.cardList, cardIndex, cardToSwap);
            System.out.println("After Swap: " + cardIndex + " " + cardList.get(cardIndex).toString() + " and " + cardToSwap + " " + cardList.get(cardToSwap).toString());
        }
    }
    public void showDeck(int numberOfCards) {
        if (numberOfCards <= cardList.size()) {
            for (int cardIndex = 0; cardIndex < numberOfCards; cardIndex++) {
                System.out.println("Card #" + (cardIndex + 1) + " : " + cardList.get(cardIndex).toString());
            }
            if (numberOfCards < cardList.size()) {
                System.out.println("And " + (cardList.size() - numberOfCards) + " others.");
            }
        }
        else {
            System.err.println("Error: Number of Card is not valid");
            System.exit(1);
        }
    }
    public Card dealNextCard() {
        Card cardToDeal = null;
        if (!cardList.isEmpty()) {
            cardToDeal = cardList.getFirst();
            cardList.removeFirst();
        }
        else {
            System.err.println("ERROR: Can't deal a card! Deck is empty.");
            System.exit(1);
        }
        return cardToDeal;
    }

}
