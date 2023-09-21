package com.nhnacademy.quiz;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Quiz011 {

    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("a", false, "a");
        options.addOption("c", false, "c");
        options.addOption("p", "path", false, "path");
        options.addOption("t", "target", true, "target");
        options.addOption("h", "help", false, "help");
        Option option = Option.builder("i").hasArg().desc("식별자입니다.").build();
        options.addOption(option);

        CommandLine command = null;
        try {
            command = new DefaultParser().parse(options, args);
        } catch (ParseException ignore) {
            System.out.println("잘못된 옵션입니다.");
            return;
        }

        if (command.hasOption("h")) {
            new HelpFormatter().printHelp("fd", options);
            return;
        }
        if (command.hasOption("a")) {
            System.out.println("-a");
        }
        if (command.hasOption("c")) {
            System.out.println("-c");
        }
        if (command.hasOption("p")) {
            System.out.println("--path");
        }
        if (command.hasOption("t")) {
            System.out.println("-t " + command.getOptionValue("t"));
        }
        command.getArgList().stream().forEach(System.out::println);
    }
}
