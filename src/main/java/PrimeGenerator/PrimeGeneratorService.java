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
        algorithmMap.put(Algorithm.ITERATIVE,  new IterativePrimeGenerator());
        algorithmMap.put(Algorithm.SIEVE, new SieveOfEratosPrimeGenerator());
        this.repository = repository;
    }

    public PrimeGeneratorResponse getPrimes(PrimeGeneratorRequest request) {

        long startTime = System.nanoTime();
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String range = request.getRangeStart() + " - " + request.getRangeEnd();

        List<Integer> primes = algorithmMap.get(request.getAlgorithm())
                .generatePrimes(request.getRangeStart(), request.getRangeEnd());

        long stopTime = System.nanoTime();
        ServiceLog serviceLog = new ServiceLog();
        serviceLog.setUserId(request.getUserID());
        serviceLog.setAlgorithm(request.getAlgorithm());
        serviceLog.setRange(range);
        serviceLog.setTimestamp(timestamp);
        serviceLog.setNumberOfPrimes(primes.size());
        serviceLog.setTotalTime(stopTime - startTime);

        repository.save(serviceLog);
        return new PrimeGeneratorResponse(primes);
    }

}
