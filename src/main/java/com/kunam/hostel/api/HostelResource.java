package com.kunam.hostel.api;


import com.kunam.hostel.api.HostelDao;
import com.kunam.hostel.api.HostelDaoImpl;
import com.kunam.hostel.api.Hostel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/hostels")
public class HostelResource {

    private HostelDao hostelDao = new HostelDaoImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hostel> getAllUsers() {
        return hostelDao.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Hostel getUserById(@PathParam("id") int id) {
        return hostelDao.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(Hostel hostel) {
        hostelDao.save(hostel);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") long id, Hostel hostel) {
        hostel.setId(id);
        hostelDao.update(hostel);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") int id) {
        hostelDao.deleteById(id);
        return Response.noContent().build();
    }
}

