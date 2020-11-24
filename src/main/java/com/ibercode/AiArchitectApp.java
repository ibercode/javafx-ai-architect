package com.ibercode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
public class AiArchitectApp extends Application {

	private ConfigurableApplicationContext context;
	private Parent parent;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() throws Exception {
		context = SpringApplication.run(AiArchitectApp.class);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ibercode/controllers/Main.fxml"));
		loader.setControllerFactory(context::getBean);
		parent = loader.load();
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(new Scene(parent));
		stage.setTitle("AI ARCHITECT");
		stage.show();
	}

	@Override
	public void stop() throws Exception {
		context.close();
	}

}
