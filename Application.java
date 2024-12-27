
import java.util.ArrayList;
import java.util.Scanner;
public class Application {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        ArrayList<Client> clients = new ArrayList<>();
          ArrayList<Compte> listCompte = new ArrayList<>();
        Client client = new Client();
        Compte compte = new Compte();
        Compte ajouterClient= new Compte();
        Compte afficherCompte= new Compte();


        int choix;
        do {

            System.out.println(" --------Menu principal-----");
            System.out.println("1. Gestion des clients : ");
            System.out.println("2. gestion des Compte: ");
            System.out.println("0. Quitter");
            System.out.print("votre choix :");
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    client.GestionClient();

                    break;
                case 2:
                    //compte.GestionCompte();
                    break;
                case 0:
                    System.out.println("Au revoir!");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 0);
    }


}
