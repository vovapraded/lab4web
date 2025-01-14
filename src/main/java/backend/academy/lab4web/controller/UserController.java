package backend.academy.lab4web.controller;

import backend.academy.lab4web.dto.User;
import backend.academy.lab4web.service.UserService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")  // Все URL этого контроллера будут начинаться с /api
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("login")
    private String login(@RequestBody User user) {
        return userService.login(user);
    }
    @PostMapping("register")
    private String register(@RequestBody User user) {
        return userService.create(user);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @PostMapping("auth")
    private boolean auth(@RequestBody String token) {
        try {
           return userService.checkAuth(token);
        } catch (ExpiredJwtException e){
            return false;
        }
    }

}
