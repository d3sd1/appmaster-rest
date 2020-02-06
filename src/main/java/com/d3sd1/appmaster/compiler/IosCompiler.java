package com.d3sd1.appmaster.compiler;

import com.d3sd1.appmaster.model.CommandOutput;
import com.d3sd1.appmaster.model.Compiler;
import com.d3sd1.appmaster.util.Shell;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.invoke.SwitchPoint;

@Service
public class IosCompiler implements Compiler {
    private String[] ignorableErrors = new String[]{
            "Platform ios already added."
    };
    private Shell shell;

    public IosCompiler(Shell shell) {
        this.shell = shell;
    }

    public void finishCompilation() {

    }

    public void compile() {
        System.out.println("Compiling IOS...");

//TODO: node scripts/fixproject.js &&

        // Build angular on target project (this should get output folder)
        CommandOutput ngBuild = this.shell.run("ng build --configuration=production --aot=true --prod --buildOptimizer=true --optimization=true", "/Users/andreigarcia/WebstormProjects/angular-multiplatform");
        if (ngBuild.isError() && !this.isIgnorableError(ngBuild.getMessage())) {
            System.out.println("Erroor crítico: " + ngBuild.getMessage());
            this.finishCompilation();
            return;
        }
        // cordova build (this should be done on angular-blademaster project with the output of last command)

        CommandOutput cordovaAddIos = this.shell.run("cordova platform add ios", "/Users/andreigarcia/WebstormProjects/angular-multiplatform");
        if (cordovaAddIos.isError() && !this.isIgnorableError(cordovaAddIos.getMessage())) {
            System.out.println("Erroor crítico: " + cordovaAddIos.getMessage());
            this.finishCompilation();
            return;
        }
        CommandOutput cordovaBuildIos = this.shell.run("cordova build ios", "/Users/andreigarcia/WebstormProjects/angular-multiplatform");
        if (cordovaBuildIos.isError() && !this.isIgnorableError(cordovaBuildIos.getMessage())) {
            System.out.println("Erroor crítico: " + cordovaBuildIos.getMessage());
            this.finishCompilation();
            return;
        }

        System.out.println("Compiled!");
    }

    public boolean isIgnorableError(String err) {
        for (String ignorableErr: this.ignorableErrors) {
            if(err.toLowerCase().contains(ignorableErr.toLowerCase())
                    || ignorableErr.toLowerCase().contains(err.toLowerCase())
            || ignorableErr.equalsIgnoreCase(err)) {
                return true;
            }
        }
        return false;
    }
}