package capstone;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;

public class ATM extends Application {
	static int bills;
	static int set;
	Checking checking = new Checking();
	Savings savings = new Savings();
	  Label checkingBalance;
	  Label savingsBalance;
	  String checkID;
	  String ID;
	  public static void main(String[] args) {
	        launch(args);
	    }
	    @Override
	    public void start(Stage primaryStage) {
//Account Choice
	         HBox hb1 = new HBox();
	         HBox vb = new HBox();
	 
	         Label lblBank = new Label("Bank of Java");    
	         lblBank.setFont(Font.font("Times New Roman", FontWeight.BOLD, 38));
	         lblBank.setTextFill(Color.FIREBRICK);
	         Button btChecking = new Button("Checking Account");
	         Button btSavings = new Button("Savings Account");
	         Button btTransfer = new Button("Transfer");	         	         
	        
	         hb1.setSpacing(50);
	         hb1.setAlignment(Pos.CENTER); 
	         vb.getChildren().add(lblBank);
	         vb.setAlignment(Pos.TOP_CENTER);
	         lblBank.setTranslateX(250);
	         hb1.getChildren().addAll(btChecking, btSavings, btTransfer);
	         hb1.setTranslateX(-90);
	         vb.getChildren().addAll(hb1);

	      Scene choiceScene = new Scene(vb, 720, 200);
	      primaryStage.setTitle("ATM");
	      primaryStage.setScene(choiceScene);
	      primaryStage.show();	
//PIN Login 	      
          BorderPane bp = new BorderPane();
          HBox hb = new HBox();
          GridPane gridPane = new GridPane();
    
          gridPane.setHgap(5);
          gridPane.setVgap(5); 

          Label lblID = new Label("PIN");
          TextField tfID = new TextField();
          Button btLogin = new Button("Login");
          Label lblMessage = new Label();
          Button btLogout = new Button("Log Out");
    
          gridPane.add(lblID, 0, 0);
          gridPane.add(tfID, 1, 0);
          gridPane.add(btLogin, 2, 0);
          gridPane.add(lblMessage, 1, 2);
          gridPane.setTranslateX(80);
          gridPane.setTranslateY(10);
          
          Text text = new Text("Bank of Java");
          text.setFont(Font.font("Times New Roman", FontWeight.BOLD, 28));
          text.setFill(Color.FIREBRICK);
          
          text.setTranslateX(120);
          hb.getChildren().add(text);  
          hb1.getChildren().add(btLogout);
          
          bp.setId("bp");
          gridPane.setId("root");
          btLogin.setId("btLogin");
          text.setId("text"); 
          
          bp.setTop(hb);
          bp.setCenter(gridPane);  
           
       Scene scene = new Scene(bp, 400, 110);
       primaryStage.setScene(scene);
       primaryStage.show();
//Return to PIN Login       
       btLogout.setOnAction(e -> {
     	  primaryStage.setScene(scene);
       });
       
       Button btCreateAcc = new Button("Create Account");
       gridPane.add(btCreateAcc, 2, 2);
//Create PIN   
       btCreateAcc.setOnAction(e -> {
    	   lblMessage.setText("");
    	   GridPane gpCreatePIN = new GridPane();	      	 
    	   TextField tfConfirmPIN = new TextField();
    	   TextField tfCreatePIN = new TextField();
    	   Button btCreatePIN = new Button("Create PIN");
    	   Button btCancel = new Button("Cancel");
    	   Label lblCreatePIN = new Label("Account PIN");
    	   Label lblConfirmPIN = new Label("Confirm PIN");
    	   Label lblMessage1 = new Label();
    	   Label lblMessage2 = new Label();
    	   
    	   gpCreatePIN.add(tfCreatePIN, 2, 0);
    	   gpCreatePIN.add(tfConfirmPIN, 2, 1);
    	   gpCreatePIN.add(lblCreatePIN, 1, 0);
    	   gpCreatePIN.add(lblConfirmPIN, 1, 1);
    	   gpCreatePIN.add(btCreatePIN, 2, 2);
    	   gpCreatePIN.add(btCancel, 3, 2);
    	   gpCreatePIN.add(lblMessage1, 2, 3);
    	   gpCreatePIN.add(lblMessage2, 2, 3);
    	   
    	   gpCreatePIN.setHgap(5);
    	   gpCreatePIN.setVgap(5);
    	   
    	   Scene createPINScene = new Scene(gpCreatePIN, 350, 120);
    	   primaryStage.setScene(createPINScene);
//Finalize PIN	   
    	   btCreatePIN.setOnAction(i -> {
    		   lblMessage1.setText("");
    		   lblMessage2.setText("");
    		   if(tfCreatePIN.getText().trim().isEmpty() && tfConfirmPIN.getText().trim().isEmpty()) {
    	        	 lblMessage2.setText("Please Enter a PIN");
    	             lblMessage2.setTextFill(Color.RED); 
    	         }
    		   else if(tfCreatePIN.getText().toString().length() < 4 || tfCreatePIN.getText().toString().length() > 4) {
    			   lblMessage2.setText("PIN Must Be 4 Digits");
    			   lblMessage2.setTextFill(Color.RED); 
    		   }
    		   else if(tfCreatePIN.getText().toString().equals(tfConfirmPIN.getText().toString())) {
    			   ID = tfCreatePIN.getText().toString();
    			   primaryStage.setScene(scene);
    		   }
    		   else {
    			    lblMessage1.setText("PINs Do Not Match");
    	            lblMessage1.setTextFill(Color.RED);
    		   }
    		   tfCreatePIN.setText("");
    		   tfConfirmPIN.setText("");
    	   });
//Return to PIN Login   	   
    	   btCancel.setOnAction(i -> {
    		  primaryStage.setScene(scene);
    	   });
       });
//Login to Account
       btLogin.setOnAction(j -> {
    	   lblMessage.setText("");
    	   checkID = tfID.getText().toString();
         if(tfID.getText().toString().equals(ID) || tfID.getText().toString().equals("1")) {
          primaryStage.setScene(choiceScene);
         }
         else if(tfID.getText().trim().isEmpty()) {
        	 lblMessage.setText("Please Enter an ID");
             lblMessage.setTextFill(Color.RED); 
         }
         else{
          lblMessage.setText("Incorrect ID");
          lblMessage.setTextFill(Color.RED);
         }
         tfID.setText("");
        });

//Access Checking Account
	      btChecking.setOnAction(e -> {
	    
	      	  Label lblMain = new Label("Checking Account");
		        lblMain.setFont(Font.font("Times New Roman", FontWeight.BOLD, 28));
		        lblMain.setTextFill(Color.DODGERBLUE);
		        lblMain.setAlignment(Pos.CENTER);
		        
		  	  Button btBalance = new Button("Check Balance");
		  	  Button btWithdraw = new Button("Withdraw");
		  	  Button btDeposit = new Button("Deposit");
		  	  Button btBack = new Button("Back");
		  	    
		  	  VBox vbChecking = new VBox();
		  	  
		  	  vbChecking.getChildren().addAll(lblMain, btBalance, btWithdraw, btDeposit, btBack);
		  	  vbChecking.setSpacing(50);
		  	  vbChecking.setAlignment(Pos.CENTER);

	    	  Scene checkingScene = new Scene(vbChecking, 300, 400);
	    	  primaryStage.setScene(checkingScene);
//Access Checking Balance
	    	  btBalance.setOnAction(i -> {
	    		  vbChecking.getChildren().remove(checkingBalance);
	    		  checkingBalance = new Label(checking.toString());
	    		  vbChecking.getChildren().add(checkingBalance);
	    		  if(checking.getBalance() > 0) {
	    			  checkingBalance.setTextFill(Color.GREEN);
	    		  }
	    		  else if(checking.getBalance() < 0) {
	    			  checkingBalance.setTextFill(Color.RED);
	    		  }
	    	  });
//Access Checking Withdraw
	    	  btWithdraw.setOnAction(i -> {
	    		  vbChecking.getChildren().remove(checkingBalance);
	    		  Label lblAmount = new Label("Withdraw Amount");
			        lblAmount.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 20));
			        lblAmount.setAlignment(Pos.CENTER);
			        
			        Button btSet20 = new Button("$20");
			        Button btSet50 = new Button("$50");
			        Button btSet80 = new Button("$80");
			        Button btSet100 = new Button("$100");
			        Button btSetOther = new Button("Other");
			        Button btSetBack = new Button("Back");
			        
			        VBox vbSet = new VBox();
			        vbSet.getChildren().addAll(lblAmount, btSet20, btSet50, btSet80, btSet100, btSetOther, btSetBack);
			        vbSet.setSpacing(30);
			        vbSet.setAlignment(Pos.CENTER);
	    		  
	    		  Scene checkingWithdrawScene = new Scene(vbSet, 300, 400);
	    		  primaryStage.setScene(checkingWithdrawScene);
//Withdraw $20 from Checking Account  		  
	    		  btSet20.setOnAction(j -> {
	    			  VBox vbSet1 = new VBox();
	    			  HBox hbSet = new HBox();
	    			  
	    			  set = 20;
	    			  
	    			  Label lblConfirm = new Label("Withdraw $" + set + " From Account?");
	    		      lblConfirm.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 15));
	    			  lblConfirm.setAlignment(Pos.TOP_CENTER);
	    			  
	    			  Button btYes = new Button("YES");
	    			  Button btNo = new Button("NO");
	    			  
	    			  hbSet.getChildren().addAll(btYes, btNo);
	    			  vbSet1.getChildren().addAll(lblConfirm, hbSet);
	    			  vbSet1.setSpacing(50);
	    			  hbSet.setSpacing(30);
//Confirm $20 Withdraw from Checking    			  
	    			  	btYes.setOnAction(l -> {
	    			  		if(checking.canWithdraw(set)) {
	    			  			checking.withdraw(set);
	    			  			primaryStage.setScene(checkingWithdrawScene);
	    			  		}
	    			  		else {
	    			  			VBox vbLimit = new VBox();
	    			  			VBox vbLimit1 = new VBox();
	    			  			Button btReturn = new Button("Back");
	    			  			Label lblLimit = new Label("Cannot Withdraw");
	    			  			Label lblLimit1 = new Label("Overdraft Limit Reached");
	    			  			lblLimit1.setTextFill(Color.RED);
	    			  			lblLimit.setTextFill(Color.RED);
	    			  			vbLimit.setPadding(new Insets(-120, 20, 10, 10));
	    			  			vbLimit1.setPadding(new Insets(-150, 20, 10, 10));
	    			  			vbLimit.getChildren().add(lblLimit);
	    			  			vbLimit1.getChildren().add(lblLimit1);
	    			  			vbSet1.getChildren().addAll(vbLimit, vbLimit1);
	    			  			hbSet.getChildren().clear();
    			  				hbSet.getChildren().add(btReturn);
//Return to Withdraw Amount Selection   			  				
	    			  			btReturn.setOnAction(m -> {	
	    			  				primaryStage.setScene(checkingWithdrawScene);
	    			  			});
	    			  		}
	    			  	});
//Return to Withdraw Amount Selection
	    			  	btNo.setOnAction(m -> {
	    			  		primaryStage.setScene(checkingWithdrawScene);
	    			  	});  
	    			  	Scene setScene = new Scene(vbSet1, 200, 100);
	    				  primaryStage.setScene(setScene);
	    		  });
//Return to Checking Account	    		  
	    		  btSetBack.setOnAction(k -> {
		    		  primaryStage.setScene(checkingScene);
		    	  });
//Withdraw $50 from Checking Account	    		  
	    		  btSet50.setOnAction(j -> {
	    			  VBox vbSet1 = new VBox();
	    			  HBox hbSet = new HBox();
	    			  
	    			  set = 50;
	    			  
	    			  Label lblConfirm = new Label("Withdraw $" + set + " From Account?");
	    		      lblConfirm.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 15));
	    			  lblConfirm.setAlignment(Pos.TOP_CENTER);
	    			  
	    			  Button btYes = new Button("YES");
	    			  Button btNo = new Button("NO");
	    			  
	    			  hbSet.getChildren().addAll(btYes, btNo);
	    			  vbSet1.getChildren().addAll(lblConfirm, hbSet);
	    			  vbSet1.setSpacing(50);
	    			  hbSet.setSpacing(30);
//Confirm $50 Withdraw from Checking Account   			  
	    			  	btYes.setOnAction(l -> {
	    			  		if(checking.canWithdraw(set)) {
	    			  			checking.withdraw(set);
	    			  			primaryStage.setScene(checkingWithdrawScene);
	    			  		}
	    			  		else {
	    			  			VBox vbLimit = new VBox();
	    			  			VBox vbLimit1 = new VBox();
	    			  			Button btReturn = new Button("Back");
	    			  			Label lblLimit = new Label("Cannot Withdraw");
	    			  			Label lblLimit1 = new Label("Overdraft Limit Reached");
	    			  			lblLimit1.setTextFill(Color.RED);
	    			  			lblLimit.setTextFill(Color.RED);
	    			  			vbLimit.setPadding(new Insets(-120, 20, 10, 10));
	    			  			vbLimit1.setPadding(new Insets(-150, 20, 10, 10));
	    			  			vbLimit.getChildren().add(lblLimit);
	    			  			vbLimit1.getChildren().add(lblLimit1);
	    			  			vbSet1.getChildren().addAll(vbLimit, vbLimit1);
	    			  			hbSet.getChildren().clear();
    			  				hbSet.getChildren().add(btReturn);
//Return to Withdraw Amount Selection   			  				
	    			  			btReturn.setOnAction(m -> {	
	    			  				primaryStage.setScene(checkingWithdrawScene);
	    			  			});
	    			  		}
	    			  	});
//Return to Withdraw Amount Selection
	    			  	btNo.setOnAction(m -> {
	    			  		primaryStage.setScene(checkingWithdrawScene);
	    			  	}); 
	    			  	Scene setScene = new Scene(vbSet1, 200, 100);
	    				  primaryStage.setScene(setScene);
	    		  });
