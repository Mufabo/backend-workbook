package wepa._01_05_greeting;

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
	public void test1() throws Exception {
		this.mockMvc.perform(get("/greet?greeting=Greetings&name=Earthling")).andExpect(content().string("Greetings, Earthling"));
	}

	@Test
	public void paramTest2() throws Exception {
		this.mockMvc.perform(get("/greet?greeting=Oi&name=Mate")).andExpect(content().string("Oi, Mate"));
	}

	@Test
	public void randomPathTest() throws Exception {
		this.mockMvc.perform(get("/" + UUID.randomUUID().toString())).andExpect(status().is(HttpURLConnection.HTTP_NOT_FOUND));
	}

}
