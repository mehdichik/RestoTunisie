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

    public void insertStock(Client cl) {
        // DepotDAO depdao=new DepotDAO();

        String requete = "insert into stock (Nom,Prenom,Username,Password,Email) values (?,?,?,?,?)";
        try { //dep=depdao.findDepotById(st.getDepot().getId_dep());
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

    public void updateStock(Client cl) {
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

    public void deleteStock(int num) {

        String requete = "delete from stock where numero_client=?";
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

    public Client findStockByNum(int num) {

        String requete = "select * from stock where numero_client=?";

        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
//        DepotDAO depotDAO = new DepotDAO();
            Client client = new Client();
            while (resultat.next()) {

                client.setNumero_client(resultat.getInt(1));
                client.setNom(resultat.getString(2));
                client.setPrenom(resultat.getString(3));
                client.setUsername(resultat.getString(4));
                client.setPassword(resultat.getString(5));
                client.setEmail(resultat.getString(6));
//            stock.setType_vet_stock(resultat.getString(2));
//            stock.setNombre_articles(resultat.getInt(3));
//            stock.setDepot(depotDAO.findDepotById(resultat.getInt(4)));
            }
            return client;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement  " + ex.getMessage());
            return null;
        }
    }

    public List<Client> DisplayAllClient() {


        List<Client> listeClient = new ArrayList<Client>();

        String requete = "select * from Client";
        try {
            Statement statement = MyConnection.getInstance()
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
//            DepotDAO depotDAO = new DepotDAO();
            while (resultat.next()) {
                Client client = new Client();
//                stock.setNumero_stock(resultat.getInt(1));
                client.setNom(resultat.getString(1));
                client.setPrenom(resultat.getString(2));
                client.setUsername(resultat.getString(3));
                client.setPassword(resultat.getString(4));
                client.setEmail(resultat.getString(5));
//                stock.setType_vet_stock(resultat.getString(2));
//                stock.setNombre_articles(resultat.getInt(3));
//                stock.setDepot(depotDAO.findDepotById(resultat.getInt(4)));

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
