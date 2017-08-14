package hu.papai.grana.controller;

import hu.papai.grana.model.Manufacture;
import hu.papai.grana.repository.ManufactureRepository;
import hu.papai.grana.service.ManufactureService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manufactures")
public class ManufactureController extends AbstractCrudRestController<Manufacture, Long, ManufactureRepository, ManufactureService> {

    protected ManufactureController(ManufactureService service) {
        super(service);
    }
}
