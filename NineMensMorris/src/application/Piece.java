package application;

import java.util.ArrayList;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.Paint;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;

public class Piece extends StackPane {

	private static final int RADIUS = 20; // The size of the pieces
	private int position; // What dot am I on?
	private boolean black; // Am I black or white?
	private Circle piece;

	public Piece(double x, double y, boolean player, int position) {
		piece = new Circle(RADIUS, Paint.valueOf("0x1a1a1a"));
		RadialGradient r = null;
		this.position = position;
		black = player;
		if (player)
			r = new RadialGradient(0, 0, 0, 0, 0.5, true, CycleMethod.NO_CYCLE, new Stop(0.0, Color.WHITE),
					new Stop(1.0, Color.BLACK));
		else
			r = new RadialGradient(0, 0, 0, 0, 0.5, true, CycleMethod.NO_CYCLE, new Stop(0.0, Color.LIGHTGREY),
					new Stop(1.0, Color.DARKGREY));
		piece.setFill(r);
		piece.setCenterX(RADIUS / 2);
		piece.setCenterY(RADIUS / 2);
		getChildren().add(piece);

		setOnMousePressed(e -> {
			Main.selectPiece(this);
		});
	}

	public boolean inMile(ArrayList<Piece> p) {
		switch (position) {
		case 1:
			return (pieceAtPosition(p, 2) && pieceAtPosition(p, 3))
					|| (pieceAtPosition(p, 10) && pieceAtPosition(p, 22));
		case 2:
			return (pieceAtPosition(p, 1) && pieceAtPosition(p, 3)) 
					|| (pieceAtPosition(p, 5) && pieceAtPosition(p, 8));
		case 3:
			return (pieceAtPosition(p, 1) && pieceAtPosition(p, 2))
					|| (pieceAtPosition(p, 15) && pieceAtPosition(p, 24));
		case 4:
			return (pieceAtPosition(p, 5) && pieceAtPosition(p, 6))
					|| (pieceAtPosition(p, 11) && pieceAtPosition(p, 19));
		case 5:
			return (pieceAtPosition(p, 4) && pieceAtPosition(p, 6)) 
					|| (pieceAtPosition(p, 2) && pieceAtPosition(p, 8));
		case 6:
			return (pieceAtPosition(p, 4) && pieceAtPosition(p, 5))
					|| (pieceAtPosition(p, 14) && pieceAtPosition(p, 21));
		case 7:
			return (pieceAtPosition(p, 8) && pieceAtPosition(p, 9))
					|| (pieceAtPosition(p, 12) && pieceAtPosition(p, 16));
		case 8:
			return (pieceAtPosition(p, 2) && pieceAtPosition(p, 5)) 
					|| (pieceAtPosition(p, 7) && pieceAtPosition(p, 9));
		case 9:
			return (pieceAtPosition(p, 7) && pieceAtPosition(p, 8))
					|| (pieceAtPosition(p, 13) && pieceAtPosition(p, 18));
		case 10:
			return (pieceAtPosition(p, 1) && pieceAtPosition(p, 22))
					|| (pieceAtPosition(p, 11) && pieceAtPosition(p, 12));
		case 11:
			return (pieceAtPosition(p, 4) && pieceAtPosition(p, 19))
					|| (pieceAtPosition(p, 10) && pieceAtPosition(p, 12));
		case 12:
			return (pieceAtPosition(p, 7) && pieceAtPosition(p, 16))
					|| (pieceAtPosition(p, 10) && pieceAtPosition(p, 11));
		case 13:
			return (pieceAtPosition(p, 9) && pieceAtPosition(p, 18))
					|| (pieceAtPosition(p, 14) && pieceAtPosition(p, 15));
		case 14:
			return (pieceAtPosition(p, 6) && pieceAtPosition(p, 21))
					|| (pieceAtPosition(p, 13) && pieceAtPosition(p, 15));
		case 15:
			return (pieceAtPosition(p, 3) && pieceAtPosition(p, 24))
					|| (pieceAtPosition(p, 13) && pieceAtPosition(p, 14));
		case 16:
			return (pieceAtPosition(p, 7) && pieceAtPosition(p, 12))
					|| (pieceAtPosition(p, 17) && pieceAtPosition(p, 18));
		case 17:
			return (pieceAtPosition(p, 16) && pieceAtPosition(p, 18))
					|| (pieceAtPosition(p, 20) && pieceAtPosition(p, 23));
		case 18:
			return (pieceAtPosition(p, 16) && pieceAtPosition(p, 17))
					|| (pieceAtPosition(p, 9) && pieceAtPosition(p, 13));
		case 19:
			return (pieceAtPosition(p, 4) && pieceAtPosition(p, 11))
					|| (pieceAtPosition(p, 20) && pieceAtPosition(p, 21));
		case 20:
			return (pieceAtPosition(p, 17) && pieceAtPosition(p, 23))
					|| (pieceAtPosition(p, 19) && pieceAtPosition(p, 21));
		case 21:
			return (pieceAtPosition(p, 6) && pieceAtPosition(p, 14))
					|| (pieceAtPosition(p, 19) && pieceAtPosition(p, 20));
		case 22:
			return (pieceAtPosition(p, 1) && pieceAtPosition(p, 10))
					|| (pieceAtPosition(p, 23) && pieceAtPosition(p, 24));
		case 23:
			return (pieceAtPosition(p, 17) && pieceAtPosition(p, 20))
					|| (pieceAtPosition(p, 22) && pieceAtPosition(p, 24));
		case 24:
			return (pieceAtPosition(p, 15) && pieceAtPosition(p, 3))
					|| (pieceAtPosition(p, 22) && pieceAtPosition(p, 23));
		}

		return false;
	}

