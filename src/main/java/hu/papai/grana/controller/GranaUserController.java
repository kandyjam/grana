package hu.papai.grana.controller;

import hu.papai.grana.controller.util.CreateUserRequestDto;
import hu.papai.grana.model.security.GranaUser;
import hu.papai.grana.service.GranaUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class GranaUserController {

    private final GranaUserService granaUserService;

    public GranaUserController(GranaUserService granaUserService) {
        this.granaUserService = granaUserService;
    }

    @PostMapping
    public ResponseEntity<GranaUser> createUser(@RequestBody @Valid CreateUserRequestDto userRequest) {
        GranaUser newUser = granaUserService.save(userRequest);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
