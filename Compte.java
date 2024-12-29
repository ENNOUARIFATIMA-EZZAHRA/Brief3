package App;

public class Compte {
    private String num;
    private double sold;
    private Client proprietaire;

    public Compte(String num, double sold, Client proprietaire) {
        this.num = num;
        this.sold = sold;
        this.proprietaire = proprietaire;
    }


    public void deposer(double montant) {
        if (montant > 0) {
            this.sold += montant;
            System.out.println("Dépôt de " + montant + " MAD réussi. Nouveau solde: " + this.sold + "€.");
        } else {
            System.out.println(" votre sole 0 MAD .");
        }
    }


    public void retirer(double montant) {
        if (montant > 0 && montant <= this.sold) {
            this.sold -= montant;
            System.out.println("Retrait de " + montant + " MAD  réussi. Nouveau solde: " + this.sold + "MAD.");
        } else if (montant > this.sold) {
            System.out.println("Solde insuffisant pour retirer " + montant + "MAD.");
        } else {
            System.out.println(" votre sole 0 MAD .");
        }
        
    }


    public String getNumero() {
        return num;
    }

    public double getSolde() {
        return sold;
    }

    public Client getProprietaire() {
        return proprietaire;
    }

    @Override
    public String toString() {
        return "Compte{num='" + num + "', solde=" + sold + ", proprietaire=" + proprietaire.getNom() + "}";
    }
}
