package be.bstorm.streams.exos;

import java.time.LocalDate;
import java.util.Objects;

public class Occupation {

    private static int COUNT = 1;

    private int id;
    private LocalDate dateArrivee;
    private LocalDate dateDepart;
    private int nbOccupants;

    public int getId() {
        return id;
    }

    public LocalDate getDateArrivee() {
        return dateArrivee;
    }

    public LocalDate getDateDepart() {
        return dateDepart;
    }

    public int getNbOccupants() {
        return nbOccupants;
    }

    public Occupation(LocalDate dateArrivee, LocalDate dateDepart, int nbOccupants) {
        this.id = COUNT++;
        this.dateArrivee = dateArrivee;
        this.dateDepart = dateDepart;
        this.nbOccupants = nbOccupants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Occupation that = (Occupation) o;
        return id == that.id && nbOccupants == that.nbOccupants && Objects.equals(dateArrivee, that.dateArrivee) && Objects.equals(dateDepart, that.dateDepart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateArrivee, dateDepart, nbOccupants);
    }

    @Override
    public String toString() {
        return "Occupation{" +
                "id=" + id +
                ", dateArrivee=" + dateArrivee +
                ", dateDepart=" + dateDepart +
                ", nbOccupants=" + nbOccupants +
                '}';
    }

    public String toCSVString() {
        return "{" + id + ";" + dateArrivee + ";" + dateDepart + ";" + nbOccupants + "}";
    }
}
