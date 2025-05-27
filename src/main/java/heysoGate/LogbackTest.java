package heysoGate;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

// @Component
public class LogbackTest {

    private static final Logger log = LoggerFactory.getLogger(LogbackTest.class);

    // @PostConstruct
    public void init() {
        log.trace("TRACE 레벨 로그입니다.");
        log.debug("DEBUG 레벨 로그입니다.");
        log.info("INFO 레벨 로그입니다.");
        log.warn("WARN 레벨 로그입니다.");
        log.error("ERROR 레벨 로그입니다.");
    }
}