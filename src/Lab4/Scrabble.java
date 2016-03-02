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
		String one = scan.nextLine();
		FileIO reader = new FileIO();
		ar = reader.load("C://Users/Aiden/Desktop/dictionary.txt");    //Reading the File as a String array
		workSpace = new String[ar.length];
		String[] found = new String[10];
		

		mergeSort2(ar);				
		for(int i=0;i<10000;i++)
		{
			System.out.print(ar[i]);
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