package br.com.apisys.college.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.thymeleaf.util.StringUtils;

import br.com.apisys.college.model.Aluno;

public class AlunoConverter implements Converter<String, Aluno> {

	@Override
	public Aluno convert(String id) {
		if (!StringUtils.isEmpty(id)) {
			Aluno aluno = new Aluno();
			aluno.setId(Long.valueOf(id));
			return aluno;
		}

		return null;
	}

}
