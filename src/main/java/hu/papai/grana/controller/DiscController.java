package hu.papai.grana.controller;

import hu.papai.grana.model.Disc;
import hu.papai.grana.repository.DiscRepository;
import hu.papai.grana.service.DiscService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discs")
public class DiscController extends AbstractCrudRestController<Disc, Long, DiscRepository, DiscService> {

    protected DiscController(DiscService service) {
        super(service);
    }
}
