package Lab4;
import java.util.*;

public class Scrabble 
{

	public static String[] ar;
	public static String[] workSpace;

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Please Enter your letters");		
		String one = scan.nextLine(), two = "", three = "", s3 = "";
		System.out.println();
		FileIO reader = new FileIO();
		ar = reader.load("C://Users/Aiden/Desktop/dictionary.txt");    //Reading the File as a String array
		workSpace = new String[ar.length];	   //declare an array size for mergesort
		String[] found = new String[ar.length];//set an array for found strings
		int count2= 0, a=0;					   //declare count and a variable a for later use
		scan.close();



		mergeSort2(ar);	//calls a merge sort on the array of strings - sorted buy string length descending			


		for (int i = 0; i < ar.length; i++) //run though the array of strings
		{		 
			two = ar[i];//string two is the current string being looked at in ar
			three = two;//set a string to the value of two, as two will be changed during comparison
			s3 = one;	//same as string three
			
			if(two.length()-1>one.length())//only compares words that are equal to or shorter than in length
			{
				i++;	
				//System.out.print(" Two length = "+ (two.length()-1)+" " + two + " one length = "+ one.length()+" "+ one);
			}
			else
			{				
				for (int j = 0; j < two.length(); j++)
				{
//					System.out.print("one "+ s3  );
//				    System.out.print(" two " + two);
//				    System.out.println();
					for (int j2 = 0; j2 <one.length(); j2++) 
					{ 						
						if (s3.charAt(j2)==two.charAt(j)) //checks if a letter matches both strings and replaces it in both if found
						{							
							char[] twoChars = two.toCharArray();
							twoChars[j] = '-';
							two = String.valueOf(twoChars);	
							char[] s3Chars = s3.toCharArray();
							s3Chars[j2] = '*';
							s3 = String.valueOf(s3Chars);		
						    count2=0;
							
							for (int k = 0; k <two.length(); k++) //run through the word
							{								
								if(two.charAt(k)=='-')//count number of of replaced letters
								{
									count2++;
//									System.out.println(count2);
//									System.out.println(two.length()-1);
									
									if(count2==two.length()-1)//if the number of replace letters = the length of the string, this word can be formed from the given letters
									{
										//System.out.println(three);
										
										found[a]=three;// places the found word in an array for easy access/printing		
										a++;
									}
								}
							}
						}
					}
				}
			}
		}
		for(int x=0;x<10;x++)
		{
			if(found[x]!=null)
			{
				System.out.println(found[x]);
			}
		}
		
	}
	public static void mergeSort2(String[] ar) 
	{
		if (ar.length >= 2) {
			String[] left = new String[ar.length / 2];
			String[] right = new String[ar.length-ar.length / 2];

			for (int i = 0; i < left.length; i++)
			{
				left[i] = ar[i]; 
			}
			for (int i = 0; i < right.length; i++)
			{
				right[i] = ar[i + ar.length / 2];
			}
			mergeSort2(left);
			mergeSort2(right);

			merge(ar, left, right);
		}
	}
	public static void merge(String[] workspace, String[] left, String[] right) {
		int x = 0;
		int y = 0;
		for (int i = 0; i < workspace.length; i++)
		{
			if (y >= right.length || (x < left.length && left[x].length()>(right[y].length())))
			{
				workspace[i] = left[x];
				x++;
			} 
			else 
			{
				workspace[i] = right[y];
				y++;
			}
		}
	}
}