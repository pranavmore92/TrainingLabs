package more.pranav.isolationlevels.service;

import more.pranav.isolationlevels.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public void createUser(User user) {

        // Insert your code here to create new User.

    }

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();

        // Insert your code here to fetch all Users.

        return users;
    }
}
