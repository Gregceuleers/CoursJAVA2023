package be.bstorm.utils.models.impl;

import be.bstorm.utils.models.Vehicule;
import be.bstorm.utils.models.enums.Carburant;

import java.util.Objects;

public abstract class VehiculeImpl implements Vehicule {
    private String _modele;
    private Carburant _carburant;
    private Integer _cylindree;
    private Integer _nombrePlaces;
    private Integer _vitesseMaximale;
    public String getModele() {
        return _modele;
    }
    public Carburant getCarburant() {
        return _carburant;
    }
    public Integer getCylindree() {
        return _cylindree;
    }
    public Integer getNombrePlaces() {
        return _nombrePlaces;
    }
    public Integer getVitesseMaximale() {
        return _vitesseMaximale;
    }

    protected VehiculeImpl(String _modele, Carburant _carburant, Integer _cylindree, Integer _nombrePlaces, Integer _vitesseMaximale) {
        this._modele = _modele;
        this._carburant = _carburant;
        this._cylindree = _cylindree;
        this._nombrePlaces = _nombrePlaces;
        this._vitesseMaximale = _vitesseMaximale;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehiculeImpl vehicule = (VehiculeImpl) o;
        return Objects.equals(_modele, vehicule._modele) && _carburant == vehicule._carburant && Objects.equals(_cylindree, vehicule._cylindree) && Objects.equals(_nombrePlaces, vehicule._nombrePlaces) && Objects.equals(_vitesseMaximale, vehicule._vitesseMaximale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_modele, _carburant, _cylindree, _nombrePlaces, _vitesseMaximale);
    }

    @Override
    public String toString() {
        return  "modele='" + _modele + '\'' +
                ", carburant=" + _carburant +
                ", cylindree=" + _cylindree +
                ", nombrePlaces=" + _nombrePlaces +
                ", vitesseMaximale=" + _vitesseMaximale;
    }
}
