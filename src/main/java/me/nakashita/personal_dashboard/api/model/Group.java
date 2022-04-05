package me.nakashita.personal_dashboard.api.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String groupdId;

    private String name;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "group")
    private List<Shortcut> shortcuts;


    public String getGroupdId() {
        return groupdId;
    }

    public void setGroupdId(String groupdId) {
        this.groupdId = groupdId;
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
