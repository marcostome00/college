package br.com.apisys.college.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.apisys.college.service.CadastroAlunoService;

@Configuration
@ComponentScan(basePackageClasses = CadastroAlunoService.class)
public class ServiceConfig {

}
