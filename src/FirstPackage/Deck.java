package FirstPackage;

import java.util.*;

class Deck {
    public ArrayList<Card> cardlist;

    public Deck(boolean shuffle) {
        cardlist = new ArrayList<Card>();
        if (shuffle) {
            Shape shape = Shape.Spades;
            for (int i = 1; i <= 13; i++) {
                Card current = new Card(i, Shape.Spades);
                cardlist.add(current);
            }

            for (int i = 1; i <= 13; i++) {
                Card current = new Card(i, Shape.Diamonds);
                cardlist.add(current);
            }

            for (int i = 1; i <= 13; i++) {
                Card current = new Card(i, Shape.Clubs);
                cardlist.add(current);
            }

            for (int i = 1; i <= 13; i++) {
                Card current = new Card(i, Shape.Hearts);
                cardlist.add(current);

            }
        }
    }
    public Card getTopCard() {
        return cardlist.get(cardlist.size()-1);
    }
    public void addCard(Card card) {
        cardlist.add(card);
    }

    public Card removeTopCard() {
        return cardlist.remove(cardlist.size() - 1);
    }

    public boolean isEmpty() {
        return cardlist.size() == 0;
    }

    public void shuffle() {
        Random ran = new Random();
        int nxt1 = ran.nextInt(cardlist.size());
        int nxt2 = ran.nextInt(cardlist.size());
        for (int i = 0; i < 50; i++) {
            Card tempCard = new Card(cardlist.get(nxt1).getNumber(), cardlist.get(nxt1).getShape());
            cardlist.set(nxt1, cardlist.get(nxt2));
            cardlist.set(nxt2, tempCard);
            nxt1 = ran.nextInt(cardlist.size());
            nxt2 = ran.nextInt(cardlist.size());
        }
    }
}

}

}