//Withdraw $80 from Checking Account	    		  
	    		  btSet80.setOnAction(j -> {
	    			  VBox vbSet1 = new VBox();
	    			  HBox hbSet = new HBox();
	    			  
	    			  set = 80;
	    			  
	    			  Label lblConfirm = new Label("Withdraw $" + set + " From Account?");
	    		      lblConfirm.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 15));
	    			  lblConfirm.setAlignment(Pos.TOP_CENTER);
	    			  
	    			  Button btYes = new Button("YES");
	    			  Button btNo = new Button("NO");
	    			  
	    			  hbSet.getChildren().addAll(btYes, btNo);
	    			  vbSet1.getChildren().addAll(lblConfirm, hbSet);
	    			  vbSet1.setSpacing(50);
	    			  hbSet.setSpacing(30);
//Confirm $80 Withdraw from Checking Account  			  
	    			  	btYes.setOnAction(l -> {
	    			  		if(checking.canWithdraw(set)) {
	    			  			checking.withdraw(set);
	    			  			primaryStage.setScene(checkingWithdrawScene);
	    			  		}
	    			  		else {
	    			  			VBox vbLimit = new VBox();
	    			  			VBox vbLimit1 = new VBox();
	    			  			Button btReturn = new Button("Back");
	    			  			Label lblLimit = new Label("Cannot Withdraw");
	    			  			Label lblLimit1 = new Label("Overdraft Limit Reached");
	    			  			lblLimit1.setTextFill(Color.RED);
	    			  			lblLimit.setTextFill(Color.RED);
	    			  			vbLimit.setPadding(new Insets(-120, 20, 10, 10));
	    			  			vbLimit1.setPadding(new Insets(-150, 20, 10, 10));
	    			  			vbLimit.getChildren().add(lblLimit);
	    			  			vbLimit1.getChildren().add(lblLimit1);
	    			  			vbSet1.getChildren().addAll(vbLimit, vbLimit1);
	    			  			hbSet.getChildren().clear();
    			  				hbSet.getChildren().add(btReturn);
//Return to Withdraw Amount Selection   			  				
	    			  			btReturn.setOnAction(m -> {	
	    			  				primaryStage.setScene(checkingWithdrawScene);
	    			  			});
	    			  		}
	    			  	});
//Return to Withdraw Amount Selection
	    			  	btNo.setOnAction(m -> {
	    			  		primaryStage.setScene(checkingWithdrawScene);
	    			  	}); 
	    			  	Scene setScene = new Scene(vbSet1, 200, 100);
	    				  primaryStage.setScene(setScene);
	    		  });
