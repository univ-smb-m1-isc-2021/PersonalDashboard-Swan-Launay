package me.nakashita.personal_dashboard.api.service;

import me.nakashita.personal_dashboard.api.model.Group;
import me.nakashita.personal_dashboard.api.model.Shortcut;
import me.nakashita.personal_dashboard.api.model.User;
import me.nakashita.personal_dashboard.api.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    @Lazy
    @Autowired
    ShortcutService shortcutService;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserService userService;

    public List<Group> getGroupList() {
        User user = userService.getCurrentUser();
        return user.getGroups();
    }

    public Optional<Group> getGroup(Long id) {
        if (userService.currentUserOwnGroup(id)) {
            return groupRepository.findById(id);
        } else {
            return Optional.empty();
        }
    }

    public Group saveGroup(Group group) {
        group.setUser(userService.getCurrentUser());
        userService.getCurrentUser().addGroup(group);
        return groupRepository.save(group);
    }

    public Group saveGroup(String name) {
        Group group = new Group(name);
        return saveGroup(group);
    }

    public Group updateGroup(Long groupId, String groupName) {
        if (userService.currentUserOwnGroup(groupId)) {
            Optional<Group> group = groupRepository.findById(groupId);
            if (group.isPresent()) {
                group.get().setName(groupName);
                return groupRepository.save(group.get());
            }
        }
        return null;
    }

    public void deleteGroup(Long groupId) {
        if (userService.currentUserOwnGroup(groupId)) {
            Optional<Group> groupOp = groupRepository.findById(groupId);
            if (groupOp.isPresent()) {
                Group group = groupOp.get();
                for (Shortcut shortcut : group.getShortcuts()) {
                    shortcutService.delete(shortcut);
                }
            }
            userService.deleteGroupById(groupId);
            groupRepository.deleteById(groupId);
        }
    }
}
