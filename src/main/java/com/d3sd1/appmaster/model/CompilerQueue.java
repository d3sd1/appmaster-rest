package com.d3sd1.appmaster.model;

import com.d3sd1.appmaster.compiler.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Async
public class CompilerQueue {

    private IosCompiler iosCompiler;
    private AngularCliCompiler angularCliCompiler;
    private AndroidCompiler androidCompiler;
    private WindowsCompiler windowsCompiler;
    private LinuxCompiler linuxCompiler;
    private MacOSCompiler macOSCompiler;
    private boolean runningQueue = false;

    public CompilerQueue(IosCompiler iosCompiler, AndroidCompiler androidCompiler, WindowsCompiler windowsCompiler, LinuxCompiler linuxCompiler, MacOSCompiler macOSCompiler, AngularCliCompiler angularCliCompiler) {
        this.iosCompiler = iosCompiler;
        this.androidCompiler = androidCompiler;
        this.windowsCompiler = windowsCompiler;
        this.linuxCompiler = linuxCompiler;
        this.macOSCompiler = macOSCompiler;
        this.angularCliCompiler = angularCliCompiler;
    }

    private List<Compilation> pendingCompilations = new ArrayList<>();

    public List<Compilation> getPendingCompilations() {
        return pendingCompilations;
    }

    public void addPendingCompilations(Compilation pendingCompilation) {
        this.pendingCompilations.add(pendingCompilation);
        this.triggerQueue();
        try {
            Thread.sleep(300); // Prevent ghosting on double queue.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void triggerQueue() {
        this.triggerQueue(false);
    }
    public void triggerQueue(boolean hasPrev) {
        if (this.runningQueue || this.pendingCompilations.isEmpty()) {
            return; // If queue already running, ignore this.
        }
        this.runningQueue = true;
        Compilation platform = this.pendingCompilations.get(0);

        if(!hasPrev) {
            this.angularCliCompiler.compile();
        }

        switch (platform) {
            case IOS:
                this.iosCompiler.compile();
                break;
            case ANDROID:
                this.androidCompiler.compile();
                break;
            case WINDOWS:
                this.windowsCompiler.compile();
                break;
            case LINUX:
                this.linuxCompiler.compile();
                break;
            case MACOS:
                this.macOSCompiler.compile();
                break;
            default:
                System.out.println("Unknown platform: " + platform);
        }

        this.pendingCompilations.remove(0);
        this.runningQueue = false;
        this.triggerQueue(true);
    }
}
