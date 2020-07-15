package com.kaxi.service.impl;

import com.kaxi.entity.Reader;
import com.kaxi.repository.AdminRepository;
import com.kaxi.repository.ReaderRepository;
import com.kaxi.repository.impl.AdminRepositoryImpl;
import com.kaxi.repository.impl.ReaderRepositoryImpl;
import com.kaxi.service.LoginService;

public class LoginServiceImpl implements LoginService {
    private ReaderRepository readerRepository = new ReaderRepositoryImpl();
    private AdminRepository adminRepository = new AdminRepositoryImpl();


    @Override
    public Object login(String username, String password,String type) {
        Object object = null;
        switch (type){
            case "reader":
                object = readerRepository.login(username,password);
                break;
            case "admin":
                object = adminRepository.login(username, password);
                break;
        }
        return object;
    }
}
