package be.bstorm.utils.models;

import be.bstorm.utils.models.enums.Carburant;

public interface Vehicule {
    String getModele();
    Carburant getCarburant();
    Integer getCylindree();
    Integer getNombrePlaces();
    Integer getVitesseMaximale();

}
