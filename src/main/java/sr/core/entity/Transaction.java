package sr.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import sr.core.K;
import sr.core.MapTools;

/**
 * Class containing All information regarding a Transaction (For changes in
 * Database)
 * 
 * @author juan.soruco
 *
 */
public class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;

	public Date beginDate;
	public String transactionType;
	public Integer tranId;
	public Integer mJUserId;
	public Map<String, String> paramsIn;
	public Map<String, String> paramsOut;
	public Date endDate;
	public Integer lifespan;

	public Transaction() {
	}

	/**
	 * @return Transactional columns for insertion
	 */
	public TransactionalColumns getTransactionalColumns() {
		return new TransactionalColumns(this.tranId, this.mJUserId);
	}

	@Override
	public String toString() {
		return "Transaction [[beginDate=" + K.dateFormat.get().format(beginDate) + ", endDate="
				+ (endDate == null ? null : K.dateFormat.get().format(endDate)) + ", transactionType="
				+ transactionType + ", tranId=" + tranId + ", mJUserId=" + mJUserId + ", paramsIn="
				+ MapTools.toStr(paramsIn) + ", paramsOut=" + MapTools.toStr(paramsOut) + ", lifespan=" + lifespan
				+ "]]";
	}

}
