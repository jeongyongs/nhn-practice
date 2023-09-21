package com.nhnacademy.exam;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Exam02 {

    public static void main(String[] args) {
        boolean flag = false;

        Options options = new Options();
        options.addOption("v", "version", false, "print the version");
        options.addOption("f", "flag", false, "check flag");
        options.addOption("i", "id", true, "set identify");

        CommandLineParser commandLineParser = new DefaultParser();
        CommandLine parsedCommand = null;
        try {
            parsedCommand = commandLineParser.parse(options, args);
        } catch (ParseException ignore) {
            System.out.println("사용할 수 없는 옵션입니다.");
            return;
        }

        if (parsedCommand.hasOption("v")) {
            System.out.println("1.0-SNAPSHOT");
        }
        if (parsedCommand.hasOption("f")) {
            System.out.println(flag);
        }
        if (parsedCommand.hasOption("i")) {
            System.out.println(parsedCommand.getOptionValue("i"));
        }
    }
}
