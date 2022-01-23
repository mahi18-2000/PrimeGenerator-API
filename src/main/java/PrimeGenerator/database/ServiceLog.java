package PrimeGenerator.database;

import PrimeGenerator.model.Algorithm;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class ServiceLog {
    private @Id @GeneratedValue Long requestId;
    private String userId;
    private String range;
    private Algorithm algorithm;
    private String timestamp;
    private int numberOfPrimes;
    private long totalTime;
}
