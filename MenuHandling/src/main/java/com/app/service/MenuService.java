package com.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.MenuRepository;
import com.app.pojo.Menu;
import com.app.pojo.MenuEntity;

import java.util.List;
import java.util.Map;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    private Menu predefinedMenu = new Menu();

    // Initialize predefinedMenu with the given JSON structure

    public Menu updateMenu(Map<String, String> params) {
        // Perform string manipulation
        for (Map.Entry<String, String> entry : params.entrySet()) {
            replaceValue(predefinedMenu, entry.getKey(), entry.getValue());
        }

        // Save to the database
        MenuEntity entity = new MenuEntity();
        entity.setJsonModel(predefinedMenu.toString()); // Convert to JSON string
        menuRepository.save(entity);

        return predefinedMenu;
    }

    private void replaceValue(Menu menu, String oldValue, String newValue) {
        // Replace values in the Menu object
        if (menu.getValue().equals(oldValue)) {
            menu.setValue(newValue);
        }
        for (Menu.MenuItem item : menu.getPopup().getMenuitem()) {
            if (item.getValue().equals(oldValue)) {
                item.setValue(newValue);
            }
        }
    }
}
