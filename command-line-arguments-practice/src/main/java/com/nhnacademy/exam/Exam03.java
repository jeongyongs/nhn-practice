package com.nhnacademy.exam;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Exam03 {

    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("a", "option a");
        options.addOption("b", "option b");
        options.addOption("v", "print version");

        CommandLine command = null;
        try {
            command = new DefaultParser().parse(options, args);
        } catch (ParseException ignore) {
        }

        if (command.hasOption("a")) {
            System.out.println("-a : a 옵션이 추가되어 있습니다.");
        }
        if (command.hasOption("b")) {
            System.out.println("-b : b 옵션이 추가되어 있습니다.");
        }
        if (command.hasOption("v")) {
            System.out.println("-v : print the version");
        }
    }
}
