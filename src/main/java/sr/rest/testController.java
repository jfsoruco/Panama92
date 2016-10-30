package sr.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Test de servicios rest, debe quitarse cuando la capa de rest sea implementada
 * 
 * @author juan.soruco
 *
 */
@RestController
@RequestMapping("/rest")
public class testController {
	
	private static final Logger logger = LoggerFactory.getLogger(testController.class);
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String getHello() {
		logger.debug("Trace is working");
		return "Hello. This works fine!";
	}

}
