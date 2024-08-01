package more.pranav.springtransaction.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import more.pranav.springtransaction.entity.Bus;
import more.pranav.springtransaction.repository.BusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegisterBusService {
    private BusRepository busRepository;

    @Transactional
    public void addBus(Bus bus) {
        busRepository.save(bus);
    }

    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }
}
