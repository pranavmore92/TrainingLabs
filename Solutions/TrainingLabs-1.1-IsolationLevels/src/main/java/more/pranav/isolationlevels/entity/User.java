package more.pranav.isolationlevels.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String emailId;
    private String status;
    private String createdBy;
}
