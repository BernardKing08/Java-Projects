package CollectionMethods.DeckOfCard.Game.Poker;

import java.util.ArrayList;
import java.util.List;

import CollectionMethods.DeckOfCard.Card;

public class PokerHand {
    private List<Card> hand;
    private List<Card> keepers;
    private List<Card> discards;
    private Ranking score = Ranking.NONE;

    private int playerNo;

    public PokerHand(int playerNo, List<Card> hand ){
        hand.sort(Card.sortRankReverseSuit());
        this.hand = hand;
        this.playerNo = playerNo;
        keepers =  new ArrayList<>(hand.size());
        discards =  new ArrayList<>(hand.size());
    }

    @Override
    public String toString(){
        return "%d, %-16s Rank:$d $-40s %s".formatted(playerNo, score, score.ordinal(), hand, (discards.size() > 0) ? "Discards:" + discards : "");
    }
}
