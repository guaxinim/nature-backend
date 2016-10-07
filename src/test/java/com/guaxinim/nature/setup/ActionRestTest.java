package com.guaxinim.nature.setup;

import com.guaxinim.nature.api.ActionRest;
import com.guaxinim.nature.domain.Action;
import junit.framework.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.runner.RunWith;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.io.File;
import java.util.Date;
import java.util.List;

@RunWith(Arquillian.class)
public class ActionRestTest {

    private Client client = ClientBuilder.newClient();

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
    public void insertAction(@ArquillianResteasyResource ActionRest actionResource) {
        Action action = new Action();
        action.setName("run");
        action.setWhen(new Date());
        Response response = actionResource.insertAction(action);
        Assert.assertTrue(response.getStatus() == 1);
    }

    @Before
    @InSequence(2)
    public void getAction(@ArquillianResteasyResource ActionRest actionResource) {
        List<Action> actions = actionResource.getActions();
        Assert.assertFalse(actions.isEmpty());
    }

}
