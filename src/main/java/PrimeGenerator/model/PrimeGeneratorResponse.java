// This class represent the Object type for the response that we will send to our users when they post a request.
package PrimeGenerator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;


@Getter
@AllArgsConstructor
public class PrimeGeneratorResponse {
    private List<Integer> primes;
}


