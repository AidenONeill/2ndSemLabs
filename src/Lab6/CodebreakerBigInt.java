package Lab6;

import java.math.BigInteger;

public class CodebreakerBigInt {
	
	public static void main(String[] args) {
		double startTime = System.currentTimeMillis();		
		long c1 =15268076l;
		long c2 =743675l;		
		BigInteger p = new BigInteger("24852977");		
		BigInteger g = new BigInteger("2744");
		BigInteger y = new BigInteger("8414508");
		long x = findPrivateKey(p,g,y).intValue();
		long p2 = p.longValue();		
		long num = modPow(c1,p2-1-x,p2)*c2;
		System.out.println("Private key is: "+findPrivateKey(p,g,y));
		System.out.println("Hidden message is: "+ modPow(num,1,p2));
		double elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("Total time running is : "+ elapsedTime/1000+ " seconds");
	}	
	public static BigInteger findPrivateKey(BigInteger p, BigInteger g, BigInteger y){

		for(BigInteger i = BigInteger.ONE; ;i = i.add(BigInteger.ONE))//sets i to one, adds i to i after every pass
		{
			BigInteger found = g.modPow(i, p);
			//System.out.println(found+ " Number: "+ i);
			if(found.compareTo(y) == 0) //comparison = 0 if numbers are the same, similar to string.compareTo
			{
				return i; // Found the private key
			}
		}
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

