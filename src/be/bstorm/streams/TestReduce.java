package be.bstorm.streams;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TestReduce {

    private static final float TVA21 = 1.21F;
    private static final float TVA12 = 1.12F;
    private static final float TVA6 = 1.06F;

    private static final ProduitEnCommande[] PANIER = new ProduitEnCommande[]{
            new ProduitEnCommande("Luminaire", 15.95F, 1, TVA6),
            new ProduitEnCommande("Pile AAA",12.55F, 2, TVA12),
            new ProduitEnCommande("Vis", 0.95F, 4, TVA21),
            new ProduitEnCommande("Gant", 2.95F, 2, TVA21),
    };

    public static void main(String[] args) {

        System.out.println("TOTAL PANIER : " + Arrays.stream(PANIER)
                .map(p -> {
                    String result = String.valueOf(p.getPrix() * p.getQuantite() * p.getTvaAppliquee());
                    String[] split = result.split("[.]");
                    return Float.parseFloat(split[0]+"."+ split[1].substring(0,2));
                })
                .peek(p -> System.out.println("Prix TVAC : " + p))
                .reduce(Float::sum).get()
        );

        System.out.println("MOYENNE PANIER : " + Arrays.stream(PANIER)
                .collect(Collectors.averagingDouble(ProduitEnCommande::getPrix))
        );
        System.out.println("STATISTIQUES PRIX PANIER " + Arrays.stream(PANIER)
                .collect(Collectors.summarizingDouble(ProduitEnCommande::getPrix))
        );

        System.out.println("GROUPEMENT " + Arrays.stream(PANIER)
                .collect(Collectors.partitioningBy(p -> p.getTvaAppliquee() > 1.06))
        );
    }

}

class ProduitEnCommande {

    private String nom;
    private float prix;
    private int quantite;
    private float tvaAppliquee;

    public ProduitEnCommande(String nom, float prix, int quantite, float tvaAppliquee) {
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
        this.tvaAppliquee = tvaAppliquee;
    }

    public String getNom() {
        return nom;
    }

    public float getPrix() {
        return prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public float getTvaAppliquee() {
        return tvaAppliquee;
    }

    @Override
    public String toString() {
        return "ProduitEnCommande{" +
                "nom='" + nom + '\'' +
                ", prix=" + prix +
                ", quantite=" + quantite +
                ", tvaAppliquee=" + tvaAppliquee +
                '}';
    }
}
