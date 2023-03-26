package com.example.mdbspringboot.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "eats")
@Data
public class EATSConfig {
    private EATS dir;
    @Data
    public static class EATS {
        private String in;
        private String out;
        private String archive;
    }
}
