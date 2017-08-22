package hu.papai.grana.service;

import hu.papai.grana.controller.util.CreateUserRequestDto;
import hu.papai.grana.model.security.GranaUser;
import hu.papai.grana.repository.GranaUserRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Secured("ROLE_ADMIN")
@Service
public class GranaUserService {

    private final GranaUserRepository granaUserRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public GranaUserService(GranaUserRepository granaUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.granaUserRepository = granaUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public GranaUser save(CreateUserRequestDto newUserRequest) {
        GranaUser newUser = new GranaUser();
        newUser.setUsername(newUserRequest.getUsername());
        newUser.setPassword(bCryptPasswordEncoder.encode(newUserRequest.getPassword()));
        return granaUserRepository.save(newUser);
    }
}
