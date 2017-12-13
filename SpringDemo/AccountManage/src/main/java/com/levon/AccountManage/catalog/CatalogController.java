package com.levon.AccountManage.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class CatalogController {
    @Autowired
    CatalogService catalogService;

    @RequestMapping("/resource")
    public Map<String,Object> resource(Principal user) {
        catalogService.getCatalogBO(user);
        Map<String,Object> model = new HashMap<String,Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("user", user.getName());
        model.put("content", "Hello World");
        return model;
    }
    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
