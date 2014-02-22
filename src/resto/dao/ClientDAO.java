/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resto.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import resto.entities.Client;

/**
 *
 * @author malek
 */
public class ClientDAO {

    public void insertClient(Client cl) {
       

        String requete = "insert into client (Nom,Prenom,Username,Password,Email) values (?,?,?,?,?)";
        try { 
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, cl.getNom());
            ps.setString(2, cl.getPrenom());
            ps.setString(3, cl.getUsername());
            ps.setString(4, cl.getPassword());
            ps.setString(5, cl.getEmail());
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }
    }

    public void updateClient(Client cl) {
        String requete = "update Client set Nom=?, Prenom=?, Username=?, Password=?, Email=? ";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, cl.getNom());
            ps.setString(2, cl.getPrenom());
            ps.setString(3, cl.getUsername());
            ps.setString(4, cl.getPassword());
            ps.setString(5, cl.getEmail());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }

    }

    public void deleteClient(int num) {

        String requete = "delete from client where numero_client=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, num);
            ps.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    public Client findClientByNum(int num) {

        String requete = "select * from client where numero_client=?";

        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
            Client client = new Client();
            while (resultat.next()) {

                client.setNumero_client(resultat.getInt(1));
                client.setNom(resultat.getString(2));
                client.setPrenom(resultat.getString(3));
                client.setUsername(resultat.getString(4));
                client.setPassword(resultat.getString(5));
                client.setEmail(resultat.getString(6));
            }
            return client;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement  " + ex.getMessage());
            return null;
        }
    }

    public List<Client> DisplayAllClient() {


        List<Client> listeClient = new ArrayList<Client>();

        String requete = "select * from client";
        try {
            Statement statement = MyConnection.getInstance().createStatement();

            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                Client client = new Client();

                client.setNumero_client(resultat.getInt(1));
                client.setNom(resultat.getString(2));
                client.setPrenom(resultat.getString(3));
                client.setUsername(resultat.getString(4));
                client.setPassword(resultat.getString(5));
                client.setEmail(resultat.getString(6));


                listeClient.add(client);
            }
            return listeClient;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des stocks " + ex.getMessage());
            return null;
        }
    }
}
