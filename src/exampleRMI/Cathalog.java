package exampleRMI;

import java.util.ArrayList;
import java.util.List;

public class Cathalog {
    private List<Produit> produits = new ArrayList<>();

    public Cathalog() {
        this.produits.add(new Produit("OTM"));
    }

    public List<Produit> getProduits() {
        return produits;
    }
    public List<Produit> getProduitNom(String s){
        List<Produit> pp = new ArrayList<>();
        for (Produit p:produits) {
            if(p.getNom().equals(s))
                pp.add(p);
        }
        return pp;
    }

    public  Produit  getProduit(Long s){

        for (Produit p:produits) {
            if(p.getId().equals(s))
                return p;
        }
        return null;
    }

}
