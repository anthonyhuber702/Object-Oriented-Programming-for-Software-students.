package indproj;
import java.io.*;
import java.net.*;
import java.util.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Exercise33_01Server extends Application {
  // Text area for displaying contents
  private TextArea ta = new TextArea();

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    ta.setWrapText(true);
   
    // Create a scene and place it in the stage
    Scene scene = new Scene(new ScrollPane(ta), 400, 200);
    primaryStage.setTitle("Exercise31_01Server"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  
	new Thread(() -> {
		try {
			ServerSocket serverSocket = new ServerSocket(8000);
			
			ta.appendText("\nExercise31_01Server started at " + new Date());

			Socket socket = serverSocket.accept();

			DataInputStream input = new DataInputStream(
				socket.getInputStream());
			DataOutputStream output = new DataOutputStream(
				socket.getOutputStream());

			while (true) {
				Date dateClientConnected = new Date();
				double annualInterestRate = input.readDouble();
				int numOfYears = input.readInt();
				double amount = input.readDouble();

				double monthlyInterestRate = annualInterestRate / 1200;
				double monthlyPayment = amount * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, numOfYears * 12));
				double total = monthlyPayment * numOfYears * 12;

				output.writeDouble(monthlyPayment);
				output.writeDouble(total);

				ta.appendText("\nConnected to a client at " + dateClientConnected);
				ta.appendText("\nAnnual Interest Rate: " + annualInterestRate);
				ta.appendText("\nNumber Of Years: " + numOfYears);
				ta.appendText("\nLoan Amount: " + amount);
				ta.appendText("\nmonthlyPayment: " + monthlyPayment);
				ta.appendText("\ntotalPayment: " + total);
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
