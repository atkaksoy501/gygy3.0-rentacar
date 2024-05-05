package com.turkcell.rentacar.core.filters;


import com.turkcell.rentacar.business.abstracts.CustomerService;

import com.turkcell.rentacar.core.services.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsService customerService;
    @Override
    protected void doFilterInternal(
                                @NonNull HttpServletRequest request,
                                @NonNull HttpServletResponse response,
                                @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        // jwtyi oku
        // anahtara aitmi kontrol et
        // geçerlimi ?

        String jwtHeader = request.getHeader("Authorization");

        if(jwtHeader != null && jwtHeader.startsWith("Bearer ")){
            String jwt = jwtHeader.substring(7);
            String username = jwtService.extractUser(jwt);

            if(username != null){

                UserDetails user = customerService.loadUserByUsername(username);

                if(jwtService.validateToken(jwt,user)){

                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());

                    authenticationToken
                            .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                }
            }

        }

        filterChain.doFilter(request,response);

    }
}
