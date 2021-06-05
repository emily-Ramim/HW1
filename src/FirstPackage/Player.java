package FirstPackage;

public class Player {
    public String name;
    public Deck pullDeck;
    public Deck winDeck;

    public Player(String name) {
        this.name = name;
        pullDeck = new Deck(false);
        winDeck = new Deck(false);
    }

    public String getName() {
        return this.name;
    }

    public Deck getPullDeck() {
        return this.pullDeck;
    }

    public Deck getWinDeck() {
        return this.winDeck;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPullDeck(Deck pullDeck) {
        this.pullDeck = pullDeck;
    }

    public void setWinDeck(Deck winDeck) {
        this.winDeck = winDeck;
    }

    public void addToPullDeck(Card card) {
        this.pullDeck.addCard(card);
    }

    public void addToWinDeck(Card card) {
        this.winDeck.addCard(card);
    }

    public Card drawCard() {
        return this.pullDeck.removeTopCard();
    }
    public boolean outOfPullCards(){
        return this.pullDeck.isEmpty();
    }
    public boolean outOfWinCards(){
        return this.winDeck.isEmpty();
    }

    public boolean outOfCards() {
        if (this.pullDeck.isEmpty() && this.winDeck.isEmpty()) return true;
        if (this.pullDeck.isEmpty()) {
            this.setPullDeck(this.getWinDeck());
            Deck deck = new Deck(false);
            this.setWinDeck(deck);
            this.pullDeck.shuffle();
        }
        return false;
    }

    public String toString() {
        return this.name.toString();
    }
}
