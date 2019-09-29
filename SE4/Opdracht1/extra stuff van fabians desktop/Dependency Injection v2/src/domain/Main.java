package domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main {
    public static Klant huurder, verhuurder;
    private static ApplicationContext applicationContext;

    @Autowired
    public Main(Huurder huurder, Verhuurder verhuuder) {
        Main.huurder = huurder;
        Main.verhuurder = verhuuder;
    }

    public static void main(String[] args) {
        System.out.println("Starting....");

        applicationContext = new AnnotationConfigApplicationContext(KlantConfig.class);

        System.out.println("Spring context initialized.");
        System.out.println("Huurder's naam: '" + huurder.getNaam());
        System.out.println("Verhuuder's naam: " + verhuurder.getNaam());
    }
}