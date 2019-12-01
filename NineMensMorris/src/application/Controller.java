package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class Controller implements Initializable {

	@FXML
	private Button a1, a4, a7, b2, b4, b6, c3, c4, c5, d1, d2, d3, d5, d6, d7, e3, e4, e5, f2, f4, f6, g1, g4, g7;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//Nothing needed here.
	}
	
	public void btna1(ActionEvent event) {
		Main.move(a1.getLayoutX() - 8, a1.getLayoutY() - 8, 3);
	}

	public void btna4(ActionEvent event) {
		Main.move(a4.getLayoutX() - 8, a4.getLayoutY() - 8, 2);
	}

	public void btna7(ActionEvent event) {
		Main.move(a7.getLayoutX() - 8, a7.getLayoutY() - 8, 1);
	}

	public void btnb2(ActionEvent event) {
		Main.move(b2.getLayoutX() - 8, b2.getLayoutY() - 8, 6);
	}

	public void btnb4(ActionEvent event) {
		Main.move(b4.getLayoutX() - 8, b4.getLayoutY() - 8, 5);
	}

	public void btnb6(ActionEvent event) {
		Main.move(b6.getLayoutX() - 8, b6.getLayoutY() - 8, 4);
	}

	public void btnc3(ActionEvent event) {
		Main.move(c3.getLayoutX() - 8, c3.getLayoutY() - 8, 9);
	}

	public void btnc4(ActionEvent event) {
		Main.move(c4.getLayoutX() - 8, c4.getLayoutY() - 8, 8);
	}

	public void btnc5(ActionEvent event) {
		Main.move(c5.getLayoutX() - 8, c5.getLayoutY() - 8, 7);
	}

	public void btnd1(ActionEvent event) {
		Main.move(d1.getLayoutX() - 8, d1.getLayoutY() - 8, 15);
	}

	public void btnd2(ActionEvent event) {
		Main.move(d2.getLayoutX() - 8, d2.getLayoutY() - 8, 14);
	}

	public void btnd3(ActionEvent event) {
		Main.move(d3.getLayoutX() - 8, d3.getLayoutY() - 8, 13);
	}

	public void btnd5(ActionEvent event) {
		Main.move(d5.getLayoutX() - 8, d5.getLayoutY() - 8, 12);
	}

	public void btnd6(ActionEvent event) {
		Main.move(d6.getLayoutX() - 8, d6.getLayoutY() - 8, 11);
	}

	public void btnd7(ActionEvent event) {
		Main.move(d7.getLayoutX() - 8, d7.getLayoutY() - 8, 10);
	}

	public void btne3(ActionEvent event) {
		Main.move(e3.getLayoutX() - 8, e3.getLayoutY() - 8, 18);
	}

	public void btne4(ActionEvent event) {
		Main.move(e4.getLayoutX() - 8, e4.getLayoutY() - 8, 17);
	}

	public void btne5(ActionEvent event) {
		Main.move(e5.getLayoutX() - 8, e5.getLayoutY() - 8, 16);
	}

	public void btnf2(ActionEvent event) {
		Main.move(f2.getLayoutX() - 8, f2.getLayoutY() - 8, 21);
	}

	public void btnf4(ActionEvent event) {
		Main.move(f4.getLayoutX() - 8, f4.getLayoutY() - 8, 20);
	}

	public void btnf6(ActionEvent event) {
		Main.move(f6.getLayoutX() - 8, f6.getLayoutY() - 8, 19);
	}

	public void btng1(ActionEvent event) {
		Main.move(g1.getLayoutX() - 8, g1.getLayoutY() - 8, 24);
	}

	public void btng4(ActionEvent event) {
		Main.move(g4.getLayoutX() - 8, g4.getLayoutY() - 8, 23);
	}

	public void btng7(ActionEvent event) {
		Main.move(g7.getLayoutX() - 8, g7.getLayoutY() - 8, 22);
	}

}
