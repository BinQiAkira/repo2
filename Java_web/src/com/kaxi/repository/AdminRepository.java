package com.kaxi.repository;

import com.kaxi.entity.Admin;

public interface AdminRepository {
    public Admin login(String username,String password);
}
