package com.generation.blogpessoal.security;

import com.generation.blogpessoal.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailslmpl implements UserDetails {

    private static final long serialVersionUID =1L;

    private String userName;
    private String password;

    private List<GrantedAuthority> authorities;

    public UserDetailslmpl(Usuario user) {
        this.userName = user.getUsuario();
        this.password = user.getSenha();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
