package App;

import java.util.Date;

public class Operation {
    private String type;
    private double montant;
    private Date date;
    private Compte compteAssocie;

    public Operation(String type, double montant, Compte compteAssocie) {
        this.type = type;
        this.montant = montant;
        this.date = new Date(); 
        this.compteAssocie = compteAssocie;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "type='" + type + '\'' +
                ", montant=" + montant +
                ", date=" + date +
                ", compteAssocie=" + compteAssocie.getNumero() +
                '}';
    }


    public String getType() {
        return type;
    }

    public double getMontant() {
        return montant;
    }

    public Date getDate() {
        return date;
    }

    public Compte getCompteAssocie() {
        return compteAssocie;
    }
}

