package br.com.polisystem.scp.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class TbChamados {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String data;
	
	@Column(nullable = false)
	private String solicitante;
	
	private String teamviewer;
	
	@Column(nullable = false, length = 600)
	private String problema;
	
	@Column(length = 600)
	private String solucao;
	
	@OneToOne
	@JoinColumn(name = "analista_id", nullable = false)
	private TbAnalista analista;
	
	@OneToOne
	@JoinColumn(name = "academia_id", nullable = false)
	private TbAcademia academia;
	
	public TbChamados() {
		
	}

	public TbChamados(String solicitante, String teamviewer, String problema, String solucao,
			TbAnalista analista, TbAcademia academia) {
		super();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		this.data = sdf.format(new Date());
		this.solicitante = solicitante;
		this.teamviewer = teamviewer;
		this.problema = problema;
		this.solucao = solucao;
		this.analista = analista;
		this.academia = academia;
	}

	public TbChamados(String solicitante, String teamviewer, String problema, TbAnalista analista,
			TbAcademia academia) {
		super();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		this.data = sdf.format(new Date());
		this.solicitante = solicitante;
		this.teamviewer = teamviewer;
		this.problema = problema;
		this.analista = analista;
		this.academia = academia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getTeamviewer() {
		return teamviewer;
	}

	public void setTeamviewer(String teamviewer) {
		this.teamviewer = teamviewer;
	}

	public String getProblema() {
		return problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

	public String getSolucao() {
		return solucao;
	}

	public void setSolucao(String solucao) {
		this.solucao = solucao;
	}

	public TbAnalista getAnalista() {
		return analista;
	}

	public void setAnalista(TbAnalista analista) {
		this.analista = analista;
	}

	public TbAcademia getAcademia() {
		return academia;
	}

	public void setAcademia(TbAcademia academia) {
		this.academia = academia;
	}
	
	
	
	
	

}
