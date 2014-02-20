/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resto.entities;

/**
 *
 * @author malek
 */
public class Client {

    private String Nom;
    private String Prenom;
    private String Username;
    private String Password;
    private String Email;
    private int numero_client;

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getNumero_client() {
        return numero_client;
    }

    public void setNumero_client(int numero_client) {
        this.numero_client = numero_client;
    }
    
    
}

