package graphics;
import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MoveCircle extends Application {
	private CirclePane circlePane = new CirclePane();
	@Override
public void start(Stage primaryStage) {
		int radius = 20;
        int x = 125;
        int y = 100;
        BorderPane borderPane = new BorderPane();
        Button btLeft = new Button("Left");
        Button btRight = new Button("Right");
        Button btUp = new Button("Up");
        Button btDown = new Button("Down");
        
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        borderPane.setBottom(hBox);
       
        Circle circle = new Circle(x, y, radius);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
       
       
        
        hBox.getChildren().addAll(btLeft, btRight, btUp, btDown);
        borderPane.getChildren().add(circle);
        
        
       
        btLeft.setOnAction(e -> {
            circle.setCenterX(circle.getCenterX() > 20 ? circle.getCenterX() - 5 : 20);
            circle.requestFocus();
        });
        btRight.setOnAction(e -> {
            circle.setCenterX(circle.getCenterX() < 230 ? circle.getCenterX() + 5 : 230);
            circle.requestFocus();
        });
        btUp.setOnAction(e -> {
            circle.setCenterY(circle.getCenterY() > 20 ? circle.getCenterY() - 5 : 20);
            circle.requestFocus();
        });
        btDown.setOnAction(e -> {
            circle.setCenterY(circle.getCenterY() < 199 ? circle.getCenterY() + 5 : 199);
            circle.requestFocus();
        });
        
        circle.setFocusTraversable(true);
        circle.setOnKeyPressed(e -> {
           if (e.getCode() == KeyCode.UP) {
               circle.setCenterY(circle.getCenterY() > 20 ? circle.getCenterY() - 5 : 20);
           }
           else if (e.getCode() == KeyCode.DOWN) {
               circle.setCenterY(circle.getCenterY() < 199 ? circle.getCenterY() + 5 : 199);
           }
           else if (e.getCode() == KeyCode.LEFT) {
               circle.setCenterX(circle.getCenterX() > 20 ? circle.getCenterX() - 5 : 20);
           }
           else if (e.getCode() == KeyCode.RIGHT) {
               circle.setCenterX(circle.getCenterX() < 230 ? circle.getCenterX() + 5 : 230);
           }
        });
        
        
        Scene scene = new Scene(borderPane, 250, 250);
        primaryStage.setTitle("MoveCircle");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        circle.requestFocus();
    }
    
public static void main(String[] args) {
	Application.launch(args);
	}
}