//Withdraw $100 from Checking Account	    		  
	    		  btSet100.setOnAction(j -> {
	    			  VBox vbSet1 = new VBox();
	    			  HBox hbSet = new HBox();
	    			  
	    			  set = 100;
	    			  
	    			  Label lblConfirm = new Label("Withdraw $" + set + " From Account?");
	    		      lblConfirm.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 15));
	    			  lblConfirm.setAlignment(Pos.TOP_CENTER);
	    			  
	    			  Button btYes = new Button("YES");
	    			  Button btNo = new Button("NO");
	    			  
	    			  hbSet.getChildren().addAll(btYes, btNo);
	    			  vbSet1.getChildren().addAll(lblConfirm, hbSet);
	    			  vbSet1.setSpacing(50);
	    			  hbSet.setSpacing(30);
//Confirm $100 Withdraw from Checking Account   			  
	    			  	btYes.setOnAction(l -> {
	    			  		if(checking.canWithdraw(set)) {
	    			  			checking.withdraw(set);
	    			  			primaryStage.setScene(checkingWithdrawScene);
	    			  		}
	    			  		else {
	    			  			VBox vbLimit = new VBox();
	    			  			VBox vbLimit1 = new VBox();
	    			  			Button btReturn = new Button("Back");
	    			  			Label lblLimit = new Label("Cannot Withdraw");
	    			  			Label lblLimit1 = new Label("Overdraft Limit Reached");
	    			  			lblLimit1.setTextFill(Color.RED);
	    			  			lblLimit.setTextFill(Color.RED);
	    			  			vbLimit.setPadding(new Insets(-120, 20, 10, 10));
	    			  			vbLimit1.setPadding(new Insets(-150, 20, 10, 10));
	    			  			vbLimit.getChildren().add(lblLimit);
	    			  			vbLimit1.getChildren().add(lblLimit1);
	    			  			vbSet1.getChildren().addAll(vbLimit, vbLimit1);
	    			  			hbSet.getChildren().clear();
    			  				hbSet.getChildren().add(btReturn);
//Return to Withdraw Amount Selection   			  				
	    			  			btReturn.setOnAction(m -> {	
	    			  				primaryStage.setScene(checkingWithdrawScene);
	    			  			});
	    			  		}
	    			  	});
//Return to Withdraw Amount Selection
	    			  	btNo.setOnAction(m -> {
	    			  		primaryStage.setScene(checkingWithdrawScene);
	    			  	}); 
	    			  	Scene setScene = new Scene(vbSet1, 200, 100);
	    				  primaryStage.setScene(setScene);
	    		  });
//Return to Checking Account	    		  
	    		  btSetBack.setOnAction(k -> {
		    		  primaryStage.setScene(checkingScene);
		    	  });
//Withdraw Other Amount from Checking Account	    		  
	    		  btSetOther.setOnAction(j -> {
	    			  VBox vbSet1 = new VBox();
	    			  HBox hbSet = new HBox();
	    			  
	    			  Label lblOtherAmount = new Label("Enter Withdraw Amount");
	    			  lblOtherAmount.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 15));
	    			  lblOtherAmount.setAlignment(Pos.TOP_CENTER);
	    			  
	    			  TextField tfOther =  new TextField();
	    			  Button btSubmit = new Button("Submit");
	    			  Button btOtherBack = new Button("Back");
	    			  
	    			  	Scene setScene = new Scene(vbSet1, 250, 100);
	    				  primaryStage.setScene(setScene);
	    				  
//Return to Withdraw Amount Scene	    			  
	    			  btOtherBack.setOnAction(k -> {
			    		  primaryStage.setScene(checkingWithdrawScene);
			    	  });    		
//Go to Confirm Other Amount Scene	    			  
	    			  btSubmit.setOnAction(k -> {
	    				  VBox vbSet2 = new VBox();
	    				  HBox hbSet1 = new HBox();
	    				  Label lblConfirm = new Label("Withdraw $" + tfOther.getText().toString() + " From Account?");
		    		      lblConfirm.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 15));
		    			  lblConfirm.setAlignment(Pos.TOP_CENTER);
		    			  Button btYes = new Button("YES");
		    			  Button btNo = new Button("NO");
		    			  hbSet1.getChildren().addAll(btYes, btNo);
		    			  vbSet2.getChildren().addAll(lblConfirm, hbSet1);
		    			  vbSet2.setSpacing(50);
		    			  hbSet1.setSpacing(30);
		    				Scene setOtherScene = new Scene(vbSet2, 200, 100);
		    				  primaryStage.setScene(setOtherScene);
//Confirm Other Amount Withdraw from Checking Account   			  
		    			  	btYes.setOnAction(l -> {
		    			  		double d = Double.parseDouble(tfOther.getText().toString());
		    			  		if(checking.canWithdraw(d)) {
		    			  			checking.withdraw(d);
		    			  			primaryStage.setScene(checkingWithdrawScene);
		    			  		}
		    			  		else {
		    			  			VBox vbLimit = new VBox();
		    			  			VBox vbLimit1 = new VBox();
		    			  			Button btReturn = new Button("Back");
		    			  			Label lblLimit = new Label("Cannot Withdraw");
		    			  			Label lblLimit1 = new Label("Overdraft Limit Reached");
		    			  			lblLimit1.setTextFill(Color.RED);
		    			  			lblLimit.setTextFill(Color.RED);
		    			  			vbLimit.setPadding(new Insets(-120, 20, 10, 10));
		    			  			vbLimit1.setPadding(new Insets(-150, 20, 10, 10));
		    			  			vbLimit.getChildren().add(lblLimit);
		    			  			vbLimit1.getChildren().add(lblLimit1);
		    			  			vbSet2.getChildren().addAll(vbLimit, vbLimit1);
		    			  			hbSet1.getChildren().clear();
	    			  				hbSet1.getChildren().add(btReturn);
//Return to Withdraw Amount Selection   			  				
		    			  			btReturn.setOnAction(m -> {	
		    			  				tfOther.clear();
		    			  				primaryStage.setScene(setScene);
		    			  			});
		    			  		}
		    			  	});
//Return to Withdraw Amount Selection
		    			  	btNo.setOnAction(m -> {
		    			  		tfOther.clear();
		    			  		primaryStage.setScene(setScene);
		    			  	});  		
	    			  });
	    			  hbSet.getChildren().addAll(btSubmit, btOtherBack);
	    			  vbSet1.getChildren().addAll(lblOtherAmount, tfOther, hbSet);
	    			  tfOther.setMaxWidth(80);
	    			  vbSet1.setSpacing(30);
	    			  hbSet.setPadding(new Insets(-58, 0, 0, 80));
	    			  hbSet.setSpacing(30);
	    			
	    		  });
	    	  });
//Access Checking Deposit
	    	  btDeposit.setOnAction(i -> {
	    		  vbChecking.getChildren().remove(checkingBalance);
	    		  Label lblAmount = new Label("Deposit Amount");
			        lblAmount.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 20));
			        lblAmount.setAlignment(Pos.CENTER);
			        
			        Button btSet20 = new Button("$20");
			        Button btSet50 = new Button("$50");
			        Button btSet80 = new Button("$80");
			        Button btSet100 = new Button("$100");
			        Button btSetOther = new Button("Other");
			        Button btSetBack = new Button("Back");
			        
			        VBox vbSet = new VBox();
			        vbSet.getChildren().addAll(lblAmount, btSet20, btSet50, btSet80, btSet100, btSetOther, btSetBack);
			        vbSet.setSpacing(30);
			        vbSet.setAlignment(Pos.CENTER);
	    		  
	    		  Scene checkingDepositScene = new Scene(vbSet, 300, 400);
	    		  primaryStage.setScene(checkingDepositScene);
//Deposit $20 to Checking Account  		  
	    		  btSet20.setOnAction(j -> {
	    			  VBox vbSet1 = new VBox();
	    			  HBox hbSet = new HBox();
	    			  
	    			  set = 20;
	    			  
	    			  Label lblConfirm = new Label("Deposit $" + set + " To Account?");
	    		      lblConfirm.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 15));
	    			  lblConfirm.setAlignment(Pos.TOP_CENTER);
	    			  
	    			  Button btYes = new Button("YES");
	    			  Button btNo = new Button("NO");
	    			  
	    			  hbSet.getChildren().addAll(btYes, btNo);
	    			  vbSet1.getChildren().addAll(lblConfirm, hbSet);
	    			  vbSet1.setSpacing(50);
	    			  hbSet.setSpacing(30);
