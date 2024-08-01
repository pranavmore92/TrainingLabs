package more.pranav.springtransaction.service;

import lombok.AllArgsConstructor;
import more.pranav.springtransaction.entity.User;
import more.pranav.springtransaction.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
