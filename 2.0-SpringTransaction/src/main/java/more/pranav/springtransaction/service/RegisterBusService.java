package more.pranav.springtransaction.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import more.pranav.springtransaction.entity.Bus;
import more.pranav.springtransaction.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class RegisterBusService {
    @Autowired
    private BusRepository busRepository;

    @Transactional
    public boolean addBus(Bus bus) {
        busRepository.save(bus);
        return true;
    }

    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }
}
