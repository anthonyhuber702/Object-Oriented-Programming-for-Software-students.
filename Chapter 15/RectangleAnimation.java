package graphics;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.FadeTransition;

public class RectangleAnimation extends Application {
	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		
		Rectangle rectangle = new Rectangle(0, 0, 25, 50);
		rectangle.setFill(Color.MEDIUMPURPLE);
		
		Polygon pentagon = new Polygon();
		pentagon.getPoints().addAll(new Double[] {
		100.0, 150.0,
		150.0, 300.0,
		350.0, 300.0,
		400.0, 150.0,
		250.0, 50.0,
		});
		pentagon.setFill(Color.WHITE);
		pentagon.setStroke(Color.BLACK);
		
		pane.getChildren().add(pentagon);
		pane.getChildren().add(rectangle);
		
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(4000));
		pt.setPath(pentagon);
		pt.setNode(rectangle);
		pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setAutoReverse(true);
		pt.play();
		
		FadeTransition ft = new FadeTransition(Duration.millis(3000), rectangle);
		ft.setFromValue(1.0);
		ft.setToValue(0.1);
		ft.setCycleCount(Timeline.INDEFINITE);
		ft.setAutoReverse(true);
		ft.play();
		
		pentagon.setOnMousePressed(e -> pt.pause());
		pentagon.setOnMouseReleased(e -> pt.play());
		
		Scene scene = new Scene(pane, 500, 500);
		primaryStage.setTitle("RectangleAnimation");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
		}
}
