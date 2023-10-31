package wad._02_06_hello_form;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void titleChangesOnFormSubmit() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(not(containsString("What did one computer say to the other?"))))
                .andExpect(content().string(not(containsString("010101101010101010101"))));

        this.mockMvc.perform(post("/").param("content", "What did one computer say to the other?"))
                .andExpect(status().is3xxRedirection())
                .andReturn();

        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("What did one computer say to the other?")))
                .andExpect(content().string(not(containsString("010101101010101010101"))));

        this.mockMvc.perform(post("/").param("content", "010101101010101010101"))
                .andExpect(status().is3xxRedirection())
                .andReturn();

        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(not(containsString("What did one computer say to the other?"))))
                .andExpect(content().string(containsString("010101101010101010101")));
    }

}