//Confirm $20 Deposit to Checking    			  
	    			  	btYes.setOnAction(l -> {
	    			  	checking.deposit(set);
	    			  	primaryStage.setScene(checkingDepositScene);
	    			  	});
//Return to Deposit Amount Selection
	    			  	btNo.setOnAction(m -> {
	    			  		primaryStage.setScene(checkingDepositScene);
	    			  	});  
	    			  	Scene setScene = new Scene(vbSet1, 200, 100);
	    				  primaryStage.setScene(setScene);
	    		  });
//Return to Checking Account	    		  
	    		  btSetBack.setOnAction(k -> {
		    		  primaryStage.setScene(checkingScene);
		    	  });
//Deposit $50 to Checking Account	    		  
	    		  btSet50.setOnAction(j -> {
	    			  VBox vbSet1 = new VBox();
	    			  HBox hbSet = new HBox();
	    			  
	    			  set = 50;
	    			  
	    			  Label lblConfirm = new Label("Deposit $" + set + " To Account?");
	    		      lblConfirm.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 15));
	    			  lblConfirm.setAlignment(Pos.TOP_CENTER);
	    			  
	    			  Button btYes = new Button("YES");
	    			  Button btNo = new Button("NO");
	    			  
	    			  hbSet.getChildren().addAll(btYes, btNo);
	    			  vbSet1.getChildren().addAll(lblConfirm, hbSet);
	    			  vbSet1.setSpacing(50);
	    			  hbSet.setSpacing(30);
//Confirm $50 Deposit to Checking Account   			  
	    			  	btYes.setOnAction(l -> {
	    			  		checking.deposit(set);
	    			  		primaryStage.setScene(checkingDepositScene);
	    			  	});
//Return to Deposit Amount Selection
	    			  	btNo.setOnAction(m -> {
	    			  		primaryStage.setScene(checkingDepositScene);
	    			  	}); 
	    			  	Scene setScene = new Scene(vbSet1, 200, 100);
	    				  primaryStage.setScene(setScene);
	    		  });
//Deposit $80 to Checking Account	    		  
	    		  btSet80.setOnAction(j -> {
	    			  VBox vbSet1 = new VBox();
	    			  HBox hbSet = new HBox();
	    			  
	    			  set = 80;
	    			  
	    			  Label lblConfirm = new Label("Deposit $" + set + " To Account?");
	    		      lblConfirm.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 15));
	    			  lblConfirm.setAlignment(Pos.TOP_CENTER);
	    			  
	    			  Button btYes = new Button("YES");
	    			  Button btNo = new Button("NO");
	    			  
	    			  hbSet.getChildren().addAll(btYes, btNo);
	    			  vbSet1.getChildren().addAll(lblConfirm, hbSet);
	    			  vbSet1.setSpacing(50);
	    			  hbSet.setSpacing(30);
//Confirm $80 Deposit to Checking Account  			  
	    			  	btYes.setOnAction(l -> {
	    			  		checking.deposit(set);
	    			  		primaryStage.setScene(checkingDepositScene);
	    			  	});
//Return to Deposit Amount Selection
	    			  	btNo.setOnAction(m -> {
	    			  		primaryStage.setScene(checkingDepositScene);
	    			  	}); 
	    			  	Scene setScene = new Scene(vbSet1, 200, 100);
	    				  primaryStage.setScene(setScene);
	    		  });
//Deposit $100 to Checking Account	    		  
	    		  btSet100.setOnAction(j -> {
	    			  VBox vbSet1 = new VBox();
	    			  HBox hbSet = new HBox();
	    			  
	    			  set = 100;
	    			  
	    			  Label lblConfirm = new Label("Deposit $" + set + " To Account?");
	    		      lblConfirm.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 15));
	    			  lblConfirm.setAlignment(Pos.TOP_CENTER);
	    			  
	    			  Button btYes = new Button("YES");
	    			  Button btNo = new Button("NO");
	    			  
	    			  hbSet.getChildren().addAll(btYes, btNo);
	    			  vbSet1.getChildren().addAll(lblConfirm, hbSet);
	    			  vbSet1.setSpacing(50);
	    			  hbSet.setSpacing(30);
//Confirm $100 Deposit to Checking Account   			  
	    			  	btYes.setOnAction(l -> {
	    			  		checking.deposit(set);
	    			  		primaryStage.setScene(checkingDepositScene);
	    			  	});
//Return to Deposit Amount Selection
	    			  	btNo.setOnAction(m -> {
	    			  		primaryStage.setScene(checkingDepositScene);
	    			  	}); 
	    			  	Scene setScene = new Scene(vbSet1, 200, 100);
	    				  primaryStage.setScene(setScene);
	    		  });
//Return to Checking Account	    		  
	    		  btSetBack.setOnAction(k -> {
		    		  primaryStage.setScene(checkingScene);
		    	  });
//Deposit Other Amount to Checking Account	    		  
	    		  btSetOther.setOnAction(j -> {
	    			  VBox vbSet1 = new VBox();
	    			  HBox hbSet = new HBox();
	    			  
	    			  Label lblOtherAmount = new Label("Enter Deposit Amount");
	    			  lblOtherAmount.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 15));
	    			  lblOtherAmount.setAlignment(Pos.TOP_CENTER);
	    			  
	    			  TextField tfOther =  new TextField();
	    			  Button btSubmit = new Button("Submit");
	    			  Button btOtherBack = new Button("Back");
	    			  
	    			  	Scene setScene = new Scene(vbSet1, 250, 100);
	    				  primaryStage.setScene(setScene);
	    				  
//Return to Deposit Amount Scene	    			  
	    			  btOtherBack.setOnAction(k -> {
			    		  primaryStage.setScene(checkingDepositScene);
			    	  });    		
//Go to Confirm Other Amount Scene	    			  
	    			  btSubmit.setOnAction(k -> {
	    				  VBox vbSet2 = new VBox();
	    				  HBox hbSet1 = new HBox();
	    				  Label lblConfirm = new Label("Deposit $" + tfOther.getText().toString() + " To Account?");
		    		      lblConfirm.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 15));
		    			  lblConfirm.setAlignment(Pos.TOP_CENTER);
		    			  Button btYes = new Button("YES");
		    			  Button btNo = new Button("NO");
		    			  hbSet1.getChildren().addAll(btYes, btNo);
		    			  vbSet2.getChildren().addAll(lblConfirm, hbSet1);
		    			  vbSet2.setSpacing(50);
		    			  hbSet1.setSpacing(30);
		    				Scene setOtherScene = new Scene(vbSet2, 200, 100);
		    				  primaryStage.setScene(setOtherScene);
//Confirm Other Amount Deposit to Checking Account   			  
		    			  	btYes.setOnAction(l -> {
		    			  		double d = Double.parseDouble(tfOther.getText().toString());
		    			  		checking.deposit(d);
		    			  		primaryStage.setScene(checkingDepositScene);
		    			  	});
//Return to Deposit Amount Selection
		    			  	btNo.setOnAction(m -> {
		    			  		tfOther.clear();
		    			  		primaryStage.setScene(setScene);
		    			  	});  		
	    			  });
	    			  hbSet.getChildren().addAll(btSubmit, btOtherBack);
	    			  vbSet1.getChildren().addAll(lblOtherAmount, tfOther, hbSet);
	    			  tfOther.setMaxWidth(80);
	    			  vbSet1.setSpacing(30);
	    			  hbSet.setPadding(new Insets(-58, 0, 0, 80));
	    			  hbSet.setSpacing(30);
	    			
	    		  });
	    	  });
//Return to Account Choice 	  
	    	  btBack.setOnAction(i -> {
	    		  primaryStage.setScene(choiceScene);
	    	  });
	    	   	  	    	  
	      });

