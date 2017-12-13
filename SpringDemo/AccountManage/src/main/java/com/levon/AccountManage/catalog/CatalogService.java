package com.levon.AccountManage.catalog;

import com.google.common.collect.Sets;
import com.levon.AccountManage.account.UserRepository;
import com.levon.AccountManage.account.entity.Page;
import com.levon.AccountManage.account.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CatalogService {
    @Autowired
    UserRepository userRepository;
    Set<CatalogBO> getCatalogBO(Principal principal){
        User user=userRepository.findByName(principal.getName());
        Set<CatalogBO> catalogs=user.getRoles().stream()
            .flatMap(role -> role.getPrivileges().stream())
            .flatMap(privilege -> privilege.getPages().stream())
            .map(page -> createCatalogBO(page))
            .collect(Collectors.toSet());
        return catalogs;
    }

    private CatalogBO createCatalogBO(Page page){
        CatalogBO catalog=new CatalogBO();
        catalog.setName(page.getName());
        catalog.setUrl(page.getUrl());
        return catalog;
    }
}
