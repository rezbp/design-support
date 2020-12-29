package com.github.brezp.design.command;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

/**
 * @author brezp
 */
public interface ICmdLine {


    public Options initOptions();


    public boolean validateOptions(CommandLine cmdLine);


    public void start(CommandLine cmdLine);

}
