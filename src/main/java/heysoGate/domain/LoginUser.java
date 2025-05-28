package heysoGate.domain;

import lombok.*;

@Data
public class LoginUser {
    private Long id;
    private String email;
    private String name;
    private String role;
}
