package com.ibercode.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ibercode.aia.api.Blueprint;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

@Controller
public class MainController implements Initializable {

	@Autowired
	private Blueprint blueprint;
	
	@FXML
	private AnchorPane mainAnchorPane;
	@FXML
	private Pane pane;
	@FXML
	private Button drawButton;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}
	
	public void drawBlueprint(ActionEvent event) {
		pane.getChildren().clear();
		blueprint.draw(pane);
	}

}
