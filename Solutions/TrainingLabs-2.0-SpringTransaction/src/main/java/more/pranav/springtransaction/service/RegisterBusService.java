package more.pranav.springtransaction.service;

import lombok.AllArgsConstructor;
import more.pranav.springtransaction.entity.Bus;
import more.pranav.springtransaction.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class RegisterBusService {
    @Autowired
    private BusRepository busRepository;
    private final TransactionTemplate transactionTemplate;

    public RegisterBusService(PlatformTransactionManager transactionManager) {
        this.transactionTemplate = new TransactionTemplate(transactionManager);
    }

    //@Transactional(propagation = Propagation.REQUIRES_NEW)
    /*public boolean addBus(Bus bus) {
        busRepository.save(bus);
        //busRepository.findById(bus.getId());
        return true;
    }*/

    public boolean addBus(Bus bus) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try{
                    Optional<Bus> result = busRepository.findById(bus.getId());
                    if (result.isPresent()) {
                        throw new RuntimeException("Bus is already registered");
                    }
                    busRepository.save(bus);
                }catch (Exception e) {
                    status.setRollbackOnly();
                }
            }
        });
        return true;
    }

    /*public boolean addBus(Bus bus) {
        Boolean status = transactionTemplate.execute(new TransactionCallback<Boolean>() {

            @Override
            public Boolean doInTransaction(TransactionStatus status) {
                try{
                    Optional<Bus> payment = busRepository.findById(bus.getId());
                    if (payment.isPresent()) {
                        throw new RuntimeException("Bus is already registered");
                    }
                    busRepository.save(bus);
                }catch (Exception e) {
                    status.setRollbackOnly();
                    return false;
                }
                return true;
            }
        });

        return (boolean) status;
    }*/

    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }
}
