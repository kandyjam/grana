package hu.papai.grana.service;

import hu.papai.grana.model.Disc;
import hu.papai.grana.repository.DiscRepository;
import org.springframework.stereotype.Service;

@Service
public class DiscService extends AbstractCrudService<Disc, Long, DiscRepository> {

    protected DiscService(DiscRepository repository) {
        super(repository);
    }
}
