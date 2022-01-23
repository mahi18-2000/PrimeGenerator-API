// This is an Sieve Of Eratosthenes method for generating prime numbers.

package PrimeGenerator.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SieveOfEratosPrimeGenerator implements PrimeGenerator{
    @Override
    public List<Integer> generatePrimes(int start, int end) {
        HashSet<Integer> hashSet = new HashSet<>();
        start = start < 2 ? 2 : start;

        // Initially we store every number in our range which may or may not be a prime number.
        for (int i = start; i <= end; i++) {
            hashSet.add(i);
        }

        //if a number is not a prime number then it must have a factor between 2 to its square root.
        for (int i = 2; i <= Math.sqrt(end); i++) {

            // For the optimization for our code we start checking from a number which is closet to the lower limit of our
            // range and also divisible by i.
            int jStart = start > i ? start / i : i;

            for (int j = jStart; j <= end / i; j++) {
                if (hashSet.contains(i * j)) {
                    hashSet.remove(i * j);
                }
            }
        }
        return new ArrayList<>(hashSet);
    }
}
