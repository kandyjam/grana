package hu.papai.grana.service;

import hu.papai.grana.model.Fabric;
import hu.papai.grana.repository.FabricRepository;
import org.springframework.stereotype.Service;

@Service
public class FabricService extends AbstractCrudService<Fabric, Long, FabricRepository> {

    protected FabricService(FabricRepository repository) {
        super(repository);
    }
}
