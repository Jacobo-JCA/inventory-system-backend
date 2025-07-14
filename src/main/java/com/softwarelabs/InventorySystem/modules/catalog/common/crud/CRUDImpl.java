package com.softwarelabs.InventorySystem.modules.catalog.common.crud;

import com.softwarelabs.InventorySystem.modules.catalog.exception.NotFoundException;
import com.softwarelabs.InventorySystem.modules.catalog.repo.GenericCatalogRepo;

import java.util.List;

public abstract class CRUDImpl<T, ID> implements CRUD<T, ID> {
    protected abstract GenericCatalogRepo<T, ID> getRepo();

    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public List<T> readAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T readById(ID id) throws Exception {
        return getRepo().findById(id).orElseThrow(() -> new NotFoundException("ID NOT EXISTS: " + id));
    }

    @Override
    public T update(T t, ID id) throws Exception {
        getRepo().findById(id).orElseThrow(() -> new NotFoundException("ID NOT EXISTS: " + id));
        return getRepo().save(t);
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().findById(id).orElseThrow(() -> new NotFoundException("ID NOT EXISTS: " + id));
        getRepo().deleteById(id);
    }
}
