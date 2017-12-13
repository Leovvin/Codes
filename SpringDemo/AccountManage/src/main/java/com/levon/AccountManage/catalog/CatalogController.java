package com.levon.AccountManage.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@RestController
public class CatalogController {
    @Autowired
    CatalogService catalogService;

    @RequestMapping("/resource")
    public Set<CatalogBO> resource(Principal user) {
        Set<CatalogBO> catalogs=catalogService.getCatalogBO(user);
        return catalogs;
    }
    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
