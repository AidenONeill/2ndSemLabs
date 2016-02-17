package Lab1;
import java.util.*;

public class Sticks {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the number of iterations you wish to run");
		double n = scan.nextInt();	
		double count = 0;
		
		
		for(int i=0;i<n;i++) // number of iterations to find an average probability
		{
			boolean check = false;
			double x = 1-Math.random();		// get the value of x
			double y = 1-x;					// set y = 1-x
			double z = 0;


			if(x>y)
			{
				z = Math.abs(x-Math.random()); //randomly break x if its the bigger half
				x = Math.abs(x-z);			   //set new value to x
			}
			else
			{
				z = Math.abs(y-Math.random());//randomly break y if its the bigger half
				y = Math.abs(y-z);			  //set new value to y
			}
//			System.out.println(x);
//			System.out.println(y);
//			System.out.println(z);
//			System.out.println(x+y+z);
			
			if(x>y&&x>z) // check if x is biggest
			{
				
				if(y+z>x) //check if two smaller sides > biggest side
				{
					check = true;
					
				}
				
			}
			else if(y>x&&y>z) // check if y is biggest
			{
				
				
				if(x+z>y) //check if two smaller sides > biggest side
				{
					check = true;
					
				}
				
			}
			else if(z>x&&z>y) // check if z is biggest
			{
				
				if(x+y>z)//check if two smaller sides > biggest side
				{
					check = true;
					
				}
				
			}
			
			if(check == true)
			{
				count++;			//count number of times that two smaller sides> biggest
			}


		}
		//System.out.println(count);
		//System.out.println(n);
		System.out.println("The Probability of forming a triangle over " + n+ " iterations is: "+ count/n);
	}


}
