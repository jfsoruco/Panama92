package sr.core;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Extending this class allows to test specific controllers and mock
 * dependencies but lacks of context enabled
 * 
 * @author juan.soruco
 *
 */
public class RestControllerTestBase {

	protected MockMvc mockMvc;

	public void setupController(Object controller) {
		// standaloneSetup creates a set of default message converters (Json if
		// is in classpath)
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

}
