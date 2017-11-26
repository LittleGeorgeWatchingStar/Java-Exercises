import javax.swing.ImageIcon;
import javax.swing.ImageIcon;

public class CardofB {
	private int value, width, height;
	private String suit, name;
	private ImageIcon imgCard;
	
	public CardofB() {
		 this.imgCard = new ImageIcon("back.png");
	     this.value = 0;
	     this.name = "";
	     this.suit = "";
	     this.width = imgCard.getIconWidth();
	     this.height = imgCard.getIconHeight();
	}
	public CardofB(ImageIcon imgCard, int value, String suit){
		 this.imgCard = imgCard;
	     this.value = value;
	     this.name = Integer.toString(value);
	     this.suit = suit;
	     this.width = imgCard.getIconWidth();
	     this.height = imgCard.getIconHeight();
	}
	public int getHeight() {
		return this. height; 
	}
	public ImageIcon getImage() {
		return this. imgCard; 
	}
	public String getName() {
		if (name.equals("11")) {
			name = "Jack";
		}
		else if (name.equals("12")) {
			name = "Queen";
		}
		else if (name.equals("13")) {
			name = "King";
		}
		else if (name.equals("14")) {
			name = "Ace";
		}
		return this.name;
	}
	public String getSuit() {
		return this.suit;
	}
	public int getValue() {
		return this.value;
	}
	public int getWidth() {
		return width;
	}
	public void setHeight(int he) {
		height = he;
	}
	public void setImage(ImageIcon im) {
		imgCard = im;
	}
	public void setName(String na) {
		name = na;
	}
	public void setSuit(String su) {
		suit = su;
	}
}