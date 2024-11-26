package com.fvelasquez.prueba;

import com.fvelasquez.prueba.infraestructure.rules.ProductCircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import org.junit.jupiter.api.Test;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductCircuitBreakerTest {

    @Test
    public void testCircuitBreaker() {
        // Crear una instancia de ProductCircuitBreaker
        ProductCircuitBreaker circuitBreaker = new ProductCircuitBreaker();

        // Ejecutar el circuit breaker
        for (int i = 0; i < 10; i++) {
            try {
                // Simular una llamada al servicio con un identificador de producto válido
                circuitBreaker.getProductByIdWithCircuitBreaker("existingProductId");
            } catch (Exception e) {
                // Manejar el error (por ejemplo, registro)
            }
        }

        // Dormir durante un tiempo mayor que la duración de espera en el estado abierto del circuit breaker
        try {
            Thread.sleep(Duration.ofMillis(2000).toMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Probar el circuit breaker nuevamente después del tiempo de espera
        try {
            circuitBreaker.getProductByIdWithCircuitBreaker("existingProductId");
        } catch (Exception e) {
            // El circuit breaker debería haber abierto el circuito y activado alguna acción de recuperación o fallback
        }

        // Realizar aserciones según sea necesario
        //assertEquals(circuitBreaker.getCircuitBreaker().getState(), CircuitBreaker.State.OPEN);
    }
}