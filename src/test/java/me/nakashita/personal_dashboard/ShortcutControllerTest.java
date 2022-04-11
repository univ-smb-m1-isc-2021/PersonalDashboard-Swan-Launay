package me.nakashita.personal_dashboard;

import me.nakashita.personal_dashboard.api.controller.ShortcutController;
import me.nakashita.personal_dashboard.api.service.ShortcutService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class ShortcutControllerTest {

    private ShortcutService shortcutService;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        shortcutService = mock(ShortcutService.class);
        mockMvc = standaloneSetup(new ShortcutController(shortcutService)).build();
    }

    @Test
    public void testAddShortcut() throws Exception {
        /*
        when(shortcutService.saveShortcut("name", "url", "headerUrl", "desc", "key", 1L))
                .thenReturn(
                        new Shortcut("name", "url", "headerUrl", "desc", "key")
                );

        HashMap<String, String> params = new HashMap<>();
        params.put("name", "name");
        params.put("url", "url");
        params.put("headerUrl", "headerUrl");
        params.put("desc", "desc");
        params.put("key", "key");
        params.put("groupId", "1");

        String paramsJson = new ObjectMapper().writeValueAsString(params);


        MvcResult res = mockMvc.perform(post("/api/add-shortcut").content(paramsJson))
                .andExpect(status().isOk())
                .andReturn();
                //.andExpect(content().string("{\"name\":\"name\"}"));
        System.out.println(res.getResponse().getContentAsString());
        */
    }

    @Test
    public void testRemoveShortcut() throws Exception {

        when(shortcutService.removeById(1L)).thenReturn(true);

        HashMap<String, String> params = new HashMap<>();
        params.put("id", "1");

        mockMvc.perform(get("/api/remove-shortcut/1")).andExpect(status().isOk()).andExpect(content().string("true"));
    }


}
