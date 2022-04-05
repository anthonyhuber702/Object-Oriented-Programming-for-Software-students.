package dsandalgs;

import java.util.*;

public class Exercise08_37 {
  public static void main(String[] args) {
	  String[][] stateCapital = {
		      {"Alabama", "Montgomery"},
		      {"Alaska", "Juneau"},
		      {"Arizona", "Phoenix"},
		      {"Arkansas", "Little Rock"},
		      {"California", "Sacramento"},
		      {"Colorado", "Denver"},
		      {"Connecticut", "Hartford"},
		      {"Delaware", "Dover"},
		      {"Florida", "Tallahassee"},
		      {"Georgia", "Atlanta"},
		      {"Hawaii", "Honolulu"},
		      {"Idaho", "Boise"},
		      {"Illinois", "Springfield"},
		      {"Indiana", "Indianapolis"},
		      {"Iowa", "Des Moines"},
		      {"Kansas", "Topeka"},
		      {"Kentucky", "Frankfort"},
		      {"Louisiana", "Baton Rouge"},
		      {"Maine", "Augusta"},
		      {"Maryland", "Annapolis"},
		      {"Massachusettes", "Boston"},
		      {"Michigan", "Lansing"},
		      {"Minnesota", "Saint Paul"},
		      {"Mississippi", "Jackson"},
		      {"Missouri", "Jefferson City"},
		      {"Montana", "Helena"},
		      {"Nebraska", "Lincoln"},
		      {"Nevada", "Carson City"},
		      {"New Hampshire", "Concord"},
		      {"New Jersey", "Trenton"},
		      {"New York", "Albany"},
		      {"New Mexico", "Santa Fe"},
		      {"North Carolina", "Raleigh"},
		      {"North Dakota", "Bismarck"},
		      {"Ohio", "Columbus"},
		      {"Oklahoma", "Oklahoma City"},
		      {"Oregon", "Salem"},
		      {"Pennsylvania", "Harrisburg"},
		      {"Rhode Island", "Providence"},
		      {"South Carolina", "Columbia"},
		      {"South Dakota", "Pierre"},
		      {"Tennessee", "Nashville"},
		      {"Texas", "Austin"},
		      {"Utah", "Salt Lake City"},
		      {"Vermont", "Montpelier"},
		      {"Virginia", "Richmond"},
		      {"Washington", "Olympia"},
		      {"West Virginia", "Charleston"},
		      {"Wisconsin", "Madison"},
		      {"Wyoming", "Cheyenne"}
		    };
	  
	  Map<String, String> map = new HashMap<>();
	  map.put("Alabama", "Montgomery");
	  map.put("Alaska", "Juneau");
	  map.put("Arizona", "Phoenix");
	  map.put("Arkansas", "Little Rock");
	  map.put("California", "Sacramento");
	  map.put("Colorado", "Denver");
	  map.put("Connecticut", "Hartford");
	  map.put("Delaware", "Dover");
	  map.put("Florida", "Tallahassee");
	  map.put("Georgia", "Atlanta");
	  map.put("Hawaii", "Honolulu");
	  map.put("Idaho", "Boise");
	  map.put("Illinois", "Springfield");
	  map.put("Indiana", "Indianapolis");
	  map.put("Iowa", "Des Moines");
	  map.put("Kansas", "Topeka");
	  map.put("Kentucky", "Frankfort");
	  map.put("Louisiana", "Baton Rouge");
	  map.put("Maine", "Augusta");
	  map.put("Maryland", "Annapolis");
	  map.put("Massachusettes", "Boston");
	  map.put("Michigan", "Lansing");
	  map.put("Minnesota", "Saint Paul");
	  map.put("Mississippi", "Jackson");
	  map.put("Missouri", "Jefferson City");
	  map.put("Montana", "Helena");
	  map.put("Nebraska", "Lincoln");
	  map.put("Nevada", "Carson City");
	  map.put("New Hampshire", "Concord");
	  map.put("New Jersey", "Trenton");
	  map.put("New York", "Albany");
	  map.put("New Mexico", "Santa Fe");
	  map.put("North Carolina", "Raleigh");
	  map.put("North Dakota", "Bismarck");
	  map.put("Ohio", "Columbus");
	  map.put("Oklahoma", "Oklahoma City");
	  map.put("Oregon", "Salem");
	  map.put("Pennsylvania", "Harrisburg");
	  map.put("Rhode Island", "Providence");
	  map.put("South Carolina", "Columbia");
	  map.put("South Dakota", "Pierre");
	  map.put("Tennessee", "Nashville");
	  map.put("Texas", "Austin");
	  map.put("Utah", "Salt Lake City");
	  map.put("Vermont", "Montpelier");
	  map.put("Virginia", "Richmond");
	  map.put("Washington", "Olympia");
	  map.put("West Virginia", "Charleston");
	  map.put("Wisconsin", "Madison");
	  map.put("Wyoming", "Cheyenne");

    Scanner input = new Scanner(System.in);
    
    int correctCount = 0;

    for (int i = 0; i < stateCapital.length; i++) {
      // Prompt the user with a question
      System.out.print("What is the capital of " + stateCapital[i][0] + "? ");
      String capital = input.nextLine().trim().toLowerCase();
      
      if (map.containsKey(capital)) {
        System.out.println("Your answer is correct");
        correctCount++;
      }
      else
        System.out.println("The correct answer should be " + stateCapital[i][1]);
    }

    System.out.println("The correct count is " + correctCount);
  }
}