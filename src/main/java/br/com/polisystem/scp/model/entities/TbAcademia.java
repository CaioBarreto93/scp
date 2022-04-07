package br.com.polisystem.scp.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class TbAcademia {
	
	@Id
	@Column(nullable = false, unique = true)
	@Min(0)
	private Integer id;
	
	@Column(nullable = false)
	@NotBlank
	private String nome;
	
	@Column(nullable = false)
	@NotBlank
	private String razaosocial;
	
	private String obs;
	
	public TbAcademia() {}

	public TbAcademia(Integer id, String nome, String razaosocial) {
		super();
		this.id = id;
		this.nome = nome;
		this.razaosocial = razaosocial;
	}

	public TbAcademia(Integer id, String nome, String razaosocial, String obs) {
		super();
		this.id = id;
		this.nome = nome;
		this.razaosocial = razaosocial;
		this.obs = obs;
	}
	
	

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRazaosocial() {
		return razaosocial;
	}

	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}
}
	

