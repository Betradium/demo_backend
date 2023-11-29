package com.example.demo.security;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays; 

@Component
public class JwtToPrincipalConverter {

    public UserPrincipal convert(DecodedJWT jwt) {
        return UserPrincipal.builder()
                .id(Long.valueOf(jwt.getSubject()))
                .email(jwt.getClaim("email").asString())
                .authorities(extractAuthFromClaim(jwt))
                .build();
    }

    private List<SimpleGrantedAuthority> extractAuthFromClaim(DecodedJWT jwt) {
        Claim claim = jwt.getClaim("userRoles");
        if (claim.isNull() || claim.isMissing()) return List.of();
        String[] rolesArray = claim.asArray(String.class);
        List<SimpleGrantedAuthority> authorities = Arrays.stream(rolesArray)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return authorities;
    }
}
