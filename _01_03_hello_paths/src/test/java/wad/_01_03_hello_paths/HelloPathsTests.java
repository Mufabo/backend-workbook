package wad._01_03_hello_paths;

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
class HelloPathsTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void helloTest() throws Exception {
		this.mockMvc.perform(get("/hello"))
			.andExpect(content().string("hello"));
	}

	@Test
	public void pathTest() throws Exception {
		this.mockMvc.perform(get("/paths")).andExpect(content().string("Paths")));
	}

	@Test
	public void invalidPathTest() throws Exception {
		this.mockMvc.perform(get("/" + UUID.randomUUID().toString())).andExpect(status().is(HttpURLConnection.HTTP_NOT_FOUND));
	}


}