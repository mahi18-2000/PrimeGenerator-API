package PrimeGenerator.algorithm;

import java.util.LinkedList;
import java.util.List;

public class IterativePrimeGenerator implements PrimeGenerator{
    @Override
    public List<Integer> generatePrimes(int start, int end) {
        List<Integer> list = new LinkedList<Integer>();
        for (int i = start; i <= end; i++) {
            boolean flag = i < 2 ? false : true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(i);
            }
        }
        System.out.println(list);
        return list;
    }
}
