package info.ishared.demo.guice.services;

import com.google.inject.ImplementedBy;
import info.ishared.demo.guice.services.impl.HelloWorldImpl;

/**
 * Created with IntelliJ IDEA.
 * User: Seven
 * Date: 13-10-24
 * Time: PM3:13
 */
//@ImplementedBy(HelloWorldImpl.class)
public interface HelloWorld extends BaseService{
    void sayHello(String name);
}
