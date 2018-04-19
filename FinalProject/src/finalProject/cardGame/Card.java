package finalProject.cardGame;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Card extends Parent {

	enum Suit {
		HEARTS, DIAMONDS, CLUBS, SPADES
	};

	//Change name of this
	enum Rank {
		TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(
				13), ACE(1);

		int value;

		private Rank(int value) {
			this.value = value;
		}
	};
	
	public final Suit suit;
	public final Rank rank;
	public final int value;
	
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
		this.value = rank.value;
		
		
		//Change name to cardBackground
		Rectangle rect = new Rectangle(80, 100);
		rect.setArcWidth(20);
		rect.setArcHeight(20);
		rect.setFill(Color.WHITE);
		
		
		Text text = new Text(toString());
		text.setWrappingWidth(70);
		
		getChildren().add(new StackPane(rect, text));
		
	}
	
	public String toString() {
		
		return rank.toString()+" of " + suit.toString();		
	}

}
