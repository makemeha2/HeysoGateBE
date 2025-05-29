package heysoGate.mapper;

import heysoGate.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll();

    User findByEmail(String email);

    Long insertUser(User user);
}
