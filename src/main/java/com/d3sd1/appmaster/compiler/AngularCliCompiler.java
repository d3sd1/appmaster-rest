package com.d3sd1.appmaster.compiler;

import com.d3sd1.appmaster.model.CommandOutput;
import com.d3sd1.appmaster.model.Compiler;
import com.d3sd1.appmaster.util.Shell;
import org.springframework.stereotype.Service;

//TODO: optimizar ng build en las compilaciones?
@Service
public class AngularCliCompiler implements Compiler {
    private String[] ignorableErrors = new String[]{
            "Platform android already added."
    };
    private Shell shell;

    public AngularCliCompiler(Shell shell) {
        this.shell = shell;
    }

    public void finishCompilation() {

    }

    // This must bnot be async.
    public void compile() {
        System.out.println("Compiling Angular...");

//TODO: node scripts/fixproject.js &&

        // Build angular on target project (this should get output folder)
        CommandOutput ngBuild = this.shell.run("ng build --configuration=production --aot=true --prod --buildOptimizer=true --optimization=true", "/Users/andreigarcia/WebstormProjects/angular-multiplatform");
        if (ngBuild.isError() && !this.isIgnorableError(ngBuild.getMessage())) {
            System.out.println("Erroor crítico: " + ngBuild.getMessage());
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