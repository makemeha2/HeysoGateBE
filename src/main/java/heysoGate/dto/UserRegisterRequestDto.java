package heysoGate.dto;

import lombok.Data;

@Data
public class UserRegisterRequestDto {
    private String email;
    private String name;
    private String password;
}
