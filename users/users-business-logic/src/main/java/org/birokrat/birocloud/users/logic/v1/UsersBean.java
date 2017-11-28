package org.birokrat.birocloud.users.logic.v1;

import java.util.List;

// project
import org.birokrat.birocloud.users.persistence.v1.Users;

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
public class UsersBean {

    @PersistenceContext(unitName = "users-jpa")
    private EntityManager em;

    public List<Users> getUsers(){

        Query query = em.createNamedQuery("Users.getAll", Users.class);

        return query.getResultList();

    }

    public List<Users> getUsersFilter(UriInfo uriInfo) {

        QueryParameters queryParameters = QueryParameters.query(uriInfo.getRequestUri().getQuery()).defaultOffset(0)
                .build();

        List<Users> users = JPAUtils.queryEntities(em, Users.class, queryParameters);

        return users;
    }

}