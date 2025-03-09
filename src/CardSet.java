import java.util.ArrayList;

public class CardSet {
	private final ArrayList<Card> cards;
	private int value = 0;
	//private int highCard = 0;
	private SetName setName;
	int playerID;
	public CardSet(SetName setName, ArrayList<Card> cards, int playerID) {
		this.cards = cards;
		this.setName = setName;
		this.playerID = playerID;
		for (Card card : cards) {
			value += card.getValue();
		//	if (highCard < card.getValue())
		//		highCard = card.getValue();
		}
	}

	public int getValue() {
		return value;
	}

	//public int getHighCard() {
	//	return highCard;
	//}

	public SetName getSetName() {
		return setName;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	@Override
	public String toString() {
		StringBuilder text = new StringBuilder(setName.toString() + ": ");
		for (Card card : cards)
			text.append(card).append(", ");
		return text + ", v=" + value + ", id: " + playerID + "; ";
	}
}