//Access Savings Account
	      btSavings.setOnAction(e -> {
	  	    
	      	  Label lblMain = new Label("Savings Account");
		        lblMain.setFont(Font.font("Times New Roman", FontWeight.BOLD, 28));
		        lblMain.setTextFill(Color.CORAL);
		        lblMain.setAlignment(Pos.CENTER);
		        
		  	  Button btBalance = new Button("Check Balance");
		  	  Button btWithdraw = new Button("Withdraw");
		  	  Button btDeposit = new Button("Deposit");
		  	  Button btBack = new Button("Back");
		  	    
		  	  VBox vbSavings = new VBox();
		  	  
		  	  vbSavings.getChildren().addAll(lblMain, btBalance, btWithdraw, btDeposit, btBack);
		  	  vbSavings.setSpacing(50);
		  	  vbSavings.setAlignment(Pos.CENTER);

	    	  Scene savingsScene = new Scene(vbSavings, 300, 400);
	    	  primaryStage.setScene(savingsScene);
//Access Savings Balance
	    	  btBalance.setOnAction(i -> {
	    		  vbSavings.getChildren().remove(savingsBalance);
	    		  savingsBalance = new Label(savings.toString());
	    		  vbSavings.getChildren().add(savingsBalance);
	    		  if(savings.getBalance() > 0) {
	    			  savingsBalance.setTextFill(Color.GREEN);
	    		  }
	    	  });
//Access Savings Withdraw
	    	  btWithdraw.setOnAction(i -> {
	    		  vbSavings.getChildren().remove(savingsBalance);
	    		  Label lblAmount = new Label("Withdraw Amount");
			        lblAmount.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 20));
			        lblAmount.setAlignment(Pos.CENTER);
			        
			        Button btSet20 = new Button("$20");
			        Button btSet50 = new Button("$50");
			        Button btSet80 = new Button("$80");
			        Button btSet100 = new Button("$100");
			        Button btSetOther = new Button("Other");
			        Button btSetBack = new Button("Back");
			        
			        VBox vbSet = new VBox();
			        vbSet.getChildren().addAll(lblAmount, btSet20, btSet50, btSet80, btSet100, btSetOther, btSetBack);
			        vbSet.setSpacing(30);
			        vbSet.setAlignment(Pos.CENTER);
	    		  
	    		  Scene savingsWithdrawScene = new Scene(vbSet, 300, 400);
	    		  primaryStage.setScene(savingsWithdrawScene);
//Withdraw $20 from Savings Account  		  
	    		  btSet20.setOnAction(j -> {
	    			  VBox vbSet1 = new VBox();
	    			  HBox hbSet = new HBox();
	    			  
	    			  set = 20;
	    			  
	    			  Label lblConfirm = new Label("Withdraw $" + set + " From Account?");
	    		      lblConfirm.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 15));
	    			  lblConfirm.setAlignment(Pos.TOP_CENTER);
	    			  
	    			  Button btYes = new Button("YES");
	    			  Button btNo = new Button("NO");
	    			  
	    			  hbSet.getChildren().addAll(btYes, btNo);
	    			  vbSet1.getChildren().addAll(lblConfirm, hbSet);
	    			  vbSet1.setSpacing(50);
	    			  hbSet.setSpacing(30);
//Confirm $20 Withdraw from Savings    			  
	    			  	btYes.setOnAction(l -> {
	    			  		if(savings.canWithdraw(set)) {
	    			  			savings.withdraw(set);
	    			  			primaryStage.setScene(savingsWithdrawScene);
	    			  		}
	    			  		else {
	    			  			VBox vbLimit = new VBox();
	    			  			VBox vbLimit1 = new VBox();
	    			  			Button btReturn = new Button("Back");
	    			  			Label lblLimit = new Label("Cannot Withdraw");
	    			  			Label lblLimit1 = new Label("Cannot Overdraft Account");
	    			  			lblLimit1.setTextFill(Color.RED);
	    			  			lblLimit.setTextFill(Color.RED);
	    			  			vbLimit.setPadding(new Insets(-120, 20, 10, 10));
	    			  			vbLimit1.setPadding(new Insets(-150, 20, 10, 10));
	    			  			vbLimit.getChildren().add(lblLimit);
	    			  			vbLimit1.getChildren().add(lblLimit1);
	    			  			vbSet1.getChildren().addAll(vbLimit, vbLimit1);
	    			  			hbSet.getChildren().clear();
    			  				hbSet.getChildren().add(btReturn);
//Return to Withdraw Amount Selection   			  				
	    			  			btReturn.setOnAction(m -> {	
	    			  				primaryStage.setScene(savingsWithdrawScene);
	    			  			});
	    			  		}
	    			  	});
//Return to Withdraw Amount Selection
	    			  	btNo.setOnAction(m -> {
	    			  		primaryStage.setScene(savingsWithdrawScene);
	    			  	});  
	    			  	Scene setScene = new Scene(vbSet1, 200, 100);
	    				  primaryStage.setScene(setScene);
	    		  });
//Return to Savings Account	    		  
	    		  btSetBack.setOnAction(k -> {
		    		  primaryStage.setScene(savingsScene);
		    	  });
//Withdraw $50 from Savings Account	    		  
	    		  btSet50.setOnAction(j -> {
	    			  VBox vbSet1 = new VBox();
	    			  HBox hbSet = new HBox();
	    			  
	    			  set = 50;
	    			  
	    			  Label lblConfirm = new Label("Withdraw $" + set + " From Account?");
	    		      lblConfirm.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 15));
	    			  lblConfirm.setAlignment(Pos.TOP_CENTER);
	    			  
	    			  Button btYes = new Button("YES");
	    			  Button btNo = new Button("NO");
	    			  
	    			  hbSet.getChildren().addAll(btYes, btNo);
	    			  vbSet1.getChildren().addAll(lblConfirm, hbSet);
	    			  vbSet1.setSpacing(50);
	    			  hbSet.setSpacing(30);
//Confirm $50 Withdraw from Savings Account   			  
	    			  	btYes.setOnAction(l -> {
	    			  		if(savings.canWithdraw(set)) {
	    			  			savings.withdraw(set);
	    			  			primaryStage.setScene(savingsWithdrawScene);
	    			  		}
	    			  		else {
	    			  			VBox vbLimit = new VBox();
	    			  			VBox vbLimit1 = new VBox();
	    			  			Button btReturn = new Button("Back");
	    			  			Label lblLimit = new Label("Cannot Withdraw");
	    			  			Label lblLimit1 = new Label("Cannot Overdraft Account");
	    			  			lblLimit1.setTextFill(Color.RED);
	    			  			lblLimit.setTextFill(Color.RED);
	    			  			vbLimit.setPadding(new Insets(-120, 20, 10, 10));
	    			  			vbLimit1.setPadding(new Insets(-150, 20, 10, 10));
	    			  			vbLimit.getChildren().add(lblLimit);
	    			  			vbLimit1.getChildren().add(lblLimit1);
	    			  			vbSet1.getChildren().addAll(vbLimit, vbLimit1);
	    			  			hbSet.getChildren().clear();
    			  				hbSet.getChildren().add(btReturn);
//Return to Withdraw Amount Selection   			  				
	    			  			btReturn.setOnAction(m -> {	
	    			  				primaryStage.setScene(savingsWithdrawScene);
	    			  			});
	    			  		}
	    			  	});
//Return to Withdraw Amount Selection
	    			  	btNo.setOnAction(m -> {
	    			  		primaryStage.setScene(savingsWithdrawScene);
	    			  	}); 
	    			  	Scene setScene = new Scene(vbSet1, 200, 100);
	    				  primaryStage.setScene(setScene);
	    		  });
//Withdraw $80 from Savings Account	    		  
	    		  btSet80.setOnAction(j -> {
	    			  VBox vbSet1 = new VBox();
	    			  HBox hbSet = new HBox();
	    			  
	    			  set = 80;
	    			  
	    			  Label lblConfirm = new Label("Withdraw $" + set + " From Account?");
	    		      lblConfirm.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 15));
	    			  lblConfirm.setAlignment(Pos.TOP_CENTER);
	    			  
	    			  Button btYes = new Button("YES");
	    			  Button btNo = new Button("NO");
	    			  
	    			  hbSet.getChildren().addAll(btYes, btNo);
	    			  vbSet1.getChildren().addAll(lblConfirm, hbSet);
	    			  vbSet1.setSpacing(50);
	    			  hbSet.setSpacing(30);
//Confirm $80 Withdraw from Savings Account  			  
	    			  	btYes.setOnAction(l -> {
	    			  		if(savings.canWithdraw(set)) {
	    			  			savings.withdraw(set);
	    			  			primaryStage.setScene(savingsWithdrawScene);
	    			  		}
	    			  		else {
	    			  			VBox vbLimit = new VBox();
	    			  			VBox vbLimit1 = new VBox();
	    			  			Button btReturn = new Button("Back");
	    			  			Label lblLimit = new Label("Cannot Withdraw");
	    			  			Label lblLimit1 = new Label("Cannot Overdraft Account");
	    			  			lblLimit1.setTextFill(Color.RED);
	    			  			lblLimit.setTextFill(Color.RED);
	    			  			vbLimit.setPadding(new Insets(-120, 20, 10, 10));
	    			  			vbLimit1.setPadding(new Insets(-150, 20, 10, 10));
	    			  			vbLimit.getChildren().add(lblLimit);
	    			  			vbLimit1.getChildren().add(lblLimit1);
	    			  			vbSet1.getChildren().addAll(vbLimit, vbLimit1);
	    			  			hbSet.getChildren().clear();
    			  				hbSet.getChildren().add(btReturn);
//Return to Withdraw Amount Selection   			  				
	    			  			btReturn.setOnAction(m -> {	
	    			  				primaryStage.setScene(savingsWithdrawScene);
	    			  			});
	    			  		}
	    			  	});
