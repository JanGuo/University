package com.janguo.carsystem.service;

import com.janguo.carsystem.domain.StorageEntity;

import java.util.List;

public interface StorageService {
    List<StorageEntity> getAllStorage();
    boolean addStorage(StorageEntity storage);
    StorageEntity getStorageById(String id);

}
