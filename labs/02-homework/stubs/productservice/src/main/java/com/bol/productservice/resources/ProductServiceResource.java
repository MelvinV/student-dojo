package com.bol.productservice.resources;

import com.bol.productservice.api.Product;
import com.bol.productservice.api.ProductList;
import com.bol.productservice.jdbi.ProductDao;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

@Path("/v1")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public class ProductServiceResource {
    private final ProductDao productDao;

    public ProductServiceResource(ProductDao customerDao) {
        this.productDao = customerDao;
    }

    @GET
    @Path("product")
    @Timed
    public ProductList getProducts() {
        ProductList productList = new ProductList();
        productList.setProducts(productDao.getProducts());
        return productList;
    }

    @GET
    @Path("product/{ean}")
    @Timed
    public Product getProduct(@PathParam("ean") String ean) {
        return productDao.getProduct(ean)
                .orElseThrow(() -> new WebApplicationException(Status.NOT_FOUND));
    }
}
