package br.com.apisys.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apisys.college.model.Aluno;

@Repository
public interface Alunos extends JpaRepository<Aluno, Long>{

	
}

