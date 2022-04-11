package me.nakashita.personal_dashboard;

import me.nakashita.personal_dashboard.api.controller.GroupController;
import me.nakashita.personal_dashboard.api.controller.UserController;
import me.nakashita.personal_dashboard.api.model.Group;
import me.nakashita.personal_dashboard.api.model.User;
import me.nakashita.personal_dashboard.api.service.GroupService;
import me.nakashita.personal_dashboard.api.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class UserControllerTest {

    private UserService userService;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        userService = mock(UserService.class);
        mockMvc = standaloneSetup(new UserController(userService)).build();
    }

    @Test
    public void testGetName() throws Exception {
        when(userService.getCurrentUser())
                .thenReturn(
                        new User("username", "password", "name")
                );

        mockMvc.perform(get("/api/get-name"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"name\":\"name\"}"));
    }

}
