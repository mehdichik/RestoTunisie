/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resto.frame;


import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import resto.dao.ClientDAO;
import resto.entities.Client;

/**
 *
 * @author Houssem Eddine
 */
public class MyTableModel extends AbstractTableModel {

    List<Client> listClient = new ArrayList<Client>();
    String []header = {"Nom","Prenom","Username","Password","Email"};

    public MyTableModel() { //remplissage de la liste des stocks
        listClient=new ClientDAO().DisplayAllClient();
    }
    
    public int getRowCount() { //nombre de lignes de la table
        return listClient.size();
    }

    public int getColumnCount() { //nombre de colonnes de la table
        return header.length;
    }

    //récupération de chaque élément de la table
    public Object getValueAt(int rowIndex, int columnIndex) { 
        switch (columnIndex) {// parcour par colonne
            case 0://colonne id_Stock
                return listClient.get(rowIndex).getNom();
            case 1://colonne type_vetement
                return listClient.get(rowIndex).getPrenom();
            case 2://colonne quantité
                return listClient.get(rowIndex).getUsername();
            case 3://colonne adresse depot
                return listClient.get(rowIndex).getPassword();
            case 4:
                return listClient.get(rowIndex).getEmail();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) { // nom des colonnes
        return header[column]; 
    }
    

}
