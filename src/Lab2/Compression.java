package Lab2;
import java.util.*;

public class Compression {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a String");
		String two = scan.nextLine();
		String one = two.toLowerCase();
		int ar[] = new int[256];		
		int ascii;



		for (int i = 0; i < one.length(); i++) 
		{

			ar[(int)one.charAt(i)]++;
		}			

		for (int i = 0; i < ar.length; i++) 
		{
			if(ar[i]>0)
			{
				System.out.println("index = "+ i + " value = "+ ar[i]+ " char = "+ (char)i);
			}
		}
		for (int j = 0; j < one.length(); j++) {
			int index = 0;
			int largest = 0;
			int count = 0;		

			for (int i = 0; i < ar.length; i++) 
			{

				count++;				
				if(ar[i]>largest)
				{
					largest = ar[i];
					index = i;				
				}
				if(count==256)
				{
					ar[index]=0;
				}				
			}			
			System.out.print((char)index);
		}
	}
}




