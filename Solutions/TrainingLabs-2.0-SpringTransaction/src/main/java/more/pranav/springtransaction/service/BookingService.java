package more.pranav.springtransaction.service;

import lombok.AllArgsConstructor;
import more.pranav.springtransaction.entity.Audit;
import more.pranav.springtransaction.entity.Booking;
import more.pranav.springtransaction.entity.BookingRequest;
import more.pranav.springtransaction.entity.Payment;
import more.pranav.springtransaction.repository.AuditRepository;
import more.pranav.springtransaction.repository.BookingRepository;
import more.pranav.springtransaction.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final PaymentRepository paymentRepository;
    private final AuditService auditService;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    //@Transactional
    public void initiate(BookingRequest bookingRequest) {
        Booking booking = bookingRequest.getBooking();
        Payment payment = bookingRequest.getPayment();

        auditService.logEvent(booking, payment);
        bookingRepository.save(booking);

        Optional<Payment> paymentResult = paymentRepository.findById(payment.getId());
        if (paymentResult.isPresent()) {
            throw new RuntimeException("Payment already exists");
        }

        paymentRepository.save(payment);
    }

    public List<BookingRequest> getAllBookings(){
        List<Booking> bookings = bookingRepository.findAll();
        List<BookingRequest> bookingRequests = new ArrayList<>();
        bookings.forEach(booking -> {
            BookingRequest bookingRequest = new BookingRequest();
            bookingRequest.setBooking(booking);

            Optional<Payment> payment = paymentRepository.findById(booking.getPaymentId());
            payment.ifPresent(bookingRequest::setPayment);

            bookingRequests.add(bookingRequest);
        });

        return bookingRequests;
    }
}
