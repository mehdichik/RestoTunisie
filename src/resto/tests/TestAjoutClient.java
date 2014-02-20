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
        client.setNom("Mehdi");
        clientDAO.insertClient(client);
//        DepotDAO depotDAO = new DepotDAO();
//        depot.setAdresse_depot("La Soukra");
//        depotDAO.insertDepot(depot);
    }
    
}
