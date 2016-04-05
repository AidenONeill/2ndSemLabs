package Lab6;


import java.util.*;
import java.math.BigInteger;
public class Cryptography
{
	public static void main (String args[])
	{
		long g = 2744l;
		long found = 1l;
		long power = 1l;
		long modulo = 24852977l;
		long answer = 8414508l;
		long publicKey;

		while(found != answer)
		{
			found = modpow(g,power,modulo);
			if(found == answer)
			{
				System.out.println("Alice's private key is "+power);
				break;
			}
			else
			{
				power++;
			}
		}

		long c1 = 15268076l;
		long c2 = 743675l;
		long bottomResult =0;
		long OneOverc1 = 0;
		System.out.println(power+" "+c1+" "+modulo);

		OneOverc1 = (modpow(c1,modulo-1-power,modulo)); //getting first number to be multiplied



		System.out.println("c1 to the power of modulo-1-x = "+OneOverc1); //having a gander at it

		//long message = (c2%modulo)*OneOverc1;  // ***** This like here was the major wrong one you were getting the modulus of c2 and multiplying it by OneOver c1, it should just be OneOverc1*C2
		long num = OneOverc1*c2;				// this is the number you call modpow on, to the power of 1 with the modulus from earlier				
		long message = modpow(num,1,modulo); 	
		System.out.println("message is " +message); 


		//        ****************AIDO*************
		//        tried a few other things but cant seem to get the answer, heard its 123456789 or something
		//        
	}

	public static long modpow(long number, long power, long modulus){
		//raises a number to a power with the given modulus
		//when raising a number to a power, the number quickly becomes too large to	handle
		//you need to multiply numbers in such a way that the result is consistently moduloed to keep it in the range
		//however you want the algorithm to work quickly - having a multiplication loop would result in an O(n) algorithm!
		//the trick is to use recursion - keep breaking the problem down into smallerpieces and use the modMult method to join them back together
		if(power==0)
			return 1;
		else if (power%2==0) {
			long halfpower=modpow(number, power/2, modulus);
			return modMult(halfpower,halfpower,modulus);
		}else{
			long halfpower=modpow(number, power/2, modulus);
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