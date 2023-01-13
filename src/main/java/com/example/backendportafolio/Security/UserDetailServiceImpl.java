package com.example.backendportafolio.Security;

import com.example.backendportafolio.Models.UserModel;
import com.example.backendportafolio.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService  {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserModel usuario= userRepository.findOneByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("El usuario con email "+ "no existe"));
        return new UserDetailsImpl(usuario);
    }
}
