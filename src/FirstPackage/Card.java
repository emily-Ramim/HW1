package FirstPackage;

class Card{
    public Shape shape;
    public int number;

    public Card(int number, Shape shape) {
        this.number = number;
        this.shape = shape;
    }

    public int getNumber() {
        return number;
    }

    public Shape getShape() {
        return shape;
    }

    public int compare(Card other) {
        if (this.number > other.number) return 1;
        if (this.number < other.number) return -1;
        else return 0;
    }

    public String toString() {
        String picture = "";
        switch (this.number) {
            case 11:
                picture = "Prince of";
                break;
            case 12:
                picture = "Queen of";
                break;
            case 13:
                picture = "King of";
                break;
            case 1:
                picture = "Ace of";
                break;
            default:
                picture = String.valueOf(this.number) + " of";
        }
        switch (this.shape) {
            case Hearts:
                picture = picture.concat(" \u2764");
                break;
            case Spades:
                picture = picture.concat(" \u2660");
                break;
            case Clubs:
                picture = picture.concat(" \u2663");
                break;
            case Diamonds:
                picture = picture.concat(" \u2662");
                break;
        }
        return picture;
    }


}