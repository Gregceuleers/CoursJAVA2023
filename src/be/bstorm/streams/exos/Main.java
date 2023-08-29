package be.bstorm.streams.exos;


public class Main {

    public static void main(String[] args) {
        UtilGenerator.genererEmplacementsAleatoires(10).forEach(System.out::println);
    }
}
