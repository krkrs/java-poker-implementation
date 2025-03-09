import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static final boolean zredukowanaTalia = true;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1 - gra\n2 - scenariusz");
 		if (scanner.nextInt() == 1)
			 Game();
		 else
			Script();
    }
	public static void Game() {
		LinkedList<Card> cards = new LinkedList<>();
		ArrayList<Player> players = new ArrayList<>();
		for (int i = 0; i < 4; i++)
			for (int j = zredukowanaTalia ? 9 : 1; j < 15; j++)
				cards.add(new Card(j, Color.values()[i]));
		System.out.println("Talia przed tasowaniem:");
		cards.forEach((c) -> System.out.print(c + " "));
		Collections.shuffle(cards);
		System.out.println("\nTalia po tasowaniu:");
		cards.forEach((c) -> System.out.print(c + " "));
		System.out.println();
		players.add(new Player());
		players.add(new Player());
		for (int i = 0; i < 5; i++)
			for (Player player : players)
				player.addCard(cards.poll());
		Scanner scanner = new Scanner(System.in);
		for (Player player : players) {
			System.out.println(player);
			System.out.println("Ile kart wymienić?");
			int count = scanner.nextInt();
			for (int j = 0; j < count; j++) {
				System.out.println("Podaj pozycję karty");
				player.replaceCard(cards.poll(), scanner.nextInt());
				System.out.println(player);
			}
		}
		Evaluate(players);
	}
	public static void Script() {
		ArrayList<Player> players = new ArrayList<>();

		players.add(new Player());
		players.add(new Player());

		System.out.println("Karty 1-10, 11-Jack, 12-Królowa, 13-Król, 14-As");
		System.out.println("Kolory 0-Heart, 1-Tile, 2-Clover, 3-Pike");
		System.out.println("Karty należy podawać w formacie:");
		System.out.println("<karta> <kolor>");
		Scanner scanner = new Scanner(System.in);
		for (Player player : players) {
			System.out.println("Podaj karty gracza nr " + player.getId());
			for (int i = 0; i < 5; i++)
				player.addCard(new Card(scanner.nextInt(), Color.values()[scanner.nextInt()]));
		}
		Evaluate(players);
	}
	public static void Evaluate(ArrayList<Player> players) {
		ArrayList<CardSet> cardSets = new ArrayList<>();
		for (Player player : players) cardSets.add(player.eval());
		cardSets.sort(new HandComparator().reversed());
		for (CardSet cardSet : cardSets) System.out.println(cardSet);
		if (0 == new HandComparator().compare(cardSets.get(0), cardSets.get(1)))
			System.out.println("Remis - gracz nr " + cardSets.get(0).playerID + " i " + cardSets.get(1));
		else
			System.out.println("Wygrał gracz nr " + cardSets.get(0).playerID);
	}
}