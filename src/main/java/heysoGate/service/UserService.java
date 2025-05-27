package heysoGate.service;

import heysoGate.domain.User;
import heysoGate.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public List<User> getAllUsers() {
        return userMapper.findAll();
    }

    public User getUserByEmail(String email) {
        return userMapper.findByEmail(email);
    }
}
