package project;
import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.shape.*;
public class ToDoList extends Application {
	int done = 0;
	@Override
	public void start(Stage primaryStage) {
		TableView<Task> tableView = new TableView<>();
		ObservableList<Task> examples = 
				FXCollections.observableArrayList(
						new Task("Do project", "ASAP", "complete to do list project", true),
						new Task("Get gift", "5/08/22", "get mom a gift from the store", false));
		tableView.setItems(examples);
		
		TableColumn taskCol = new TableColumn("Task");
		taskCol.setMinWidth(200);
		taskCol.setCellValueFactory(
				new PropertyValueFactory<Task, String>("task"));
		
		TableColumn dateCol = new TableColumn("Due Date");
	    dateCol.setMinWidth(100);
	    dateCol.setCellValueFactory(
		      new PropertyValueFactory<Task, String>("date"));
	    
		TableColumn descCol = new TableColumn("Description");
		descCol.setMinWidth(300);
		descCol.setCellValueFactory(
				new PropertyValueFactory<Task, String>("description"));
		
		TableColumn urgentCol = new TableColumn("Urgent");
		urgentCol.setMinWidth(50);
		urgentCol.setCellValueFactory(
				new PropertyValueFactory<Task, Boolean>("urgent"));
		tableView.getColumns().addAll(taskCol, dateCol, descCol, urgentCol);
		
		
		FlowPane flowPane = new FlowPane(3, 3);
		TextField tfTask = new TextField();
		TextField tfDate = new TextField();
		TextField tfDesc = new TextField();
		CheckBox chkUrgent = new CheckBox("URGENT");
		
		
		Button btAdd = new Button("Add new task");
		tfTask.setPrefColumnCount(5);
		tfDate.setPrefColumnCount(5);
		tfDesc.setPrefColumnCount(5);
		flowPane.getChildren().addAll(new Label("Task: "), tfTask, new Label("Due Date: "), tfDate, new Label("Description: "), tfDesc, chkUrgent, btAdd);
				
		btAdd.setOnAction(e -> {
			examples.add(new Task(tfTask.getText(), tfDate.getText(), tfDesc.getText(), chkUrgent.isSelected()));
			tfTask.clear();
			tfDate.clear();
			tfDesc.clear();
			chkUrgent.setSelected(false);
			if(chkUrgent.isSelected() == true) {
				chkUrgent.getStyleClass().add("chkurgent");
					}
			
		});
		HBox hBox = new HBox(5);
		Button btComplete = new Button("Complete Selected Task");
		hBox.getChildren().add(btComplete);
		hBox.setAlignment(Pos.TOP_CENTER);
	
		btComplete.setOnAction(e -> {
		examples.remove(tableView.getSelectionModel().getSelectedIndex());
		});
		
		
		MenuBar menuBar = new MenuBar();
		Menu menuExit = new Menu("Exit");
		menuBar.getMenus().add(menuExit);
	
		MenuItem menuEx = new MenuItem("Close");
		menuExit.getItems().add(menuEx);
		menuEx.setOnAction(e -> System.exit(0));
		
		
		
		
		HBox hBox1 = new HBox(5);
		hBox1.getChildren().add(menuBar);
	
		
		
		//make urgent task highlighted
		
		BorderPane pane = new BorderPane();
		pane.setCenter(tableView);
		pane.setBottom(flowPane);
		pane.setTop(hBox);
		pane.setLeft(hBox1);
		
	
		
		Scene scene = new Scene(pane, 650, 350);
		primaryStage.setTitle("To-Do List");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	public static class Task {
		private final SimpleStringProperty task;
		private final SimpleStringProperty date;
		private final SimpleStringProperty description;
		private final SimpleBooleanProperty urgent;
		
		private Task(String task, String date, String description, boolean urgent) {
			this.task = new SimpleStringProperty(task);
			this.date = new SimpleStringProperty(date);
			this.description = new SimpleStringProperty(description);
			this.urgent = new SimpleBooleanProperty(urgent);
		}
		public String getTask() {
			return task.get();
		}
		public void setTask(String task) {
			this.task.set(task);
		}
		public String getDate() {
			return date.get();
		}
		public void setDate(String date) {
			this.date.set(date);
		}
		public String getDescription() {
			return description.get();
		}
		public void setDescription(String description) {
			this.description.set(description);
		}
		public boolean isUrgent() {
			return urgent.get();
			}
		public void setUrgent(boolean urgent) {
			this.urgent.set(urgent);
		}
	}
	public static void main(String[] args) {
		launch(args);
	}

}
