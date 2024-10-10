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
@Table(name = "payment_request")
public class Payment {

    @Id
    private int id;
    private int accountNo;
    private String ifscCode;
    private int amount;
    private String paymentType;
    private String status;
    private String createdBy;
    private LocalDateTime createdAt;

}