package me.nakashita.personal_dashboard;

import me.nakashita.personal_dashboard.api.model.Group;
import me.nakashita.personal_dashboard.api.model.Shortcut;
import me.nakashita.personal_dashboard.api.model.User;
import me.nakashita.personal_dashboard.security.AuthenticationType;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void testOwnShortcut() {
        Shortcut shortcut = new Shortcut("name", "url", "headerUrl", "description", "k");
        shortcut.setShortcutId(666L);

        Group group = new Group("GroupName");
        group.setGroupId(123L);
        group.addShortcut(shortcut);

        User user = new User("username", "pass", "name", AuthenticationType.DATABASE);
        user.addGroup(group);

        assert user.ownShortcut(shortcut.getShortcutId());
    }

    @Test
    public void testOwnGroup() {
        Group group = new Group("GroupName");
        group.setGroupId(123L);
        User user = new User("username", "pass", "name", AuthenticationType.DATABASE);
        user.addGroup(group);

        assert user.ownGroup(group.getGroupId());
    }

    @Test
    public void testDeleteGroupById() {
        Group group = new Group("GroupName");
        group.setGroupId(123L);
        User user = new User("username", "pass", "name", AuthenticationType.DATABASE);
        user.addGroup(group);

        assert user.ownGroup(group.getGroupId());

        user.deleteGroupById(group.getGroupId());

        assert !user.ownGroup(group.getGroupId());
    }
}
