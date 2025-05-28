package heysoGate.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor      // MEMO : NoArgsConstructor, AllArgsConstructor 정확한 용법 파악
@AllArgsConstructor
public class LoginRequestDto {
    private String email;
    private String password;
}

