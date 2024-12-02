package com.fvelasquez.prueba.infraestructure.security;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.stereotype.Component;

@Component
public class JwtUtilFirebase {

    // Método para validar el token usando Firebase
    public static FirebaseToken validateToken(String token) {
        try {
            // Elimina el prefijo "Bearer " del token si existe
            if (token.startsWith("Bearer ")) {
                token = token.substring(7);
            }
            // Valida el token con Firebase
            return FirebaseAuth.getInstance().verifyIdToken(token);
        } catch (Exception e) {
            throw new RuntimeException("Error al validar el token: " + e.getMessage(), e);
        }
    }
}
