package com.d3sd1.appmaster.configuration;

import com.d3sd1.appmaster.util.Shell;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CliDependencies {
    private Shell shell;

    public CliDependencies(Shell shell) {
        this.shell = shell;
    }

/*
    @Bean
    public FileProcessor node(){
        this.shell.run("node -v");
    }

    @Bean
    public FileProcessor cordova(){
        return new FileProcessor();
    }*/
}
