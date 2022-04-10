package me.nakashita.personal_dashboard.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import me.nakashita.personal_dashboard.security.AuthenticationType;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String name;

    @OneToMany
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@Id")
    private List<Group> groups;

    @Enumerated(EnumType.STRING)
    @Column(name = "auth_type")
    private AuthenticationType authType;

    public User() {}

    public User(String username, String password, String name, AuthenticationType authType) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.authType = authType;
    }

    public User(String username, String password, String name) {
        this(username, password, name, AuthenticationType.DATABASE);
    }

    public Map<String, Object> toJSON(){
        Map<String, Object> res = new HashMap<>();
        res.put("userId", this.id);
        res.put("name", this.name);
        res.put("username", this.username);
        res.put("authType", this.authType);
        ArrayList<Map<String, Object>> groupsLIST = new ArrayList<>();
        for(Group g : this.groups){
            groupsLIST.add(g.toJSON());
        }
        res.put("groups", groupsLIST);
        return res;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", groups=" + groups +
                ", authType=" + authType +
                '}';
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public void addGroup(Group group){
        if(this.groups == null){
            this.groups = new ArrayList<>();
        }
        this.groups.add(group);
    }

    public boolean ownGroup(Long id){
        for (Group g : this.groups) {
           if(g.getGroupId().equals(id)) {
               return true;
           }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AuthenticationType getAuthType() {
        return authType;
    }

    public void setAuthType(AuthenticationType authType) {
        this.authType = authType;
    }

    public void deleteGroupById(Long groupId) {
        for (Group g : this.groups) {
            if (g.getGroupId().equals(groupId)) {
                this.groups.remove(g);
                break;
            }
        }
    }
}
