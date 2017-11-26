import java.util.Random;
import javax.swing.ImageIcon;
public class DeckofCardofB {
	private CardofB dealtCard, backOfCard, temp = new CardofB();
	private CardofB[] deck;
	private int numCardsDealt, cardsRemaining;
	private Random rnd;
	private final static int TOTAL_CARDS = 52;
	public DeckofCardofB() {
		rnd = new Random();
		numCardsDealt = 0;
		cardsRemaining = TOTAL_CARDS;
		dealtCard = null;
		backOfCard = new CardofB();
		generateDeck();
	}
	public DeckofCardofB(boolean shuffleDeck) {
		rnd = new Random();
		numCardsDealt = 0;
		cardsRemaining = TOTAL_CARDS;
		dealtCard = null;
		backOfCard = new CardofB();
		generateDeck();
		shuffleDeck();
	}
	public CardofB dealCard() {
		cardsRemaining--;
		dealtCard = deck[numCardsDealt];
		numCardsDealt++;
		return dealtCard;
	}
	public void generateDeck() {
		deck = new CardofB[52];
		for (int i = 0; i < 13; i++) {
			deck[i] = new CardofB(new ImageIcon((i+2)+"S.gif"),i+2,"Spades");
			deck[i+13] = new CardofB(new ImageIcon( (i+2) + "C.gif"), i+2, "Clubs");
			deck[i+26] = new CardofB(new ImageIcon( (i+2) + "H.gif"), i+2, "Hearts");
			deck[i+39] = new CardofB(new ImageIcon((i+2) + "D.gif"), i+2, "Diamonds");
		}
		
	}
	public CardofB getBackOfCard() {
		return backOfCard;
	}
	public void shuffleDeck() {
		for (int i = deck.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      CardofB a = deck[index];
	      deck[index] = deck[i];
	      deck[i] = a;
	    }
	}
	public int getCardsRemaining() {
		return cardsRemaining;
	}
}