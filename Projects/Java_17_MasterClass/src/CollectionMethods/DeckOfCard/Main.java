package CollectionMethods.DeckOfCard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Card[] cardArray = new Card[13];
        Card aceOfHeart = Card.getFaceCard(Card.Suit.HEART, 'A');
        Arrays.fill(cardArray, aceOfHeart);
        Card.printDeck(Arrays.asList(cardArray), "Ace of hearts", 2);

        List<Card> cards = new ArrayList<>(52);
        Collections.fill(cards, aceOfHeart);
        System.out.println(cards);
        System.out.println("cards.size() = " + cards.size());

        List<Card> acesOfHearts = Collections.nCopies(13, aceOfHeart);
        Card.printDeck(acesOfHearts, "Ace of hearts", 1);


        //using collections shuffle
        Collections.shuffle(deck);
        Card.printDeck(deck, "SHuffled deck", 4);

        //reversing the order
        Collections.reverse(deck);
        Card.printDeck(deck, "reversed deck", 4);

        //sortin using collections
        var sortingAlgorithm = Comparator.comparing(Card::rank)
            .thenComparing(Card::suit);

        Collections.sort(deck, sortingAlgorithm);
        Card.printDeck(deck, "Standard deck sorted by rank then suit", 14);

        List<Card> deckSublist = new ArrayList<>(deck.subList(16, 20));
        Card.printDeck(deckSublist, "cards", 1);

        //working with binarySearches
        Card tenOfHeart = Card.getNumericCard(Card.Suit.HEART, 10);
        int indexFound = Collections.binarySearch(deck, tenOfHeart, sortingAlgorithm);
        System.out.println("foundIndex : " + indexFound );
        System.out.println(deck.get(indexFound));
    }
}
