package be.bstorm.utils.models;

import be.bstorm.utils.models.enums.TypeVoiture;

public interface Voiture {

    String getMarque();
    short getNombrePortieres();
    TypeVoiture getTypeVoiture();

}
