package hu.papai.grana.repository;

import hu.papai.grana.model.DictionaryCodomain;
import hu.papai.grana.model.DictionaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface DictionaryCodomainRepository extends JpaRepository<DictionaryCodomain, Long> {

    Collection<DictionaryCodomain> findByKeyIn(Collection<DictionaryKey> key);

    DictionaryCodomain findByKey(DictionaryKey key);
}
