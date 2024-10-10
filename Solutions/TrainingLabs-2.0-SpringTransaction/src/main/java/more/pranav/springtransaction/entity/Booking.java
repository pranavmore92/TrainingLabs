package more.pranav.springtransaction.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "booking_master")
public class Booking {
    @Id
    private int id;
    private int busId;
    private int userId;
    private int paymentId;
    private int seatNo;
    private LocalDate bookingDate;
    private String status;
    private String createdBy;
    private LocalDateTime createdAt;
}
