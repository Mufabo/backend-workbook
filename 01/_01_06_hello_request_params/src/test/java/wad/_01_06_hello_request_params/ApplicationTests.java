package wad._01_06_hello_request_params;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.HttpURLConnection;
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
	public void singleParamTest() throws Exception {
		this.mockMvc.perform(get("/hello?param=value")).andExpect(content().string("Hello value"));
	}

	@Test
	public void singleParamTest2() throws Exception {
		this.mockMvc.perform(get("/hello?param=test")).andExpect(content().string("Hello test"));
	}

	 @Test
    public void multiParamsTest() throws Exception {
        this.mockMvc.perform(get("/params?aaa=aaa&bbb=bbb&ccc=ccc&ddd=ddd"))
                .andExpect(content().string(containsString("aaa")))
                .andExpect(content().string(containsString("bbb")))
                .andExpect(content().string(containsString("ccc")))
                .andExpect(content().string(containsString("ddd")))
                .andExpect(content().string(not(containsString("x"))));
    }
    
    @Test
    public void multiParamsTest2() throws Exception {
        this.mockMvc.perform(get("/params?x=aaa&y=bbb"))
                .andExpect(content().string(containsString("x")))
                .andExpect(content().string(containsString("y")))
                .andExpect(content().string(not(containsString("ccc"))));
    }

    @Test
    public void randomPathTest() throws Exception {
        this.mockMvc.perform(get("/" + UUID.randomUUID().toString()))
                .andExpect(status().is(HttpURLConnection.HTTP_NOT_FOUND));
    }


}
