package com.autobot.config.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Hello world!
 *
 */
@EnableConfigServer
@SpringBootApplication
public class Application 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
