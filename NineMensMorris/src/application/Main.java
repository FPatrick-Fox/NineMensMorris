package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {

	private static Group pieceGroup = new Group();
	private static ArrayList<Piece> whitePieces = new ArrayList<>();
	private static ArrayList<Piece> blackPieces = new ArrayList<>();
	private static Stage title = null;

	private static boolean black = false;
	private static boolean capture = false;
	private static int firstNine = 9;
	private static Piece selected = null;

	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane pane = FXMLLoader.load(getClass().getResource("MyScene.fxml"));
			pane.setPrefSize(600, 600);
			pane.getChildren().add(pieceGroup);
			Parent root = pane;
			primaryStage.setTitle("Nine Men's Morris - White 9 Left");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
			title = primaryStage;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static Piece makePiece(double x, double y, int position) {
		Piece piece = new Piece(x, y, black, position);
		if (black) {
			blackPieces.add(piece);
			firstNine--;
		} else {
			whitePieces.add(piece);
		}
		piece.setLayoutX(x);
		piece.setLayoutY(y);
		pieceGroup.getChildren().add(piece);
		return piece;
	}

	public static void selectPiece(Piece piece) {
		if (capture && black && !piece.isBlack()) {
			boolean allMile = true;
			for (Piece p : whitePieces)
				if (!p.inMile(whitePieces))
					allMile = false;
			if (allMile || !piece.inMile(whitePieces)) {
				whitePieces.remove(piece);
				pieceGroup.getChildren().remove(piece);
				capture = false;
				black = false;
			}
		} else if (capture && !black && piece.isBlack()) {
			boolean allMile = true;
			for (Piece p : blackPieces)
				if (!p.inMile(blackPieces))
					allMile = false;
			if (allMile || !piece.inMile(blackPieces)) {
				blackPieces.remove(piece);
				pieceGroup.getChildren().remove(piece);
				capture = false;
				black = true;
			}
		} else if (((black && piece.isBlack()) || (!black && !piece.isBlack())) && firstNine == 0){
			if (selected != null) 
				selected.unselect();
			selected = piece;
			selected.selectedRing();
		}
		updateText();
	}

	public static void move(double x, double y, int position) {
		if (firstNine > 0 && !capture) {
			Piece piece = makePiece(x, y, position);
			if (black) {
				if (piece.inMile(blackPieces)) {
					capture = true;
				} else
					black = false;
			} else {
				if (piece.inMile(whitePieces)) {
					capture = true;
				} else
					black = true;
			}
			if (selected != null) selected.unselect();
		} else if (selected != null && !capture) {
			if ((black && selected.isBlack() && selected.canMove(position, blackPieces.size()))
					|| (!black && !selected.isBlack() && selected.canMove(position, whitePieces.size()))) {
				selected.setLayoutX(x);
				selected.setLayoutY(y);
				selected.setPosition(position);
				if (black) {
					if (selected.inMile(blackPieces))
						capture = true;
					else
						black = false;
				} else {
					if (selected.inMile(whitePieces))
						capture = true;
					else
						black = true;
				}
			}
			if (selected != null) selected.unselect();
		}
		updateText();
	}

	private static void updateText() {
		String text = "";
		if (capture) {
			if (black)
				text = "Black Capture";
			else
				text = "White Capture";
		} else if (firstNine > 0) {
			if (black)
				text = "Black " + firstNine + " Left";
			else
				text = "White " + firstNine + " Left";
		} else {
			if (black)
				text = "Black's Move";
			else
				text = "White's Move";
		}
		if (blackPieces.size() < 3 && firstNine == 0)
			text = "White Wins";
		else if (whitePieces.size() < 3 && firstNine == 0)
			text = "Black Wins";
		title.setTitle("Nine Men's Morris - " + text);
	}
}
