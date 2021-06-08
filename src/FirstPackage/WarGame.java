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

    public String winnerString(Player player) {
        return player.getName() ;
    }

    public String start() {
        this.initializeGame();
        boolean inWar = false;
        int counter=1;
        while (!playerA.outOfCards() && !playerB.outOfCards()) {
            if(inWar==false){
                System.out.println("------------------------- Round number "+counter+" -------------------------");
                counter++;
            }
            tempDeckA.addCard(playerA.drawCard());
            System.out.println(playerA.getName() + " drew " + tempDeckA.getTopCard().toString());
            tempDeckB.addCard(playerB.drawCard());
            System.out.println(playerB.getName() + " drew " + tempDeckB.getTopCard().toString());

            if (tempDeckA.getTopCard().compare(tempDeckB.getTopCard()) == 1) {
                if (inWar) {
                    System.out.println(playerA.getName() + " won the war");
                    //inWar = false;
                }
                playerA.addToWinDeck(tempDeckA.getTopCard());
                playerA.addToWinDeck(tempDeckB.getTopCard());
                if (!inWar)System.out.println(playerA.getName() + " won");
                inWar = false;
            }
            if (tempDeckA.getTopCard().compare(tempDeckB.getTopCard()) == -1) {
                if (inWar){
                    System.out.println(playerA.getName() + " won the war");
                    //inWar = false;
                }
                playerB.addToWinDeck(tempDeckA.getTopCard());
                playerB.addToWinDeck(tempDeckB.getTopCard());
                if (!inWar)System.out.println(playerB.getName() + " won");
                inWar = false;
            }
            if (tempDeckA.getTopCard().compare(tempDeckB.getTopCard()) == 0){
                System.out.println("Starting a war...");
                inWar = true;
                for (int i = 0; i < 2; i++) {
                    if (playerA.outOfCards() || playerB.outOfCards()) break;//change later
                    tempDeckA.addCard(playerA.drawCard());
                    System.out.println(playerA.getName() + " drew a war card");
                    tempDeckB.addCard(playerB.drawCard());
                    System.out.println(playerB.getName() + " drew a war card");
                }

            }
        }
        if (playerA.outOfCards()) return this.winnerString(playerA);
        else return this.winnerString(playerB);
    }

}

