package com.levon.AccountManage.catalog;

import com.levon.AccountManage.account.UserRepository;
import com.levon.AccountManage.account.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class CatalogService {
    @Autowired
    UserRepository userRepository;
    CatalogBO getCatalogBO(Principal principal){
        User user=userRepository.findByName(principal.getName());
        principal.getName();
        return new CatalogBO();
    }
}
