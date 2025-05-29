package heysoGate.service;

import heysoGate.domain.User;
import heysoGate.dto.UserRegisterRequestDto;
import heysoGate.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;


    public List<User> getAllUsers() {
        return userMapper.findAll();
    }

    public User getUserByEmail(String email) {
        return userMapper.findByEmail(email);
    }

    public Long registerLocalUser(UserRegisterRequestDto request) {
        // 비밀번호 해싱
        String hashedPassword = passwordEncoder.encode(request.getPassword());

        User user = new User();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setPassword(hashedPassword);

        userMapper.insertUser(user);

        return user.getId();
    }
}
