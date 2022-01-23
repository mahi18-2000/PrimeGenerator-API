package PrimeGenerator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;


@Getter
@AllArgsConstructor
public class PrimeGeneratorResponse {
    private List<Integer> primes;
}


