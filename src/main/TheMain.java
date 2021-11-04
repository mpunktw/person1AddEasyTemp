package main;

import javafx.application.Application;
import javafx.stage.Stage;
import auto.viewController.PersonVC;

public class TheMain extends Application {
  @Override
  public void start(Stage stage) {
    PersonVC.show(stage);
  }
  
  public static void main(String[] args) {
    launch(args);
  }
}
