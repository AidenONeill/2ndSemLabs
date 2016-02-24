package Lab3;
import java.util.*;

public class Compression_cont {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a String");
		String one = scan.nextLine();
		//String one = two.toLowerCase();
		double total =one.length()*7;
		scan.close();

		int ar[] = new int[256];		

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
			if(ar[i]>0)//print out non-zero frequencies - cast to a char
			{ 
				System.out.println("'"+(char)i+"' appeared "+ar[i]+((ar[i] == 1) ? " time" : " times"));


				Tree x = new Tree();//create a new Tree
				x.frequency=ar[i];//set the cumulative frequency of that Tree	
				x.root.letter =(char)i;//insert the letter as the root node 	               
				PQ.add(x);//add the Tree into the PQ		                



			}
		}
		//System.out.println(PQ.size());

		while(PQ.size()>1)//while there are two or more Trees left in the forest
		{       
			Tree t1 = PQ.remove();
			Tree t2 = PQ.remove();
			Tree a = new Tree(t1,t2);			
			//System.out.println("Tree 1 " + t1.root.letter+" T1: Freq "+ t1.frequency+"   |  "+" Tree 2 "+t2.root.letter+ " T2: Freq "+ t2.frequency+"  |  "+" Total Freq "+ a.frequency);
			PQ.add(a);
		}

		Tree HuffmanTree = PQ.poll();//now there's only one tree left - get its codes
		double n1 = 0;//set a double to find compression %
		for (int i = 0; i < one.length(); i++) 
		{
			System.out.print(HuffmanTree.getCode(one.charAt(i))+ " ");
			n1 = n1+HuffmanTree.path.length();
		}
		System.out.println();
		System.out.print("Compressed size is "+ n1+ " bits / "+total+ " bits = ");
		double d= n1/total*100;
		System.out.printf("%.2f",d);
		System.out.print("%");



	}      
}
