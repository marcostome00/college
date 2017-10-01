package br.com.apisys.college.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.apisys.college.model.Aluno;
import br.com.apisys.college.repository.Alunos;

@Service
public class CadastroAlunoService {

	@Autowired
	private Alunos alunos;

	@Transactional
	public void salvar(Aluno aluno) {
		alunos.save(aluno);
	}
	
	@Transactional
	public void excluir(Long id) {
		
		alunos.delete(id);
	}
	
}
