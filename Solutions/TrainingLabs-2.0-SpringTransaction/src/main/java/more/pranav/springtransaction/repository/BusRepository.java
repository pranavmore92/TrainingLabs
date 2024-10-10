package more.pranav.springtransaction.repository;

import more.pranav.springtransaction.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer> {

    //@Transactional(propagation = Propagation.MANDATORY)
    //@Transactional(propagation = Propagation.NESTED)
    public Optional<Bus> findById(int busId);
}
