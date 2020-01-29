package com.bibliotheque.security;

import com.bibliotheque.repository.repository.LoginRepository;
import livres.wsdl.MembreType;
import livres.wsdl.ServiceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

/*

@Service
public class CustomAuthentication implements AuthenticationProvider {


    @Autowired
    private LoginRepository login;

    @Autowired
    private HttpSession session;

    @Autowired
    private User user;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        Collection<SimpleGrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(user.getRole()));

        Optional<ServiceStatus> serviceStatus = login.login
                (authentication.getName(), authentication.getCredentials().toString());


        if (serviceStatus.get().getStatusCode().equals("SUCCESS")){

            MembreType membreType = login.getCompteAfterLoginSuccess(authentication.getName());
            User user = new User(membreType.getId(), membreType.getPrenom());

            session.setAttribute("user", user);

            return new UsernamePasswordAuthenticationToken
                    (authentication.getName(), authentication.getCredentials().toString(), roles);
        } else {
            session.setAttribute("loginError", serviceStatus.get().getStatusCode());
            throw new BadCredentialsException("Authentication failed");
        }
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}

*/
