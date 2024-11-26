package com.fvelasquez.prueba.infraestructure.rules;

import com.fvelasquez.prueba.domain.model.Product;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;

public class ProductRules {

    /*
    public void applyRules(Product product) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(product);
        kieSession.fireAllRules();
        kieSession.dispose();
    }
*/

/*
    public void applyRules(Product product) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession();
        try {
            kieSession.insert(product);
            kieSession.fireAllRules();
        } finally {
            kieSession.dispose();
        }
    }

 */
public void applyRules(Product product) {
    KieServices kieServices = KieServices.Factory.get();
    KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
    kieFileSystem.write(ResourceFactory.newClassPathResource("ProductsRules.drl", getClass()));
    KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
    kieBuilder.buildAll();
    KieContainer kieContainer = kieServices.newKieContainer(kieBuilder.getKieModule().getReleaseId());
    KieSession kieSession = kieContainer.newKieSession();
    kieSession.insert(product);
    kieSession.fireAllRules();
    kieSession.dispose();
}


}
