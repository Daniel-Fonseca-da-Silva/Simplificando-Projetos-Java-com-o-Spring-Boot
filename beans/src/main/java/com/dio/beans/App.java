package com.dio.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);

        Livro livro = factory.getBean(Livro.class);
        livro.setNome("Call Of Cthulhu");
        livro.setCodigo("F17DN");

        Autor autor = factory.getBean(Autor.class);
        autor.setNome("H. P. Lovecraft");

        livro.exibir();

        ((AbstractApplicationContext) factory).close();
    }

}
