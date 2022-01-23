package PrimeGenerator;

import java.util.List;

import PrimeGenerator.database.ServiceLog;
import PrimeGenerator.database.ServiceLogRepository;
import PrimeGenerator.exception.ServiceLogNotFoundException;
import PrimeGenerator.model.PrimeGeneratorRequest;
import PrimeGenerator.model.PrimeGeneratorResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ServerController {

    private ServiceLogRepository repository;
    private PrimeGeneratorService primeGeneratorService;

    ServerController(ServiceLogRepository repository) {
        this.repository = repository;
        this.primeGeneratorService = new PrimeGeneratorService(repository);
    }

    @GetMapping("/service-logs")
    List<ServiceLog> getServiceLogs() {
        return repository.findAll();
    }

    @GetMapping("/service-logs/{id}")
    ServiceLog getServiceLog(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ServiceLogNotFoundException(id));
    }

    @DeleteMapping("/service-logs/{id}")
    void deleteServiceLog(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PostMapping("/primes")
    PrimeGeneratorResponse getPrimes(@RequestBody PrimeGeneratorRequest request){
        return primeGeneratorService.getPrimes(request);
    }
}
