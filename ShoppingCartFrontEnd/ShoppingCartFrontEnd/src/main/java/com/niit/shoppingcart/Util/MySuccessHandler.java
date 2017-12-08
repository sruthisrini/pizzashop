package com.niit.shoppingcart.Util;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class MySuccessHandler implements AuthenticationSuccessHandler {
	public void onAuthenticationSuccess(HttpServletRequest request,
            HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
		
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("ROLE_ADMIN")){
            response.sendRedirect("/ShoppingCartFrontEnd/admin1");   
            return;
        }
        response.sendRedirect("/ShoppingCartFrontEnd/productlist1");
    }    
}
