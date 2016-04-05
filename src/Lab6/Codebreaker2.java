package Lab6;

import java.math.BigInteger;

public class Codebreaker2 {
	

	
	public static void main(String[] args) {
		double startTime = System.currentTimeMillis();		
		long c1 =15268076l;
		long c2 =743675l;
		long p = 24852977l;
		long g = 2744l;
		long y = 8414508l;
		long found = 1l;
		long x = 1l;
		long power = 0;
		
		while(found != y)
		{
			found = modPow(g,x,p);
			if(found == y)power = x;			
			else x++;
		}
		
		
		long num = modPow(c1,p-1-x,p)*c2;
		System.out.println("Private key is: "+ power);
		System.out.println("Hidden message is: "+ modPow(num,1,p));
		double elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("Total time running is : "+ elapsedTime/1000+ " seconds");
	}
		
	public static long modPow(long number, long power, long modulus){
		//raises a number to a power with the given modulus
		//when raising a number to a power, the number quickly becomes too large to	handle
		//you need to multiply numbers in such a way that the result is consistently moduloed to keep it in the range
		//however you want the algorithm to work quickly - having a multiplication loop would result in an O(n) algorithm!
		//the trick is to use recursion - keep breaking the problem down into smallerpieces and use the modMult method to join them back together
		if(power==0)
			return 1;
		else if (power%2==0) {
			long halfpower=modPow(number, power/2, modulus);
			return modMult(halfpower,halfpower,modulus);
		}else{
			long halfpower=modPow(number, power/2, modulus);
			long firstbit = modMult(halfpower,halfpower,modulus);
			return modMult(firstbit,number,modulus);
		}
	}
	public static long modMult(long first, long second, long modulus){
		//multiplies the first number by the second number with the given modulus
		//a long can have a maximum of 19 digits. Therefore, if you're multiplying
		//two ten digits numbers the usual way, things will go wrong
		//you need to multiply numbers in such a way that the result is consistently
		//moduloed to keep it in the range
		//however you want the algorithm to work quickly - having an addition loop
		//would result in an O(n) algorithm!
		//the trick is to use recursion - keep breaking down the multiplication into
		//smaller pieces and mod each of the pieces individually
		if(second==0)
			return 0;
		else if (second%2==0) {
			long half=modMult(first, second/2, modulus);
			return (half+half)%modulus;
		}else{
			long half=modMult(first, second/2, modulus);
			return (half+half+first)%modulus;
		}
	}

}
