package backend.academy.lab4web.service;

import backend.academy.lab4web.dto.User;
import backend.academy.lab4web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private final JwtService jwtService;
    @Autowired
    public UserService(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public String create(User user) {
        // Проверяем, существует ли пользователь с данным логином
        if (userRepository.findByLogin(user.getLogin()).isPresent()) {
            throw new IllegalArgumentException("Пользователь с таким логином уже существует.");
        }
        // Создаем нового пользователя
        User newUser = user.withPassword(encoder.encode(user.getPassword()));
        userRepository.save(newUser);
        return jwtService.generateToken(newUser);
    }
    public String login(User user) {
       return userRepository.findByLogin(user.getLogin())
                .map(u -> {
                    if (!encoder.matches(user.getPassword(), u.getPassword())){
                        throw new IllegalArgumentException("Пароль не верный");

                    }
                    return jwtService.generateToken(u);
                })
                .orElseThrow(() -> new IllegalArgumentException("Пользователь с таким логином не найден"));
    }
    public boolean checkAuth(String token) {
        return jwtService.isTokenValid(token);
    }
}
