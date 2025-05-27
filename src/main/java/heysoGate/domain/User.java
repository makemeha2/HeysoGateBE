package heysoGate.domain;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String email;
    private String name;
    private String password;
    private String provider;
    private String providerId;
    private String profileImageUrl;
    private String role;
    private Boolean isActive;
}
