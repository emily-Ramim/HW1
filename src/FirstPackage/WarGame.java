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

    }

    public boolean stopGame() {
        if (playerA.outOfCards() == false && playerB.outOfCards() == false) return true;
        return false;

    }

    public String start() {
        while (playerA.outOfCards() == false && playerB.outOfCards() == false) {
            tempDeckA.addCard(playerA.drawCard());
            tempDeckB.addCard(playerB.drawCard());
            if (tempDeckA.cardlist.get(tempDeckA.cardlist.size() - 1).getNumber() > tempDeckB.cardlist.get(tempDeckB.cardlist.size() - 1).getNumber()) {
                while (!tempDeckB.isEmpty()) {
                    playerA.getWinDeck().addCard(tempDeckB.removeTopCard());

                }
                while (!tempDeckA.isEmpty()) {
                    playerA.getWinDeck().addCard(tempDeckA.removeTopCard());

                }
            }
            if (tempDeckA.cardlist.get(tempDeckA.cardlist.size() - 1).getNumber() < tempDeckB.cardlist.get(tempDeckB.cardlist.size() - 1).getNumber()) {
                while (!tempDeckB.isEmpty()) {
                    playerB.getWinDeck().addCard(tempDeckB.removeTopCard());

                }
                while (!tempDeckA.isEmpty()) {
                    playerB.getWinDeck().addCard(tempDeckA.removeTopCard());

                }
            }
            if (tempDeckA.cardlist.get(tempDeckA.cardlist.size() - 1).getNumber() == tempDeckB.cardlist.get(tempDeckB.cardlist.size() - 1).getNumber()) {
               try
               {
                   tempDeckA.addCard(playerA.drawCard());
                   tempDeckA.addCard(playerA.drawCard());
               }
               catch () {
                   System.out.println("player a out of cards!");
               }


        }



        public String starts()
        {
            this.initializeGame();
            tempDeckA.addCard(playerA.drawCard());
            tempDeckB.addCard(playerB.drawCard());
            if(tempDeckA.getTopCard().compare(tempDeckB.getTopCard())==1) {
                playerA.addToWinDeck(tempDeckA.getTopCard());
                playerA.addToWinDeck(tempDeckB.getTopCard());
            }
            if(tempDeckA.getTopCard().compare(tempDeckB.getTopCard())==-1) {
                playerB.addToWinDeck(tempDeckA.getTopCard());
                playerB.addToWinDeck(tempDeckB.getTopCard());
            }
            else {
                tempDeckA.addCard(playerA.drawCard());
                tempDeckB.addCard(playerB.drawCard());
            }
            }

    }
}

