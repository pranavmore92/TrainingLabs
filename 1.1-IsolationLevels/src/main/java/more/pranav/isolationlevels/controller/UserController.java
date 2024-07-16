package more.pranav.isolationlevels.controller;

import lombok.AllArgsConstructor;
import more.pranav.isolationlevels.entity.User;
import more.pranav.isolationlevels.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping(value = "/user")
    public ResponseEntity<Void> createUser(@RequestBody User user) {

        userService.createUser(user);
        return ResponseEntity.accepted().build();
    }
}
