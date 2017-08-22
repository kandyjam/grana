package hu.papai.grana.repository;

import hu.papai.grana.model.security.GranaUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GranaUserRepository extends JpaRepository<GranaUser, Long> {
    GranaUser findByUsername(String username);
}
