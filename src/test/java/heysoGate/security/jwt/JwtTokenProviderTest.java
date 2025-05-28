package heysoGate.security.jwt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class JwtTokenProviderTest {
    private static final Logger log = LoggerFactory.getLogger(JwtTokenProviderTest.class);
    JwtTokenProvider provider;

    @BeforeEach
    void setup() {
        provider = new JwtTokenProvider();
        // 직접 필드 주입 or reflection or setter 사용
        ReflectionTestUtils.setField(provider, "secretKeyPlain", "58pAj59IBhGA9O5armXSD7MN1Z7wRtn2t3LKJsoGVTU=");
        ReflectionTestUtils.setField(provider, "validityInMs", 3600000L);
        provider.init();
    }

    @Test
    void create_and_parse_token() {
        String token = provider.createToken("testUser", "ADMIN");
        assertThat(token).isNotEmpty();

        log.info(token);

        assertThat(provider.validateToken(token)).isTrue();
        assertThat(provider.getEmail(token)).isEqualTo("testUser");
        assertThat(provider.getRole(token)).isEqualTo("ADMIN");
    }

    @Test
    void expired_token_should_be_invalid() throws InterruptedException {
        ReflectionTestUtils.setField(provider, "validityInMs", 1L);
        provider.init();
        String token = provider.createToken("testUser", "USER");
        Thread.sleep(5);
        assertThat(provider.validateToken(token)).isFalse();
    }
}
