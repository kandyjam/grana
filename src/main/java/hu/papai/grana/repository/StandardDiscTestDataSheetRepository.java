package hu.papai.grana.repository;

import hu.papai.grana.model.StandardDiscTestDataSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandardDiscTestDataSheetRepository extends JpaRepository<StandardDiscTestDataSheet, Long> {
}
