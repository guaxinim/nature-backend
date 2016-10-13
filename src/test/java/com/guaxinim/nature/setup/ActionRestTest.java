package com.guaxinim.nature.setup;

import com.guaxinim.nature.api.ActionRest;
import com.guaxinim.nature.domain.Action;
import com.guaxinim.nature.domain.Entity;
import com.guaxinim.nature.persistence.Neo4jGenericService;
import com.guaxinim.nature.persistence.Neo4jService;
import com.guaxinim.nature.service.ActionService;
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
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Session;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.io.File;
import java.util.Date;
import java.util.List;

@RunWith(Arquillian.class)
public class ActionRestTest {

    @Inject
    @Neo4jDriver
    Driver driver;
    Session session;

    @Deployment
    public static WebArchive createTestArchive() {
        return ShrinkWrap.create(WebArchive.class)
                .addClass(Setup.class)
                .addClass(Neo4jDriver.class)
                .addClass(Neo4jSession.class)
                .addClass(Neo4jSessionFactory.class)
                .addPackage("com.guaxinim.nature.domain")
                .addPackage("com.guaxinim.nature.api")
                .addPackage("com.guaxinim.nature.persistence")
                .addPackage("com.guaxinim.nature.service")
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
    public void insertAction(@ArquillianResteasyResource ActionRest actionResource) {
        Action action = new Action();
        action.setName("run");
        action.setWhen(new Date());
        Response response = actionResource.insertAction(action);
        Assert.assertTrue(response.getStatus() == 1);
    }

    @Test
    @InSequence(3)
    public void getAction(@ArquillianResteasyResource ActionRest actionResource) {
        List<Action> actions = actionResource.getActions();
        Assert.assertFalse(actions.isEmpty());
    }

}
