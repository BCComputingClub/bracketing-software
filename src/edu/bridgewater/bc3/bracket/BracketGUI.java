package edu.bridgewater.bc3.bracket;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Prototype version of the Bracket GUI (mostly non-functional atm)
 * 
 * @author Jason Laatz
 *
 */
public class BracketGUI extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage myStage) {
		myStage.setTitle("BC3 Tournament Software");
		myStage.setResizable(false);

		// Intro Screen Node & Scene Instantiation
		FlowPane rootNode = new FlowPane();
		rootNode.setAlignment(Pos.CENTER);
		Scene firstScene = new Scene(rootNode, 800, 600);

		// Add/Remove Screen Node & Scene Instantiation
		FlowPane addRemoveNode = new FlowPane();
		rootNode.setAlignment(Pos.CENTER);
		Scene addRemoveScene = new Scene(addRemoveNode, 800, 600);

		// Event Screen Node & Scene Instantiation
		BorderPane eventNode = new BorderPane();
		Scene eventScene = new Scene(eventNode, 800, 600);

		// Score Screen Node & Scene Instantiation
		BorderPane scoreNode = new BorderPane();
		Scene scoreScene = new Scene(scoreNode, 800, 600);

		// Intro Screen Label, TextField, Button, and HBox Instantiation
		Label eventNameLabel = new Label("Event Name");
		TextField eventTextField = new TextField();
		Button addRemoveButton = new Button("Add/Remove Players");
		Button startButton = new Button("Start");
		HBox eventNameHBox = new HBox(100);
		eventNameHBox.setPadding(new Insets(20, 190, 150, 0));
		eventNameHBox.getChildren().addAll(eventNameLabel, eventTextField);
		HBox eventPlayerHBox = new HBox(150);
		eventPlayerHBox.getChildren().addAll(addRemoveButton, startButton);

		// Add/Remove Screen Counter, Label, TextField, Button, and VBox
		// Instantiation
		int totalPlayerCounter = 0;
		Label playerName = new Label("Jim");
		Button addButton = new Button("+");
		Button removeButton = new Button("-");
		Button finishButton = new Button("Finish");
		HBox playerAndDeleteButtonHBox = new HBox(100);
		playerAndDeleteButtonHBox.getChildren().addAll(playerName, removeButton);
		HBox addAndFinishHBox = new HBox(100);
		addAndFinishHBox.getChildren().addAll(addButton, finishButton);
		VBox deleteHBoxAndFinishHBox = new VBox(300);
		deleteHBoxAndFinishHBox.getChildren().addAll(playerAndDeleteButtonHBox, addAndFinishHBox);

		// Event Screen Labels, Toolbar, Buttons, and VBox Instantiations
		Label currentMatch = new Label("Current Match");
		Label player1 = new Label("Jim");
		Label player2 = new Label("Guy");
		Label player3 = new Label("Nick");
		Label player4 = new Label("Pat");
		Label nextMatch = new Label("Next Match");
		Label nextPlayer1 = new Label("Kim");
		Label nextPlayer2 = new Label("Joe");
		Label nextPlayer3 = new Label("Bob");
		Label nextPlayer4 = new Label("Fred");
		Button enterScoresButton = new Button("Enter Scores");
		Button nextMatchButton = new Button("Next Match");
		VBox currentMatchVBox = new VBox(5);
		currentMatchVBox.setPadding(new Insets(0, 100, 0, 0));
		currentMatchVBox.getChildren().addAll(currentMatch, player1, player2, player3, player4, enterScoresButton);
		VBox nextMatchVBox = new VBox(20);
		nextMatchVBox.setPadding(new Insets(0, 100, 0, 0));
		nextMatchVBox.getChildren().addAll(nextMatch, nextPlayer1, nextPlayer2, nextPlayer3, nextPlayer4,
				nextMatchButton);
		Menu fileMenu = new Menu("File");
		MenuItem save = new MenuItem("Save");
		MenuItem load = new MenuItem("Load");
		MenuItem quit = new MenuItem("Quit");
		fileMenu.getItems().addAll(save, load, quit);
		Menu editMenu = new Menu("Edit");
		MenuItem addPlayer = new MenuItem("Add Player");
		MenuItem dropPlayer = new MenuItem("Drop Player");
		editMenu.getItems().addAll(addPlayer, dropPlayer);
		Menu returnMenu = new Menu("Return");
		MenuItem returnToMainScreen = new MenuItem("Back");
		returnMenu.getItems().addAll(returnToMainScreen);
		MenuBar menuBar = new MenuBar();
		menuBar.setPadding(new Insets(0, 500, 0, 0));
		menuBar.getMenus().addAll(fileMenu, editMenu, returnMenu);

