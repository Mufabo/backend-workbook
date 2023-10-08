package wad._01_07_hello_request_param;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void paramTest1() throws Exception {
        this.mockMvc.perform(get("/hello?param=value"))
                .andExpect(content().string("Hello value"));
    }

    @Test
    public void paramTest2() throws Exception {
        this.mockMvc.perform(get("/hello?param=test"))
                .andExpect(content().string("Hello test"));
    }

    @Test
    public void randomPathTest() throws Exception {
        this.mockMvc.perform(get("/" + UUID.randomUUID().toString()))
                .andExpect(status().is(404));
    }

}
