package sr.core.entity;

import java.io.Serializable;

/**
 * Clase Entity para la tabla Exalumno
 * 
 * @author juan.soruco
 *
 */
public class Exalumno implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer exalumnoId;
	private String nombresExalumno;
	private String apellidosExalumno;
	private String email;
	private String promocionYear;
	private String paisResidencia;
	private String ciudadResidencia;
	private String direccionResidencia;
	private String bachillerEnColegio;
	private String status;
	public Exalumno() {
		super();
	}
	public Exalumno(Integer exalumnoId, String nombresExalumno, String apellidosExalumno, String email,
			String promocionYear, String paisResidencia, String ciudadResidencia, String direccionResidencia,
			String bachillerEnColegio, String status) {
		super();
		this.exalumnoId = exalumnoId;
		this.nombresExalumno = nombresExalumno;
		this.apellidosExalumno = apellidosExalumno;
		this.email = email;
		this.promocionYear = promocionYear;
		this.paisResidencia = paisResidencia;
		this.ciudadResidencia = ciudadResidencia;
		this.direccionResidencia = direccionResidencia;
		this.bachillerEnColegio = bachillerEnColegio;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Exalumno [exalumnoId=" + exalumnoId + ", nombresExalumno=" + nombresExalumno + ", apellidosExalumno="
				+ apellidosExalumno + ", email=" + email + ", promocionYear=" + promocionYear + ", paisResidencia="
				+ paisResidencia + ", ciudadResidencia=" + ciudadResidencia + ", direccionResidencia="
				+ direccionResidencia + ", bachillerEnColegio=" + bachillerEnColegio + ", status=" + status + "]";
	}
	public Integer getExalumnoId() {
		return exalumnoId;
	}
	public void setExalumnoId(Integer exalumnoId) {
		this.exalumnoId = exalumnoId;
	}
	public String getNombresExalumno() {
		return nombresExalumno;
	}
	public void setNombresExalumno(String nombresExalumno) {
		this.nombresExalumno = nombresExalumno;
	}
	public String getApellidosExalumno() {
		return apellidosExalumno;
	}
	public void setApellidosExalumno(String apellidosExalumno) {
		this.apellidosExalumno = apellidosExalumno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPromocionYear() {
		return promocionYear;
	}
	public void setPromocionYear(String promocionYear) {
		this.promocionYear = promocionYear;
	}
	public String getPaisResidencia() {
		return paisResidencia;
	}
	public void setPaisResidencia(String paisResidencia) {
		this.paisResidencia = paisResidencia;
	}
	public String getCiudadResidencia() {
		return ciudadResidencia;
	}
	public void setCiudadResidencia(String ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}
	public String getDireccionResidencia() {
		return direccionResidencia;
	}
	public void setDireccionResidencia(String direccionResidencia) {
		this.direccionResidencia = direccionResidencia;
	}
	public String getBachillerEnColegio() {
		return bachillerEnColegio;
	}
	public void setBachillerEnColegio(String bachillerEnColegio) {
		this.bachillerEnColegio = bachillerEnColegio;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
