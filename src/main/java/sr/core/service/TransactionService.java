package sr.core.service;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import sr.core.entity.Transaction;
import sr.core.entity.domain.TransactionType;
import sr.core.sec.SecTools;

/**
 * Service that manages all operations related with Transaction
 * 
 * @author juan.soruco
 *
 */
@Service
public class TransactionService {

	private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Map<String, String> params;

	/**
	 * Get next Id for a Transaction
	 * 
	 */
	public Integer nextSecTransaction() {
		StringBuilder seqTranSQL = new StringBuilder();
		seqTranSQL.append("SELECT nextval('sr.seq_Transaction')");//("SELECT NEXT VALUE FOR mj.seq_Transaction");

		logger.debug("Executing:" + seqTranSQL.toString());

		return jdbcTemplate.queryForObject(seqTranSQL.toString(), Integer.class);
	}

	/**
	 * Creates a Transaction with all required Info of a beginning transaction
	 * 
	 * @param paramsIn
	 *            The corresponding set of initial parameters
	 * @return Transaction initial information
	 */
	public Transaction beginTransaction(TransactionType transactionType, Map<String, String> paramsIn) {
		Transaction transaction = new Transaction();

		transaction.beginDate =  new Date();
		transaction.transactionType =  transactionType.value;
		transaction.tranId = nextSecTransaction();
		transaction.mJUserId = SecTools.getMJUserId();
		transaction.paramsIn = paramsIn;

		logger.info("[OUTPUT]transaction=" + transaction);
		return transaction;
	}

	
	/**
	 * Creates a Transaction with all required Info of a beginning transaction
	 * receives mJUserId manually to avoid context security requirement (tests)
	 * 
	 * @param paramsIn
	 *            The corresponding set of initial parameters
	 * @return Transaction initial information
	 */
	public Transaction beginTransaction(TransactionType transactionType, Map<String, String> paramsIn, Integer mJUserId) {
		Transaction transaction = new Transaction();

		transaction.beginDate =  new Date();
		transaction.transactionType =  transactionType.value;
		transaction.tranId = nextSecTransaction();
		transaction.mJUserId = mJUserId;
		transaction.paramsIn = paramsIn;

		logger.info("[OUTPUT]transaction=" + transaction);
		return transaction;
	}	

	/**
	 * Completes a Transaction with all required Info and logs the transaction
	 * 
	 * @param paramsOut
	 *            The corresponding set of returning params
	 * @return Transaction final information
	 */
	public void endTransaction(Transaction transaction, Map<String, String> paramsOut) {

		transaction.paramsOut = paramsOut;
		transaction.endDate = new Date();
		transaction.lifespan = (int) (transaction.endDate.getTime()-transaction.beginDate.getTime());

		logger.info("[OUTPUT]transaction=" + transaction.toString());
	}

}
