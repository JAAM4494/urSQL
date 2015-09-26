/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueryProcessor.GUI;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author jaam
 */
public class ResultSetManager {

    //{"Nombre":["Pedro","Mario","Pablo"],"columnNames":["Nombre","Apellido"],"rowsModif":"22","Apellido":["Ramirez","Castro","Perez"],"codeStatus":"1044"}
    // jTable1.getColumnModel().getColumn(0).setHeaderValue("Ariel");
    public DefaultTreeModel displayMetadata(String pResponse) throws JSONException {
        DefaultTreeModel model = new DefaultTreeModel(new DefaultMutableTreeNode("Schemas"));
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();

        JSONObject mainJSON = new JSONObject(pResponse);
        JSONArray mainArray = mainJSON.getJSONArray("columnNames");
        String tempDB;

        if (mainArray.length() != 0) {
            for (int i = 0; i < mainArray.length(); i++) {
                tempDB = mainArray.getString(i);
                JSONArray subArray = mainJSON.getJSONArray(tempDB);
                JSONObject subJSON;
                root.add(new DefaultMutableTreeNode(tempDB));
                //System.out.println(tempDB);
                //System.out.println("**");
                model.insertNodeInto(new DefaultMutableTreeNode("Tables"), root.getLastLeaf(),
                        root.getLastLeaf().getChildCount());
                if (subArray.length() != 0) {
                    for (int j = 0; j < subArray.length(); j++) {
                        subJSON = subArray.getJSONObject(j);
                        JSONArray subsubArray = subJSON.getJSONArray((String) subJSON.names().get(0));
                //System.out.println(subJSON.names().get(0).toString());
                        //System.out.println("----");
                        if (root.getLastChild().isLeaf()) {
                            model.insertNodeInto(new DefaultMutableTreeNode(subJSON.names().get(0).toString()), ((DefaultMutableTreeNode) root.getLastChild()).getLastLeaf(),
                                    ((DefaultMutableTreeNode) root.getLastChild()).getLastLeaf().getChildCount());
                        } else {
                            model.insertNodeInto(new DefaultMutableTreeNode(subJSON.names().get(0).toString()), ((DefaultMutableTreeNode) ((DefaultMutableTreeNode) root.getLastChild()).getLastChild()),
                                    ((DefaultMutableTreeNode) ((DefaultMutableTreeNode) root.getLastChild()).getLastChild()).getChildCount());
                        }

                        //////
                        model.insertNodeInto(new DefaultMutableTreeNode("Columns"), root.getLastLeaf().getLastLeaf().getLastLeaf(),
                                root.getLastLeaf().getLastLeaf().getLastLeaf().getChildCount());
                        for (int k = 0; k < subsubArray.length(); k++) {
                            //System.out.println(((DefaultMutableTreeNode) ((DefaultMutableTreeNode) ((DefaultMutableTreeNode) root.getLastChild()).getLastChild()).getLastChild()).getLastChild());
                            if (((DefaultMutableTreeNode) ((DefaultMutableTreeNode) ((DefaultMutableTreeNode) root.getLastChild()).getLastChild())
                                    .getLastChild()).getLastChild().isLeaf()) {
                                model.insertNodeInto(new DefaultMutableTreeNode(subsubArray.get(k)),
                                        ((DefaultMutableTreeNode) ((DefaultMutableTreeNode) ((DefaultMutableTreeNode) ((DefaultMutableTreeNode) root.getLastChild()).getLastChild())
                                        .getLastChild()).getLastChild()).getLastLeaf(),
                                        ((DefaultMutableTreeNode) ((DefaultMutableTreeNode) ((DefaultMutableTreeNode) ((DefaultMutableTreeNode) root.getLastChild()).getLastChild())
                                        .getLastChild()).getLastChild()).getLastLeaf().getChildCount());

                            } else {
                                model.insertNodeInto(new DefaultMutableTreeNode(subsubArray.get(k)),
                                        ((DefaultMutableTreeNode) ((DefaultMutableTreeNode) ((DefaultMutableTreeNode) ((DefaultMutableTreeNode) ((DefaultMutableTreeNode) root.getLastChild()).getLastChild())
                                        .getLastChild()).getLastChild())),
                                        ((DefaultMutableTreeNode) ((DefaultMutableTreeNode) ((DefaultMutableTreeNode) ((DefaultMutableTreeNode) ((DefaultMutableTreeNode) root.getLastChild()).getLastChild())
                                        .getLastChild()).getLastChild())).getChildCount());

                            }
                        }
                        //System.out.println("--");
                    }
                }
            }
        }

        return model;
    }

    public DefaultTableModel displayColumns(String pResponse) {
        DefaultTableModel newModel = new DefaultTableModel();
        newModel.addColumn("#");

        JSONObject json = null;
        JSONArray jArray = null;

        try {
            json = new JSONObject(pResponse);
            jArray = json.getJSONArray("columnNames");
        } catch (JSONException ex) {
            Logger.getLogger(ResultSetManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (jArray.length() == 0) {
            // cuando no se realizan consultas con valores de retorno
        } else {
            for (int i = 0; i < jArray.length(); i++) {
                try {
                    JSONArray jArrayAux = json.getJSONArray(jArray.getString(i));
                    newModel.addColumn(jArray.getString(i));
                    newModel.setRowCount(jArrayAux.length());
                    for (int j = 0; j < jArrayAux.length(); j++) {
                        newModel.setValueAt(jArrayAux.get(j), j, i + 1);
                        newModel.setValueAt(j, j, 0);
                        //newModel.setValueAt(Integer.toString(j), j, 0);
                    }
                } catch (JSONException ex) {
                    Logger.getLogger(ResultSetManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return newModel;
    }

    public String displayStatus(String pResponse) {
        String rValue = null;

        JSONObject json = null;

        try {
            json = new JSONObject(pResponse);
            rValue = "Code: " + json.getString("codeStatus") + " : " + json.getString("rowsModif") + " rows modified.";
        } catch (JSONException ex) {
            Logger.getLogger(ResultSetManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rValue;
    }

}
