package project;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.collections.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import java.text.*;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javafx.event.*;
import javafx.geometry.Insets;
import java.util.TimeZone;
import java.util.Calendar; 
import java.util.GregorianCalendar;

public class WorldClocks extends Application {

private String[] continents = {"North America", "South America", "Europe", "Africa", "Asia", "Australia", "Antarctica"}; 


@Override
public void start(Stage primaryStage) {
		//North America timezones
		ClockPane PST = new ClockPane(Calendar.HOUR - 8, Calendar.MINUTE);
		ClockPane MST = new ClockPane(Calendar.HOUR - 7, Calendar.MINUTE);
		ClockPane CST = new ClockPane(Calendar.HOUR - 6, Calendar.MINUTE);
		ClockPane EST = new ClockPane(Calendar.HOUR - 5, Calendar.MINUTE);
		ClockPane AST = new ClockPane(Calendar.HOUR - 9, Calendar.MINUTE);
		ClockPane HST = new ClockPane(Calendar.HOUR - 10, Calendar.MINUTE);
		
		//South America timezones
		ClockPane  SAUTC6 = new ClockPane(Calendar.HOUR - 6, Calendar.MINUTE);
		ClockPane  SAUTC5 = new ClockPane(Calendar.HOUR - 5, Calendar.MINUTE);
		ClockPane  SAUTC4 = new ClockPane(Calendar.HOUR - 4, Calendar.MINUTE);
		ClockPane  SAUTC3 = new ClockPane(Calendar.HOUR - 3, Calendar.MINUTE);
		
		//Europe timezones
		ClockPane  WET = new ClockPane(Calendar.HOUR, Calendar.MINUTE);
		ClockPane  CET = new ClockPane(Calendar.HOUR + 1, Calendar.MINUTE);
		ClockPane  EET = new ClockPane(Calendar.HOUR + 2, Calendar.MINUTE);
		ClockPane  ESTE = new ClockPane(Calendar.HOUR + 3, Calendar.MINUTE);
		ClockPane  MSK = new ClockPane(Calendar.HOUR + 3, Calendar.MINUTE);
		
		//Africa timezones
		ClockPane  GMT = new ClockPane(Calendar.HOUR, Calendar.MINUTE);
		ClockPane  WAT = new ClockPane(Calendar.HOUR + 1, Calendar.MINUTE);
		ClockPane  CAT = new ClockPane(Calendar.HOUR + 2, Calendar.MINUTE);
		ClockPane  EAT = new ClockPane(Calendar.HOUR + 3, Calendar.MINUTE);
		
		//Asia timezones
		ClockPane  AUTC9 = new ClockPane(Calendar.HOUR + 9, Calendar.MINUTE);
		ClockPane  AUTC8 = new ClockPane(Calendar.HOUR + 8, Calendar.MINUTE);
		ClockPane  AUTC7 = new ClockPane(Calendar.HOUR + 7, Calendar.MINUTE);
		ClockPane  AUTC6 = new ClockPane(Calendar.HOUR + 6, Calendar.MINUTE);
		ClockPane  AUTC5 = new ClockPane(Calendar.HOUR + 5, Calendar.MINUTE);
		ClockPane  AUTC4 = new ClockPane(Calendar.HOUR + 4, Calendar.MINUTE);
		ClockPane  AUTC3 = new ClockPane(Calendar.HOUR + 3, Calendar.MINUTE);
		ClockPane  AUTC2 = new ClockPane(Calendar.HOUR + 2, Calendar.MINUTE);
		
		//Australia timezones
		ClockPane  AEDT = new ClockPane(Calendar.HOUR + 11, Calendar.MINUTE);
		ClockPane  AEST = new ClockPane(Calendar.HOUR + 10, Calendar.MINUTE);
		ClockPane  AWST = new ClockPane(Calendar.HOUR + 8, Calendar.MINUTE);
		
		//Antarctica timezones
		ClockPane  NZDT = new ClockPane(Calendar.HOUR + 13, Calendar.MINUTE);
		ClockPane  DDUT = new ClockPane(Calendar.HOUR + 10, Calendar.MINUTE);
		ClockPane  CAST = new ClockPane(Calendar.HOUR + 8, Calendar.MINUTE);
		ClockPane  DAVT = new ClockPane(Calendar.HOUR + 7, Calendar.MINUTE);
		ClockPane  VOST = new ClockPane(Calendar.HOUR + 6, Calendar.MINUTE);
		ClockPane  MAWT = new ClockPane(Calendar.HOUR + 5, Calendar.MINUTE);
		ClockPane  CEST = new ClockPane(Calendar.HOUR + 2, Calendar.MINUTE);
		ClockPane  CLST = new ClockPane(Calendar.HOUR - 3, Calendar.MINUTE);


	    Date today = new Date();
	    DateFormat df = new SimpleDateFormat("HH:mm ");
        
	    //NA
        df.setTimeZone(TimeZone.getTimeZone("GMT-8"));
        String timeStringPST = "PST " + df.format(today);
    
        df.setTimeZone(TimeZone.getTimeZone("GMT-7"));
	    String timeStringMST= "MST " + df.format(today);
		
	    df.setTimeZone(TimeZone.getTimeZone("GMT-6"));
	    String timeStringCST= "CST " + df.format(today);

        df.setTimeZone(TimeZone.getTimeZone("GMT-5"));
        String timeStringEST = "EST " + df.format(today);
        
	    df.setTimeZone(TimeZone.getTimeZone("GMT-9"));
	    String timeStringAST= "AST " + df.format(today);
	
        df.setTimeZone(TimeZone.getTimeZone("GMT-10"));
        String timeStringHST = "HST " + df.format(today);
        
        //SA
        df.setTimeZone(TimeZone.getTimeZone("GMT-6"));
        String SA6 = "UTC-6 " + df.format(today);
        
        df.setTimeZone(TimeZone.getTimeZone("GMT-5"));
        String SA5 = "UTC-5 " + df.format(today);
        
        df.setTimeZone(TimeZone.getTimeZone("GMT-4"));
        String SA4 = "UTC-4 " + df.format(today);
        
        df.setTimeZone(TimeZone.getTimeZone("GMT-3"));
        String SA3 = "UTC-3 " + df.format(today);
        
        //Europe
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        String timeStringWET = "WET " + df.format(today);
    
        df.setTimeZone(TimeZone.getTimeZone("GMT+1"));
	    String timeStringCET = "CET " + df.format(today);
		
	    df.setTimeZone(TimeZone.getTimeZone("GMT+2"));
	    String timeStringEET = "EET " + df.format(today);

        df.setTimeZone(TimeZone.getTimeZone("GMT+3"));
        String timeStringESTE = "EST " + df.format(today);
        
	    df.setTimeZone(TimeZone.getTimeZone("GMT+3"));
	    String timeStringMSK = "MSK " + df.format(today);
	    
	    //Africa
	    df.setTimeZone(TimeZone.getTimeZone("GMT"));
	    String timeStringGMT = "GMT " + df.format(today);
	    
	    df.setTimeZone(TimeZone.getTimeZone("GMT+1"));
	    String timeStringWAT = "WAT " + df.format(today);
			
	    df.setTimeZone(TimeZone.getTimeZone("GMT+2"));
	    String timeStringCAT = "CAT " + df.format(today);

	    df.setTimeZone(TimeZone.getTimeZone("GMT+3"));
	    String timeStringEAT = "EAT " + df.format(today);
	    
	    //Asia
	    df.setTimeZone(TimeZone.getTimeZone("GMT+9"));
        String ASIA9 = "UTC+9 " + df.format(today);
        
        df.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        String ASIA8 = "UTC+8 " + df.format(today);
        
        df.setTimeZone(TimeZone.getTimeZone("GMT+7"));
        String ASIA7 = "UTC+7 " + df.format(today);
        
        df.setTimeZone(TimeZone.getTimeZone("GMT+6"));
        String ASIA6 = "UTC+6 " + df.format(today);
        
        df.setTimeZone(TimeZone.getTimeZone("GMT+5"));
        String ASIA5 = "UTC+5 " + df.format(today);
        
        df.setTimeZone(TimeZone.getTimeZone("GMT+4"));
        String ASIA4 = "UTC+4 " + df.format(today);
        
        df.setTimeZone(TimeZone.getTimeZone("GMT+3"));
        String ASIA3 = "UTC+3 " + df.format(today);
        
        df.setTimeZone(TimeZone.getTimeZone("GMT+2"));
        String ASIA2 = "UTC+2 " + df.format(today);
       
        //Australia
        df.setTimeZone(TimeZone.getTimeZone("GMT+11"));
	    String timeStringAEDT = "AEDT " + df.format(today);
			
	    df.setTimeZone(TimeZone.getTimeZone("GMT+10"));
	    String timeStringAEST = "AEST " + df.format(today);

	    df.setTimeZone(TimeZone.getTimeZone("GMT+8"));
	    String timeStringAWST = "AWST " + df.format(today);
	    
	    //Antarctica
	    df.setTimeZone(TimeZone.getTimeZone("GMT+13"));
	    String timeStringNZDT = "NZDT " + df.format(today);
			
	    df.setTimeZone(TimeZone.getTimeZone("GMT+10"));
	    String timeStringDDUT = "DDUT " + df.format(today);

	    df.setTimeZone(TimeZone.getTimeZone("GMT+8"));
	    String timeStringCAST = "CAST " + df.format(today);
	    
	    df.setTimeZone(TimeZone.getTimeZone("GMT+7"));
	    String timeStringDAVT = "DAVT " + df.format(today);
			
	    df.setTimeZone(TimeZone.getTimeZone("GMT+6"));
	    String timeStringVOST = "VOST " + df.format(today);

	    df.setTimeZone(TimeZone.getTimeZone("GMT+5"));
	    String timeStringMAWT = "MAWT " + df.format(today);
	    
	    df.setTimeZone(TimeZone.getTimeZone("GMT+2"));
	    String timeStringCEST = "CEST " + df.format(today);
			
	    df.setTimeZone(TimeZone.getTimeZone("GMT-3"));
	    String timeStringCLST = "CLST " + df.format(today);
        
		HBox paneForClocks = new HBox(20);
		paneForClocks.setPadding(new Insets(50, 50, 50, 50));
		paneForClocks.setStyle("-fx-border-width: 2px; -fx-border-color:black");
		
		ListView<String> lv = new ListView<>
		(FXCollections.observableArrayList(continents));
		lv.setPrefSize(200, 200);
		lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		FlowPane imagePane = new FlowPane(10,10);
		BorderPane pane = new BorderPane();

		//NA
	  	Label lblCurrentTimePST = new Label(timeStringPST);
	  	Label lblCurrentTimeMST = new Label(timeStringMST);
	  	Label lblCurrentTimeCST = new Label(timeStringCST);
	  	Label lblCurrentTimeEST = new Label(timeStringEST);
	  	Label lblCurrentTimeAST = new Label(timeStringAST);
	  	Label lblCurrentTimeHST = new Label(timeStringHST);
	
	  	//SA
	  	Label lblCurrentTimeSA6 = new Label(SA6);
	  	Label lblCurrentTimeSA5 = new Label(SA5);
	  	Label lblCurrentTimeSA4 = new Label(SA4);
	  	Label lblCurrentTimeSA3 = new Label(SA3);
	  	
	  	//Europe
		Label lblCurrentTimeWET = new Label(timeStringWET);
	  	Label lblCurrentTimeCET = new Label(timeStringCET);
	  	Label lblCurrentTimeEET = new Label(timeStringEET);
	  	Label lblCurrentTimeESTE = new Label(timeStringESTE);
	  	Label lblCurrentTimeMSK = new Label(timeStringMSK);
	  	
	  	//Africa
	  	Label lblCurrentTimeGMT = new Label(timeStringGMT);
	  	Label lblCurrentTimeWAT = new Label(timeStringWAT);
	  	Label lblCurrentTimeCAT = new Label(timeStringCAT);
	  	Label lblCurrentTimeEAT = new Label(timeStringEAT);
	  	
	  	//Asia
	 	Label lblCurrentTimeASIA9 = new Label(ASIA9);
	  	Label lblCurrentTimeASIA8 = new Label(ASIA8);
	  	Label lblCurrentTimeASIA7 = new Label(ASIA7);
	  	Label lblCurrentTimeASIA6 = new Label(ASIA6);
	 	Label lblCurrentTimeASIA5 = new Label(ASIA5);
	  	Label lblCurrentTimeASIA4 = new Label(ASIA4);
	  	Label lblCurrentTimeASIA3 = new Label(ASIA3);
	  	Label lblCurrentTimeASIA2 = new Label(ASIA2);
	  	
	  	//Australia
		Label lblCurrentTimeAEDT = new Label(timeStringAEDT);
	  	Label lblCurrentTimeAEST = new Label(timeStringAEST);
	  	Label lblCurrentTimeAWST = new Label(timeStringAWST);
	  	
	  	//Antarctica
		Label lblCurrentTimeNZDT = new Label(timeStringNZDT);
	  	Label lblCurrentTimeDDUT = new Label(timeStringDDUT);
	  	Label lblCurrentTimeCAST = new Label(timeStringCAST);
		Label lblCurrentTimeDAVT = new Label(timeStringDAVT);
	  	Label lblCurrentTimeVOST = new Label(timeStringVOST);
	  	Label lblCurrentTimeMAWT = new Label(timeStringMAWT);
		Label lblCurrentTimeCEST = new Label(timeStringCEST);
	  	Label lblCurrentTimeCLST = new Label(timeStringCLST);
	  	

	  	
	    paneForClocks.getChildren().addAll(PST, MST, CST, EST, AST, HST, SAUTC6, SAUTC5, SAUTC4, SAUTC3, WET, CET, EET, ESTE, MSK, GMT, WAT, CAT, EAT, AUTC9, AUTC8, AUTC7, AUTC6, AUTC5, AUTC4, AUTC3, AUTC2, AEDT, AEST, AWST, NZDT, DDUT, CAST, DAVT, VOST, MAWT, CEST, CLST);
		pane.setLeft(new ScrollPane(lv));
		pane.setCenter(imagePane);
		
		lv.getSelectionModel().selectedItemProperty().addListener(ov -> {
			imagePane.getChildren().clear();
			if(lv.getSelectionModel().getSelectedItem() == continents[0]) {
				for(Integer i: lv.getSelectionModel().getSelectedIndices()) {
					imagePane.getChildren().addAll(PST, MST, CST, EST, AST, HST, lblCurrentTimePST, lblCurrentTimeMST, lblCurrentTimeCST, lblCurrentTimeEST, lblCurrentTimeAST, lblCurrentTimeHST);	
				}
			}
			else if(lv.getSelectionModel().getSelectedItem() == continents[1]) {
				for(Integer i: lv.getSelectionModel().getSelectedIndices()) {
					imagePane.getChildren().addAll(SAUTC6, SAUTC5, SAUTC4, SAUTC3, lblCurrentTimeSA6, lblCurrentTimeSA5, lblCurrentTimeSA4, lblCurrentTimeSA3);	
				}
			}
			else if(lv.getSelectionModel().getSelectedItem() == continents[2]) {
				for(Integer i: lv.getSelectionModel().getSelectedIndices()) {
					imagePane.getChildren().addAll(WET, CET, EET, ESTE, MSK, lblCurrentTimeWET, lblCurrentTimeCET, lblCurrentTimeEET, lblCurrentTimeESTE, lblCurrentTimeMSK);	
				}
			}
			else if(lv.getSelectionModel().getSelectedItem() == continents[3]) {
				for(Integer i: lv.getSelectionModel().getSelectedIndices()) {
					imagePane.getChildren().addAll(GMT, WAT, CAT, EAT, lblCurrentTimeGMT, lblCurrentTimeWAT, lblCurrentTimeCAT, lblCurrentTimeEAT);	
				}
			}
			else if(lv.getSelectionModel().getSelectedItem() == continents[4]) {
				for(Integer i: lv.getSelectionModel().getSelectedIndices()) {
					imagePane.getChildren().addAll( AUTC9, AUTC8, AUTC7, AUTC6, AUTC5, AUTC4, AUTC3, AUTC2,lblCurrentTimeASIA9, lblCurrentTimeASIA8, lblCurrentTimeASIA7, lblCurrentTimeASIA6, lblCurrentTimeASIA5, lblCurrentTimeASIA4, lblCurrentTimeASIA3, lblCurrentTimeASIA2);	
				}
			}
			else if(lv.getSelectionModel().getSelectedItem() == continents[5]) {
				for(Integer i: lv.getSelectionModel().getSelectedIndices()) {
					imagePane.getChildren().addAll(AEDT, AEST, AWST, lblCurrentTimeAEDT, lblCurrentTimeAEST, lblCurrentTimeAWST);	
				}
			}
			else if(lv.getSelectionModel().getSelectedItem() == continents[6]) {
				for(Integer i: lv.getSelectionModel().getSelectedIndices()) {
					imagePane.getChildren().addAll(NZDT, DDUT, CAST, DAVT, VOST, MAWT, CEST, CLST, lblCurrentTimeNZDT, lblCurrentTimeDDUT, lblCurrentTimeCAST, lblCurrentTimeDAVT, lblCurrentTimeVOST, lblCurrentTimeMAWT, lblCurrentTimeCEST, lblCurrentTimeCLST);	
				}
			}
		});
		
		
		//NA
		PST.setWidth(120);
		PST.setHeight(120);
		MST.setWidth(120);
		MST.setHeight(120);
		CST.setWidth(120);
		CST.setHeight(120);
		EST.setWidth(120);
		EST.setHeight(120);
		AST.setWidth(120);
		AST.setHeight(120);
		HST.setWidth(120);
		HST.setHeight(120);
		
		//SA
		SAUTC6.setWidth(185);
		SAUTC6.setHeight(185);
		SAUTC5.setWidth(185);
		SAUTC5.setHeight(185);
		SAUTC4.setWidth(185);
		SAUTC4.setHeight(185);
		SAUTC3.setWidth(185);
		SAUTC3.setHeight(185);
	
		//Europe
		WET.setWidth(150);
		WET.setHeight(150);
		CET.setWidth(150);
		CET.setHeight(150);
		EET.setWidth(150);
		EET.setHeight(150);
		ESTE.setWidth(150);
		ESTE.setHeight(150);
		MSK.setWidth(150);
		MSK.setHeight(150);
		
		//Africa
		GMT.setWidth(185);
		GMT.setHeight(185);
		WAT.setWidth(185);
		WAT.setHeight(185);
		CAT.setWidth(185);
		CAT.setHeight(185);
		EAT.setWidth(185);
		EAT.setHeight(185);
		
		//Asia
		AUTC9.setWidth(90);
		AUTC9.setHeight(90);
		AUTC8.setWidth(90);
		AUTC8.setHeight(90);
		AUTC7.setWidth(90);
		AUTC7.setHeight(90);
		AUTC6.setWidth(90);
		AUTC6.setHeight(90);
		AUTC5.setWidth(90);
		AUTC5.setHeight(90);
		AUTC4.setWidth(90);
		AUTC4.setHeight(90);
		AUTC3.setWidth(90);
		AUTC3.setHeight(90);
		AUTC2.setWidth(90);
		AUTC2.setHeight(90);
		
		//Australia
		AEDT.setWidth(150);
		AEDT.setHeight(150);
		AEST.setWidth(150);
		AEST.setHeight(150);
		AWST.setWidth(150);
		AWST.setHeight(150);
		
		//Antartica
		NZDT.setWidth(90);
		NZDT.setHeight(90);
		DDUT.setWidth(90);
		DDUT.setHeight(90);
		CAST.setWidth(90);
		CAST.setHeight(90);
		DAVT.setWidth(90);
		DAVT.setHeight(90);
		VOST.setWidth(90);
		VOST.setHeight(90);
		MAWT.setWidth(90);
		MAWT.setHeight(90);
		CEST.setWidth(90);
		CEST.setHeight(90);
		CLST.setWidth(90);
		CLST.setHeight(90);
		
	Scene scene = new Scene(pane, 1000, 250);
	primaryStage.setTitle("WorldClocks");
	primaryStage.setScene(scene);
	primaryStage.show();
	
	}
public static void main(String[] args) {
	Application.launch(args);
	}
}
