package info.ishared.demo.guice.services.impl;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import info.ishared.demo.guice.services.BaseService;

import javax.persistence.EntityManager;

/**
 * Created with IntelliJ IDEA.
 * User: Seven
 * Date: 13-10-24
 * Time: PM5:08
 */
@Singleton
public class BaseServiceImpl implements BaseService {
    @Inject
    Provider<EntityManager> entityManagerProvider;

    @Override
    public EntityManager getEntityManager() {
        return entityManagerProvider.get();
    }
}
