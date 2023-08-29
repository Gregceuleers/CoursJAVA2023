package be.bstorm.utils.models.impl;

import be.bstorm.utils.models.PeutRouler;
import be.bstorm.utils.models.Voiture;
import be.bstorm.utils.models.enums.Carburant;
import be.bstorm.utils.models.enums.TypeVoiture;

public class VoitureImpl extends VehiculeImpl implements Voiture, PeutRouler {

    private short _nombrePortieres;

    private TypeVoiture _typeVoiture;

    private short _nombreRoues = 4;

    private String _marque;

    public VoitureImpl(String _modele, Carburant _carburant, Integer _cylindree, Integer _nombrePlaces, Integer _vitesseMaximale, String _marque, short _nombrePortieres, TypeVoiture _typeVoiture) {
        super(_modele, _carburant, _cylindree, _nombrePlaces, _vitesseMaximale);
        this._marque = _marque;
        this._nombrePortieres = _nombrePortieres;
        this._typeVoiture = _typeVoiture;
    }


    @Override
    public String getMarque() {
        return _marque;
    }

    @Override
    public short getNombrePortieres() {
        return _nombrePortieres;
    }

    @Override
    public TypeVoiture getTypeVoiture() {
        return _typeVoiture;
    }

    @Override
    public short getNombreRoues() {
        return _nombreRoues;
    }

    @Override
    public String toString() {
        return "VoitureImpl{" +
                super.toString() +
                ", nombrePortieres=" + _nombrePortieres +
                ", typeVoiture=" + _typeVoiture +
                ", nombreRoues=" + _nombreRoues +
                ", marque='" + _marque + '\'' +
                '}';
    }
}
