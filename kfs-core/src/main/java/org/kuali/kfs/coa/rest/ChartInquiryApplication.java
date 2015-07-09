package org.kuali.kfs.coa.rest;

import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("inquiry")
public class ChartInquiryApplication extends Application {
    private Set<Object> singletons = new HashSet<>();

    public ChartInquiryApplication() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/kfs-dev/inquiry");
        beanConfig.setResourcePackage("org.kuali.kfs.coa.rest");
        beanConfig.setScan(true);

        singletons.add(new ChartInquiryResource());

    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();

        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        return resources;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
