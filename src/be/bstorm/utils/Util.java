package be.bstorm.utils;

import be.bstorm.utils.models.Vehicule;
import be.bstorm.utils.models.enums.Carburant;
import be.bstorm.utils.models.enums.TypeMoto;
import be.bstorm.utils.models.enums.TypeVoiture;
import be.bstorm.utils.models.impl.MotoImpl;
import be.bstorm.utils.models.impl.VoitureImpl;

import java.util.Random;
import java.util.stream.Stream;

public class Util {

    private static final Random random = new Random();

    public static Vehicule randomVehicule() {
        return Streams.tableauVehicules()[random.nextInt(Streams.tableauVehicules().length)];
    }

    public static class Streams {

        public static Vehicule[] tableauVehicules() {
            return new Vehicule[]{
                    new VoitureImpl("Octavia", Carburant.ESSENCE, 1000, 5, 205, "SKoda",(short)4 , TypeVoiture.BREAK),
                    new VoitureImpl("Meriva", Carburant.DIESEL, 1500, 5, 183, "Opel",(short)4 , TypeVoiture.FAMILLIALE),
                    new VoitureImpl("Classe C Coupé", Carburant.ESSENCE, 2200, 4, 243, "Mercedes",(short)4 , TypeVoiture.COUPE),
                    new MotoImpl("GSXR", Carburant.ESSENCE, 600, 1, 295, "Honda", TypeMoto.DEUX_ROUES),
                    new MotoImpl("Vespa", Carburant.ELECTRIQUE, 50, 1, 85, "Piago", TypeMoto.SCOOTER)
            };
        }
        public static Stream<Vehicule> listeVehicules() {
            return Stream.of(
                    new VoitureImpl("Octavia", Carburant.ESSENCE, 1000, 5, 205, "SKoda",(short)4 , TypeVoiture.BREAK),
                    new VoitureImpl("Meriva", Carburant.DIESEL, 1500, 5, 183, "Opel",(short)4 , TypeVoiture.FAMILLIALE),
                    new VoitureImpl("Classe C Coupé", Carburant.ESSENCE, 2200, 4, 243, "Mercedes",(short)4 , TypeVoiture.COUPE),
                    new MotoImpl("GSXR", Carburant.ESSENCE, 600, 1, 295, "Honda", TypeMoto.DEUX_ROUES),
                    new MotoImpl("Vespa", Carburant.ELECTRIQUE, 50, 1, 85, "Piago", TypeMoto.SCOOTER)
            );
        }


    }

}
