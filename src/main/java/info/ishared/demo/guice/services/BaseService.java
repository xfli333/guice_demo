package info.ishared.demo.guice.services;

import com.google.inject.ImplementedBy;
import info.ishared.demo.guice.services.impl.BaseServiceImpl;

import javax.persistence.EntityManager;

/**
 * Created with IntelliJ IDEA.
 * User: Seven
 * Date: 13-10-24
 * Time: PM5:07
 */
//@ImplementedBy(BaseServiceImpl.class)
public interface BaseService {
    EntityManager getEntityManager();
}
