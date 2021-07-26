package com.socin.user;

import com.socin.persistence.entity.User;
import com.socin.persistence.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO: Move logic to service.
 */
@RestController
@RequestMapping({"/users"})
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private static final String messageReturn = "Não foi possível retornar as informações dos usuários.";

    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService,
                          UserRepository userRepository) {

        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity findAll(){
        try {
            List<User> userList = userRepository.findAll();

            for (User user: userList) {
                user.setPassword("");
            }

            return ResponseEntity.ok(userList);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable Integer id) {

        return userRepository.findById(id)
                .map(record -> {
                    record.setPassword("");
                    return ResponseEntity.ok().body(record);
                }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public User create(@RequestBody User user) {
        try {
            User userToSave = new User();

            userToSave.setPassword(UserService.sha256(user.getPassword()));
            userToSave.setName(user.getName());
            userToSave.setEmail(user.getEmail());
            userToSave.setAccountNonLocked(true);

            userRepository.save(userToSave);

            userToSave.setPassword("");

            return userToSave;
        } catch (Exception exception) {
            return user;
        }
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") Integer id,
                                 @RequestBody User user) {

        return userRepository.findById(id)
                .map(record -> {
                    record.setName(user.getName());
                    record.setEmail(user.getEmail());
                    record.setAccountNonLocked(true);

                    if (null != user.getPassword() && !user.getPassword().isEmpty()) {
                        record.setPassword(UserService.sha256(user.getPassword()));
                    }

                    User updated = userRepository.save(record);

                    updated.setPassword("");

                    return ResponseEntity.ok().body(updated);

                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return userRepository.findById(id)
                .map(record -> {
                    userRepository.deleteById(id);

                    return ResponseEntity.ok().build();

                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/find/{id}")
    public User findUserById(@PathVariable("id") int id){
        return userRepository.findUserById(id);
    }
}