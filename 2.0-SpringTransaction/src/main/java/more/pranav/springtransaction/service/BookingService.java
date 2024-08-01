package more.pranav.springtransaction.service;

import lombok.AllArgsConstructor;
import more.pranav.springtransaction.entity.BookingRequest;
import more.pranav.springtransaction.repository.BookingRepository;
import more.pranav.springtransaction.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final PaymentRepository paymentRepository;

    public void initiate(BookingRequest bookingRequest) {
        // Insert your code here to initiate bus seats booking
    }

    public List<BookingRequest> getAllBookings(){
        List<BookingRequest> bookingRequests = new ArrayList<>();

        // Insert your code here to fetch all bookings

        return bookingRequests;
    }
}
