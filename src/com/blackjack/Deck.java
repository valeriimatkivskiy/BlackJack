package com.blackjack;

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
    public void swapCards(Card firstCard, Card secondCard) {
        Card temp = firstCard;
        firstCard = secondCard;
        secondCard = temp;
    }
    public void shuffleDeck() {
        Random randomGenerator = new Random();
        for (int cardIndex = 0; cardIndex < cardList.size(); cardIndex++) {
            int cardToSwap = randomGenerator.nextInt(cardList.size());
            System.out.println("Before Swap: " + cardIndex + " " + cardList.get(cardIndex).toString() + " and " + cardToSwap + " " + cardList.get(cardToSwap).toString());
            swapCards(cardList.get(cardIndex), cardList.get(cardToSwap));
            System.out.println("After Swap: " + cardIndex + " " + cardList.get(cardIndex).toString() + " and " + cardToSwap + " " + cardList.get(cardToSwap).toString());
        }
    }
    public void showDeck() {
        for (int cardIndex = 0; cardIndex < cardList.size(); cardIndex++) {
            System.out.println(cardList.get(cardIndex).toString());
        }
    }

    public static void main(String[] args) {
        Deck deck = new Deck(4);
        deck.shuffleDeck();
        deck.showDeck();
    }
}
