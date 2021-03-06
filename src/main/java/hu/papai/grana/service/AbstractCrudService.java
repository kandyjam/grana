package hu.papai.grana.service;

import hu.papai.grana.model.AbstractEntity;
import hu.papai.grana.model.security.AuthorityConstants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.annotation.Secured;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractCrudService<
        T extends AbstractEntity,
        ID extends Serializable,
        R extends JpaRepository<T, ID>
    > {

    private final R repository;

    protected AbstractCrudService(R repository) {
        this.repository = repository;
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public List<T> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<T> findAll(Iterable<ID> ids) {
        return repository.findAll(ids);
    }

    public long count() {
        return repository.count();
    }

    @Secured(AuthorityConstants.ROLE_MANAGER)
    public void delete(ID id) {
        repository.delete(id);
    }

    @Secured(AuthorityConstants.ROLE_MANAGER)
    public void delete(T entity) {
        repository.delete(entity);
    }

    @Secured(AuthorityConstants.ROLE_MANAGER)
    public void delete(Iterable<? extends T> entities) {
        repository.delete(entities);
    }

    @Secured(AuthorityConstants.ROLE_MANAGER)
    public void deleteAll() {
        repository.deleteAll();
    }

    @Secured(AuthorityConstants.ROLE_OPERATOR)
    public T save(T entity) {
        return repository.save(entity);
    }

    @Secured(AuthorityConstants.ROLE_OPERATOR)
    public List<T> save(Iterable<T> entities) {
        return repository.save(entities);
    }

    public T findOne(ID id) {
        return repository.findOne(id);
    }

    public boolean exists(ID id) {
        return repository.exists(id);
    }
}
