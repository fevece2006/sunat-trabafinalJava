package com.fvelasquez.prueba.infraestructure.adapter;

import com.fvelasquez.prueba.domain.port.IAtlasMongoDBConexion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AtlasMongoDBConexionImpl implements IAtlasMongoDBConexion {

    private RestTemplate restTemplate;

    @Autowired
    public AtlasMongoDBConexionImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String processConexion() throws Exception {

        try {
            restTemplate.getForEntity("https://www.mongodb.com/atlas/database", String.class);
            return "Carga correcta de Atlas MongoDB";
        } catch (Exception ex) {
            throw ex;
        }

    }

}
