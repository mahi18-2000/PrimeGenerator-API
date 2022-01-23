// The main purpose of this interface is to enable us to create an object type for our algorithm classes so that we can map
// it as a Value for an Enum key.

package PrimeGenerator.algorithm;

import java.util.List;

public interface PrimeGenerator {
    //This function will be overridden in our derived classes for generating prime numbers.
    List<Integer> generatePrimes(int start, int end);
}
