package Lab5;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import Lab5.FileIO;

public class Crypto {

	public static void main(String[] args) throws IOException {
		FileIO reader = new FileIO();
		String one = "";

		String[] inputs = reader.load("C://Users/Aiden/Desktop/mystery3.txt");    //Reading the File as a String array
		double[] Dan = {6.03,3.39,1.98,2.00,5.23,2.33,0.56,3.24,0.07,5.86,7.24,0.03,15.45, 4.64,0.70,2.41,1.76,0.03,4.08, 0.01,0.87,1.62, 8.96,0.94,6.00,5.81,1.19,0.73,6.86};
		double[] Eng = {8.55,0.81,2.68,1.60, 4.21,1.06,3.16,2.53,1.83,3.87,7.17,0.19,12.10,7.47,1.72,2.18,2.07,0.11,2.09,0.10,4.96,6.33,7.33,6.73,0.22,8.94};
		double[] Fin = {12.22,4.97,5.01,0.28,5.76,2.25,0.28,3.20,0.09,1.04,8.83,0.03,7.97,5.61,1.74,0.19,1.84,0.05,0.39,0.01,0.00,1.85,2.87,3.58,10.82,7.86,0.44,2.04,8.75};
		double[] Fre = {7.60,1.18,0.85,0.43,0.93,6.86,0.05,7.21,7.98,0.00,0.04,7.11	,3.39,0.30,0.02,0.05,0.16,0.02,4.08,5.86 ,0.00,14.47,2.78,1.29,2.43,7.32,0.08,0.42,5.39,0.43,0.13,0.05,0.34,0.00,0.02,0.00,1.12,2.98,0.10};
		double[] Ger = {6.34,1.50,3.76,2.21,3.72,0.94,2.71,2.75,1.40,4.92,9.59,0.07,15.99,2.75,0.13,1.80,1.06,1.22,3.02,0.04,0.54,11,7.71,0.24,7.60,6.41,0.63,0.27,6.43,0.15};
		double[] Ice = {10.11,1.57,4.95,1.80,1.14,4.56,1.04,3.31,0.61,1.58,4.53,2.44,4.39,4.04,0.05,6.42,7.71,0.90,0.65,2.17,0.23,3.01,0.99,1.45,4.24,0.79,0.87,1.87,8.58,0.78,7.58,5.63};
		double[] Pol = {9.02,8.09,5.06,0.95,2.26,4.46,1.39,3.54,0.58,3.96,2.36,3.94,0.26,1.82,2.59,3.23,2.73,4.78,7.51,5.81,3.70,0.98,0.21,5.17,0.41,7.90,0.07,1.54,0.89,0.66,1.25,2.92};
		double[] Rus = {8.04,3.49,1.02,1.55,4.32,0.58,4.75,3.11,1.23,1.88,6.72,0.55,2.95,10.61,0.34,8.21,2.82,0.03,0.22,5.38,1.91,0.80,5.71,1.39,1.61,5.83,0.31,7.98,2.28,0.63,1.36,0.41,2.00};
		double[] Spa = {12.50,0.08,4.42,1.27,5.84,4.00,4.43,2.61,0.98,5.14,7.09,0.03,13.24,0.22,0.19,0.79,8.98,0.79,1.17,2.75,0.42,0.81,0.83,6.91,6.62,0.45,7.44 };
		double[] Swe = {9.38,3.14,1.92,1.54,5.28,2.42,1.49,3.47,0.14,4.70,8.54,0.16,10.15,4.48,0.71,2.03,1.84,0.07,2.86,0.02,1.34,2.09,8.43,1.80,5.82,6.59,1.31,0.61,7.69 };
		for(int i=0;i<inputs.length;i++){
			//System.out.println(inputs[i]);
			one+=inputs[i];
		}
		//	    String one = new String(Files.readAllBytes(Paths.get("C://Users/Aiden/Desktop/mystery.txt")));; 
		one = one.trim();
		one=one.replaceAll("\\s+","");
		double total = 0.0;
		double len = one.length();
		double x = 0.0;	    
		System.out.println(one);

		int ar[] = new int[65534];		

		for (int i = 0; i < one.length(); i++) 
		{
			ar[(int)one.charAt(i)]++;
		}	
		Arrays.sort(ar);
		Arrays.sort(Dan);
		Arrays.sort(Eng);
		Arrays.sort(Fin);
		Arrays.sort(Fre);
		Arrays.sort(Ger);
		Arrays.sort(Ice);
		Arrays.sort(Pol);
		Arrays.sort(Rus);
		Arrays.sort(Spa);
		Arrays.sort(Swe);
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
		print(ar,Dan,"Danish");
		print(ar,Eng,"English");
		print(ar,Fin,"Finnish");
		print(ar,Fre,"French");
		print(ar,Ger,"German");
		print(ar,Ice,"Icelandic");
		print(ar,Pol,"Polish");
		print(ar,Rus,"Russian");
		print(ar,Spa,"Spanish");
		print(ar,Swe,"Swedish");
	}
	public static double difference(int[] ar,double[] ar2)
	{
		double diff = 0.0;
		double diff2 = 0.0;
		for(int i=15; i>0; i--) //go through frequency array
		{
			diff = diff + Math.abs((double)ar[i]-ar2[i]);
			diff2 = diff2 + Math.abs((double)ar[i]+ar2[i]);
		}
		return diff2;
	}
	public static void print(int[]ar,double[]ar2, String name)
	{
		System.out.print("The difference between unknown and "+name+ " is: ");
		System.out.printf("%.2f",difference(ar,ar2));
		System.out.print("%");
		System.out.println();
	}

	public static BigInteger findPrivateKey(BigInteger p, BigInteger g, BigInteger y){

		for(BigInteger i = BigInteger.ONE;; i = i.add(BigInteger.ONE))
		{
			BigInteger found = g.modPow(i, p);
			if(found.compareTo(y) == 0) return i; // Found the private key
		}
	}

}
