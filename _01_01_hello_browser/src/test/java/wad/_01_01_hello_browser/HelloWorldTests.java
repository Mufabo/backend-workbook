package wad._01_01_hello_browser;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloWorldTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void helloWorldTest() throws Exception {
		this.mockMvc.perform(get("/"))
				.andExpect(content().string("Hello World!"));
	}

	@Test
	public void helloWorldAnyUrlTest() throws Exception {
		this.mockMvc.perform(get("/" + UUID.randomUUID().toString()))
				.andExpect(content().string("Hello World!"));

	}

}
