package CollectionMethods.DeckOfCard.Game.Poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import CollectionMethods.DeckOfCard.Card;

public class PokerGame {
    private final List<Card> deck = Card.getStandardDeck();
    private int playerCount;
    private int cardsInHand;

    private List<PokerHand> pokerHands; 
    private List<Card> remainingCards;

    public PokerGame(int playerCount, int cardsInHand){
        this.playerCount = playerCount;
        this.cardsInHand = cardsInHand;
        pokerHands = new ArrayList<>(cardsInHand);
    }

    public void startPlay(){
        Collections.shuffle(deck);
        Card.printDeck(deck);
        int randomMiddle = new Random().nextInt(15, 35);
        Collections.rotate(deck, randomMiddle);
        Card.printDeck(deck);

        deal();
        System.out.println("-".repeat(25));
        pokerHands.forEach(System.out::println);
    }

    private void deal(){
        Card[][] hands = new Card[playerCount][cardsInHand];
        for(int deckIndex = 0, i = 0; i < cardsInHand; i++){
            for(int j = 0; j < playerCount; j++){
                hands[j][i] = deck.get(deckIndex++);
            }
        }

        int playerNo = 1;
        for(Card[] hand : hands){
            pokerHands.add(new PokerHand(playerNo++, Arrays.asList(hand)));
        }
    }
}
