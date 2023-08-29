package be.bstorm.utils.models.impl;

import be.bstorm.utils.models.Moto;
import be.bstorm.utils.models.PeutRouler;
import be.bstorm.utils.models.enums.Carburant;
import be.bstorm.utils.models.enums.TypeMoto;

public class MotoImpl extends VehiculeImpl implements Moto, PeutRouler {

    private String _marque;

    private TypeMoto _typeMoto;

    private short _nombreRoues;

    @Override
    public String getMarque() {
        return _marque;
    }

    @Override
    public TypeMoto getTypeMoto() {
        return _typeMoto;
    }


    @Override
    public short getNombreRoues() {
        return _nombreRoues;
    }

    public MotoImpl(String _modele, Carburant _carburant, Integer _cylindree, Integer _nombrePlaces, Integer _vitesseMaximale, String _marque, TypeMoto _typeMoto) {
        super(_modele, _carburant, _cylindree, _nombrePlaces, _vitesseMaximale);
        this._marque = _marque;
        this._typeMoto = _typeMoto;
        this._nombreRoues = _typeMoto.nombreRoues;
    }

    @Override
    public String toString() {
        return "MotoImpl{" +
                super.toString() +
                ", _marque='" + _marque + '\'' +
                ", _typeMoto=" + _typeMoto +
                ", _nombreRoues=" + _nombreRoues +
                '}';
    }
}
