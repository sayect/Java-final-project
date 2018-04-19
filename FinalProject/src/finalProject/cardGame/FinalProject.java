package finalProject.cardGame;

import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FinalProject extends Application {

	private Deck deck = new Deck();
	private Hand dealer, player;
	private Text message = new Text();

	private SimpleBooleanProperty playable = new SimpleBooleanProperty(false);

	// Not sure if really needed
	// Horizontal box layout
	private HBox dealerCards = new HBox(20);
	private HBox playerCards = new HBox(20);

	private Parent createContent() {
		dealer = new Hand(dealerCards.getChildren());
		player = new Hand(playerCards.getChildren());

		Pane root = new Pane();
		root.setPrefSize(800, 600);

		Region background = new Region();
		background.setPrefSize(800, 600);
		background.setStyle("-fx-background-color: rgba(0,0,0,1)");

		HBox rootLayout = new HBox(5);
		rootLayout.setPadding(new Insets(5, 5, 5, 5));
		Rectangle left = new Rectangle(550, 560);
		left.setArcWidth(50);
		left.setArcHeight(50);
		left.setFill(Color.GREEN);
		Rectangle right = new Rectangle(230, 560);
		right.setArcWidth(50);
		right.setArcHeight(50);
		right.setFill(Color.ORANGE);

		// Left

		StackPane leftStack = new StackPane();
		VBox leftVBox = new VBox(50);
		leftVBox.setAlignment(Pos.TOP_CENTER);

		Text dealerScore = new Text("Dealer: ");
		Text playerScore = new Text("Player: ");

		leftVBox.getChildren().addAll(dealerScore, dealerCards, message, playerCards, playerScore);
		leftStack.getChildren().addAll(left, leftVBox);

		// Right

		StackPane rightStack = new StackPane();

		VBox rightVBox = new VBox(20);
		rightVBox.setAlignment(Pos.CENTER);

		final TextField bet = new TextField("Bet");
		// Bet is disabled for the moment as per the video
		bet.setDisable(true);
		bet.setMaxWidth(50);
		// Placeholder for amount of money player has while playing (not important for
		// project)
		Text money = new Text("Money");

		Button btnPlay = new Button("Play");
		Button btnHit = new Button("Hit");
		Button btnStand = new Button("Stand");

		HBox buttonsHBox = new HBox(15);
		buttonsHBox.setAlignment(Pos.CENTER);
		// Buttons disabled for the moment
		btnHit.setDisable(true);
		btnStand.setDisable(true);
		buttonsHBox.getChildren().addAll(btnHit, btnStand);
		rightVBox.getChildren().addAll(bet, btnPlay, money, buttonsHBox);
		rightStack.getChildren().addAll(right, rightVBox);

		// Add both stacks to root layout

		rootLayout.getChildren().addAll(leftStack, rightStack);
		root.getChildren().addAll(background, rootLayout);

		// Bind properties

		btnPlay.disableProperty().bind(playable);
		btnHit.disableProperty().bind(playable.not());
		btnStand.disableProperty().bind(playable.not());

		playerScore.textProperty().bind(new SimpleStringProperty("Player: ").concat(player.valueProperty().asString()));
		dealerScore.textProperty().bind(new SimpleStringProperty("Dealer: ").concat(player.valueProperty().asString()));

		player.valueProperty().addListener((obs, old, newValue) -> {
			if (newValue.intValue() >= 24) {
				endGame();
			}

		});

		dealer.valueProperty().addListener((obs, old, newValue) -> {
			if (newValue.intValue() >= 24) {
				endGame();
			}

		});

		// Init buttons

		btnPlay.setOnAction(event -> {
			startNewGame();

		});

		btnHit.setOnAction(event -> {
			player.takeCard(deck.drawCard());

		});

		btnStand.setOnAction(event -> {
			while (dealer.valueProperty().get() < 17) {
				dealer.takeCard(deck.drawCard());
			}

			endGame();
		});

		return root;
	}

	private void startNewGame() {
		playable.set(true);
		message.setText("");

		deck.refill();

		dealer.reset();
		player.reset();

		dealer.takeCard(deck.drawCard());
		dealer.takeCard(deck.drawCard());
		player.takeCard(deck.drawCard());
		player.takeCard(deck.drawCard());

	}

	private void endGame() {
		playable.set(false);

		int dealerValue = dealer.valueProperty().get();
		int playerValue = player.valueProperty().get();

		String winner = "Exceptional case: d: " + dealerValue + " p: " + playerValue;

		if (dealerValue == 24 || playerValue > 24 || dealerValue == playerValue
				|| (dealerValue < 24 && dealerValue > playerValue)) {
			winner = "Dealer";
		}

		else if (playerValue == 24 || dealerValue > 24 || playerValue > dealerValue) {
			winner = "Player";
		}

		message.setText(winner + " won!");

	}

	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(new Scene(createContent()));
		primaryStage.setWidth(800);
		primaryStage.setHeight(600);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Player Card 24");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
