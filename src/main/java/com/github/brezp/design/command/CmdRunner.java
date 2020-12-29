package com.github.brezp.design.command;

import org.apache.commons.cli.*;


/**
 * 命令行客户端工具, Class for command line tools
 *
 * @author brezp
 */
public class CmdRunner {

    /**
     * 初始化命令行工具
     *
     * @param args    program arguments
     * @param cmdName command-line program name
     * @param runner  command-line runner
     */
    public static boolean initRunner(String[] args, String cmdName, ICmdLine runner) {
        CommandLineParser parser = new GnuParser();
        Options options = runner.initOptions();
        try {
            CommandLine cmdLine = parser.parse(options, args);
            runner.start(cmdLine);
            return true;
        } catch (ParseException e) {
            System.out.println("Unexpected exception:" + e.getMessage());
            return false;
        }
    }

}
