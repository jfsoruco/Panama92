package sr.core.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Columnas transaccionales para control de tablas en bd
 * 
 * @author juan.soruco
 *
 */
public class TransactionalColumns implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public String status;
	public Integer tranId;
	public Integer createdBy;
	public Date createdDate;
	public Integer updatedBy;
	public Date updatedDate;
	
	public TransactionalColumns() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TransactionalColumns(Integer tranId, Integer createdBy) {
		super();
		this.tranId = tranId;
		this.createdBy = createdBy;
		this.createdDate = new Date();
		this.updatedBy = createdBy;
		this.updatedDate = new Date();
	}

	public TransactionalColumns(String status, Integer tranId, Integer createdBy, Date createdDate, Integer updatedBy,
			Date updatedDate) {
		super();
		this.status = status;
		this.tranId = tranId;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "TransactionalColumns [status=" + status + ", tranId=" + tranId + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + "]";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getTranId() {
		return tranId;
	}

	public void setTranId(Integer tranId) {
		this.tranId = tranId;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
