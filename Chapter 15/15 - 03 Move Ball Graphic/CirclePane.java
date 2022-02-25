package graphics;
import javafx.application.Application;
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
class CirclePane extends Pane {
	private Circle circle = new Circle();
	int i = 10;
	CirclePane(){
		
	}
    public CirclePane(double centerX, double centerY, double radius) {
        circle = new Circle(centerX, centerY, radius);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        getChildren().add(circle);
        }

    public void moveLeft(Circle circle) {
		if(circle.getCenterX() > circle.getRadius()) {
		circle.setCenterX(circle.getCenterX() - i);
		}
	}
	
	public void moveRight(Circle circle, Scene scene) {
		if(circle.getCenterX() < scene.getWidth() - 50) {
		circle.setCenterX(circle.getCenterX() + i);
		}
	}
	
	public void moveUp(Circle circle) {
		if(circle.getCenterY() > circle.getRadius()) {
		circle.setCenterY(circle.getCenterY() - i);
		}
	}
	
	public void moveDown(Circle circle, Scene scene) {
		if(circle.getCenterY() < scene.getHeight() - 50) {
		circle.setCenterY(circle.getCenterY() + i);
		}
	}
}