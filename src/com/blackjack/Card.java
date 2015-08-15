package com.blackjack;

/**
 * An implementation of a card type.
 *
 * @author Valerii Matkivskiy
 */
public class Card {

    /**
     * One of the four valid suits from this card.
     */
    private CardSuit cardSuit;

    /**
     *
     */
    private CardName cardName;

    /**
     *
     * @param suit
     * @param name
     */
    public Card(CardSuit suit, CardName name) {
        this.cardSuit = suit;
        this.cardName = name;
    }

    /**
     *
     * @return
     */
    public int getCardValue() {
        int cardValue;
        switch (cardName) {
            case TWO :
                cardValue = 2;
                break;
            case THREE:
                cardValue = 3;
                break;
            case FOUR: {
                cardValue = 4;
                break;
            }
            case FIVE:
                cardValue = 5;
                break;
            case SIX:
                cardValue = 6;
                break;
            case SEVEN:
                cardValue = 7;
                break;
            case EIGHT:
                cardValue = 8;
                break;
            case NINE:
                cardValue = 9;
                break;
            case TEN:
                cardValue = 10;
                break;
            case JACK:
                cardValue = 10;
                break;
            case QUEEN:
                cardValue = 10;
                break;
            case KING:
                cardValue = 10;
                break;
            case ACE:
                cardValue = 11;
                break;
            default:
                cardValue = 0;
        }
        return cardValue;
    }

    /**
     *
     * @return
     */
    public String toString() {
        return cardName.toString() + " of " + cardSuit.toString();
    }

}
