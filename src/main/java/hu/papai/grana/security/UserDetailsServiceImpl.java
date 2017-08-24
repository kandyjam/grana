package hu.papai.grana.security;

import hu.papai.grana.model.security.GranaUser;
import hu.papai.grana.repository.GranaUserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final GranaUserRepository repository;

    public UserDetailsServiceImpl(GranaUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        GranaUser user = repository.findByUsername(username);

        if (user != null) {
            List<GrantedAuthority> authorities = user.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toList());
            return new User(user.getUsername(), user.getPassword(), authorities);
        }
        throw new UsernameNotFoundException("No user was found for username: " + username);
    }
}
