package sr.core.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import sr.core.DateTools;
import sr.core.K;
import sr.core.entity.Exalumno;
import sr.core.entity.TransactionalColumns;
import sr.core.exception.SREmptyRequiredParametersException;
import sr.core.exception.SRInconsistencyFoundException;
import sr.core.exception.SRNoDataFoundException;

/**
 * Servicio de repositorio (CRUD) para Exalumno
 * 
 * @author juan.soruco
 *
 */
@Repository
public class ExalumnoService extends DbService {
	final static Logger logger = LoggerFactory.getLogger(ExalumnoService.class);
	
	public Integer nextSeqExalumno() {
		final StringBuilder sql = new StringBuilder();
		sql.append(" SELECT NEXTVAL('sr.seqExalumno') ");
		
		logger.debug("Executing:" + sql);
		
		return jdbcTemplate.queryForObject(sql.toString(), Integer.class);
	}
	
	public void insertExalumno(final Exalumno exalumno, final TransactionalColumns tran) {
		logger.debug("[INPUT]:exalumno=" + exalumno);
		
		// validations
		if (exalumno == null) {
			throw new SREmptyRequiredParametersException("El registro de exalumno esta vacio");
		}
		if (exalumno.getNombresExalumno() == null || exalumno.getNombresExalumno().trim().equals("")) {
			throw new SREmptyRequiredParametersException("El nombre del exalumno esta en blanco");
		}
		if (exalumno.getPromocionYear() == null || exalumno.getPromocionYear().trim().equals("")) {
			throw new SREmptyRequiredParametersException("El año de promoción esta en blanco");
		}
		// insert record
		final StringBuilder sql = new StringBuilder();
		sql.append("  INSERT INTO sr.exalumno(exalumnoId, nombresExalumno, apellidosExalumno, email, promocionYear, ");
		sql.append("  ciudadResidencia, paisResidencia, direccionResidencia, bachillerEnColegio, ");
		sql.append("  status, createdBy, createdDate, createdTranId) ");
		sql.append(" values (?, ?, ?, ?, ?, ");
		sql.append("  ?, ?, ?, ?, ");
		sql.append("  ?, ?, ?, ? )");
		
		logger.debug("Executing:" + sql + " ; Param: exalumno=" + exalumno.toString());
		
		Integer numInserted = jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql.toString());
				ps.setInt(1, nextSeqExalumno());
				ps.setString(2, exalumno.getNombresExalumno());
				ps.setString(3, exalumno.getApellidosExalumno());
				ps.setString(4, exalumno.getEmail());
				ps.setString(5, exalumno.getPromocionYear());
				
				ps.setString(6, exalumno.getCiudadResidencia());
				ps.setString(7, exalumno.getPaisResidencia());
				ps.setString(8, exalumno.getDireccionResidencia());
				ps.setString(9, exalumno.getBachillerEnColegio());
				
