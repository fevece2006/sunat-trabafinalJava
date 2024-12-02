package com.fvelasquez.prueba.infraestructure.security;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;

//@Configuration
public class FirebaseConfig {

    public FirebaseConfig() {
        try {
            FileInputStream serviceAccount =
                    new FileInputStream("ruta-a-tu-archivo-de-credenciales.json");

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al inicializar Firebase", e);
        }
    }
}