//Return to Withdraw Amount Selection
	    			  	btNo.setOnAction(m -> {
	    			  		primaryStage.setScene(savingsWithdrawScene);
	    			  	}); 
	    			  	Scene setScene = new Scene(vbSet1, 200, 100);
	    				  primaryStage.setScene(setScene);
	    		  });
//Withdraw $100 from Savings Account	    		  
	    		  btSet100.setOnAction(j -> {
	    			  VBox vbSet1 = new VBox();
	    			  HBox hbSet = new HBox();
	    			  
	    			  set = 100;
	    			  
	    			  Label lblConfirm = new Label("Withdraw $" + set + " From Account?");
	    		      lblConfirm.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 15));
	    			  lblConfirm.setAlignment(Pos.TOP_CENTER);
	    			  
	    			  Button btYes = new Button("YES");
	    			  Button btNo = new Button("NO");
	    			  
	    			  hbSet.getChildren().addAll(btYes, btNo);
	    			  vbSet1.getChildren().addAll(lblConfirm, hbSet);
	    			  vbSet1.setSpacing(50);
	    			  hbSet.setSpacing(30);
//Confirm $100 Withdraw from Savings Account   			  
	    			  	btYes.setOnAction(l -> {
	    			  		if(savings.canWithdraw(set)) {
	    			  			savings.withdraw(set);
	    			  			primaryStage.setScene(savingsWithdrawScene);
	    			  		}
	    			  		else {
	    			  			VBox vbLimit = new VBox();
	    			  			VBox vbLimit1 = new VBox();
	    			  			Button btReturn = new Button("Back");
	    			  			Label lblLimit = new Label("Cannot Withdraw");
	    			  			Label lblLimit1 = new Label("Cannot Overdraft Account");
	    			  			lblLimit1.setTextFill(Color.RED);
	    			  			lblLimit.setTextFill(Color.RED);
	    			  			vbLimit.setPadding(new Insets(-120, 20, 10, 10));
	    			  			vbLimit1.setPadding(new Insets(-150, 20, 10, 10));
	    			  			vbLimit.getChildren().add(lblLimit);
	    			  			vbLimit1.getChildren().add(lblLimit1);
	    			  			vbSet1.getChildren().addAll(vbLimit, vbLimit1);
	    			  			hbSet.getChildren().clear();
    			  				hbSet.getChildren().add(btReturn);
//Return to Withdraw Amount Selection   			  				
	    			  			btReturn.setOnAction(m -> {	
	    			  				primaryStage.setScene(savingsWithdrawScene);
	    			  			});
	    			  		}
	    			  	});
//Return to Withdraw Amount Selection
	    			  	btNo.setOnAction(m -> {
	    			  		primaryStage.setScene(savingsWithdrawScene);
	    			  	}); 
	    			  	Scene setScene = new Scene(vbSet1, 200, 100);
	    				  primaryStage.setScene(setScene);
	    		  });
//Return to Savings Account	    		  
	    		  btSetBack.setOnAction(k -> {
		    		  primaryStage.setScene(savingsScene);
		    	  });
//Withdraw Other Amount from Savings Account	    		  
	    		  btSetOther.setOnAction(j -> {
	    			  VBox vbSet1 = new VBox();
	    			  HBox hbSet = new HBox();
	    			  
	    			  Label lblOtherAmount = new Label("Enter Withdraw Amount");
	    			  lblOtherAmount.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 15));
	    			  lblOtherAmount.setAlignment(Pos.TOP_CENTER);
	    			  
	    			  TextField tfOther =  new TextField();
	    			  Button btSubmit = new Button("Submit");
	    			  Button btOtherBack = new Button("Back");
	    			  
	    			  	Scene setScene = new Scene(vbSet1, 250, 100);
	    				  primaryStage.setScene(setScene);
	    				  
//Return to Withdraw Amount Scene	    			  
	    			  btOtherBack.setOnAction(k -> {
			    		  primaryStage.setScene(savingsWithdrawScene);
			    	  });    		
//Go to Confirm Other Amount Scene	    			  
	    			  btSubmit.setOnAction(k -> {
	    				  VBox vbSet2 = new VBox();
	    				  HBox hbSet1 = new HBox();
	    				  Label lblConfirm = new Label("Withdraw $" + tfOther.getText().toString() + " From Account?");
		    		      lblConfirm.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 15));
		    			  lblConfirm.setAlignment(Pos.TOP_CENTER);
		    			  Button btYes = new Button("YES");
		    			  Button btNo = new Button("NO");
		    			  hbSet1.getChildren().addAll(btYes, btNo);
		    			  vbSet2.getChildren().addAll(lblConfirm, hbSet1);
		    			  vbSet2.setSpacing(50);
		    			  hbSet1.setSpacing(30);
		    				Scene setOtherScene = new Scene(vbSet2, 200, 100);
		    				  primaryStage.setScene(setOtherScene);
//Confirm Other Amount Withdraw from Savings Account   			  
		    			  	btYes.setOnAction(l -> {
		    			  		double d = Double.parseDouble(tfOther.getText().toString());
		    			  		if(savings.canWithdraw(d)) {
		    			  			savings.withdraw(d);
		    			  			primaryStage.setScene(savingsWithdrawScene);
		    			  		}
		    			  		else {
		    			  			VBox vbLimit = new VBox();
		    			  			VBox vbLimit1 = new VBox();
		    			  			Button btReturn = new Button("Back");
		    			  			Label lblLimit = new Label("Cannot Withdraw");
		    			  			Label lblLimit1 = new Label("Cannot Overdraft Account");
		    			  			lblLimit1.setTextFill(Color.RED);
		    			  			lblLimit.setTextFill(Color.RED);
		    			  			vbLimit.setPadding(new Insets(-120, 20, 10, 10));
		    			  			vbLimit1.setPadding(new Insets(-150, 20, 10, 10));
		    			  			vbLimit.getChildren().add(lblLimit);
		    			  			vbLimit1.getChildren().add(lblLimit1);
		    			  			vbSet2.getChildren().addAll(vbLimit, vbLimit1);
		    			  			hbSet1.getChildren().clear();
	    			  				hbSet1.getChildren().add(btReturn);
//Return to Withdraw Amount Selection   			  				
		    			  			btReturn.setOnAction(m -> {	
		    			  				tfOther.clear();
		    			  				primaryStage.setScene(setScene);
		    			  			});
		    			  		}
		    			  	});
//Return to Withdraw Amount Selection
		    			  	btNo.setOnAction(m -> {
		    			  		tfOther.clear();
		    			  		primaryStage.setScene(setScene);
		    			  	});  		
	    			  });
	    			  hbSet.getChildren().addAll(btSubmit, btOtherBack);
	    			  vbSet1.getChildren().addAll(lblOtherAmount, tfOther, hbSet);
	    			  tfOther.setMaxWidth(80);
	    			  vbSet1.setSpacing(30);
	    			  hbSet.setPadding(new Insets(-58, 0, 0, 80));
	    			  hbSet.setSpacing(30);
	    			
	    		  });
	    	  });
//Access Savings Deposit
	    	  btDeposit.setOnAction(i -> {
	    		  vbSavings.getChildren().remove(savingsBalance);
	    		  Label lblAmount = new Label("Deposit Amount");
			        lblAmount.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 20));
			        lblAmount.setAlignment(Pos.CENTER);
			        
			        Button btSet20 = new Button("$20");
			        Button btSet50 = new Button("$50");
			        Button btSet80 = new Button("$80");
			        Button btSet100 = new Button("$100");
			        Button btSetOther = new Button("Other");
			        Button btSetBack = new Button("Back");
			        
			        VBox vbSet = new VBox();
			        vbSet.getChildren().addAll(lblAmount, btSet20, btSet50, btSet80, btSet100, btSetOther, btSetBack);
			        vbSet.setSpacing(30);
			        vbSet.setAlignment(Pos.CENTER);
	    		  
	    		  Scene savingsDepositScene = new Scene(vbSet, 300, 400);
	    		  primaryStage.setScene(savingsDepositScene);
