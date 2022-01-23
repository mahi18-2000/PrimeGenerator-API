package PrimeGenerator.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SieveOfEratosPrimeGenerator implements PrimeGenerator{
    @Override
    public List<Integer> generatePrimes(int start, int end) {
        HashSet<Integer> hashSet = new HashSet<>();
        start = start < 2 ? 2 : start;
        for (int i = start; i <= end; i++) {
            hashSet.add(i);
        }

        for (int i = 2; i <= Math.sqrt(end); i++) {
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
