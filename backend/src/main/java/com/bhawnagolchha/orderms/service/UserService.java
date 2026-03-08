package com.bhawnagolchha.orderms.service;

import com.bhawnagolchha.orderms.domain.User;
import com.bhawnagolchha.orderms.exceptions.UserNotFoundException;
import com.bhawnagolchha.orderms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(() ->new UserNotFoundException("email",email));
    }

    public User createUser(User user){
        return userRepository.save(user);
    }
}
