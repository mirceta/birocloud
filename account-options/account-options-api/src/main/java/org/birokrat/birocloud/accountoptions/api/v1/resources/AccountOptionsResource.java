package org.birokrat.birocloud.accountoptions.api.v1.resources;

import java.util.List;

// project imports
import org.birokrat.birocloud.accountoptions.persistence.v1.AccountOptions;
import org.birokrat.birocloud.accountoptions.logic.v1.AccountOptionsBean;

// jax-rs
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

// other
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
@Path("/accountoptions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AccountOptionsResource {

    @Context
    protected UriInfo uriInfo;

    @Inject
    private AccountOptionsBean accountOptionsBean;

    @GET
    public Response getAccountOptions() {

        List<AccountOptions> AccountOptions = accountOptionsBean.getAccountOptions();

        return Response.ok(AccountOptions).build();
    }

    @GET
    @Path("/filtered")
    public Response getAccountOptionsFiltered() {

        List<AccountOptions> customers;

        customers = accountOptionsBean.getAccountOptionsFilter(uriInfo);

        return Response.status(Response.Status.OK).entity(customers).build();
    }

}

