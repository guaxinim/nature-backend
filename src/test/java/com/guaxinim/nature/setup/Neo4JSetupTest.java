package com.guaxinim.nature.setup;

import com.guaxinim.nature.setup.neo4j.Neo4jDriver;
import junit.framework.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.driver.v1.*;

import javax.inject.Inject;
import java.io.File;
import java.util.logging.Logger;

@RunWith(Arquillian.class)
public class Neo4JSetupTest {

    Logger log = Logger.getLogger(Neo4JSetupTest.class.getName());
    Session session;

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

    @Before
    @InSequence(1)
    public void setupNeo4j() {
        session = driver.session();
        Assert.assertTrue(session.isOpen());
    }

    @Test
    @InSequence(2)
    public void insertPerson() {
        try {
            session.run("CREATE (a:Person {name:'Arthur', title:'King'})");
        } catch (Exception e) {
            Assert.fail("Neo4j CREATE Error");
        }
    }

    @Test
    @InSequence(3)
    public void matchPerson() {
        StatementResult result = session.run( "MATCH (a:Person) WHERE a.name = 'Arthur' RETURN a.name AS name, a.title AS title" );
        while ( result.hasNext() ) {
            Record record = result.next();
            Assert.assertTrue(record.get("title").asString().equals("King"));
            Assert.assertTrue(record.get("name").asString().equals("Arthur"));
        }
    }

    @Test
    @InSequence(4)
    public void removePerson() {
        session.run("MATCH (a:Person {name:'Arthur', title:'King'}) DELETE a");
        StatementResult result = session.run( "MATCH (a:Person) RETURN a" );
        Assert.assertTrue(result.list().isEmpty());
    }

}
