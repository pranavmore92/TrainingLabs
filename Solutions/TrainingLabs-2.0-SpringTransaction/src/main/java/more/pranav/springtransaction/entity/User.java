package more.pranav.springtransaction.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_master")
public class User {
    @Id
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String emailId;
    private String status;
    private String createdBy;
}
