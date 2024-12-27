import java.util.ArrayList;

public class Operation {
    private String type;
    private double montant;
    private String date;
    private String compteAssocie;
//constructor

    public Operation(String type, double montant, String date, String compteAssocie) {
        this.type = type;
        this.montant = montant;
        this.date = date;
        this.compteAssocie = compteAssocie;
    }

    //geters and setters

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCompteAssocie() {
        return compteAssocie;
    }

    public void setCompteAssocie(String compteAssocie) {
        this.compteAssocie = compteAssocie;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "type='" + type + '\'' +
                ", montant=" + montant +
                ", date='" + date + '\'' +
                ", compteAssocie='" + compteAssocie + '\'' +
                '}';
    }



}










