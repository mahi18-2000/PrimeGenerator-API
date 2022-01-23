package PrimeGenerator;

import PrimeGenerator.algorithm.PrimeGenerator;
import PrimeGenerator.algorithm.IterativePrimeGenerator;
import PrimeGenerator.algorithm.SieveOfEratosPrimeGenerator;
import PrimeGenerator.database.ServiceLog;
import PrimeGenerator.database.ServiceLogRepository;
import PrimeGenerator.model.Algorithm;
import PrimeGenerator.model.PrimeGeneratorRequest;
import PrimeGenerator.model.PrimeGeneratorResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class PrimeGeneratorService {

    private HashMap<Algorithm, PrimeGenerator> algorithmMap = new HashMap<>();
    private ServiceLogRepository repository;

    public PrimeGeneratorService(ServiceLogRepository repository){

        // It maps all the algorithm class to its enum key.
        algorithmMap.put(Algorithm.ITERATIVE,  new IterativePrimeGenerator());
        algorithmMap.put(Algorithm.SIEVE, new SieveOfEratosPrimeGenerator());
        this.repository = repository;
    }

    //Here we are defining all the attributes of our log which will be stored in our database.
    public PrimeGeneratorResponse getPrimes(PrimeGeneratorRequest request) {

        // Recording the start time
        long startTime = System.nanoTime();
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String range = request.getRangeStart() + " - " + request.getRangeEnd();

        // Generating prime numbers function from user specified algorithm
        List<Integer> primes = algorithmMap.get(request.getAlgorithm())
                .generatePrimes(request.getRangeStart(), request.getRangeEnd());

        // Recording the stop time
        long stopTime = System.nanoTime();
        ServiceLog serviceLog = new ServiceLog();
        serviceLog.setUserId(request.getUserID());
        serviceLog.setAlgorithm(request.getAlgorithm());
        serviceLog.setRange(range);
        serviceLog.setTimestamp(timestamp);
        serviceLog.setNumberOfPrimes(primes.size());
        serviceLog.setTotalTime(stopTime - startTime);

        //save the log in our Database
        repository.save(serviceLog);
        return new PrimeGeneratorResponse(primes);
    }

}
