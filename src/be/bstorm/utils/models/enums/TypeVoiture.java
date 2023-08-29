package be.bstorm.utils.models.enums;

public enum TypeVoiture {
    BERLINE("Berline"),
    COUPE("Coupé"),
    CITADINE("Citadine"),
    BREAK("Break"),
    SUV("SUV"),
    FAMILLIALE("Familliale"),
    TOUT_TERRAIN("Tout terrain"),
    SPORT("Sport");

    final String display;

    TypeVoiture(String display) {
        this.display = display;
    }
}
