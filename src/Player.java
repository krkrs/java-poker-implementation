import java.util.*;

public class Player {
	public static int count = 0;
	private final int id;
    TreeSet<Card> hand = new TreeSet<>(new CardComparator());

	public Player() {
		count++;
		this.id=count;
	}

	public int getId() {
		return id;
	}
    public void addCard(Card card) {
        hand.add(card);
    }
    public void replaceCard(Card newCard, int index) {
		//System.out.println("wymiana na " + newCard);
		TreeSet<Card> tmp = new TreeSet<>(hand); hand.clear();
		//System.out.println(index);
		for (int i = 0; i < 5; i++)
			if (i == index-1)
				tmp.pollFirst();
			else
				hand.add(tmp.pollFirst());
		hand.add(newCard);
    }

	public CardSet eval() {
		LinkedList<CardSet> sets = new LinkedList<>();
		boolean straight = true;
		boolean color = true;
		boolean flush = true;
		Iterator<Card> iterator = hand.iterator();
		ArrayList<Card> cards = new ArrayList<>();
		while (iterator.hasNext()) cards.add(iterator.next());
		//System.out.println(cards);
		int card_value = cards.get(0).getValue();
		Color card_color = cards.get(0).getColor();
		System.out.println(cards);
		for (int i = 1; i < 5; i++) {
			// wykrycie wszystkich par
			if (isPair(cards.get(i-1), cards.get(i))) {
				sets.add(new CardSet(SetName.Pair, sliceHand(i-1,i+1,cards), id));
			}
			// wykrycie braku straighta
			if (card_value != (cards.get(i).getValue()-i)) straight = false;
			// wykrycie braku koloru
			if (card_color != cards.get(i).getColor()) color = false;
			if (cards.get(i-1).getValue()+1 == cards.get(i).getValue() ||
				cards.get(i-1).getValue() == cards.get(i).getValue()) flush = false;
		}
		System.out.println("kolor" + color);
		for (int i = 2; i < 5; i++)
			if (isThree(cards.get(i-2), cards.get(i-1), cards.get(i)))
				sets.add(new CardSet(SetName.Three, sliceHand(i-2,i+1,cards), id));

		int pair = 0;
		int three = 0;

		for (CardSet set : sets) {
			SetName name = set.getSetName();
			if (name == SetName.Three)
				three++;
			if (name == SetName.Pair)
				pair++;
		}

		if (pair == 3 && three == 1)
			sets.add(new CardSet(SetName.FullHouse, cards, id));

		if (pair == 3 && three == 2)
			if (cards.get(0) == cards.get(1))
				sets.add(new CardSet(SetName.Quads, sliceHand(0,4, cards), id));
			else
				sets.add(new CardSet(SetName.Quads, sliceHand(1,5, cards), id));


		if (pair == 2 && three == 0) {
			ArrayList<Card> tmp = new ArrayList<>();
			for (CardSet cardSet : sets)
				if(cardSet.getSetName() == SetName.Pair)
					tmp.addAll(cardSet.getCards());
			sets.add(new CardSet(SetName.TwoPair, tmp, id));
		}


		if (flush)
			sets.add(new CardSet(SetName.Flush, cards, id));

		if (straight) {
			if (color && cards.get(4).getValue() == 14)
				sets.add(new CardSet(SetName.RoyalFlush, cards, id));
			else
				sets.add(new CardSet(SetName.Straight, cards, id));
		}

		if (color) sets.add(new CardSet(SetName.StraightFlush, cards, id));

		if (sets.isEmpty())
			return new CardSet(SetName.HighCard, cards, id);

		sets.sort(new HandComparator().reversed());

		return sets.get(0);
	}

	ArrayList<Card> sliceHand(int i, int j, ArrayList<Card> cards) {
		ArrayList<Card> tmp = new ArrayList<>();
		while (i < j) {
			tmp.add(cards.get(i));
			i++;
		}
		return tmp;
	}

	boolean isPair(Card a, Card b) {
		return a.getValue() == b.getValue();
	}

	boolean isThree(Card a, Card b, Card c) {
		return a.getValue() == b.getValue() && b.getValue() == c.getValue();
	}

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder("Gracz " + id + ": ");
        for (Card card : hand)
            text.append(card).append(", ");
        return text.toString();
    }
}
