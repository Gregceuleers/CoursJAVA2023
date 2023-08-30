package be.bstorm.streams.exos;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Emplacement {

    private static int COUNT = 1;

    private int numero;

    private TypeEmplacement typeEmplacement;

    private TailleEmplacement tailleEmplacement;

    private List<Occupation> occupationList;

    public int getNumero() {
        return numero;
    }

    public TypeEmplacement getTypeEmplacement() {
        return typeEmplacement;
    }

    public TailleEmplacement getTailleEmplacement() {
        return tailleEmplacement;
    }

    public List<Occupation> getOccupationList() {
        return occupationList;
    }

    public Emplacement(TypeEmplacement typeEmplacement, TailleEmplacement tailleEmplacement, List<Occupation> occupationList) {
        this.numero = COUNT++;
        this.typeEmplacement = typeEmplacement;
        this.tailleEmplacement = tailleEmplacement;
        this.occupationList = occupationList;
    }

    public Emplacement(int numero, TypeEmplacement typeEmplacement, TailleEmplacement tailleEmplacement, List<Occupation> occupationList) {
        this.numero = numero;
        this.typeEmplacement = typeEmplacement;
        this.tailleEmplacement = tailleEmplacement;
        this.occupationList = occupationList;
    }

    public double calculerPrixRevientTotal() {

        int nombreTotalOccupants = this.occupationList.stream()
                .map(Occupation::getNbOccupants)
                .reduce(Integer::sum)
                .orElse(0);

        return nombreTotalOccupants * this.typeEmplacement.getPrice();
    }

    public boolean verifierOccupation(LocalDate dateDOccupation) {
        return this.occupationList.stream()
                .anyMatch(o -> (o.getDateArrivee().isBefore(dateDOccupation) || o.getDateArrivee().isEqual(dateDOccupation))
                        && (o.getDateDepart().isAfter(dateDOccupation) || o.getDateDepart().isEqual(dateDOccupation)));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emplacement that = (Emplacement) o;
        return numero == that.numero && typeEmplacement == that.typeEmplacement && tailleEmplacement == that.tailleEmplacement && Objects.equals(occupationList, that.occupationList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, typeEmplacement, tailleEmplacement, occupationList);
    }

    @Override
    public String toString() {
        return "Emplacement{" +
                "numero=" + numero +
                ", typeEmplacement=" + typeEmplacement +
                ", tailleEmplacement=" + tailleEmplacement +
                ", occupationList=" + occupationList +
                '}';
    }

    public String toCSVString() {
        return numero + ";" + typeEmplacement + ";" + tailleEmplacement + ";[" + occupationList.stream().map(Occupation::toCSVString).collect(Collectors.joining(",")) + "]";
    }

    public static Emplacement fromCSVString(String data) {
        // 5;CARAVANE;M;[{21;2023-07-10;2023-07-16;6},{22;2023-08-20;2023-08-26;1}]
        String[] donnees = data.split(";", 4);
        return new Emplacement(
                Integer.parseInt(donnees[0]),
                TypeEmplacement.valueOf(donnees[1]),
                TailleEmplacement.valueOf(donnees[2]),
                Occupation.fromCSVString(donnees[3])
        );
    }
}
