package be.bstorm.streams.exos;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UtilGenerator {

    private static Random random = new Random();

    public static List<Emplacement> genererEmplacementsAleatoires(int nombreEmplacement) {

        List<Emplacement> output = new ArrayList<>(nombreEmplacement);

        for (int i = 0; i < nombreEmplacement; i++) {

            Emplacement e = genererEmplacementAleatoire();
            output.add(e);
        }

        return output;
    }

    public static void enregistrerEmplacementsAleatoires(List<Emplacement> emplacements, String filename) {
        File fichier = new File(filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichier))) {
            emplacements.forEach(e -> {
                try {
                    writer.write(e.toCSVString() + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static List<Emplacement> recupererListeEmplacements(String filename) {
        File fichier = new File(filename);
        try (BufferedReader reader = new BufferedReader(new FileReader(fichier))) {
           return reader.lines()
                   .map(Emplacement::fromCSVString)
                   .toList();

        }catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return new ArrayList<>();
    }

    private static Emplacement genererEmplacementAleatoire() {
        return new Emplacement(
                genererTypeEmplacement(),
                genererTailleEmplacement(),
                genererListeOccupation()
        );

    }

    private static TypeEmplacement genererTypeEmplacement() {
        return TypeEmplacement.values()[random.nextInt(TypeEmplacement.values().length)];
    }

    private static TailleEmplacement genererTailleEmplacement() {
        return TailleEmplacement.values()[random.nextInt(TailleEmplacement.values().length)];
    }

    private static List<Occupation> genererListeOccupation() {
        List<Occupation> output = new ArrayList<>(SemaineOccupation.values().length);

        for (int i = 0; i < SemaineOccupation.values().length; i++) {
            if (random.nextBoolean()) {
                output.add(
                        new Occupation(
                                SemaineOccupation.values()[i].getDateMin(),
                                SemaineOccupation.values()[i].getDateMax(),
                                random.nextInt(1, 7)
                        )
                );
            }
        }
        return output;
    }

    enum SemaineOccupation {
        SEMAINE_1(LocalDate.of(2023,7,3), LocalDate.of(2023,7,9)),
        SEMAINE_2(LocalDate.of(2023,7,10), LocalDate.of(2023,7,16)),
        SEMAINE_3(LocalDate.of(2023,7,17), LocalDate.of(2023,7,23)),
        SEMAINE_4(LocalDate.of(2023,7,24), LocalDate.of(2023,7,30)),
        SEMAINE_5(LocalDate.of(2023,7,31), LocalDate.of(2023,8,5)),
        SEMAINE_6(LocalDate.of(2023,8,6), LocalDate.of(2023,8,12)),
        SEMAINE_7(LocalDate.of(2023,8,13), LocalDate.of(2023,8,19)),
        SEMAINE_8(LocalDate.of(2023,8,20), LocalDate.of(2023,8,26));

        private LocalDate dateMin;

        private LocalDate dateMax;

        SemaineOccupation(LocalDate dateMin, LocalDate dateMax) {
            this.dateMin = dateMin;
            this.dateMax = dateMax;
        }

        public LocalDate getDateMin() {
            return dateMin;
        }

        public LocalDate getDateMax() {
            return dateMax;
        }
    }

}
