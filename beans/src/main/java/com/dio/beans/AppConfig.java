package com.dio.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    // <bean id="livro" class="com.dio.beans.Livro/">
    public Livro getLivro() {
        return new Livro();
    }

    @Bean
    public AutorLivro getAutorLivro() {
        return new Autor();
    }

}
