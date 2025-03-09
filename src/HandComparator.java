import java.util.Comparator;

public class HandComparator implements Comparator<CardSet> {
	@Override
	public int compare(CardSet a, CardSet b) {
		// porównanie układów
		if (a.getSetName().ordinal() > b.getSetName().ordinal())
			return 1;
		else if (a.getSetName().ordinal() < b.getSetName().ordinal())
			return -1;
		// porównanie wartości dla Karety
		if (a.getSetName() == SetName.FullHouse)
			return Integer.compare(a.getValue(), b.getValue());
		// porównanie wysokiej karty
		var setA = a.getCards();
		var setB = b.getCards();
		for ( int i = 0; i < 5; i++) {
			if (setA.get(i).getValue() > setB.get(i).getValue())
				return 1;
			else if (setA.get(i).getValue() < setB.get(i).getValue())
				return -1;
		}
		return 0;
		//return Integer.compare(a.getHighCard(), b.getHighCard());
	}
}
