package be.bstorm.streams.exos;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

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

    public double calculerPrixRevientTotal() {

        int nombreTotalOccupants = this.occupationList.stream()
                .map(Occupation::getNbOccupants)
                .reduce(Integer::sum)
                .orElse(0);

        return nombreTotalOccupants * this.typeEmplacement.getPrice();
    }

    public boolean verifierOccupation(LocalDate dateDOccupation) {
        return this.occupationList.stream()
                .anyMatch(o -> (o.getDateArrivee().isAfter(dateDOccupation) || o.getDateArrivee().isEqual(dateDOccupation))
                        && (o.getDateDepart().isBefore(dateDOccupation) || o.getDateDepart().isEqual(dateDOccupation)));
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
}
