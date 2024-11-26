package com.fvelasquez.prueba.infraestructure.rest;

import com.fvelasquez.prueba.domain.port.IAtlasMongoDBService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serviciosexternos")
public class ServiciosexternosController {

    private final IAtlasMongoDBService iAtlasMongoDBService;

    public ServiciosexternosController(IAtlasMongoDBService iAtlasMongoDBService) {
        this.iAtlasMongoDBService = iAtlasMongoDBService;
    }

    @GetMapping("/processAtlasMongoDB")
    @CircuitBreaker(name = "processAtlasMongoDB", fallbackMethod = "fallbackMethod")
    public String processAtlasMongoDB() throws Exception {
        return iAtlasMongoDBService.estadoAtlasMongoDB();
    }

    public String fallbackMethod(Throwable throwable) {
        return "Lo sentimos, actualmente estamos experimentando dificultades técnicas para procesar pagos en línea. Por favor, inténtalo de nuevo más tarde. Agradecemos tu paciencia y comprensión.";
    }

}
