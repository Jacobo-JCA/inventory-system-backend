package com.softwarelabs.InventorySystem.modules.catalog.service.impl;

import com.softwarelabs.InventorySystem.modules.catalog.entity.Category;
import com.softwarelabs.InventorySystem.modules.catalog.repo.CategoryRepo;
import com.softwarelabs.InventorySystem.modules.catalog.service.CategoryService;
import com.softwarelabs.InventorySystem.modules.catalog.common.crud.CRUDImpl;
import com.softwarelabs.InventorySystem.modules.catalog.repo.GenericCatalogRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoryServiceImp extends CRUDImpl<Category, Long> implements CategoryService {
    private final CategoryRepo categoryRepo;

    @Override
    protected GenericCatalogRepo<Category, Long> getRepo() {
        return categoryRepo;
    }

    @Override
    public Category update(Category category, Long aLong) throws Exception {
        category.setIdCategory(aLong);
        return super.update(category, aLong);
    }
}
