package br.com.alexmdo.codecademy.portfolioproject.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;
    
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        var createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
    
    @PutMapping("/{displayName}")
    public ResponseEntity<User> updateUser(@PathVariable String displayName, @RequestBody User user) {
        user.setDisplayName(displayName);
        var updatedUser = userService.updateUser(user);
        return ResponseEntity.ok(updatedUser);
    }
    
    @GetMapping("/{displayName}")
    public ResponseEntity<User> getUserByDisplayName(@PathVariable String displayName) {
        var user = userService.getUserByDisplayName(displayName);
        return ResponseEntity.ok(user);
    }
    
}
