package more.pranav.springtransaction.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequest {
    private Booking booking;
    private Payment payment;
}
