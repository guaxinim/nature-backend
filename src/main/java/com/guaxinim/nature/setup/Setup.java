package com.guaxinim.nature.setup;

import com.guaxinim.nature.setup.neo4j.Neo4jDriver;
import com.guaxinim.nature.setup.neo4j.Neo4jSession;
import com.guaxinim.nature.setup.neo4j.Neo4jSessionFactory;
import org.neo4j.ogm.session.Session;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;


//@Singleton
//@Startup
/*
This class is for test purposes when running in standalone mode
 */
public class Setup {

    Logger logger = Logger.getLogger(this.getClass().getName());
    private String url;
    //private AuthToken token;
    //private Driver driver;

    public Setup() throws IOException {
        logger.fine("starting up Neo4J..");
        Properties properties = new Properties();
        try (InputStream stream = ClassLoader.getSystemResourceAsStream("settings.properties")) {
            properties.load(stream);
            stream.close();
        } catch (IOException ioex) {
            logger.severe("Error loading settings.properties");
            throw ioex;
        }
        url = properties.getProperty("neo4j.bolt.url");
        //token = AuthTokens.basic(properties.getProperty("neo4j.username"), properties.getProperty("neo4j.password"));
    }

    //@Produces
    //@Neo4jDriver
    //public Driver getDriver() {
        //TODO: Check if is correct obtain a new driver in every producer
        //driver = GraphDatabase.driver(url, token, Config.build().withEncryptionLevel(Config.EncryptionLevel.NONE).toConfig());
        //return driver;
    //}

    //@Neo4jDriver
    //public void closeDriver(@Disposes Driver driver) {
        //if (driver != null) {
            //driver.close();
        //}
    //}

    //@Produces
    //@Neo4jSession
    //public Session getSession() {
        //return Neo4jSessionFactory.getInstance().getOGMSession();
    //}

}
