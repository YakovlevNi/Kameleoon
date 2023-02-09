package main.java.Quote.model;

import jakarta.persistence.GeneratedValue;
import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMINISTRATOR, BANNED_User;

    @Override
    public String getAuthority() {
        return name();
    }
}
