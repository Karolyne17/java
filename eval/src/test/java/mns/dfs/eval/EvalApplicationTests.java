package mns.dfs.eval;

import mns.dfs.eval.models.Article;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EvalApplicationTests {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@BeforeEach
	private void init (){

		mvc = MockMvcBuilders
				.webAppContextSetup(context)
				.build();
	}

	@Test
	void contextLoads() {
	}

	@Test
	void appelApiGetListeEmploye_obtientCode200() throws Exception {
		mvc.perform(get("/liste-employe")).andExpect(status().isOk());
	}

	@Test
	void appelApiGetListeCommande_obtientCode200() throws Exception {
		mvc.perform(get("/liste-commande")).andExpect(status().isOk());
	}

}
