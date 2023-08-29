package be.bstorm.utils.models;

public interface PeutRouler {

    short getNombreRoues();

    default <T extends Vehicule> void seDeplacer(T vehicule) {

        Class<?> clazz = vehicule.getClass();

        switch (clazz.getSimpleName()) {
            case "VoitureImpl":
                System.out.printf(
                        "%s %s se déplace en roulant sur ses %d roues ! ",
                        ((Voiture)vehicule).getMarque(),
                        vehicule.getModele(),
                        this.getNombreRoues()
                );
                System.out.println();
                break;
            case "MotoImpl": {
                System.out.printf(
                        "%s %s se déplace en filant sur ses %d roues ! ",
                        ((Moto)vehicule).getMarque(),
                        vehicule.getModele(),
                        this.getNombreRoues()
                );
                System.out.println();
                break;
            }
        }


    }

}
