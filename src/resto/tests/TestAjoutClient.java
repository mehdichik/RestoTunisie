/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resto.tests;

import resto.dao.ClientDAO;
import resto.entities.Client;

/**
 *
 * @author malek
 */
public class TestAjoutClient {
    public static void main(String[] args) {
//        Depot depot = new Depot();
        Client client = new Client();
        ClientDAO clientDAO = new ClientDAO();
        client.setNumero_client(2);
        client.setNom("Ibn Cheikh");
        client.setPrenom("Mehdi");
        client.setUsername("mehdichik");
        client.setPassword("mehdi");
        client.setEmail("mehdichik@gmail.com");
        clientDAO.insertClient(client);
//        DepotDAO depotDAO = new DepotDAO();
//        depot.setAdresse_depot("La Soukra");
//        depotDAO.insertDepot(depot);
    }
    
}