				ps.setString(10, exalumno.getStatus());
				ps.setInt(11, tran.getCreatedBy());
				ps.setTimestamp(12, DateTools.toTimestamp(tran.getCreatedDate()));
				ps.setInt(13, tran.getCreatedBy());
				return ps;
			}
		});
				
		// historic
		// TODO: Registrar el estudiante en el historico
				
		if (numInserted == 0) {
			throw new SREmptyRequiredParametersException("No se registro al estudiante");
		}
		
		logger.debug("[OUTPUT] inserted=" + numInserted);
		
	}
	
	public void updateExalumno(final Exalumno exalumno, final TransactionalColumns tran) {
		
		// validations
		if (exalumno == null) {
			throw new SREmptyRequiredParametersException("El registro de exalumno esta vacio");
		}
		if (exalumno.getExalumnoId() == null) {
			throw new SREmptyRequiredParametersException("El identificador del exalumno esta en blanco");
		}
		if (exalumno.getNombresExalumno() == null || exalumno.getNombresExalumno().trim().equals("")) {
			throw new SREmptyRequiredParametersException("El nombre del exalumno esta en blanco");
		}
		if (exalumno.getPromocionYear() == null || exalumno.getPromocionYear().trim().equals("")) {
			throw new SREmptyRequiredParametersException("El año de promoción esta en blanco");
		}
		
		final StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE sr.exalumno SET nombresExalumno=?, apellidosExalumno=?, email=?, promocionYear=?, ");
		sql.append("   paisResidencia=?, ciudadResidencia=?, direccionResidencia=?, bachillerEnColegio=?, ");
		sql.append("   status=?, updatedBy=?, updatedDate=?, updatedTranId=?");
		sql.append("  WHERE exalumnoId = ? ");
		
		logger.debug("Executing:" + sql + " ; Param: exalumno=" + exalumno.toString());
		
		Integer numUpdated = jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql.toString());
				ps.setString(1, exalumno.getNombresExalumno());
				ps.setString(2, exalumno.getApellidosExalumno());
				ps.setString(3, exalumno.getEmail());
				ps.setString(4, exalumno.getPromocionYear());
				
				ps.setString(5, exalumno.getPaisResidencia());
				ps.setString(6, exalumno.getCiudadResidencia());
				ps.setString(7, exalumno.getDireccionResidencia());
				ps.setString(8, exalumno.getBachillerEnColegio());
				// Transactional information
				ps.setString(9, tran.status);
				ps.setString(10, String.valueOf(tran.updatedBy));
				ps.setTimestamp(11, DateTools.toTimestamp(tran.updatedDate));
				ps.setInt(12, tran.getTranId());
				
				// Where
				ps.setInt(13, exalumno.getExalumnoId());

				return ps;

			}
		});

		if (numUpdated == 0) {
			logger.warn("[ERROR]0 Registers updated!");
			throw new SRInconsistencyFoundException("No se actualizaron registros!",
					"Verifique los datos de la tabla mj.pg_transaction");
		}
		logger.debug("[OUTPUT]exalumnoId=" + exalumno.getExalumnoId() + ", numUpdated=" + numUpdated);
	}
	
	/**
	 * General method to logical delete a Exalumno record in the DB
	 * (Postgresql)
	 * 
	 * @param exalumnoId
	 * @param status
	 * @param tran
	 * @throws Exception
	 * 
	 */
	public void logicalDeleteExalumno(final Integer exalumnoId, final TransactionalColumns tran) {
		logger.debug("[INPUT]exalumnoId=" + exalumnoId);
		// Validations
		if (exalumnoId == null || exalumnoId.toString().trim().isEmpty()) {
			throw new SREmptyRequiredParametersException(
					"No se tiene el parametro identificador de exalumno que se desea borrar");
		}

		this.updateStatusExalumno(exalumnoId, K.TRANSACTION_DELETED_STATUS, tran);
		logger.debug("[OUTPUT]exalumnoId=" + exalumnoId);
	}
	
	/**
	 * Actualización del estado de la transacción
	 * 
	 * @param transactionId
	 * @param status
	 * @param tran
	 */
	public void updateStatusExalumno(final Integer exalumnoId, final String status, final TransactionalColumns tran) {
		logger.debug("[INPUT]exalumnoId=" + exalumnoId + ", status=" + status);
		// Validations
		if (exalumnoId == null || exalumnoId.toString().trim().isEmpty()) {
			throw new SREmptyRequiredParametersException(
					"No se tiene el parametro identificador de exalumno que se desea borrar");
		}
		if (status == null || status.trim().isEmpty()) {
			throw new SREmptyRequiredParametersException("No se tiene el parametro estado que se desea borrar");
		}

		final StringBuilder sql = new StringBuilder();
		sql.append("UPDATE sr.exalumno SET status=?, updatedBy=?, updatedDate=?, updatedTranId=? ");
		sql.append(" WHERE exalumnoId=? ");

		logger.debug("Executing:" + sql + " ; Param: exalumnoId=" + exalumnoId + ", tran=" + tran.toString());
		Integer numUpdated = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql.toString());
				ps.setString(1, status);
				// Transactional information
				ps.setString(2, String.valueOf(tran.updatedBy));
				ps.setTimestamp(3, DateTools.toTimestamp(tran.updatedDate));
				ps.setInt(4, tran.getTranId());
				// Where
				ps.setInt(5, exalumnoId);

				return ps;
			}
		});

		logger.debug("[OUTPUT]numUpdated=" + numUpdated);
		if (numUpdated == 0) {
			throw new SRInconsistencyFoundException("0 Registros actualizados!",
					"Verifique la tabla sr.exalumno");
		}
	}
	
	/**
	 * Get a exalumno
	 * 
	 * @param transactionId
	 * @return
	 * @throws Exception
	 * 
	 */
	public Exalumno getExalumno(final Integer exalumnoId) {
		logger.debug("[INPUT] exalumnoId=" + exalumnoId);
		Exalumno exalumno = null;

		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT e.exalumnoId, e.nombresExalumno, e.apellidosExalumno, e.email, e.promocionYear, ");
		sql.append("   e.paisResidencia, e.ciudadResidencia, e.direccionResidencia, e.bachillerEnColegio, ");
		sql.append("   e.status ");
		sql.append("  FROM sr.exalumno e ");
		sql.append("  WHERE e.exalumnoId = ? ");

		logger.debug("Executing:" + sql + " ; Param: exalumnoId=" + exalumnoId);
		try {

			exalumno = (Exalumno) this.jdbcTemplate.queryForObject(sql.toString(),
					new Object[] { exalumnoId }, new BeanPropertyRowMapper<Exalumno>(Exalumno.class));

			logger.debug("[OUTPUT]" + exalumno.toString());
			return exalumno;
		} catch (EmptyResultDataAccessException e) {
			logger.warn("[ERROR]" + e.getMessage());
			throw new SRNoDataFoundException("No existe la Transacción",
					"Exception in query:" + sql + " ; " + exalumnoId);
		}

	}
}
