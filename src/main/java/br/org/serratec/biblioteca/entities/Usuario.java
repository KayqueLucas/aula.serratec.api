package br.org.serratec.biblioteca.entities;

//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
//@JsonIdentityInfo(
//		generator = ObjectIdGenerators.PropertyGenerator.class,
//		property = "usuarioId",
//		scope = Usuario.class
//)
public class Usuario {

	// chave primaria
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer usuarioId;

	// atributos
	@Column(name = "user_nome")
	private String usuarioNome;
	@Column(name = "user_email", unique = true)
	private String usuarioEmail;
	@Column(name = "user_password")
	private String usuarioSenha;

	// relaçao
	@ManyToOne
	@JoinColumn(name = "perfil_id")
	private Perfil perfil;

	public Usuario() {

	}

	public Usuario(Integer usuarioId, String usuarioNome, String usuarioEmail, String usuarioSenha, Perfil perfil) {
		this.usuarioId = usuarioId;
		this.usuarioNome = usuarioNome;
		this.usuarioEmail = usuarioEmail;
		this.usuarioSenha = usuarioSenha;
		this.perfil = perfil;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getUsuarioNome() {
		return usuarioNome;
	}

	public void setUsuarioNome(String usuarioNome) {
		this.usuarioNome = usuarioNome;
	}

	public String getUsuarioEmail() {
		return usuarioEmail;
	}

	public void setUsuarioEmail(String usuarioEmail) {
		this.usuarioEmail = usuarioEmail;
	}

	public String getUsuarioSenha() {
		return usuarioSenha;
	}

	public void setUsuarioSenha(String usuarioSenha) {
		this.usuarioSenha = usuarioSenha;
	}

	public Perfil getPerfil() {
		return perfil;
	}

}
