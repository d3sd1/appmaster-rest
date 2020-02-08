package com.d3sd1.appmaster.rest;

import com.d3sd1.appmaster.model.Compilation;
import com.d3sd1.appmaster.model.CompilerQueue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/compile")
public class Compile {
    private CompilerQueue compilerQueue;

    public Compile(CompilerQueue compilerQueue) {
        this.compilerQueue = compilerQueue;
    }

    @GetMapping("/all")
    public boolean all() {
        this.compilerQueue.addPendingCompilations(Compilation.IOS);
        this.compilerQueue.addPendingCompilations(Compilation.ANDROID);
        this.compilerQueue.addPendingCompilations(Compilation.WINDOWS);
        this.compilerQueue.addPendingCompilations(Compilation.LINUX);
        this.compilerQueue.addPendingCompilations(Compilation.MACOS);
        return true;
    }

    @GetMapping("/mobile")
    public boolean mobile() {
        this.compilerQueue.addPendingCompilations(Compilation.IOS);
        this.compilerQueue.addPendingCompilations(Compilation.ANDROID);
        return true;
    }

    @GetMapping("/ios")
    public boolean ios() {
        this.compilerQueue.addPendingCompilations(Compilation.IOS);
        return true;
    }

    @GetMapping("/android")
    public boolean android() {
        this.compilerQueue.addPendingCompilations(Compilation.ANDROID);
        return true;
    }

    @GetMapping("/desktop")
    public boolean desktop() {
        this.compilerQueue.addPendingCompilations(Compilation.WINDOWS);
        this.compilerQueue.addPendingCompilations(Compilation.LINUX);
        this.compilerQueue.addPendingCompilations(Compilation.MACOS);
        return true;
    }

    @GetMapping("/windows")
    public boolean windows() {
        this.compilerQueue.addPendingCompilations(Compilation.WINDOWS);
        return true;
    }

    @GetMapping("/linux")
    public boolean linux() {
        this.compilerQueue.addPendingCompilations(Compilation.LINUX);
        return true;
    }

    @GetMapping("/macos")
    public boolean macos() {
        this.compilerQueue.addPendingCompilations(Compilation.MACOS);
        return true;
    }
}
