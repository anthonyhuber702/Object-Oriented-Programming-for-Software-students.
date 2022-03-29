package dsandalgs;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class GuessCapitals {

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
				  
				  LinkedList<String[]> list = new LinkedList<>();
				  
	    Scanner input = new Scanner(System.in);
	    
	    int correctCount = 0;

	    for (String[] i: stateCapital) {
	      // Prompt the user with a question
	      Collections.addAll(list,stateCapital);
	      Collections.shuffle(list);
	      String[] s = list.pollFirst();
	      System.out.print("What is the capital of " + s[0] + "? ");
	      String capital = input.nextLine().trim().toLowerCase();
	      
	      if (capital.toLowerCase().equals(s[1].toLowerCase())) {
	        System.out.println("Your answer is correct");
	        correctCount++;
	      }
	      else
	        System.out.println("The correct answer should be " + s[1]);
	    }

	    System.out.println("The correct count is " + correctCount);
	  }
	}
