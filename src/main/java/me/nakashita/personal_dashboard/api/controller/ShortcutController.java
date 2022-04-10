package me.nakashita.personal_dashboard.api.controller;

import me.nakashita.personal_dashboard.api.model.Group;
import me.nakashita.personal_dashboard.api.model.Shortcut;
import me.nakashita.personal_dashboard.api.service.GroupService;
import me.nakashita.personal_dashboard.api.service.ShortcutService;
import me.nakashita.personal_dashboard.api.service.UserService;
import net.bytebuddy.implementation.bytecode.ShiftLeft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ShortcutController {

    @Autowired
    private UserService userService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private ShortcutService shortcutService;


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

}
