package heysoGate.controller;

import heysoGate.domain.User;
import heysoGate.dto.UserRegisterRequestDto;
import heysoGate.mapper.UserMapper;
import heysoGate.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterRequestDto request) {
        Long userId = userService.registerLocalUser(request);

        return ResponseEntity.ok().body("회원가입 완료! userId=" + userId);
    }
}
