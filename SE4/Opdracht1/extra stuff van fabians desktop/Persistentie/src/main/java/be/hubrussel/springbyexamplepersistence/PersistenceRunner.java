package be.hubrussel.springbyexamplepersistence;

import be.hubrussel.domain.*;

import be.hubrussel.service.OhsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.List;

public class PersistenceRunner {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersistenceConfig.class)) {

            OhsService persistenceService = (OhsService) applicationContext.getBean("ohsService");
            persistenceService.voegMatToe(555.00, new Date("02/02/1999"), "Goed", 129);
            System.out.println("mat toegevoegd");

            Mat m = persistenceService.zoekMat(1);
            System.out.println(m.getStatus());

            m.markeerAlsVersleten();
            persistenceService.bewerkMat(m);

            m.herstel();
            persistenceService.bewerkMat(m);
        }
    }
}
