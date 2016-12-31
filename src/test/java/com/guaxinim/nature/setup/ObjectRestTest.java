package com.guaxinim.nature.setup;

import com.google.common.collect.Iterables;
import com.guaxinim.nature.api.ObjectRest;
import com.guaxinim.nature.domain.Object;
import com.guaxinim.nature.setup.neo4j.Neo4jDriver;
import com.guaxinim.nature.setup.neo4j.Neo4jSession;
import com.guaxinim.nature.setup.neo4j.Neo4jSessionFactory;
import junit.framework.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.core.Response;
import java.io.File;
import java.util.logging.Logger;

@RunWith(Arquillian.class)
public class ObjectRestTest {

    Logger log = Logger.getLogger(ObjectRestTest.class.getName());

    @Deployment
    public static WebArchive createTestArchive() {
        return ShrinkWrap.create(WebArchive.class)
                .addClass(Setup.class)
                .addClass(Neo4jDriver.class)
                .addClass(Neo4jSession.class)
                .addClass(Object.class)
                .addClass(Neo4jSessionFactory.class)
                .addPackage("com.guaxinim.nature.domain")
                .addPackage("com.guaxinim.nature.api")
                .addPackage("com.guaxinim.nature.persistence")
                .addPackage("com.guaxinim.nature.service")
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/jboss-deployment-structure.xml.rej"))
                .addAsResource(new File("src/main/resources/settings.properties"))
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }


    @Test
    @InSequence(5)
    public void insertObject(@ArquillianResteasyResource ObjectRest objectResource) {
        log.info("[TESTS] - POSTING new Object...");
        Object object = new Object("chair");
        Response response = objectResource.insertObject(object);
        Assert.assertEquals(response.getStatus(), Response.Status.CREATED.getStatusCode());
    }

    @Test
    @InSequence(6)
    public void getObject(@ArquillianResteasyResource ObjectRest objectResource) {
        log.info("[TESTS] - Getting objects ...");
        Iterable<Object> objects = objectResource.getObjects();
        Assert.assertTrue(Iterables.size(objects) > 0);
    }

}
