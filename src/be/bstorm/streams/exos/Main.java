package be.bstorm.streams.exos;


import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
//        UtilGenerator.enregistrerEmplacementsAleatoires(UtilGenerator.genererEmplacementsAleatoires(50), "emplacements.csv");
        List<Emplacement> emplacements = UtilGenerator.recupererListeEmplacements("emplacements.csv");

        // Question 1
        // Calculer le nombre d'emplacement qui génère plus de 1000 EUR de rentrée et me les afficher
        System.out.println(
                "Nb d'emplacements générant plus de 1000 EUR : " + emplacements.stream()
                        .filter(e -> e.calculerPrixRevientTotal() > 1000)
                        .peek(System.out::println)
                        .count()
        );

        // Question 2
        // Puis-je réserver un emplacement de type CARAVANE le 15 Juillet 2023.
        // Si oui me montrer les emplacements correspondants
        System.out.println(emplacements.stream()
                .filter(e -> e.getTypeEmplacement() == TypeEmplacement.CARAVANE
                        && !e.verifierOccupation(LocalDate.of(2023, 7, 15))
                )
                .peek(System.out::println)
                .count() > 0 ? "ON PEUT" : "ON NE PEUT PAS");

        // Question 3
        // Calculer la fréquentation totale de mon camping
        // V1 Stream de stream
        System.out.println(
                emplacements.stream()
                        .mapToInt(e -> e.getOccupationList().stream()
                                .mapToInt(Occupation::getNbOccupants)
                                .sum()
                        ).sum()
        );
        // V2 Optimisation avec flatMap()
        System.out.println(
                emplacements.stream()
                        .flatMapToInt(e -> e.getOccupationList().stream()
                                .mapToInt(Occupation::getNbOccupants))
                        .sum()
        );

        // Question 4
        // Grouper par semaine d'occupations les emplacements et on afficher le total par semaine
       emplacements.stream()
                .flatMap(e -> e.getOccupationList().stream()
                        .sorted(Comparator.comparing(Occupation::getDateArrivee)))
                .collect(Collectors.groupingBy(Occupation::getDateArrivee))
                .forEach((k,v) -> System.out.println(k + " : " + v.stream()
                        .map(o -> {
                            int output = 0;
                            for (Emplacement e : emplacements) {
                                if (e.getOccupationList().stream().anyMatch(occ -> occ.getId() == o.getId())) {
                                    output = e.getNumero();
                                }
                            }
                            return String.valueOf(output);
                        })
                        .collect(Collectors.joining(","))));


    }
}
