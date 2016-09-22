package com.guaxinim.nature.setup;

import junit.framework.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.driver.v1.*;

import javax.inject.Inject;
import java.io.File;
import java.util.logging.Logger;

@RunWith(Arquillian.class)
public class Neo4JSetupTest {

    Logger log = Logger.getLogger(Neo4JSetupTest.class.getName());

    @Inject
    @Neo4jDriver
    Driver driver;

    @Deployment
    public static WebArchive createTestArchive() {
        return ShrinkWrap.create(WebArchive.class)
                .addClass(Setup.class)
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/jboss-deployment-structure.xml"))
                .addAsWebInfResource("wildfly-ds.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }



    @Test
    public void testNeo4j() {
        try (Session session = driver.session()) {
            session.run("CREATE (a:Person {name:'Arthur', title:'King'})");
            StatementResult result = session.run( "MATCH (a:Person) WHERE a.name = 'Arthur' RETURN a.name AS name, a.title AS title" );
            while ( result.hasNext() )
            {
                Record record = result.next();
                System.out.println( record.get( "title" ).asString() + " " + record.get("name").asString() );
                Assert.assertTrue(record.get("name").equals("Arthur"));
            }
            session.close();
            driver.close();
        }
    }

}
