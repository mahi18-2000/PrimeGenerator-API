//This interface extends JpaRespository which enable us to perform CRUD (Create Read Update Delete) operations on our Database.
//for example- creating a new ServiceLog, deleting a ServiceLog.

package PrimeGenerator.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceLogRepository extends JpaRepository<ServiceLog, Long> {
}