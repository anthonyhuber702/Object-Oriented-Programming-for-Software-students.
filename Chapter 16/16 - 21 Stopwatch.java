package graphics;
import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.media.*;
import javafx.event.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.util.Duration;
import javafx.scene.control.*;
public class Stopwatch extends Application {
private static final String MEDIA_URL = "https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3";
	@Override
public void start(Stage primaryStage) {
		Media media = new Media(MEDIA_URL);
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		
	
    TextField countdown = new TextField("0");
    countdown.setFont(Font.font(70));
    Pane pane = new Pane(countdown);


    Timeline animation = new Timeline(
            new KeyFrame(Duration.millis(1000), e -> { 
            	 
                countdown.setText((Integer.parseInt(countdown.getText()) - 1) + "");
            }));
   
    countdown.setOnAction((e) -> {
        if (animation.getStatus() == Animation.Status.RUNNING) {
            animation.stop();
            mediaPlayer.play();
        }
        
        animation.setCycleCount(Timeline.INDEFINITE);
       
    });
  
    Scene scene = new Scene(pane, 250, 150);
    primaryStage.setTitle("Countdown");
    primaryStage.setScene(scene);
    primaryStage.show();
}
public static void main(String[] args) {
    Application.launch(args);
	}
}

