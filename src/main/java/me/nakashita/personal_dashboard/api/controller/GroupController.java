package me.nakashita.personal_dashboard.api.controller;

import me.nakashita.personal_dashboard.api.model.Group;
import me.nakashita.personal_dashboard.api.service.GroupService;
import me.nakashita.personal_dashboard.api.service.ShortcutService;
import me.nakashita.personal_dashboard.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private UserService userService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }


    @GetMapping("/api/get-groups")
    public List<Map<String, Object>> getShortcuts() {
        List<Map<String, Object>> res = new ArrayList<>();
        List<Group> groups = groupService.getGroupList();
        for (Group group : groups) {
            res.add(group.toJSON());
        }
        return res;
    }

    @GetMapping("/api/add-group/{groupName}")
    public Map<String, Object> addGroup(@PathVariable String groupName) {
        return groupService.saveGroup(groupName).toJSON();
    }

    @GetMapping("/api/update-group/{groupId}/{groupName}")
    public Map<String, Object> updateGroup(@PathVariable Long groupId, @PathVariable String groupName) {
        return groupService.updateGroup(groupId, groupName).toJSON();
    }

    @GetMapping("/api/delete-group/{groupId}")
    public boolean deleteGroup(@PathVariable Long groupId) {
        groupService.deleteGroup(groupId);
        return true;
    }

}
