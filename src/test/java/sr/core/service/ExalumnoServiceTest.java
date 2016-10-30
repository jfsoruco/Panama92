package sr.core.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;

import sr.core.RestContextTestBase;
import sr.core.entity.Exalumno;
import sr.core.entity.Transaction;
import sr.core.entity.TransactionalColumns;
import sr.core.entity.domain.TransactionType;

/**
 * Class testing crud services to the Exalumno entity
 * 
 * @author juan.soruco
 **/
// @off
@SqlGroup({ 
		@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:SrScriptBeforeTests.sql"),
		@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:SrScriptAfterTests.sql") })
// @on
public class ExalumnoServiceTest extends RestContextTestBase {

	private final Logger logger = LoggerFactory.getLogger(ExalumnoServiceTest.class);

	// Servicio en test
	@Autowired
	ExalumnoService exalumnoService;

	Exalumno exalumnoExistente, exalumnoNuevo;

	@Before
	public void setUp() throws Exception {
		exalumnoExistente = new Exalumno();
		exalumnoExistente.setExalumnoId(1);

		exalumnoNuevo = new Exalumno(null, "Jose Antonio", "Aquino Chavarria", "antonio.aquino@test.com", "1992",
				"Bolivia", "Cochabamba", "direccion", "SI", "A");

	}

	@Test
	public void testNextSeqExalumno() {
		logger.debug("en test de testNextSeqExalumno");
		Integer nextSecForExalumno = exalumnoService.nextSeqExalumno();
		assertTrue(nextSecForExalumno == 100);
	}

	@Test
	public void testInsertExalumno() {
		Map<String, String> paramsIn = new HashMap<String, String>();
		paramsIn.put("Exalumno", exalumnoNuevo.toString());
		Transaction transaction = transactionService.beginTransaction(TransactionType.DATA_INSERT, paramsIn);
		logger.debug("Insertando registro " + exalumnoNuevo.toString() + ":"
				+ transaction.getTransactionalColumns().toString());
		TransactionalColumns tran = transaction.getTransactionalColumns();
		tran.createdBy = 1;
		exalumnoService.insertExalumno(exalumnoNuevo, tran);
		transactionService.endTransaction(transaction, null);

		Exalumno exalumno = exalumnoService.getExalumno(100);

		assertNotNull(exalumno);
		assertTrue(exalumno.getApellidosExalumno().equals("Aquino Chavarria"));
	}

	@Test
	public void testUpdateExalumno() {
		Map<String, String> paramsIn = new HashMap<String, String>();
		exalumnoExistente = exalumnoService.getExalumno(exalumnoExistente.getExalumnoId());
		exalumnoExistente.setDireccionResidencia("direccion de prueba");
		paramsIn.put("Exalumno", exalumnoExistente.toString());
		Transaction transaction = transactionService.beginTransaction(TransactionType.DATA_UPDATE, paramsIn);
		logger.debug("Actualizando registro " + exalumnoExistente.toString() + ":"
				+ transaction.getTransactionalColumns().toString());
		TransactionalColumns tran = transaction.getTransactionalColumns();
		tran.updatedBy = 1;

		exalumnoService.updateExalumno(exalumnoExistente, tran);
		transactionService.endTransaction(transaction, null);

		Exalumno exalumno = exalumnoService.getExalumno(exalumnoExistente.getExalumnoId());

		assertNotNull(exalumno);
		assertTrue(exalumno.getDireccionResidencia().equals("direccion de prueba"));

	}

	@Test
	public void testLogicalDeletePgTransaction() {
		Map<String, String> paramsIn = new HashMap<String, String>();
		paramsIn.put("exalumnoId", Integer.toString(exalumnoExistente.getExalumnoId()));
		Transaction transaction = transactionService.beginTransaction(TransactionType.DATA_UPDATE, paramsIn);
		logger.debug("Actualizando registro " + exalumnoExistente.getExalumnoId() + ":I:"
				+ transaction.getTransactionalColumns().toString());
		TransactionalColumns tran = transaction.getTransactionalColumns();
		tran.updatedBy = 1;
		
		exalumnoService.logicalDeleteExalumno(exalumnoExistente.getExalumnoId(), tran);
		
		transactionService.endTransaction(transaction, null);

		Exalumno exalumno = exalumnoService.getExalumno(exalumnoExistente.getExalumnoId());

		assertNotNull(exalumno);
		assertTrue(exalumno.getStatus().equals("I"));
	}

	@Test
	public void testUpdateStatusExalumno() {
		Map<String, String> paramsIn = new HashMap<String, String>();
		paramsIn.put("exalumnoId", Integer.toString(exalumnoExistente.getExalumnoId()));
		Transaction transaction = transactionService.beginTransaction(TransactionType.DATA_UPDATE, paramsIn);
		logger.debug("Actualizando registro " + exalumnoExistente.getExalumnoId() + ":I:"
				+ transaction.getTransactionalColumns().toString());
		TransactionalColumns tran = transaction.getTransactionalColumns();
		tran.updatedBy = 1;

		exalumnoService.updateStatusExalumno(exalumnoExistente.getExalumnoId(), "I", tran);

		transactionService.endTransaction(transaction, null);

		Exalumno exalumno = exalumnoService.getExalumno(exalumnoExistente.getExalumnoId());

		assertNotNull(exalumno);
		assertTrue(exalumno.getStatus().equals("I"));

	}

	@Test
	public void testGetExalumno() {
		Exalumno exalumno = exalumnoService.getExalumno(exalumnoExistente.getExalumnoId());

		assertNotNull(exalumno);
		assertTrue(exalumno.getApellidosExalumno().equals("Soruco Velasquez"));
	}

}
