package FirstPackage;

public class WarGame {
    public Player playerA;
    public Player playerB;
    public Deck tempDeckA;
    public Deck tempDeckB;

    public WarGame(String nameA, String nameB) {
        playerA = new Player(nameA);
        playerB = new Player(nameB);
        tempDeckA = new Deck(false);
        tempDeckB = new Deck(false);
    }

    public Deck getTempDeckA() {
        return tempDeckA;
    }

    public Deck getTempDeckB() {
        return tempDeckB;
    }

    public Player getPlayerA() {
        return playerA;
    }

    public Player getPlayerB() {
        return playerB;
    }

    public void setTempDeckA(Deck tempDeckA) {
        this.tempDeckA = tempDeckA;
    }

    public void setTempDeckB(Deck tempDeckB) {
        this.tempDeckB = tempDeckB;
    }

    public void initializeGame() {
        Deck gameDeck = new Deck(true);
        gameDeck.shuffle();
        while (!gameDeck.isEmpty()) {
            playerA.addToPullDeck(gameDeck.removeTopCard());
            playerB.addToPullDeck((gameDeck.removeTopCard()));
        }
        System.out.println("Initializing the game...");
    }

    public boolean stopGame() {
        if (playerA.outOfCards() == false && playerB.outOfCards() == false) return true;
        return false;

    }

    public void startingAWar() {
        while (tempDeckA.getTopCard().compare(tempDeckB.getTopCard()) == 0 && !playerA.outOfCards() && !playerB.outOfCards()) {
            for (int i = 0; i < 3; i++) {
                tempDeckA.addCard(playerA.drawCard());
                tempDeckB.addCard(playerB.drawCard());
            }

        }
    }

    public String winnerString(Player player)
    {
        return player.toString()+"won";
    }
    public String gameString(Player player)
    {
        return
    }
    public String start() {
        this.initializeGame();
        while (!playerA.outOfCards() && !playerB.outOfCards()) {
            tempDeckA.addCard(playerA.drawCard());
            tempDeckB.addCard(playerB.drawCard());
            if (tempDeckA.getTopCard().compare(tempDeckB.getTopCard()) == 1) {
                playerA.addToWinDeck(tempDeckA.getTopCard());
                playerA.addToWinDeck(tempDeckB.getTopCard());
            }
            if (tempDeckA.getTopCard().compare(tempDeckB.getTopCard()) == -1) {
                playerB.addToWinDeck(tempDeckA.getTopCard());
                playerB.addToWinDeck(tempDeckB.getTopCard());
            } else {
                this.startingAWar();
            }
        }
        if(playerA.outOfCards())return this.winnerString(playerA);
        else return this.winnerString(playerB);
    }

}

