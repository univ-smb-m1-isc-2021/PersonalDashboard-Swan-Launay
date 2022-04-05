package me.nakashita.personal_dashboard.api.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "shortcuts")
public class Shortcut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shortcutId;

    private String name;
    private String url;
    private String headerUrl;
    private String description;
    private String keyboardShortcut;

    @ManyToOne
    private Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Long getShortcutId() {
        return shortcutId;
    }

    public void setShortcutId(Long shortcutId) {
        this.shortcutId = shortcutId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHeaderUrl() {
        return headerUrl;
    }

    public void setHeaderUrl(String headerUrl) {
        this.headerUrl = headerUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeyboardShortcut() {
        return keyboardShortcut;
    }

    public void setKeyboardShortcut(String keyboardShortcut) {
        this.keyboardShortcut = keyboardShortcut;
    }



}
