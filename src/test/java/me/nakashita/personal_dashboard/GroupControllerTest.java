package me.nakashita.personal_dashboard;

import me.nakashita.personal_dashboard.api.controller.GroupController;
import me.nakashita.personal_dashboard.api.model.Group;
import me.nakashita.personal_dashboard.api.model.User;
import me.nakashita.personal_dashboard.api.service.GroupService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class GroupControllerTest {

    private GroupService groupService;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        groupService = mock(GroupService.class);
        mockMvc = standaloneSetup(new GroupController(groupService)).build();
    }

    @Test
    public void testGetGroups() throws Exception {
        when(groupService.getGroupList())
                .thenReturn(
                        List.of(
                                new Group("group1", new User()),
                                new Group("group2", new User())
                        )
                );

        mockMvc.perform(get("/api/get-groups"))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"groupId\":null,\"name\":\"group1\",\"shortcuts\":[],\"userId\":null},{\"groupId\":null,\"name\":\"group2\",\"shortcuts\":[],\"userId\":null}]"));
    }

    @Test
    public void testAddGroup() throws Exception {
        when(groupService.saveGroup("group1"))
                .thenReturn(
                        new Group("group1", new User())
                );

        mockMvc.perform(get("/api/add-group/group1"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"groupId\":null,\"name\":\"group1\",\"shortcuts\":[],\"userId\":null}"));
    }

    @Test
    public void testUpdateGroup() throws Exception {
        when(groupService.updateGroup(1L, "group1"))
                .thenReturn(
                        new Group("group1", new User())
                );

        mockMvc.perform(get("/api/update-group/1/group1"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"groupId\":null,\"name\":\"group1\",\"shortcuts\":[],\"userId\":null}"));
    }

    @Test
    public void testDeleteGroup() throws Exception {
        mockMvc.perform(get("/api/delete-group/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }
}
