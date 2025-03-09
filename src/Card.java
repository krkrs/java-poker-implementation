public class Card {
    private final int value;
    private final Color color;

    public Card(int value, Color color) {
        this.value = value;
        this.color = color;
    }

	public int getValue() {
		return value;
	}

	public Color getColor() {
		return color;
	}

	public static String colorToSign(Color color) {
        if (color == Color.Heart)
            return  "♥";
        else if (color == Color.Tile)
            return  "♦";
        else if (color == Color.Clover)
            return  "♣";
        else
            return "♠";
    }

	String valueName() {
		if (value == 11)
			return "Joker";
		if (value == 12)
			return "Queen";
		if (value == 13)
			return "King";
		if (value == 14)
			return "Ace";
		else
			return Integer.toString(value);
	}

    @Override
    public String toString() {
        return valueName() + colorToSign(this.color);
    }
}
