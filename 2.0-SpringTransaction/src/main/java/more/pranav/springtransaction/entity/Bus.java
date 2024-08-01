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
@Table(name = "BusMaster")
public class Bus {
    @Id
    private int id;
    private String agencyName;
    private String busType;
    private LocalDateTime startDate;
    private String fromLocation;
    private String toLocation;
    private int bookableSeats;
    private String status;
    private String createdBy;
    private LocalDateTime createdAt;
}
