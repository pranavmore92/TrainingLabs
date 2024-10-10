package more.pranav.springtransaction.repository;

import more.pranav.springtransaction.entity.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AuditRepository extends JpaRepository<Audit, Integer> {

}
