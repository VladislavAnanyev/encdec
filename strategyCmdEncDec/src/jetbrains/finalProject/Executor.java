package jetbrains.finalProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Executor {
    private RunAlgorithm runAlgorithm;
    private String string;
    private String mode;
    private String key;
    private char[] chars;

    public Executor() {
        chars = new char[100];
        this.setRunAlgorithm(new Shift());
        this.setKey("0");
        this.setMode("enc");
        this.string = "";
        this.chars = this.string.toCharArray();
    }

    public void setRunAlgorithm(RunAlgorithm runAlgorithm) {
        this.runAlgorithm = runAlgorithm;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void runAlgorithm(String[] args) throws IOException {
        for (int i = 0; i < args.length; i++)
        {
            if(args[i].equals("-alg"))
            {
                if(args[i+1].equals("unicode")) {
                    this.setRunAlgorithm(new Unicode());
                }

                if(args[i+1].equals("shift")) {
                    this.setRunAlgorithm(new Shift());
                }
            }

            if (args[i].equals("-mode")) {
                this.setMode(args[i+1]);
            }

            if(args[i].equals("-data")) {
                this.chars = args[i+1].toCharArray();
            }

            if (args[i].equals("-key")) {
                this.setKey(args[i+1]);
            }

            if(args[i].equals("-in")) {
                this.setInput(args[i+1]);
            }

        }

        this.runAlgorithm.run(mode, chars, Integer.parseInt(key));

        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-out")) {
                this.setOutput(args[i + 1]);
            }
        }
    }

    @Override
    public String toString() {
        return String.valueOf(runAlgorithm);
    }

    public void setInput(String args) throws FileNotFoundException {
        File fileIn = new File(args);
        Scanner scanner = new Scanner(fileIn);
        this.chars = scanner.nextLine().toCharArray();
        scanner.close();
    }

    public void setOutput(String args) throws IOException {
        File fileOut = new File(args);
        FileWriter fileWriter = new FileWriter(fileOut);
        fileWriter.write(this.chars);
        fileWriter.flush();
        fileWriter.close();
    }

    public void setMode(String args) {
        this.mode = args;
    }

}

