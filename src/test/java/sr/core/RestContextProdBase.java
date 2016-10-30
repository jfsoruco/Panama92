package sr.core;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Extending this clas you have al spring context pointing to DEv/prod database
 * where Diagnoser runs!. Test class for UserModuleController API's. Allows to
 * load ALL Spring CONTEXT so is like the application with all beans configured
 * for Spring available(DataSource, JDBCTemplate, Controllers..)
 * 
 * <pre>
 * It is required at least to include the mvc-dispatcher-servlet.xml (Spring context) 
 * because it scan beans on mj*.
 * One of those beans is the controller been tested.  
 * 
 * The config file: spring-database.xml also needs to be included 
 * because the services included by context and the also controller require 
 * the injection of other beans that use for example: jdbcTemplate 
 * defined on spring-database.xml 
 * 
 * For example, the bean auto injected by context scan: restResponseEntityExceptionHandler 
 * requires ExceptionService  ( @Autowired private ExceptionService exceptionService;)
 * and ExceptionService injects jdbcTemplate defined on spring-database.xml
 * 
 * </pre>
 * 
 * @author juan.soruco
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml",
		"file:src/main/webapp/WEB-INF/spring-database.xml" })
@WebAppConfiguration
public class RestContextProdBase {

	protected MockMvc mockMvc;

	@Autowired
	WebApplicationContext wac;

	@Before
	public void setupMaster() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

}
