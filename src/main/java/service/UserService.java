package service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String authentificate(Long userId, String secret) {

        return "token";
    }
}
