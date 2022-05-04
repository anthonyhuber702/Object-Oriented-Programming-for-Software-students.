package indproj;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class TabPaneDemo extends Application {   
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {   
    TabPane tabPane = new TabPane();
    Tab tab1 = new Tab("Line");
    StackPane pane1 = new StackPane();
    pane1.getChildren().add(new Line(10, 10, 80, 80));
    tab1.setContent(pane1);
    Tab tab2 = new Tab("Rectangle");
    tab2.setContent(new Rectangle(10, 10, 200, 200));
    Tab tab3 = new Tab("Circle");
    tab3.setContent(new Circle(50, 50, 20));    
    Tab tab4 = new Tab("Ellipse");
    tab4.setContent(new Ellipse(10, 10, 100, 80));
    tabPane.getTabs().addAll(tab1, tab2, tab3, tab4);
    
    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(tabPane);
    HBox hBox = new HBox(5);
    RadioButton btTop = new RadioButton("Top");
    RadioButton btLeft = new RadioButton("Left");
    RadioButton btBottom = new RadioButton("Bottom");
    RadioButton btRight = new RadioButton("Right");
    hBox.getChildren().addAll(btTop, btLeft, btBottom, btRight);
    hBox.setAlignment(Pos.BOTTOM_CENTER);
    borderPane.setBottom(hBox);
    
    btTop.setOnAction(e -> {
    	tabPane.setSide(Side.TOP);
    	btLeft.setSelected(false);
    	btRight.setSelected(false);
    	btBottom.setSelected(false);
    });
    btLeft.setOnAction(e -> {
    	tabPane.setSide(Side.LEFT);
    	btTop.setSelected(false);
    	btBottom.setSelected(false);
    	btRight.setSelected(false);
    });
    btBottom.setOnAction(e -> {
    	tabPane.setSide(Side.BOTTOM);
    	btTop.setSelected(false);
    	btLeft.setSelected(false);
    	btRight.setSelected(false);
    });
    btRight.setOnAction(e -> {
    	tabPane.setSide(Side.RIGHT);
    	btTop.setSelected(false);
    	btLeft.setSelected(false);
    	btBottom.setSelected(false);
    });
    Scene scene = new Scene(borderPane, 300, 250);  
    primaryStage.setTitle("DisplayFigure"); // Set the window title
    primaryStage.setScene(scene); // Place the scene in the window
    primaryStage.show(); // Display the window
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   * line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}