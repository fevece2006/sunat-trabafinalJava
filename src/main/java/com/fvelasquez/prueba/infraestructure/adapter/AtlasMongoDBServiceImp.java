package com.fvelasquez.prueba.infraestructure.adapter;

import com.fvelasquez.prueba.domain.port.IAtlasMongoDBConexion;
import com.fvelasquez.prueba.domain.port.IAtlasMongoDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtlasMongoDBServiceImp implements IAtlasMongoDBService {

    private final IAtlasMongoDBConexion iAtlasMongoDBConexion;

    @Autowired
    public AtlasMongoDBServiceImp(IAtlasMongoDBConexion iAtlasMongoDBConexion) {
        this.iAtlasMongoDBConexion = iAtlasMongoDBConexion;
    }


    @Override
    public String estadoAtlasMongoDB() throws Exception {
        return iAtlasMongoDBConexion.processConexion();
    }
}
