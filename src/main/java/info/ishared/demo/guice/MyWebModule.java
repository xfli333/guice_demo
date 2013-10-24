package info.ishared.demo.guice;

import com.google.inject.Singleton;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.RequestScoped;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import info.ishared.demo.guice.controllers.CommonController;
import info.ishared.demo.guice.services.BaseService;
import info.ishared.demo.guice.services.HelloWorld;
import info.ishared.demo.guice.services.impl.BaseServiceImpl;
import info.ishared.demo.guice.services.impl.HelloWorldImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Seven
 * Date: 13-10-23
 * Time: PM4:30
 */
public class MyWebModule extends ServletModule {
    @Override
    protected void configureServlets(){
        install(new JpaPersistModule("myJPA"));
        filter("/*").through(PersistFilter.class);

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("com.sun.jersey.config.property.packages", "info.ishared.demo.guice.controllers");
        serve("/*").with(GuiceContainer.class, parameters);


        this.bind(BaseService.class).to(BaseServiceImpl.class).in(Singleton.class);
        this.bind(HelloWorld.class).to(HelloWorldImpl.class).in(Singleton.class);
    }


}
