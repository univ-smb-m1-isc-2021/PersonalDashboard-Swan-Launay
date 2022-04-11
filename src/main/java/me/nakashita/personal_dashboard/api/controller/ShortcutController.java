package me.nakashita.personal_dashboard.api.controller;

import me.nakashita.personal_dashboard.api.service.GroupService;
import me.nakashita.personal_dashboard.api.service.ShortcutService;
import me.nakashita.personal_dashboard.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ShortcutController {

    @Autowired
    private ShortcutService shortcutService;

    public ShortcutController(ShortcutService shortcutService) {
        this.shortcutService = shortcutService;
    }

    @PostMapping("/api/add-shortcut")
    public Map<String, Object> addShortcut(@RequestBody HashMap<String, String> json) {
        return shortcutService.saveShortcut(
                json.get("name"),
                json.get("url"),
                json.get("headerUrl"),
                json.get("desc"),
                json.get("key"),
                Long.parseLong(json.get("groupId"))
        ).toJSON();
    }

    @GetMapping("/api/remove-shortcut/{id}")
    public boolean removeShortcut(@PathVariable Long id) {
        return shortcutService.removeById(id);
    }

    @PostMapping("/api/update-shortcut/{id}")
    public Map<String, Object> updateShortcut(@PathVariable Long id, @RequestBody HashMap<String, String> json) {
        return shortcutService.updateShortcut(
                id,
                json.get("name"),
                json.get("url"),
                json.get("headerUrl"),
                json.get("desc"),
                json.get("key")
        ).toJSON();
    }

}
