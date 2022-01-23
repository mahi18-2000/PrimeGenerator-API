/** This is an iterative algorithm used to generate prime numbers in O(nlogn) Time complexity. */
package PrimeGenerator.algorithm;

import java.util.LinkedList;
import java.util.List;

public class IterativePrimeGenerator implements PrimeGenerator{
    @Override
    public List<Integer> generatePrimes(int start, int end) {
        List<Integer> list = new LinkedList<Integer>();
        for (int i = start; i <= end; i++) {

            // A number which is less than 2 can never be a prime number.
            boolean flag = i < 2 ? false : true;

            //if a number is not a prime number then it must have a factor between 2 to its square root.
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }

            // If it does not have any factor then it is a prime number.
            if (flag) {
                list.add(i);
            }
        }
        return list;
    }
}
