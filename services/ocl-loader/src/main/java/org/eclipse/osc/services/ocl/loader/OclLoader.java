package org.eclipse.osc.services.ocl.loader;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.karaf.minho.boot.service.ServiceRegistry;
import org.apache.karaf.minho.boot.spi.Service;

import java.net.URL;

public class OclLoader implements Service {

    private ObjectMapper mapper;

    @Override
    public String name() {
        return "osc-ocl-loader";
    }

    @Override
    public int priority() {
        return 900;
    }

    @Override
    public void onRegister(ServiceRegistry serviceRegistry) {
        mapper = new ObjectMapper();
    }

    public Ocl getOcl(URL url) throws Exception {
        return mapper.readValue(url, Ocl.class);
    }

}
