package more.pranav.springtransaction.service;

import lombok.AllArgsConstructor;
import more.pranav.springtransaction.entity.Audit;
import more.pranav.springtransaction.entity.Booking;
import more.pranav.springtransaction.entity.Payment;
import more.pranav.springtransaction.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuditService {

    @Autowired
    private AuditRepository auditRepository;
    private int auditCounter = 1;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void logEvent(Booking booking, Payment payment){
        Audit audit = Audit.build(auditCounter, "BOOKING", booking.getId(), payment.getId(), booking.getStatus(), booking.getCreatedBy(), booking.getCreatedAt());
        auditRepository.save(audit);
        auditCounter++;
    }
}
