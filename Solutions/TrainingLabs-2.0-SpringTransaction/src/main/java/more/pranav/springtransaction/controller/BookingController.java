package more.pranav.springtransaction.controller;


import lombok.AllArgsConstructor;
import more.pranav.springtransaction.entity.BookingRequest;
import more.pranav.springtransaction.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<BookingRequest>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @PostMapping(value = "/booking")
    public ResponseEntity<Void> createBooking(@RequestBody BookingRequest bookingRequest) {

        bookingService.initiate(bookingRequest);

        return ResponseEntity.accepted().build();
    }
}