	public boolean pieceAtPosition(ArrayList<Piece> p, int pos) {
		for (Piece i : p)
			if (i.position == pos)
				return true;
		return false;
	}

	public boolean canMove(int newPos, int numPieces) {
		if (numPieces <= 4)
			return true;
		switch (position) {
		case 1:
			return newPos == 10 || newPos == 2;
		case 2:
			return newPos == 3 || newPos == 5 || newPos == 1;
		case 3:
			return newPos == 2 || newPos == 15;
		case 4:
			return newPos == 5 || newPos == 11;
		case 5:
			return newPos == 2 || newPos == 8 || newPos == 4 || newPos == 6;
		case 6:
			return newPos == 14 || newPos == 5;
		case 7:
			return newPos == 8 || newPos == 12;
		case 8:
			return newPos == 7 || newPos == 5 || newPos == 9;
		case 9:
			return newPos == 13 || newPos == 8;
		case 10:
			return newPos == 1 || newPos == 11 || newPos == 22;
		case 11:
			return newPos == 4 || newPos == 19 || newPos == 10 || newPos == 12;
		case 12:
			return newPos == 7 || newPos == 11 || newPos == 16;
		case 13:
			return newPos == 9 || newPos == 14 || newPos == 18;
		case 14:
			return newPos == 6 || newPos == 13 || newPos == 15 || newPos == 21;
		case 15:
			return newPos == 3 || newPos == 14 || newPos == 24;
		case 16:
			return newPos == 12 || newPos == 17;
		case 17:
			return newPos == 16 || newPos == 18 || newPos == 20;
		case 18:
			return newPos == 13 || newPos == 17;
		case 19:
			return newPos == 11 || newPos == 20;
		case 20:
			return newPos == 17 || newPos == 19 || newPos == 21 || newPos == 23;
		case 21:
			return newPos == 14 || newPos == 20;
		case 22:
			return newPos == 10 || newPos == 23;
		case 23:
			return newPos == 20 || newPos == 22 || newPos == 24;
		case 24:
			return newPos == 15 || newPos == 23;
		}
		
		return false;
	}

	public boolean isBlack() {
		return black;
	}
	
	public void selectedRing() {
		piece.setStroke(Color.BLUE);
		piece.setStrokeWidth(5);
	}
	
	public void unselect() {
		piece.setStroke(null);
		piece.setStrokeWidth(1);
	}

	public int getPosition() {
		return position;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	
	public String toString() {
		return "Black: " + black + "\tPosition: " + position;
	}
}
