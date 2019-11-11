package com.example.demo.domain;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "USERS")
@Data
@RequiredArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
public class User implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    @NotEmpty(message = "Vul username in aub")
    private String username;

    @Column
    @NotEmpty(message = "Vul wachtwoord in aub")
    private String password;

    @Column
    private String role;

    @NotEmpty(message = "Vul voornaam in aub")
    private String firstName;

    @Column
    @NotEmpty(message = "Vul achternaam in aub")
    private String lastName;

    @Column
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$", message = "Vul een geldig e-mail adres in ")
    private String email;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword()
    {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
