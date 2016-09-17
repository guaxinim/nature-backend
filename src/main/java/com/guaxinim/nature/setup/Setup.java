package com.guaxinim.nature.setup;

import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Created by elvis on 16/09/2016.
 */
@Singleton
@Startup
public class Setup {

    private final org.neo4j.driver.v1.Driver driver;

}
