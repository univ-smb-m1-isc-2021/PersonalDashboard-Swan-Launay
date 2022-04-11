package me.nakashita.personal_dashboard;

import me.nakashita.personal_dashboard.api.model.User;
import me.nakashita.personal_dashboard.api.repository.UserRepository;
import me.nakashita.personal_dashboard.api.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    private UserRepository userRepository;
    private UserService userService;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        userRepository = mock(UserRepository.class);
        userService = new UserService(userRepository);
    }

    @Test
    public void testIsExist() {
        when(userRepository.getUserByUsername("name")).thenReturn(new User());

        assertTrue(userService.isExist("name"));
    }

    @Test
    public void testSaveUser() {
        User user = new User();

        when(userRepository.save(user)).thenReturn(user);

        assertTrue(userService.saveUser(user) != null);
    }

    @Test
    public void testGetByUsername() {
        when(userRepository.getUserByUsername("name")).thenReturn(new User());

        assertTrue(userService.getUserByUsername("name") != null);
    }
    /*
    @Test
    public void testCurrentUserOwnGroup(){
        User user = new User();
        Group group = new Group();
        group.setGroupId(1L);
        user.addGroup(group);

        when(userService.getCurrentUser())
                .thenReturn(user);

        assertTrue(userService.currentUserOwnGroup(1L));
    }
    */

}
