package com.fvelasquez.prueba.infraestructure.rules;


import com.fvelasquez.prueba.domain.model.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
public class PersonRules {

    public void applyRules(Person person) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(person);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

}
