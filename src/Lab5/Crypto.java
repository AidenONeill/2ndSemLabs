package Lab5;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import Lab3.Tree;
import Lab4.FileIO;

public class Crypto {

	public static void main(String[] args) throws IOException {
		
		
		
	    String one = new String(Files.readAllBytes(Paths.get("C://Users/Aiden/Desktop/mystery.txt")));; 
	    one = one.trim();
	    //one=one.replaceAll("\\s+","");
	    
	    double total = 0.0;
	   
	    double len = one.length();
	    double x = 0.0;	    
	    System.out.println(one);
	   
	   int ar[] = new int[75000];		

		String binaryString="";      //this stores the string of binary code


		for(int i=0; i < one.length(); i++)//go through the sentence
		{        
			int decimalValue = (int)one.charAt(i);      //convert to decimal
			String binaryValue = Integer.toBinaryString(decimalValue); //convert to binary

			for(int j=7;j>binaryValue.length();j--)
			{
				binaryString+="0";           //this loop adds in those pesky leading zeroes
			}
			binaryString += binaryValue+" "; //add to the string of binary
		}
		System.out.println(binaryString);    //print out the binary


		for (int i = 0; i < one.length(); i++) 
		{

			ar[(int)one.charAt(i)]++;
		}	

		PriorityQueue < Tree >  PQ = new PriorityQueue < Tree >() ;  //make a priority queue to hold the forest of trees    

		
		for(int i=0; i<ar.length; i++) //go through frequency array
		{
			total = (double)ar[i]/len;
			if(ar[i]>0)//print out non-zero frequencies - cast to a char
			{ 
				System.out.print("'"+(char)i+"' appeared "+ar[i]+((ar[i] == 1) ? " time" + "	|frequency: " : " times" + "	|frequency: "));
				System.out.printf("%.2f",total*100);
				System.out.print("%");
				System.out.println();
				x=x+(total*100);
				
			}
		}
		System.out.println(x);
		
	   
	


	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static BigInteger findPrivateKey(BigInteger p, BigInteger g, BigInteger y){

		for(BigInteger i = BigInteger.ONE;; i = i.add(BigInteger.ONE))
		{
			BigInteger found = g.modPow(i, p);
			if(found.compareTo(y) == 0) return i; // Found the private key
		}
	}

}