		// Score Screen Labels, Buttons, HBox, and VBox Instantiations
		Label nameLabel = new Label("Player");
		Label rankingLabel = new Label("Ranking");
		Label player1Score = new Label("Sal");
		Label player2Score = new Label("Jim");
		Label player3Score = new Label("Kat");
		Label player4Score = new Label("Mike");
		ObservableList<String> positionEntries = FXCollections.observableArrayList("1", "2", "3", "4");
		ComboBox comboBox1 = new ComboBox<String>(positionEntries);
		ComboBox comboBox2 = new ComboBox<String>(positionEntries);
		ComboBox comboBox3 = new ComboBox<String>(positionEntries);
		ComboBox comboBox4 = new ComboBox<String>(positionEntries);
		Button doneButton = new Button("Done");
		HBox labelHBox = new HBox(50);
		labelHBox.setPadding(new Insets(10, 100, 10, 0));
		labelHBox.getChildren().addAll(nameLabel, rankingLabel);
		HBox player1HBox = new HBox(50);
		player1.setPadding(new Insets(10, 100, 10, 0));
		player1HBox.getChildren().addAll(player1Score, comboBox1);
		HBox player2HBox = new HBox(50);
		player2.setPadding(new Insets(10, 100, 10, 0));
		player2HBox.getChildren().addAll(player2Score, comboBox2);
		HBox player3HBox = new HBox(50);
		player3.setPadding(new Insets(10, 100, 10, 0));
		player3HBox.getChildren().addAll(player3Score, comboBox3);
		HBox player4HBox = new HBox(50);
		player4.setPadding(new Insets(10, 100, 10, 0));
		player4HBox.getChildren().addAll(player4Score, comboBox4);
		VBox playerPositionVBox = new VBox();
		playerPositionVBox.getChildren().addAll(player1HBox, player2HBox, player3HBox, player4HBox, doneButton);

		// Sets up the scenes and then displays the title screen
		rootNode.getChildren().addAll(eventNameHBox, eventPlayerHBox);
		addRemoveNode.getChildren().addAll(deleteHBoxAndFinishHBox);
		eventNode.setTop(menuBar);
		eventNode.setLeft(currentMatchVBox);
		eventNode.setRight(nextMatchVBox);
		scoreNode.setTop(labelHBox);
		scoreNode.setCenter(playerPositionVBox);
		myStage.setScene(firstScene);
		myStage.show();

		// Actions for buttons on main screen
		addRemoveButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				myStage.setScene(addRemoveScene);
				myStage.setTitle("BC3 Tournament - Add/Remove Players");
			}
		});

		startButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				myStage.setScene(eventScene);
				myStage.setTitle("BC3 Tournament - Event Matches");
			}
		});

		// Actions for buttons on Add/Remove Screen
		addButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
			}
		});

		removeButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
			}
		});

		finishButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				myStage.setScene(firstScene);
				myStage.setTitle("BC3 Tournament Software");
			}
		});

		// Actions for buttons on Event Screen
		enterScoresButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				myStage.setScene(scoreScene);
				myStage.setTitle("BC3 Tournament - Position Ranking");
			}
		});

		nextMatchButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
			}
		});

		// Actions for buttons on Score Screen
		doneButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				myStage.setScene(eventScene);
				myStage.setTitle("BC3 Tournament - Event Matches");
			}
		});

	}
}