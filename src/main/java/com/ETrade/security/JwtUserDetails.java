package com.ETrade.security;

import com.ETrade.entities.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
public class JwtUserDetails implements UserDetails {

    private Long userId;
    private String username;
    private String password;
    private String email;
    private Date birthDate;
    private int age;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtUserDetails(Long userId, String username, String password,
                          String email, Date birthDate, int age,
                          Collection<? extends GrantedAuthority> authorities) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
        this.age = age;
        this.authorities = authorities;
    }

    public static JwtUserDetails create(User user) {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("user"));
        return new JwtUserDetails(user.getUserId(), user.getUserName(), user.getPassword(), user.getEmail(),
                user.getBirthDate(), user.getAge(), authorityList);
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
