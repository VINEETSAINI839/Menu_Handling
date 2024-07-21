package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.pojo.Menu;
import com.app.service.MenuService;

import java.util.Map;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/update")
    public Menu updateMenu(@RequestParam Map<String, String> params) {
        return menuService.updateMenu(params);
    }
}
