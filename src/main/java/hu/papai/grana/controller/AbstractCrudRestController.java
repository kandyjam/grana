package hu.papai.grana.controller;

import hu.papai.grana.model.AbstractEntity;
import hu.papai.grana.service.AbstractCrudService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractCrudRestController<
        T extends AbstractEntity,
        ID extends Serializable,
        R extends JpaRepository<T, ID>,
        S extends AbstractCrudService<T, ID, R>> {

    private static final String NO_ELEMENT_FOUND_MESSAGE = "No result for this id.";

    private final S service;

    protected AbstractCrudRestController(S service) {
        this.service = service;
    }

    @GetMapping
    public List<T> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable ID id) {
        T result = service.findOne(id);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Exception(NO_ELEMENT_FOUND_MESSAGE), HttpStatus.NOT_FOUND);

    }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody @Valid T element) {
        T entity = service.save(element);
        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable ID id, @RequestBody @Valid T element) {
        T entity = service.findOne(id);
        if (entity == null) {
            return new ResponseEntity<>(new Exception(NO_ELEMENT_FOUND_MESSAGE), HttpStatus.NOT_FOUND);
        }
        BeanUtils.copyProperties(element, entity);
        return new ResponseEntity<>(service.save(entity), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable ID id) {
        if (service.exists(id)) {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(new Exception(NO_ELEMENT_FOUND_MESSAGE), HttpStatus.NOT_FOUND);
    }
}
