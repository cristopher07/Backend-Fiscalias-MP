package com.fiscalias.crud.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_fiscalias")
public class Fiscalia {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_fiscalia;

	@Column(name = "agencia", length = 50, nullable = false)
	private String agencia;

	@Column(name = "codigo", length = 50, nullable = false)
	private String codigo;
	@Column(name = "tipo", length = 50, nullable = false)
	private String tipo;
	@Column(name = "departamento", length = 50, nullable = false)
	private String departamento;

	@Column(name = "municipio", length = 50, nullable = false)
	private String municipio;

	@Column(name = "telefono", length = 50, nullable = false)
	private String telefono;
	@Column(name = "datetime")
	private String datetime;



	public Fiscalia(String agencia, String codigo, String tipo, String departamento, String municipio, String telefono,
			String datetime) {
		super();
		this.agencia = agencia;
		this.codigo = codigo;
		this.tipo = tipo;
		this.departamento = departamento;
		this.municipio = municipio;
		this.telefono = telefono;
		this.datetime = datetime;
	}



	public Fiscalia() {
		super();
	}



	public long getId_fiscalia() {
		return id_fiscalia;
	}



	public void setId_fiscalia(long id_fiscalia) {
		this.id_fiscalia = id_fiscalia;
	}



	public String getAgencia() {
		return agencia;
	}



	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}



	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public String getDepartamento() {
		return departamento;
	}



	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}



	public String getMunicipio() {
		return municipio;
	}



	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getDatetime() {
		return datetime;
	}



	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}



	@Override
	public String toString() {
		return "Fiscalia [id_fiscalia=" + id_fiscalia + ", agencia=" + agencia + ", codigo=" + codigo + ", tipo=" + tipo
				+ ", departamento=" + departamento + ", municipio=" + municipio + ", telefono=" + telefono
				+ ", datetime=" + datetime + "]";
	}



	

}