//Deposit $20 to Savings Account  		  
	    		  btSet20.setOnAction(j -> {
	    			  VBox vbSet1 = new VBox();
	    			  HBox hbSet = new HBox();
	    			  
	    			  set = 20;
	    			  
	    			  Label lblConfirm = new Label("Deposit $" + set + " To Account?");
	    		      lblConfirm.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 15));
	    			  lblConfirm.setAlignment(Pos.TOP_CENTER);
	    			  
	    			  Button btYes = new Button("YES");
	    			  Button btNo = new Button("NO");
	    			  
	    			  hbSet.getChildren().addAll(btYes, btNo);
	    			  vbSet1.getChildren().addAll(lblConfirm, hbSet);
	    			  vbSet1.setSpacing(50);
	    			  hbSet.setSpacing(30);
//Confirm $20 Deposit to Savings    			  
	    			  	btYes.setOnAction(l -> {
	    			  	savings.deposit(set);
	    			  	primaryStage.setScene(savingsDepositScene);
	    			  	});
//Return to Deposit Amount Selection
	    			  	btNo.setOnAction(m -> {
	    			  		primaryStage.setScene(savingsDepositScene);
	    			  	});  
	    			  	Scene setScene = new Scene(vbSet1, 200, 100);
	    				  primaryStage.setScene(setScene);
	    		  });
//Return to Savings Account	    		  
	    		  btSetBack.setOnAction(k -> {
		    		  primaryStage.setScene(savingsScene);
		    	  });
//Deposit $50 to Savings Account	    		  
	    		  btSet50.setOnAction(j -> {
	    			  VBox vbSet1 = new VBox();
	    			  HBox hbSet = new HBox();
	    			  
	    			  set = 50;
	    			  
	    			  Label lblConfirm = new Label("Deposit $" + set + " To Account?");
	    		      lblConfirm.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 15));
	    			  lblConfirm.setAlignment(Pos.TOP_CENTER);
	    			  
	    			  Button btYes = new Button("YES");
	    			  Button btNo = new Button("NO");
	    			  
	    			  hbSet.getChildren().addAll(btYes, btNo);
	    			  vbSet1.getChildren().addAll(lblConfirm, hbSet);
	    			  vbSet1.setSpacing(50);
	    			  hbSet.setSpacing(30);
//Confirm $50 Deposit to Savings Account   			  
	    			  	btYes.setOnAction(l -> {
	    			  		savings.deposit(set);
	    			  		primaryStage.setScene(savingsDepositScene);
	    			  	});
//Return to Deposit Amount Selection
	    			  	btNo.setOnAction(m -> {
	    			  		primaryStage.setScene(savingsDepositScene);
	    			  	}); 
	    			  	Scene setScene = new Scene(vbSet1, 200, 100);
	    				  primaryStage.setScene(setScene);
	    		  });
//Deposit $80 to Savings Account	    		  
	    		  btSet80.setOnAction(j -> {
	    			  VBox vbSet1 = new VBox();
	    			  HBox hbSet = new HBox();
	    			  
	    			  set = 80;
	    			  
	    			  Label lblConfirm = new Label("Deposit $" + set + " To Account?");
	    		      lblConfirm.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 15));
	    			  lblConfirm.setAlignment(Pos.TOP_CENTER);
	    			  
	    			  Button btYes = new Button("YES");
	    			  Button btNo = new Button("NO");
	    			  
	    			  hbSet.getChildren().addAll(btYes, btNo);
	    			  vbSet1.getChildren().addAll(lblConfirm, hbSet);
	    			  vbSet1.setSpacing(50);
	    			  hbSet.setSpacing(30);
//Confirm $80 Deposit to Savings Account  			  
	    			  	btYes.setOnAction(l -> {
	    			  		savings.deposit(set);
	    			  		primaryStage.setScene(savingsDepositScene);
	    			  	});
//Return to Deposit Amount Selection
	    			  	btNo.setOnAction(m -> {
	    			  		primaryStage.setScene(savingsDepositScene);
	    			  	}); 
	    			  	Scene setScene = new Scene(vbSet1, 200, 100);
	    				  primaryStage.setScene(setScene);
	    		  });
//Deposit $100 to Savings Account	    		  
	    		  btSet100.setOnAction(j -> {
	    			  VBox vbSet1 = new VBox();
	    			  HBox hbSet = new HBox();
	    			  
	    			  set = 100;
	    			  
	    			  Label lblConfirm = new Label("Deposit $" + set + " To Account?");
	    		      lblConfirm.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 15));
	    			  lblConfirm.setAlignment(Pos.TOP_CENTER);
	    			  
	    			  Button btYes = new Button("YES");
	    			  Button btNo = new Button("NO");
	    			  
	    			  hbSet.getChildren().addAll(btYes, btNo);
	    			  vbSet1.getChildren().addAll(lblConfirm, hbSet);
	    			  vbSet1.setSpacing(50);
	    			  hbSet.setSpacing(30);
//Confirm $100 Deposit to Savings Account   			  
	    			  	btYes.setOnAction(l -> {
	    			  		savings.deposit(set);
	    			  		primaryStage.setScene(savingsDepositScene);
	    			  	});
//Return to Deposit Amount Selection
	    			  	btNo.setOnAction(m -> {
	    			  		primaryStage.setScene(savingsDepositScene);
	    			  	}); 
	    			  	Scene setScene = new Scene(vbSet1, 200, 100);
	    				  primaryStage.setScene(setScene);
	    		  });
//Return to Savings Account	    		  
	    		  btSetBack.setOnAction(k -> {
		    		  primaryStage.setScene(savingsScene);
		    	  });
//Deposit Other Amount to Savings Account	    		  
	    		  btSetOther.setOnAction(j -> {
	    			  VBox vbSet1 = new VBox();
	    			  HBox hbSet = new HBox();
	    			  
	    			  Label lblOtherAmount = new Label("Enter Deposit Amount");
	    			  lblOtherAmount.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 15));
	    			  lblOtherAmount.setAlignment(Pos.TOP_CENTER);
	    			  
	    			  TextField tfOther =  new TextField();
	    			  Button btSubmit = new Button("Submit");
	    			  Button btOtherBack = new Button("Back");
	    			  
	    			  	Scene setScene = new Scene(vbSet1, 250, 100);
	    				  primaryStage.setScene(setScene);
	    				  
//Return to Deposit Amount Scene	    			  
	    			  btOtherBack.setOnAction(k -> {
			    		  primaryStage.setScene(savingsDepositScene);
			    	  });    		
//Go to Confirm Other Amount Scene	    			  
	    			  btSubmit.setOnAction(k -> {
	    				  VBox vbSet2 = new VBox();
	    				  HBox hbSet1 = new HBox();
	    				  Label lblConfirm = new Label("Deposit $" + tfOther.getText().toString() + " To Account?");
		    		      lblConfirm.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 15));
		    			  lblConfirm.setAlignment(Pos.TOP_CENTER);
		    			  Button btYes = new Button("YES");
		    			  Button btNo = new Button("NO");
		    			  hbSet1.getChildren().addAll(btYes, btNo);
		    			  vbSet2.getChildren().addAll(lblConfirm, hbSet1);
		    			  vbSet2.setSpacing(50);
		    			  hbSet1.setSpacing(30);
		    				Scene setOtherScene = new Scene(vbSet2, 200, 100);
		    				  primaryStage.setScene(setOtherScene);
//Confirm Other Amount Deposit to Savings Account   			  
		    			  	btYes.setOnAction(l -> {
		    			  		double d = Double.parseDouble(tfOther.getText().toString());
		    			  		savings.deposit(d);
		    			  		primaryStage.setScene(savingsDepositScene);
		    			  	});
//Return to Deposit Amount Selection
		    			  	btNo.setOnAction(m -> {
		    			  		tfOther.clear();
		    			  		primaryStage.setScene(setScene);
		    			  	});  		
	    			  });
	    			  hbSet.getChildren().addAll(btSubmit, btOtherBack);
	    			  vbSet1.getChildren().addAll(lblOtherAmount, tfOther, hbSet);
	    			  tfOther.setMaxWidth(80);
	    			  vbSet1.setSpacing(30);
	    			  hbSet.setPadding(new Insets(-58, 0, 0, 80));
	    			  hbSet.setSpacing(30);
	    			
	    		  });
	    	  });
