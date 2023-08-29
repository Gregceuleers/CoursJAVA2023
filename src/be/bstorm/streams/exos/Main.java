package be.bstorm.streams.exos;


public class Main {

    public static void main(String[] args) {
        UtilGenerator.genererEmplacementsAleatoires(10).forEach(e -> System.out.println(e.toCSVString()));
    }
}
