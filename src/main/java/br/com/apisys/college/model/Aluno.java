package br.com.apisys.college.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import br.com.apisys.college.enuns.EnumStatus;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_aluno", sequenceName = "aluno_id_seq", allocationSize=1)
	@GeneratedValue(generator = "seq_aluno", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NotBlank(message = "nome é obrigatório")
	private String nome;
	
	@NotBlank(message = "curso é obrigatório")
	private String curso;
	
	@NotNull(message = "matricula é obrigatória")
	private Integer matricula;
	
	@NotNull(message = "semestre é obrigatório")
	private Integer semestre;
	
	@Enumerated(EnumType.STRING)
	private EnumStatus status;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public boolean isNovo() {
		return id == null;
	}
	
	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public EnumStatus getStatus() {
		return status;
	}

	public void setStatus(EnumStatus status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
