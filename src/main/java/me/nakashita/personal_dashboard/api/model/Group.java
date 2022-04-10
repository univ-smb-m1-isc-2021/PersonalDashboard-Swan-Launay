package me.nakashita.personal_dashboard.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @Column(name = "group_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;

    private String name;

    @ManyToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@Id")
    private User user;

    @OneToMany(mappedBy = "group")
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@Id")
    private List<Shortcut> shortcuts;

    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }

    public Group(String name, User user) {
        this(name, user, null);
    }

    public Group(String name, User user, List<Shortcut> shortcuts) {
        this.name = name;
        this.user = user;
        this.shortcuts = shortcuts;
    }

    public Map<String, Object> toJSON(){
        Map<String, Object> res = new HashMap<>();
        res.put("groupId", this.getGroupId());
        res.put("userId", this.user.getId());
        res.put("name", this.name);
        ArrayList<Map<String, Object>> shortcutsLIST = new ArrayList<>();
        if(this.shortcuts != null) {
            for (Shortcut s : this.shortcuts) {
                shortcutsLIST.add(s.toJSON());
            }
        }
        res.put("shortcuts", shortcutsLIST);
        return res;
    }

    public void addShortcut(Shortcut shortcut) {
        shortcuts.add(shortcut);
    }

    public void removeShortcut(Shortcut shortcut) {
        shortcuts.remove(shortcut);
    }










/* =======================================
        SETTERS AND GETTERS
 ======================================= */


    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Shortcut> getShortcuts() {
        return shortcuts;
    }

    public void setShortcuts(List<Shortcut> shortcuts) {
        this.shortcuts = shortcuts;
    }
}
