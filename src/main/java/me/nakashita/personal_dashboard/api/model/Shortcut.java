package me.nakashita.personal_dashboard.api.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Data
@Entity
@Table(name = "shortcuts")
public class Shortcut {

    @Id
    @Column(name = "shortcut_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shortcutId;

    private String name;
    private String url;
    private String headerUrl;
    private String description;
    private String keyboardShortcut;

    public Shortcut() {
        //Used for JPA.user =
        this.name = name;
    }

    public Shortcut(String name, String url, String headerUrl, String description, String keyboardShortcut) {
        this.name = name;
        this.url = url;
        this.headerUrl = headerUrl;
        this.description = description;
        this.keyboardShortcut = keyboardShortcut;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private Group group;

    public Map<String, Object> toJSON(){
        Map<String, Object> res = new HashMap<>();
        res.put("shortcutId", this.shortcutId);
        res.put("userId", this.group.getUser().getId());
        res.put("groupId", this.group.getGroupId());
        res.put("name", this.name);
        res.put("url", this.url);
        res.put("headerUrl", this.headerUrl);
        res.put("description", this.description);
        res.put("keyboardShortcut", this.keyboardShortcut);
        return res;
    }

    @Override
    public String toString() {
        return "Shortcut{" +
                "shortcutId=" + shortcutId +
                "groupId='" + group.getGroupId() + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", headerUrl='" + headerUrl + '\'' +
                ", description='" + description + '\'' +
                ", keyboardShortcut='" + keyboardShortcut + '\'' +
                '}';
    }

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
