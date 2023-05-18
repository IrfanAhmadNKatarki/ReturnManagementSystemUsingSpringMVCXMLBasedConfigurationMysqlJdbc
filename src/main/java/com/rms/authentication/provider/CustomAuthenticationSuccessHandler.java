package com.rms.authentication.provider;

import java.io.IOException;
import java.util.Collection;
import java.util.function.Predicate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        if (authorities.stream().anyMatch(new Predicate<GrantedAuthority>() {
			@Override
			public boolean test(GrantedAuthority role) {
				return role.getAuthority().equals("ROLE_ADMIN");
			}
		})) {
            response.sendRedirect(request.getContextPath() + "/csp/home");
        } else if (authorities.stream().anyMatch(new Predicate<GrantedAuthority>() {
			@Override
			public boolean test(GrantedAuthority role) {
				return role.getAuthority().equals("ROLE_USER");
			}
		})) {
            response.sendRedirect(request.getContextPath() + "/customer/customerHome");
        } else {
            response.sendRedirect(request.getContextPath() + "/helloworld");
        }
    }
}
