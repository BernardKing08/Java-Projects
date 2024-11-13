package CollectionMethods.DeckOfCard.Game;

import CollectionMethods.DeckOfCard.Game.Poker.PokerGame;

public class GameController {
    public static void main(String[] args) {
        PokerGame fiveCardDraw = new PokerGame(4, 5);
        fiveCardDraw.startPlay();
    }
}
