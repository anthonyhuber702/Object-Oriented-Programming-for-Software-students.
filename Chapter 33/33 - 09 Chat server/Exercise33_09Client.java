package indproj;
import javafx.application.Application;
import static javafx.application.Application.launch;
import java.io.*;
import java.net.Socket;
import java.util.*;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Exercise33_09Client extends Application {
  private TextArea taServer = new TextArea();
  private TextArea taClient = new TextArea();
  private DataInputStream input;
  private DataOutputStream output;
 
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    taServer.setWrapText(true);
    taClient.setWrapText(true);
    //taServer.setDisable(true);

    BorderPane pane1 = new BorderPane();
    pane1.setTop(new Label("History"));
    pane1.setCenter(new ScrollPane(taServer));
    BorderPane pane2 = new BorderPane();
    pane2.setTop(new Label("New Message"));
    pane2.setCenter(new ScrollPane(taClient));
    
    VBox vBox = new VBox(5);
    vBox.getChildren().addAll(pane1, pane2);

    // Create a scene and place it in the stage
    Scene scene = new Scene(vBox, 200, 200);
    primaryStage.setTitle("Exercise31_09Client"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    // To complete later
    taClient.requestFocus();
    taClient.setOnKeyPressed(ov -> {
    	if(ov.getCode() == KeyCode.ENTER) {
    		try {
    			String messageC = taClient.getText().trim();
    			taClient.clear();
    			output.writeUTF(messageC);
    			taServer.appendText("\nC: " + messageC);
    		}
    		catch(IOException io) {
    			io.printStackTrace();
    		}
    	}
    });
    new Thread(() -> {
    		try {
    			Socket socket = new Socket("localHost", 8000);
    			taServer.appendText("Connected to Host at " + new Date());
    			input = new DataInputStream(socket.getInputStream());
    			output = new DataOutputStream(socket.getOutputStream());
    			
    			while(true) {
    				String messageS = input.readUTF();
    				taServer.appendText("\nS: " + messageS);
    			}
    		}
    		catch(IOException ex) {
    			ex.printStackTrace();
    		}
  }).start();
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}