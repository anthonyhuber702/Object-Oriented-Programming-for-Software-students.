package inputoutput;
import java.io.*;

public class Exercise17_07 {    
	public static void main(String[] args) throws FileNotFoundException {
		Loan loan1 = new Loan();        
		Loan loan2 = new Loan(1.8, 10, 10000);        
		try (
				ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat"));
		) {            
			output.writeObject(loan1);            
			output.writeObject(loan2);        
		} 
		catch (IOException ex) {            
			System.out.println("File could not be opened");
		}    		
		outputData("Exercise17_07.dat");
	}
	public static void outputData(String file) {
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
			double sum = 0;
			Loan loan;
			boolean done = false;
			
			while (done != true) {
		try {
			loan = (Loan)input.readObject();
			sum += loan.getLoanAmount();
			} 
		catch (EOFException e) {
				System.out.println("Total loan amount is: $" + sum);
				done = true;
			}
		}
	}
		catch (Exception e) {

		}
	}
}