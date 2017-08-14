package hu.papai.grana.service;

import hu.papai.grana.model.Manufacture;
import hu.papai.grana.repository.ManufactureRepository;
import org.springframework.stereotype.Service;

@Service
public class ManufactureService extends AbstractCrudService<Manufacture, Long, ManufactureRepository> {

    protected ManufactureService(ManufactureRepository repository) {
        super(repository);
    }
}
