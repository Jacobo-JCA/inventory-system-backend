package com.softwarelabs.InventorySystem.modules.billing.common.crud;

import java.util.List;

public interface CRUD<T, ID> {
    T save(T t) throws Exception;
    List<T> readAll() throws Exception;
    T readById(ID id) throws Exception;
    T update(T t, ID id) throws Exception;
    void delete(ID id) throws Exception;
}