package dev.paie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan({"dev.paie.web.controller","dev.paie.config","dev.paie.service","dev.paie.config.aspect"})
@ImportResource("classpath:donnees-config.xml")
public class WebAppConfig {

	@Bean
	public ViewResolver viewResolver() {
		//Permet de specifier l'entête et le suffix des vues
		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	
	}

}
