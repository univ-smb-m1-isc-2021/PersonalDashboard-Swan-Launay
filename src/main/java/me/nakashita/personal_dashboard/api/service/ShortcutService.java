
package me.nakashita.personal_dashboard.api.service;

import lombok.Data;
import me.nakashita.personal_dashboard.api.model.Group;
import me.nakashita.personal_dashboard.api.model.Shortcut;
import me.nakashita.personal_dashboard.api.repository.ShortcutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class ShortcutService{
    @Autowired
    private ShortcutRepository shortcutRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private GroupService groupService;

    public void save(Shortcut shortcut){
        shortcutRepository.save(shortcut);
    }

    public Iterable<Shortcut> findAll(){
        List<Group> groups = userService.getCurrentUser().getGroups();
        ArrayList<Shortcut> shortcuts = new ArrayList<>();
        for (Group group : groups) {
            shortcuts.addAll(group.getShortcuts());
        }
        return shortcuts;
    }

    public Shortcut saveShortcut(Shortcut shortcut, Long groupId) {
        Optional<Group> groupOptional = groupService.getGroup(groupId);
        if (groupOptional.isPresent()) {
            System.out.println("oui");
            Group group = groupOptional.get();
            shortcut.setGroup(group);
            group.addShortcut(shortcut);
            return shortcutRepository.save(shortcut);
        }
        System.out.println("non");

        return null;
    }

    public Shortcut saveShortcut(String name, String url, String headerUrl, String description, String key, Long groupId) {
        return saveShortcut(new Shortcut(name, url, headerUrl, description, key), groupId);
    }

    public void delete(Shortcut shortcut) {
        if(shortcut != null){
            shortcutRepository.delete(shortcut);
        }
    }
}
