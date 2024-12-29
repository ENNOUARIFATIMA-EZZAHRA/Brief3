package App;

import java.util.ArrayList;
import java.util.Scanner;
public class Application {
    private static ArrayList<Client> clients = new ArrayList<>();
    private static ArrayList<Compte> comptes = new ArrayList<>();
    private static ArrayList<Operation> operations = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("****** MENU DE L'APPLICATION BANCAIRE ******");
            System.out.println("1. Gérer les Clients");
            System.out.println("2. Gérer les Comptes");
            System.out.println("3. Effectuer une Opération");
            System.out.println("4. Quitter");

            int choix = sc.nextInt();
            sc.nextLine();  

            switch (choix) {
                case 1:
                    menuClient(sc); 
                    break;
                case 2:
                    menuCompte(sc); 
                    break;
                case 3:
                    menuOperation(sc); 
                    break;
                case 4:
                    running = false;
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide choose [1,2,3,4].");
            }
        }
        sc.close();
    }


    public static void menuClient(Scanner sc) {
        boolean running = true;

        while (running) {
            System.out.println("****** GÉRER DES CLIENTS ******");
            System.out.println("1. Ajouter un Client");
            System.out.println("2. Afficher tous les Clients");
            System.out.println("3. Retourner au menu principal");

            int choix = sc.nextInt();
            sc.nextLine(); 

            switch (choix) {
                case 1:
                    ajouterClient(sc); 
                    break;
                case 2:
                    Client.afficherClients(); 
                    break;
                case 3:
                    running = false; 
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
    }
    public static void menuCompte(Scanner sc) {
        boolean running = true;

        while (running) {
            System.out.println("****** GÉRER DES COMPTES ******");
            System.out.println("1. Ajouter un Compte");
            System.out.println("2. Afficher tous les Comptes");
            System.out.println("3. Retourner au menu principal");

            int choix = sc.nextInt();
            sc.nextLine(); 

            switch (choix) {
                case 1:
                    ajouterCompte(sc) ;
                    break;
                case 2:
                    afficherComptes(); 
                    break;
                case 3:
                    running = false; 
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
    }
    public static void menuOperation(Scanner sc) {
        boolean running = true;

        while (running) {
            System.out.println("****** GÉRER LES OPÉRATIONS ******");
            System.out.println("1. Effectuer un Dépôt");
            System.out.println("2. Effectuer un Retrait");
            System.out.println("3. Afficher l'historique des Opérations");
            System.out.println("4. Retourner au menu principal");

            int choix = sc.nextInt();
            sc.nextLine(); 

            switch (choix) {
                case 1:
                    effectuerDepot(sc); 
                    break;
                case 2:
                    effectuerRetrait(sc);  
                    break;
                case 3:
                    afficherHistoriqueOperations();  
                    break;
                case 4:
                    running = false;  
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
    }

    
    public static void ajouterClient(Scanner sc) {
        System.out.println("Entrer l'ID du client:");
        int id = sc.nextInt();
        sc.nextLine();  

        System.out.println("Entrer le nom du client:");
        String nom = sc.nextLine();

        System.out.println("Entrer le prénom du client:");
        String prenom = sc.nextLine();

        System.out.println("Entrer l'email du client:");
        String email = sc.nextLine();

        System.out.println("Entrer l'adresse du client:");
        String address = sc.nextLine();

        System.out.println("Entrer le téléphone du client:");
        String tel = sc.nextLine();

        Client client = new Client(id, nom, prenom, email, address, tel);
        Client.ajouterClient(client);
    }

    public static void ajouterCompte(Scanner sc) {
        System.out.println("Entrer le numéro du compte : ");
        String num = sc.nextLine();
        System.out.println("Entrer le solde du compte : ");
        double sold = sc.nextDouble();
        sc.nextLine();  

        System.out.println("Entrer l'ID du client propriétaire : ");
        int idClient = sc.nextInt();
        sc.nextLine();  

        Client client = Client.rechercherClientParId(idClient);
        if (client != null) {
            Compte compte = new Compte(num, sold, client);
            comptes.add(compte);
            System.out.println("Compte ajouté avec succès !");
        } else {
            System.out.println("Client non trouvé !");
        }
    }
    public static void afficherComptes() {
        if (comptes.isEmpty()) {
            System.out.println("Aucun compte à afficher.");
        } else {
            for (Compte compte : comptes) {
                System.out.println(compte);
            }
        }
    }

    public static void effectuerDepot(Scanner sc) {
        System.out.println("Entrer le numéro de compte : ");
        String numeroCompte = sc.nextLine();
        Compte compte = rechercherCompte(numeroCompte);

        if (compte != null) {
            System.out.println("Entrer le montant à déposer : ");
            double montant = sc.nextDouble();
            sc.nextLine(); 
            compte.deposer(montant);
            operations.add(new Operation("deposit", montant, compte));
            System.out.println("Dépôt effectué avec succès !");
        } else {
            System.out.println("Compte non trouvé !");
        }
    }
    public static void effectuerRetrait(Scanner sc) {
        System.out.println("Entrer le numéro de compte : ");
        String numeroCompte = sc.nextLine();
        Compte compte = rechercherCompte(numeroCompte);

        if (compte != null) {
            System.out.println("Entrer le montant à retirer : ");
            double montant = sc.nextDouble();
            sc.nextLine();  

            compte.retirer(montant);
            operations.add(new Operation("withdraw", montant, compte));
            System.out.println("Retrait effectué avec succès !");
        } else {
            System.out.println("Compte non trouvé !");
        }
    }

    public static void afficherHistoriqueOperations() {
        if (operations.isEmpty()) {
            System.out.println("Aucune opération effectuée.");
        } else {
            for (Operation operation : operations) {
                System.out.println(operation);
            }
        }
    }

    public static Compte rechercherCompte(String numeroCompte) {
        for (Compte compte : comptes) {
            if (compte.getNumero().equals(numeroCompte)) {
                return compte;
            }
        }
        return null;
    }
}
