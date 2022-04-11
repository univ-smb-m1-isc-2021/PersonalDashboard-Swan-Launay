package me.nakashita.personal_dashboard;

import me.nakashita.personal_dashboard.api.model.Group;
import me.nakashita.personal_dashboard.api.model.Shortcut;
import org.junit.jupiter.api.Test;

public class GroupTest {

    @Test
    public void testAddShortcut() {
        Group group = new Group();
        Shortcut shortcut = new Shortcut();
        group.addShortcut(shortcut);
        assert group.getShortcuts().contains(shortcut);
    }

    @Test
    public void removeShortcut() {
        Group group = new Group();
        Shortcut shortcut = new Shortcut();
        group.addShortcut(shortcut);
        assert group.getShortcuts().contains(shortcut);
        group.removeShortcut(shortcut);
        assert !group.getShortcuts().contains(shortcut);
    }
}
