package indproj;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.net.Socket;
import java.util.Date;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Exercise33_09Server extends Application {
  private TextArea taServer = new TextArea();
  private TextArea taClient = new TextArea();
  private DataInputStream input;
  private DataOutputStream output;
 
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    taServer.setWrapText(true);
    taClient.setWrapText(true);
    //taClient.setDisable(true);

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
    primaryStage.setTitle("Exercise31_09Server"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    taClient.requestFocus();
    taClient.setOnKeyPressed(ov -> {
    	
    		try {
    			if(ov.getCode() == KeyCode.ENTER) {
    			String messageS = taClient.getText().trim();
    			taClient.clear();
    			output.writeUTF(messageS);
    			taServer.appendText("\nS: " + messageS);
    			}
    		}
    		catch(IOException io) {
    			io.printStackTrace();
    	}
    });
    new Thread(() -> {
    		try {
    			ServerSocket serverSocket = new ServerSocket(8000);
    			Socket socket = serverSocket.accept();
    			taServer.appendText("Connected to Client at " + new Date());
    			input = new DataInputStream(socket.getInputStream());
    			output = new DataOutputStream(socket.getOutputStream());
    			
    			while(true) {
    				String messageC = input.readUTF();
    				taServer.appendText("\nC: " + messageC);
    			}
    		}
    		catch(IOException io) {
    			io.printStackTrace();
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