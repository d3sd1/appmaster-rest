package com.d3sd1.appmaster.util;

import com.d3sd1.appmaster.model.CommandOutput;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class Shell {
    public CommandOutput run(String command) {
        return this.run(command, "/");
    }
    public CommandOutput run(String command, String path) {
        CommandOutput commandOutput = new CommandOutput();
        StringBuilder output = new StringBuilder();
        try {
            Process cmd = Runtime.getRuntime().exec(command, null,
                    new File(path));

            int exitCode = cmd.waitFor();
            if (exitCode == 0) {
                String line;
                BufferedReader outputReader = new BufferedReader(
                        new InputStreamReader(cmd.getInputStream()));
                while ((line = outputReader.readLine()) != null) {
                    if (!output.toString().equals("")) {
                        output.append("\n");
                    }
                    output.append(line).append("\n");
                }
                commandOutput.setError(false);
            } else {
                String line;
                BufferedReader outputErrorReader = new BufferedReader(
                        new InputStreamReader(cmd.getErrorStream()));
                while ((line = outputErrorReader.readLine()) != null) {
                    if (!output.toString().equals("")) {
                        output.append("\n");
                    }
                    output.append(line);
                }
                commandOutput.setError(true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        commandOutput.setMessage(output.toString());
        return commandOutput;
    }
}
