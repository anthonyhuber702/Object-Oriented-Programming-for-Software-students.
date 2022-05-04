package indproj;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
public class InvestmentCalc extends Application {
	private TextField investmentAmount = new TextField();
	private TextField numOfYears = new TextField();
	private TextField annualInterest = new TextField();
	private TextField futureValue = new TextField();
	
	@Override
	public void start(Stage primaryStage) {
		MenuBar menuBar = new MenuBar();
		
		Menu menuOperation = new Menu("Operation");
		Menu menuExit = new Menu("Exit");
		menuBar.getMenus().addAll(menuOperation, menuExit);
		
		MenuItem menuCalculate = new MenuItem("Calculate");
		
		menuOperation.getItems().add(menuCalculate);
		
		MenuItem menuItemClose = new MenuItem("Close");
		menuExit.getItems().add(menuItemClose);
		
		HBox hBox1 = new HBox(5);
		Button btCalculate = new Button("Calculate");
		hBox1.getChildren().add(btCalculate);
		hBox1.setAlignment(Pos.CENTER);
		
		VBox vBox = new VBox(10);
		investmentAmount.setPrefColumnCount(5);
		numOfYears.setPrefColumnCount(5);
		annualInterest.setPrefColumnCount(5);
		futureValue.setPrefColumnCount(5);
		vBox.getChildren().addAll(menuBar, new Label("Investment Amount: "), investmentAmount, new Label("Number of Years: "), numOfYears, new Label("Annual Interest Rate: "), annualInterest, new Label("Future Value: "), futureValue);
		vBox.setAlignment(Pos.CENTER);
		vBox.getChildren().add(hBox1);
		
		Scene scene = new Scene(vBox, 350, 320);
		primaryStage.setTitle("Investment Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		menuCalculate.setOnAction(e -> perform("Calculate"));
		btCalculate.setOnAction(e -> perform("Calculate"));
		menuItemClose.setOnAction(e -> System.exit(0));
	}
	private void perform(String operator) {
		double number1 = Double.parseDouble(investmentAmount.getText());
		double number2 = Double.parseDouble(numOfYears.getText());
		double number3 = Double.parseDouble(annualInterest.getText());
		
		double result = 0;
		switch(operator) {
		case "Calculate": result = number1 * (Math.pow(1 + (number3 / 1200), number2 * 12)); 
		}
		futureValue.setText(String.format("$%.2f", result) + " ");
	}
}