package sr.core.entity;

import java.io.Serializable;

/**
 * Clase Entity para la tabla Promocion
 * 
 * @author juan.soruco
 *
 */
public class Promocion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String promocionYear;
	private String nombrePromocion;
	private Integer cantidadBachilleres;
	private String status;
	
	public Promocion() {
		super();
	}

	public Promocion(String promocionYear, String nombrePromocion, Integer cantidadBachilleres, String status) {
		super();
		this.promocionYear = promocionYear;
		this.nombrePromocion = nombrePromocion;
		this.cantidadBachilleres = cantidadBachilleres;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Promocion [promocionYear=" + promocionYear + ", nombrePromocion=" + nombrePromocion
				+ ", cantidadBachilleres=" + cantidadBachilleres + ", status=" + status + "]";
	}

	public String getPromocionYear() {
		return promocionYear;
	}

	public void setPromocionYear(String promocionYear) {
		this.promocionYear = promocionYear;
	}

	public String getNombrePromocion() {
		return nombrePromocion;
	}

	public void setNombrePromocion(String nombrePromocion) {
		this.nombrePromocion = nombrePromocion;
	}

	public Integer getCantidadBachilleres() {
		return cantidadBachilleres;
	}

	public void setCantidadBachilleres(Integer cantidadBachilleres) {
		this.cantidadBachilleres = cantidadBachilleres;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
