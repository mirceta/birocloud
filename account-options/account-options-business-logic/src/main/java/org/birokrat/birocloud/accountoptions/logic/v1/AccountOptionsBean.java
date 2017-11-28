package org.birokrat.birocloud.accountoptions.logic.v1;

import java.util.List;

// project
import org.birokrat.birocloud.accountoptions.persistence.v1.AccountOptions;

// javax persistence
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

// kumuluzee
import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.JPAUtils;

// other
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.UriInfo;


@RequestScoped
public class AccountOptionsBean {

    @PersistenceContext(unitName = "account-options-jpa")
    private EntityManager em;

    public List<AccountOptions> getAccountOptions(){

        Query query = em.createNamedQuery("accountoptions.getAll", AccountOptions.class);

        return query.getResultList();

    }

    public List<AccountOptions> getAccountOptionsFilter(UriInfo uriInfo) {

        QueryParameters queryParameters = QueryParameters.query(uriInfo.getRequestUri().getQuery()).defaultOffset(0)
                .build();

        List<AccountOptions> accountOptions = JPAUtils.queryEntities(em, AccountOptions.class, queryParameters);

        return accountOptions;
    }

}