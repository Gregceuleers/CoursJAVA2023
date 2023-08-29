package be.bstorm.utils.models.enums;

public enum TypeMoto {
    DEUX_ROUES("2 roues", (short) 2),
    TROIS_ROUES("3 roues", (short) 3),
    QUAD("Quad", (short) 4),
    SCOOTER("Scooter", (short) 2);

    String display;

    public short nombreRoues;

    private TypeMoto(String display, short nombreRoues)
    {
        this.display = display;
        this.nombreRoues = nombreRoues;
    }
}
