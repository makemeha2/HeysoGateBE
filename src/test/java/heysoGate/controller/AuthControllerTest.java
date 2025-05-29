package heysoGate.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest // 실제 Spring Boot 전체 컨텍스트 로드
@AutoConfigureMockMvc
//@ActiveProfiles("test") // application-test.yml 적용
@ActiveProfiles
class AuthControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @DisplayName("실제 DB 및 토큰 생성까지 전체 인증 테스트")
    @Test
    void login_success_integration() throws Exception {
        // testuser/testpass (data.sql에서 INSERT된 사용자)

        String jsonBody = """
            {
              "email": "user1@example.com",
              "password": "1234"
            }
            """;

        MvcResult result = mockMvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                .content(jsonBody))
                .andExpect(status().isOk())
                .andReturn();

        String jwt = result.getResponse().getContentAsString();
        System.out.println("생성된 JWT 토큰: " + jwt);

        // 토큰 구조 검증 (jwt 형식: header.payload.signature)
        org.assertj.core.api.Assertions.assertThat(jwt.split("\\.")).hasSize(3);
    }

    @DisplayName("비밀번호 오류로 로그인 실패")
    @Test
    void login_fail_wrong_password() throws Exception {
        String jsonBody = """
            {
              "email": "user1@example.com",
              "password": "$2a$10$Dow1GVdkeYyLQJd5SxZaqOBOcrX5E6C2yD.S0Vv0D4zjF3Viqx2Zq"
            }
            """;

        mockMvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andExpect(status().is4xxClientError());
    }
}