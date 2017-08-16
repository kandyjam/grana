package hu.papai.grana.service;

import hu.papai.grana.model.DictionaryCodomain;
import hu.papai.grana.model.DictionaryKey;
import hu.papai.grana.repository.DictionaryCodomainRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Service
public class DictionaryService {

    private final DictionaryCodomainRepository repository;

    public DictionaryService(DictionaryCodomainRepository repository) {
        this.repository = repository;
    }

    public Map<DictionaryKey, Collection<String>> findAll() {
        List<DictionaryCodomain> codomains = repository.findAll();
        return codomains.stream().collect(toMap(DictionaryCodomain::getKey, DictionaryCodomain::getValues));
    }

    public Map<DictionaryKey, Collection<String>> findAll(Collection<DictionaryKey> keys) {
        Collection<DictionaryCodomain> codomains = repository.findByKeyIn(keys);
        return codomains.stream().collect(toMap(DictionaryCodomain::getKey, DictionaryCodomain::getValues));
    }

    public Collection<String> getValuesForKey(DictionaryKey key) {
        return repository.findByKey(key).getValues();
    }
}
