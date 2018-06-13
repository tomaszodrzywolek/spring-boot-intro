package pl.todrzywolek.springtask.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenAuthenticationFilter extends OncePerRequestFilter {


    @Autowired
    private TokenHelper tokenHelper;

    private UserDetailsService userDetailsService;

    @Autowired
    public TokenAuthenticationFilter(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {

        String error = "";
        String authToken = tokenHelper.getToken(request);
        if (authToken != null) {

            // Get username from token
            String username = tokenHelper.getUsernameFromToken( authToken );
            if (username != null) {

                // get user
                UserDetails userDetails = userDetailsService.loadUserByUsername( username );

                // create authentication
                TokenBasedAuthentication authentication = new TokenBasedAuthentication( userDetails );
                authentication.setToken( authToken );
                SecurityContextHolder.getContext().setAuthentication( authentication );
            }
            else {
                error = "Username from token can't be found";
            }

        }
        if (!error.equals("")) {
            SecurityContextHolder.getContext().setAuthentication(new AnonAuthentication()); // prevent show login form
        }
        chain.doFilter(request, response);
    }
}