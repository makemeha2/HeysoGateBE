package heysoGate.controller;

import heysoGate.domain.User;
import heysoGate.dto.LoginRequestDto;
import heysoGate.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthController.class)
class AuthControllerTest {
//    @Autowired
//    private MockMvc mockMvc;    // MEMO: 이게 뭘까?
//
//    @MockBean
//    private UserMapper userMapper;
//
//    @MockBean
//    private AuthenticationManager authenticationManager;
//
//    @MockBean
//    private heysoGate.security.jwt.JwtTokenProvider jwtTokenProvider;
//
//    @MockBean
//    private org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;
//
//    @Test
//    void login_success() throws Exception {
//        User user = new User();
//        user.setEmail("user1@example.com");
//        user.setPassword("$2a$10$Dow1GVdkeYyLQJd5SxZaqOBOcrX5E6C2yD.S0Vv0D4zjF3Viqx2Zq");
//        user.setRole("ADMIN");
//
//        Mockito.when(userMapper.findByEmail("user1@example.com")).thenReturn(user);
//        Mockito.when(passwordEncoder.matches("1234", "$2a$10$Dow1GVdkeYyLQJd5SxZaqOBOcrX5E6C2yD.S0Vv0D4zjF3Viqx2Zq")).thenReturn(true);
//        Mockito.when(jwtTokenProvider.createToken("user1@example.com", "USER")).thenReturn("MOCK_TOKEN");
//
//        LoginRequestDto dto = new LoginRequestDto("user1@example.com", "1234");
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/login")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("""
//                        {
//                          "email": "user1@example.com",
//                          "password": "1234"
//                        }
//                        """)
//                )
//                .andExpect(status().isOk());
//                //.andExpect(content().string("MOCK_TOKEN"));
//    }
//
//    @Test
//    void login_fail_wrong_password() throws Exception {
////        User user = new User();
////        user.setUsername("testUser");
////        user.setPassword("encodedPwd");
////        user.setRole("ADMIN");
////
////        Mockito.when(userMapper.findByUsername("testUser")).thenReturn(user);
////        Mockito.when(passwordEncoder.matches("wrongPwd", "encodedPwd")).thenReturn(false);
////
////        mockMvc.perform(MockMvcRequestBuilders.post("/login")
////                        .contentType(MediaType.APPLICATION_JSON)
////                        .content("""
////                        {
////                          "username": "testUser",
////                          "password": "wrongPwd"
////                        }
////                        """)
////                )
////                .andExpect(status().is4xxClientError());
//    }
}