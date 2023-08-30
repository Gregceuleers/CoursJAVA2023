package be.bstorm.streams.exos;


public class Main {

    public static void main(String[] args) {
        UtilGenerator.enregistrerEmplacementsAleatoires(UtilGenerator.genererEmplacementsAleatoires(50), "emplacements.csv");
//        UtilGenerator.recupererListeEmplacements("emplacements.csv").forEach(System.out::println);
    }
}