//Return to Account Choice 	  
	    	  btBack.setOnAction(i -> {
	    		  primaryStage.setScene(choiceScene);
	    	  }); 	  	    	  
	      }); 
//Go to Transfer Scene	      
	      btTransfer.setOnAction(e -> {
	    	  GridPane gpTrans = new GridPane();
	    	  Label lblTransAmount = new Label("Transfer Amount 	 $");
	    	  lblTransAmount.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 15));
	    	  TextField tfTransAmount = new TextField();
	    	  Label lblFrom = new Label("From");
	    	  lblFrom.setFont(Font.font("Times New Roman", FontPosture.ITALIC, 28));
	    	  Label lblEmpty = new Label("Please Choose Transfer Selection");
	    	  Label lblEmptyAmt = new Label("Please Enter Transfer Amount");
	    	  lblEmpty.setTextFill(Color.RED);
	    	  lblEmptyAmt.setTextFill(Color.RED);
	    	  ComboBox cmboFrom = new ComboBox();
	    	  ComboBox cmboTo = new ComboBox();
	    	  cmboFrom.getItems().addAll("Checking", "Savings");
	    	  cmboTo.getItems().addAll("Checking", "Savings");
	    	  
	    	  Label lblTo = new Label("To");
	    	  lblTo.setFont(Font.font("Times New Roman", FontPosture.ITALIC, 28));
	    	  HBox hbTrans1 = new HBox();
	    	  Button btTransConfirm = new Button("Confirm");
	    	  Button btBack = new Button("Back");
	    	  hbTrans1.getChildren().addAll(btTransConfirm, btBack);
	    	  hbTrans1.setSpacing(5);
	    		 
	    	  gpTrans.add(lblTransAmount, 0, 9);
	    	  gpTrans.add(tfTransAmount, 2, 9);
	    	  gpTrans.add(lblFrom, 0, 0);
	    	  gpTrans.add(cmboFrom , 0, 1);
	    	  gpTrans.add(cmboTo , 2, 1);
	    	  gpTrans.add(lblTo, 2, 0);
	    	  gpTrans.add(hbTrans1, 2, 13);
	    	  gpTrans.setHgap(5);
	    	  gpTrans.setVgap(5);    	
	    		 
	    	  cmboFrom.setOnAction(i ->{
	    		  gpTrans.getChildren().remove(lblEmpty);
	    		if(cmboFrom.getValue() == "Checking") {
	    			cmboTo.setValue("Savings");
	    		}
	    		else if(cmboFrom.getValue() == "Savings") {
	    			cmboTo.setValue("Checking");
	    		}
	    		else {
	    			cmboTo.setValue(null);
	    		}
	    	  });
	    	  cmboTo.setOnAction(i ->{
	    		  gpTrans.getChildren().remove(lblEmpty);
		    		if(cmboTo.getValue() == "Checking") {
		    			cmboFrom.setValue("Savings");
		    		}
		    		else if(cmboTo.getValue() == "Savings") {
		    			cmboFrom.setValue("Checking");
		    		}
		    		else {
		    			cmboFrom.setValue(null);
		    		}
		    	  });
	    	  
	    	  Scene transferScene = new Scene(gpTrans, 360, 190);
	    	  primaryStage.setScene(transferScene);
	    	  primaryStage.show();
//Confirm Transfer Amount to Account	    	  
	    	  btTransConfirm.setOnAction(j -> {
	    		 GridPane gpConfirm = new GridPane();
	    		 HBox hbTrans = new HBox();
	    		 Label lblAmountConfirm = new Label("Transfer " + "$" + tfTransAmount.getText().toString() + " From " + cmboFrom.getValue() + " To " + cmboTo.getValue() + "?");
	    		 lblAmountConfirm.setFont(Font.font("Times New Roman", FontWeight.MEDIUM, 15));
	    		 Button btYes = new Button("YES");
	    		 Button btNo = new Button("NO");
	    		 
	    		 hbTrans.getChildren().addAll(btYes, btNo);
	    		 hbTrans.setSpacing(15);
	    		 
	    		 gpConfirm.add(lblAmountConfirm, 1, 0);
	    		 gpConfirm.add(hbTrans, 1, 1);
	    		 gpConfirm.setHgap(5);
		    	 gpConfirm.setVgap(5);
//Transfer Amount to Account			     
	    		 btYes.setOnAction(i -> {
	    			 double d = Double.parseDouble(tfTransAmount.getText().toString());
	    			  if(cmboFrom.getValue() == "Checking") {
	    				  if(checking.canWithdraw(d) && checking.getBalance() > 0 && d <= checking.getBalance()) {
	    					checking.withdraw(d);
	  	  			  		savings.deposit(d);
	  	  			  		primaryStage.setScene(choiceScene);
	    				  }
	    				  else {
	    						Button btReturn = new Button("Back");
	    			  			Label lblLimit = new Label("Cannot Withdraw From Checking. Amount Exceeds Balance");
	    			  			Label lblBalance = new Label("Account balance: $" + checking.getBalance());
	    			  			if(checking.getBalance() < 0) {
	    			  				lblBalance.setTextFill(Color.RED);
	    			  			}
	    			  			else if(checking.getBalance() > 0) {
	    			  				lblBalance.setTextFill(Color.GREEN);
	    			  			}
	    			  			lblLimit.setTextFill(Color.RED);
	    			  			gpConfirm.getChildren().remove(lblAmountConfirm);
	    			  			gpConfirm.getChildren().remove(hbTrans);
	    			  			gpConfirm.add(lblLimit, 1, 0);
	    			  			gpConfirm.add(lblBalance, 1, 1);
	    			  			gpConfirm.add(btReturn, 1, 2);	    			  			
//Return to Transfer Scene 			  				
	    			  			btReturn.setOnAction(m -> {	
	    			  				primaryStage.setScene(transferScene);
	    			  			});	    					  
	    				  }
	    			  }	    		  
	    		  	  if(cmboFrom.getValue() == "Savings") {  			  		
		  			  		if(savings.canWithdraw(d)){
		  			  		 savings.withdraw(d);
		  			  	     checking.deposit(d);
		  			  	     primaryStage.setScene(choiceScene);
		  			  		}
		  			  		else {
    			  			Button btReturn = new Button("Back");
    			  			Label lblLimit = new Label("Cannot Withdraw From Savings. Amount Exceeds Balance");
    			  			Label lblBalance = new Label("Account balance: $" + savings.getBalance());
    			  			if(savings.getBalance() > 0) {
    			  				lblBalance.setTextFill(Color.GREEN);
    			  			}
    			  			lblLimit.setTextFill(Color.RED);
    			  			gpConfirm.getChildren().remove(lblAmountConfirm);
    			  			gpConfirm.getChildren().remove(hbTrans);
    			  			gpConfirm.add(lblLimit, 1, 0);
    			  			gpConfirm.add(lblBalance, 1, 1);
    			  			gpConfirm.add(btReturn, 1, 2);  		
//Return to Transfer Scene  			  				
    			  			btReturn.setOnAction(m -> {	
    			  				primaryStage.setScene(transferScene);
    			  			});	  			  			
		  			  		}
		    		  }
	    		 });
//Return to Transfer Scene
	    		 btNo.setOnAction(k -> {
	    			 primaryStage.setScene(transferScene);
	    		 });    		
	    		 if(cmboFrom.getValue() == null || tfTransAmount.getText().trim().isEmpty()) {
	    		  if(cmboFrom.getValue() == null || cmboTo.getValue() == null) {
			  		  gpTrans.add(lblEmpty, 0, 4);
			  	  }
	    		  else if(tfTransAmount.getText().trim().isEmpty()) {
	    			  gpTrans.add(lblEmptyAmt, 0, 5);
	    		  }	 
	    		  tfTransAmount.setOnMouseClicked(i -> {
		    	  		 gpTrans.getChildren().remove(lblEmptyAmt); 
		    		 });
	    		 }
	    		 else {	 
		    		  Scene transferSceneConfirm = new Scene(gpConfirm, 330, 70);
		    		  primaryStage.setScene(transferSceneConfirm);	  
		    		  }
	    	  });
	    	  btBack.setOnAction(j -> {
	    		 primaryStage.setScene(choiceScene); 
	    	  });   	  	    	  
	      });
	    }		  
}