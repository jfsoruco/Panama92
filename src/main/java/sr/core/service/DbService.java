package sr.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Generico para servicio de Base de datos
 * 
 * @author juan.soruco
 *
 */
public abstract class DbService {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	TransactionService transactionService;

}
