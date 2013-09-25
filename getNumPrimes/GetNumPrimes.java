package getNumPrimes;

import java.util.LinkedList;

public class GetNumPrimes {
	
	/**
	 * Returns number of prime numbers that are less than n.
	 * @param n
	 * @return
	 */
	public static int getNumPrimes(int n) {
		LinkedList<Integer> primes = new LinkedList<Integer>();
		
		for (int i = 2; i <= n; i++) {
			boolean isPrime = true;
			for (Integer num : primes) {
				if (num > Math.sqrt(i)) {
					break;
				}else if (i % num == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primes.addLast(i);
			}
		}
		return primes.size();
	}

}
