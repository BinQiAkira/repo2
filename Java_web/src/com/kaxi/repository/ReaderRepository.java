package com.kaxi.repository;

import com.kaxi.entity.Reader;

public interface ReaderRepository {
    public Reader login(String username,String password);
}
