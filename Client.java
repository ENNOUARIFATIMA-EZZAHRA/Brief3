package App;

import java.util.ArrayList;

public class Client {
    private int id;
    private String nom , prenom,email,address,tel;

    private static ArrayList<Client> ListClients = new ArrayList<>();
    public Client(int id, String nom, String prenom, String email, String address, String tel) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.address = address;
        this.tel = tel;
    }

    // get client info
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getTel() {
        return tel;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nom: " + nom + ", Prénom: " + prenom + ", Email: " + email + ", Adresse: " + address + ", Téléphone: " + tel;
    }

    public static void ajouterClient(Client client) {
        ListClients.add(client);
        System.out.println("Client ajouté avec succès !");
    }


    public static void afficherClients() {
        if (ListClients.isEmpty()) {
            System.out.println("Aucun client à afficher.");
        } else {
            for (Client client : ListClients) {
                System.out.println(client);
            }
        }
    }


    public static Client rechercherClientParId(int id) {
        for (Client client : ListClients) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    }
}
