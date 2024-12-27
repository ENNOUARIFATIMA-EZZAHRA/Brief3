import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Client {
   private int id;
    private String nom;
    private String prenom;
    private String email;
    private String address;
    private String tel;

    //liste de affichage/ajouter
    //static pour chercher dans class
    private static ArrayList<Client> ListClients = new ArrayList<>();
    public Client(){

    }
    public Client(int id, int num, String nom, String prenom, String email, String address, String tel) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.address = address;
        this.tel = tel;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;

    }

    public static ArrayList<Client> getListClients() {
        return ListClients;
    }

    public static void setListClients(ArrayList<Client> listClients) {
        ListClients = listClients;
    }

    public void GestionClient() {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        sc.nextLine();
        do {
            System.out.println("******GERER DES CLIENTS******");
            System.out.println("1-Ajouter un Client Courant");
            System.out.println("2-Afficher un Client Epagne");
            System.out.println("3-Quitter");


            switch(c){
                case 1:
                    ajouterClient();
                    break;
                case 2:
                    afficherClient();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Choix invalide, veuillez reessayer.");
            }
        }while (c!=3);
    }
    @Override
    public String toString() {
        return "Client{" +
                "\n id=" + id +
                "\n, nom='" + nom + '\'' +
                "\n, prenom='" + prenom + '\'' +
                "\n, email='" + email + '\'' +
                "\n, address='" + address + '\'' +
                "\n, tel='" + tel + '\'' +
                '}';
    }

    public void ajouterClient() {
        Scanner sc = new Scanner(System.in);
        System.out.println("entrer Id de client");
        id= sc.nextInt();//pour stocker l'id de client a ete ajouter
        sc.nextLine();
        System.out.println("entrer le Num de client\n");
        int num = sc.nextInt();
        sc.nextLine();
        System.out.println("entrer le Name de client\n");
        String nom = sc.nextLine();
        System.out.println("entrer le Prenom de client\n");
        String prenom = sc.nextLine();
//boocle regex
//       do {
           System.out.println("entrer l'Email de client\n");
           String email = sc.nextLine();
           //if email valid entrer l'adress et tel
//           if (IsEmailValid(email)) {
               System.out.println("entrer l'Address de client\n");
               String address = sc.nextLine();
               System.out.println("entrer le Telephone de client\n");
               String tel = sc.nextLine();
               ListClients.add(new Client(id, num, nom, prenom, email, address, tel));
               System.out.println("Le client est Ajouter avec succes !");
//           } else {
//
//               System.out.println("email non valid\n");
//           }
           //look at the condition and start from first car compaire the condition with email
//       }while(!IsEmailValid(email));
    }
    public void afficherClient() {
        for (Client client : ListClients){
            System.out.println(client.toString());
        }
    }
    // La recherche du client pour l'associe a un compte
    public  Client RechercherClientParId(int idClient, ArrayList<Client> clients) {
        for (Client client : clients) {
            if (client.getId()==idClient) {
                return client;
            }
        }
        return null;
    }
//regex
    public  boolean IsEmailValid(String Email){

        return Pattern.matches("^[\\w\\.-]+@[a-zA-Z\\d\\.-]+\\.[a-zA-Z]{2,6}$",email);

    }
}


