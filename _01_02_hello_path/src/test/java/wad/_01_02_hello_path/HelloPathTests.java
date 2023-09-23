package wad._01_02_hello_path;

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
class HelloPathTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void pathTest() throws Exception {
		this.mockMvc.perform(get("/path"))
			.andExpect(content().string("Correct!"));
	}

	@Test
	public void invalidPathTest() throws Exception {
		this.mockMvc.perform(get("/paths")).andExpect(status().is(HttpURLConnection.HTTP_NOT_FOUND));
	}

	@Test
	public void invalidPathTest2() throws Exception {
		this.mockMvc.perform(get("/" + UUID.randomUUID().toString())).andExpect(status().is(HttpURLConnection.HTTP_NOT_FOUND));
	}


}
