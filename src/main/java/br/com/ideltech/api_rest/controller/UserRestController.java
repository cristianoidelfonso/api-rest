package br.com.ideltech.api_rest.controller;

import br.com.ideltech.api_rest.domain.model.User;
import br.com.ideltech.api_rest.domain.repository.UserRepository;
import br.com.ideltech.api_rest.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService, UserRepository userRepository){
        this.userService = userService;
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable(value = "id") long id) {
        User entity = userService.findById(id);
        return ResponseEntity.ok(entity);
    }


    /**
     *
     * @param user
     * @return
     */
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User userToCreate) {
        var userCreated = userService.create(userToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id")
                .buildAndExpand(userCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(userCreated);
    }



}
