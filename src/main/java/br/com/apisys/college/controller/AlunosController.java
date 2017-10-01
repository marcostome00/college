package br.com.apisys.college.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.apisys.college.enuns.EnumStatus;
import br.com.apisys.college.model.Aluno;
import br.com.apisys.college.repository.Alunos;
import br.com.apisys.college.service.CadastroAlunoService;

@Controller
@RequestMapping("/aluno")
public class AlunosController {

	@Autowired
	private CadastroAlunoService alunoService;

	@Autowired
	private Alunos alunos;

	@RequestMapping("/novo")
	public ModelAndView novoAluno(Aluno aluno) {
		
		ModelAndView mv = new ModelAndView("aluno/CadastroAluno");
		mv.addObject("status", EnumStatus.values());
		return mv;
	}

	@RequestMapping(value = { "/novo", "{\\d+}" }, method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Aluno aluno, BindingResult result, Model model,
			RedirectAttributes attributes) {

		if (result.hasErrors()) {
			model.addAttribute(aluno);
			return novoAluno(aluno);
		}

		alunoService.salvar(aluno);
		attributes.addFlashAttribute("mensagem", "Aluno adicionado com sucesso!");
		return new ModelAndView("redirect:/aluno/novo");
	}

	@GetMapping
	public ModelAndView pesquisar() {
		ModelAndView mv = new ModelAndView("aluno/PesquisaAlunos");

		mv.addObject("alunos", alunos.findAll());
		return mv;
	}

	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable("id") Aluno aluno) {

		ModelAndView mv = novoAluno(aluno);

		Aluno a = alunos.findOne(aluno.getId());
		mv.addObject(a);

		return mv;
	}

	@RequestMapping("/exclui/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {

		alunoService.excluir(id);
		return new ModelAndView("redirect:/aluno");
	}

}
