package com.smswh.smswh_backend.config.auth;

import com.smswh.smswh_backend.domain.user.User;
import com.smswh.smswh_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// /login요청이 올때 동작
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("PrincipalDetailsService의 loadUserByUsername() 실행됨");
        User userEntity = userRepository.findByNickname(username);
        System.out.println("userEntity : " + userEntity);

        return new PrincipalDetails(userEntity);
    }
}