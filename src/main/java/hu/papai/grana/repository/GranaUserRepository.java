package hu.papai.grana.repository;

import hu.papai.grana.model.security.GranaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GranaUserRepository extends JpaRepository<GranaUser, Long> {
    GranaUser findByUsername(String username);
}
