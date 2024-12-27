import java.util.ArrayList;
import java.util.Scanner;

class Compte {
    String num;
    double sold;
    Client proprietere=new Client();


    //ArrayList de Comptecourant
    private static ArrayList<Compte> listCompte = new ArrayList<>();

    public Compte(String num, double sold, Client proprietere) {
        this.num= num;
        this.sold=sold;
        this.proprietere=proprietere;

    }
    public Compte(){}
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public double getSold() {
        return sold;
    }

    public void setSold(double sold) {
        this.sold = sold;
    }

    public Client getProprietere() {
        return proprietere;
    }

    public void setProprietere(Client proprietere) {
        this.proprietere = proprietere;
    }

    public void GestionCompte() {
        Scanner sc = new Scanner(System.in);
        int choix = sc.nextInt();
        while (true) {
            System.out.println("******GERER DES COMPTES******");
            System.out.println("1-Ajouter un Compte Courant");
            System.out.println("2-Afficher un Compte Epagne");
            System.out.println("3-Quitter");
            if (choix == 0) {
                System.out.println("Retour au menu principal...");
                break;
            }
            switch (choix) {
                case 1:
                    ajouterCompte(Client.getListClients());
                    break;
                case 2:
                    afficherCompte();
                    break;
                default:
                    System.out.println("Choix invalide, veuillez reessayer.");
            }
        }
    }

    @Override
    public String toString() {
        return "compte{" +
                "\n num=" + num +
                "\n, sold=" + sold +
                "\n, proprietere='" + proprietere + '\'' +
                '}';
    }

    public void ajouterCompte( ArrayList<Client> listeClients ) {
        Scanner sc = new Scanner(System.in);
        System.out.println("entrer le Num de copmte\n");
        String num = sc.nextLine();
        System.out.println("entrer le sold de copmte\n");
        double sold = sc.nextDouble();
        System.out.println("entrer proprietere du compte\n");
        int idClient = sc.nextInt();
        Client c= proprietere.RechercherClientParId(idClient,listeClients);
        if(c!=null) {
            listCompte.add(new Compte(num, sold, c));
            System.out.println("Le compte est Ajouter avec succes !");
        }else {
            System.out.println("Le compte n'est pas Ajouter (le client n'existe pas!");
        }
        //proprietere
        //1-il faut entrer l'id du client pour lui associer un compte
        //2- Rechercher le client par id (RechercherClientParId)
        //3- si le client existe -> affecter le client au compte
        //4- Sinon operation annuler




    }
    public void afficherCompte() {
        for (Compte compte :  listCompte){
            System.out.println(compte.toString());
        }
    }
}





