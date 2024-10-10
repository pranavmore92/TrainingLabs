package more.pranav.payment.repository;

import more.pranav.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
