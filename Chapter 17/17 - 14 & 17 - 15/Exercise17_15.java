package inputoutput;

import java.io.*;
import java.util.Scanner;

public class Exercise17_15 {
  public static void main(String[] args) throws IOException { 
	  Scanner input = new Scanner(System.in);

	  System.out.print("Enter input file name: ");
	  File sourceFile = new File(input.next());
	  
	  System.out.print("Enter output file name: ");
	  File targetFile = new File(input.next());

	  
    if (!sourceFile.exists()) {
       System.out.println("Source file " + args[0] + " does not exist");
       System.exit(2);
    }
    if (targetFile.exists()) {
      System.out.println("Target file " + args[1] + " already exists");
      System.exit(3);
    }

    try (
      BufferedInputStream input1 = 
      	new BufferedInputStream(new FileInputStream(sourceFile));
    		
      BufferedOutputStream output = 
    		  new BufferedOutputStream(new FileOutputStream(targetFile));
    ) {
      int r, numberOfBytesCopied = 0;
      while ((r = input1.read()) != -1) {
        output.write((byte)(r - 5));
        numberOfBytesCopied++;
      }
      System.out.println(numberOfBytesCopied + " bytes copied");
    }
  }
}