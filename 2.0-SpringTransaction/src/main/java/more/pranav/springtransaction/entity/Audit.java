package more.pranav.springtransaction.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "audit_master")
public class Audit {

    @Id
    private int id;
    private String event;
    private int bookingId;
    private int paymentId;
    private String status;
    private String createdBy;
    private LocalDateTime createdAt;

    public static Audit build(int id, String event, int bookingId, int paymentId, String status, String createdBy, LocalDateTime createdAt){
        Audit audit = new Audit();
        audit.setId(id);
        audit.setEvent(event);
        audit.setBookingId(bookingId);
        audit.setPaymentId(paymentId);
        audit.setStatus(status);
        audit.setCreatedBy(createdBy);
        audit.setCreatedAt(createdAt);
        return audit;
    }
}
