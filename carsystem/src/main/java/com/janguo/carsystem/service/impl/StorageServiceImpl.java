package com.janguo.carsystem.service.impl;

import com.janguo.carsystem.dao.StorageDao;
import com.janguo.carsystem.domain.StorageEntity;
import com.janguo.carsystem.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    StorageDao storageDao;

    @Override
    public List<StorageEntity> getAllStorage() {
        return storageDao.getAllStorage();
    }

    @Override
    public boolean addStorage(StorageEntity storage) {

        return storageDao.addStorage(storage);
    }

    @Override
    public StorageEntity getStorageById(String id) {
        return storageDao.getStorageById(id);
    }
}
