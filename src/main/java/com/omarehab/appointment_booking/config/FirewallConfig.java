// src/main/java/com/omarehab/appointment_booking/config/FirewallConfig.java
package com.omarehab.appointment_booking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;

@Configuration
public class FirewallConfig {

    /**
     * Replace the default StrictHttpFirewall with DefaultHttpFirewall,
     * which won’t reject encoded newlines (%0A).
     */
    @Bean
    public HttpFirewall defaultHttpFirewall() {
        return new DefaultHttpFirewall();
    }

    /**
     * Wire our firewall into Spring Security.
     */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(HttpFirewall defaultHttpFirewall) {
        return web -> web.httpFirewall(defaultHttpFirewall);
    }
}
