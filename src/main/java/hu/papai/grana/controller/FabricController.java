package hu.papai.grana.controller;

import hu.papai.grana.model.Fabric;
import hu.papai.grana.repository.FabricRepository;
import hu.papai.grana.service.FabricService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fabrics")
public class FabricController extends AbstractCrudRestController<Fabric, Long, FabricRepository, FabricService> {

    protected FabricController(FabricService service) {
        super(service);
    }
}
