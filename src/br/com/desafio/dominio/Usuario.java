package br.com.desafio.dominio;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "cargo_nome")
	private String nome;

	@ManyToOne
	@JoinColumn(name = "id_cargo")
	private Cargo cargo;
	
	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
	private Telefone telefone;

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

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

}
