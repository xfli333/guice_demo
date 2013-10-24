package info.ishared.demo.guice.services.impl;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;
import info.ishared.demo.guice.entry.User;
import info.ishared.demo.guice.services.HelloWorld;

import javax.persistence.EntityManager;

/**
 * Created with IntelliJ IDEA.
 * User: Seven
 * Date: 13-10-24
 * Time: PM3:14
 */

public class HelloWorldImpl extends BaseServiceImpl implements HelloWorld {


    @Override
    @Transactional
    public void sayHello(String name) {
        System.out.println("hello " + name);
        User user = new User();
        user.setName(name);
        super.getEntityManager().persist(user);
    }
}
