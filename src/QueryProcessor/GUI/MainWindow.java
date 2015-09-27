/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueryProcessor.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author jaam
 */
public class MainWindow extends JFrame implements Observer, Runnable {

    private int numScripts;
    private int numTabs;

    private TextAnalysis textAnalizer;
    private ArrayList<JTextPane> paneList;

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();

        this.paneList = new ArrayList<>();
        paneList.add(scriptTxtPane);
        numScripts = 1;
        numTabs = 0;

        this.logErrorArea.setEditable(false);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

    }

    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    private void processQueries(String pQueries) {
        String[] qList = pQueries.split(";");

        for (int i = 0; i < qList.length; i++) {
            try {
                //System.out.println(tempText);
                Connector conn = new Connector(8080);
                String out = conn.sendMessage(qList[i]);
                //System.out.println(out);
                processQueriesAux(out);

            } catch (IOException ex) {
                System.out.println("Error 1184: Connecting to urSQL, verify connection.");
                //Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void processQueriesAux(String pResponse) {
        JSONObject json = null;
        try {
            json = new JSONObject(pResponse);
            if (json.getString("format").equals("json") | json.getString("format").equals("xml")) {
                ForXMLForJSONWindow display = ForXMLForJSONWindow.getObject();
                display.setTextArea(pResponse);
                display.setVisible(true);
            } else {
                ResultSetManager nn = new ResultSetManager();
                jTable1.setModel(nn.displayColumns(pResponse));

                if (logErrorArea.getText().equals("")) {
                    logErrorArea.append(nn.displayStatus(pResponse));
                } else {
                    logErrorArea.append("\n" + nn.displayStatus(pResponse));
                }
            }

        } catch (JSONException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void saveFile() {
        JFileChooser saveFile = new JFileChooser();
        //saveFile.showSaveDialog(null);
        int returnVal = saveFile.showSaveDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            BufferedWriter out = null;
            try {

                out = new BufferedWriter(new FileWriter(saveFile.getSelectedFile().getPath() + ".urSQL"));
                JTextPane tempPane = null;
                int textPaneSelected = jTabbedPane1.getSelectedIndex();
                if (textPaneSelected != -1) {
                    tempPane = paneList.get(textPaneSelected);
                }

                if (tempPane != null) {
                    out.write(tempPane.getText());
                }

            } catch (IOException ex) {
                System.out.println("Error saving file");
            } finally {
                try {
                    out.close();
                } catch (IOException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    private void loadFile() {
        JFileChooser loadFile = new JFileChooser();
        //saveFile.showSaveDialog(null);
        int returnVal = loadFile.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            FileInputStream fis = null;
            try {
                //String fileName;

                File selectedFile = loadFile.getSelectedFile();
                //fileName = selectedFile.getName();
                fis = new FileInputStream(selectedFile);
                InputStreamReader in
                        = new InputStreamReader(fis, Charset.forName("UTF-8"));
                char[] buffer = new char[1024];
                int n = in.read(buffer);
                String text = new String(buffer, 0, n);

                JTextPane newScriptPane = new JTextPane();

                Font font = newScriptPane.getFont();
                float size = font.getSize() + 4.0f;
                newScriptPane.setFont(font.deriveFont(size));
                newScriptPane.setText(text);

                jTabbedPane1.addTab("urSQL File " + Integer.toString(numScripts += 1), newScriptPane);
                jTabbedPane1.setSelectedIndex(numTabs += 1);

                paneList.add(newScriptPane);

                in.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Error file not found");
            } catch (IOException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    private void refresh() {
        String tempText = "metadata";

        try {
            Connector conn = new Connector(8080);
            String out = conn.sendMessage(tempText);
            //System.out.println(out);
            ResultSetManager nn = new ResultSetManager();
            schemasTree.setModel(nn.displayMetadata(out));
        } catch (IOException ex) {
            System.out.println("Error 1184: Connecting to urSQL, verify connection.");
        } catch (JSONException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void getPlan() {
        String tempText = "plan";

        try {
            //System.out.println(tempText);
            Connector conn = new Connector(8080);
            String out = conn.sendMessage(tempText);
            //System.out.println(out);
            ResultSetManager nn = new ResultSetManager();
            jTable1.setModel(nn.displayColumns(out));
        } catch (IOException ex) {
            System.out.println("Error 1184: Connecting to urSQL, verify connection.");
        }
    }

    private void execPortionCode() {
        String tempText = null;

        JTextPane tempPane = null;
        int textPaneSelected = jTabbedPane1.getSelectedIndex();

        if (textPaneSelected != -1) {
            tempPane = paneList.get(textPaneSelected);
        }

        if (tempPane != null) {
            tempText = tempPane.getSelectedText();
        }

        if (tempText != null) {
            processQueries(tempText);
        }
    }

    private void execAllCode() {
        String tempText = null;

        JTextPane tempPane = null;
        int textPaneSelected = jTabbedPane1.getSelectedIndex();

        if (textPaneSelected != -1) {
            tempPane = paneList.get(textPaneSelected);
        }

        if (tempPane != null) {
            tempText = tempPane.getText();
        }

        if (tempText != null) {
            processQueries(tempText);
        }

    }

    private void closeScript() {
        if (paneList.size() > 1) {
            Component selectedTab = jTabbedPane1.getSelectedComponent();
            if (selectedTab != null) {
                numTabs -= 1;
                jTabbedPane1.remove(selectedTab);
                int index = jTabbedPane1.getSelectedIndex();
                paneList.remove(index);
            }
        }

    }

    private void newScript() {
        JTextPane newScriptPane = new JTextPane();

        Font font = newScriptPane.getFont();
        float size = font.getSize() + 4.0f;
        newScriptPane.setFont(font.deriveFont(size));

        jTabbedPane1.addTab("urSQL File " + Integer.toString(numScripts += 1), newScriptPane);
        jTabbedPane1.setSelectedIndex(numTabs += 1);

        paneList.add(newScriptPane);

    }

    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        schemasTree = new javax.swing.JTree();
        executePortionBtn = new javax.swing.JButton();
        executeAllBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        scriptTxtPane = new javax.swing.JTextPane();
        newSQLFileBtn = new javax.swing.JButton();
        saveFileBtn = new javax.swing.JButton();
        closeScriptTabBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        refreshBtn = new javax.swing.JButton();
        loadFileBtn = new javax.swing.JButton();
        getPlanBtn = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        logErrorArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        saveMenu = new javax.swing.JMenuItem();
        loadMenu = new javax.swing.JMenuItem();
        exitMenu = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        execPortionMenu = new javax.swing.JMenuItem();
        execAllMenu = new javax.swing.JMenuItem();
        newScriptMenu = new javax.swing.JMenuItem();
        closeScriptMenu = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        refreshMenu = new javax.swing.JMenuItem();
        getQPlanMenu = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        errorHelpMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Schemas");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("DefaultDB");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Tables");
        javax.swing.tree.DefaultMutableTreeNode treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Table1");
        javax.swing.tree.DefaultMutableTreeNode treeNode5 = new javax.swing.tree.DefaultMutableTreeNode("Columns");
        javax.swing.tree.DefaultMutableTreeNode treeNode6 = new javax.swing.tree.DefaultMutableTreeNode("Col1");
        treeNode5.add(treeNode6);
        treeNode6 = new javax.swing.tree.DefaultMutableTreeNode("Col2");
        treeNode5.add(treeNode6);
        treeNode4.add(treeNode5);
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Table2");
        treeNode5 = new javax.swing.tree.DefaultMutableTreeNode("Columns");
        treeNode6 = new javax.swing.tree.DefaultMutableTreeNode("Col1");
        treeNode5.add(treeNode6);
        treeNode6 = new javax.swing.tree.DefaultMutableTreeNode("Col2");
        treeNode5.add(treeNode6);
        treeNode4.add(treeNode5);
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        schemasTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(schemasTree);

        executePortionBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QueryProcessor/GUI/images/runportion.png"))); // NOI18N
        executePortionBtn.setToolTipText("execute the selected portion of the script");
        executePortionBtn.setContentAreaFilled(false);
        executePortionBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                executePortionBtnMouseClicked(evt);
            }
        });

        executeAllBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QueryProcessor/GUI/images/runall.png"))); // NOI18N
        executeAllBtn.setToolTipText("execute everthing in the script");
        executeAllBtn.setContentAreaFilled(false);
        executeAllBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                executeAllBtnMouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        scriptTxtPane.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jScrollPane2.setViewportView(scriptTxtPane);

        jTabbedPane1.addTab("urSQL File 1", jScrollPane2);

        newSQLFileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QueryProcessor/GUI/images/plus.png"))); // NOI18N
        newSQLFileBtn.setToolTipText("add new urSQL File");
        newSQLFileBtn.setContentAreaFilled(false);
        newSQLFileBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newSQLFileBtnMouseClicked(evt);
            }
        });

        saveFileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QueryProcessor/GUI/images/save.png"))); // NOI18N
        saveFileBtn.setToolTipText("save urSQL File");
        saveFileBtn.setContentAreaFilled(false);
        saveFileBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveFileBtnMouseClicked(evt);
            }
        });
        saveFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileBtnActionPerformed(evt);
            }
        });

        closeScriptTabBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QueryProcessor/GUI/images/closetab.png"))); // NOI18N
        closeScriptTabBtn.setToolTipText("close selected urSQL File");
        closeScriptTabBtn.setContentAreaFilled(false);
        closeScriptTabBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeScriptTabBtnMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("Status:");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("urSQL");

        refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QueryProcessor/GUI/images/refresh.png"))); // NOI18N
        refreshBtn.setToolTipText("refresh");
        refreshBtn.setContentAreaFilled(false);
        refreshBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshBtnMouseClicked(evt);
            }
        });

        loadFileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QueryProcessor/GUI/images/load.png"))); // NOI18N
        loadFileBtn.setToolTipText("load urSQL File");
        loadFileBtn.setContentAreaFilled(false);
        loadFileBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadFileBtnMouseClicked(evt);
            }
        });

        getPlanBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QueryProcessor/GUI/images/plan.png"))); // NOI18N
        getPlanBtn.setText("Get Query Plan");
        getPlanBtn.setToolTipText("get query plan");
        getPlanBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getPlanBtnMouseClicked(evt);
            }
        });

        logErrorArea.setColumns(20);
        logErrorArea.setRows(5);
        jScrollPane4.setViewportView(logErrorArea);

        jMenu1.setText("File");

        saveMenu.setText("Save urSQL Script");
        saveMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                saveMenuMousePressed(evt);
            }
        });
        jMenu1.add(saveMenu);

        loadMenu.setText("Load urSQL Script");
        loadMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loadMenuMousePressed(evt);
            }
        });
        jMenu1.add(loadMenu);

        exitMenu.setText("Exit urSQL");
        exitMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitMenuMousePressed(evt);
            }
        });
        jMenu1.add(exitMenu);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        execPortionMenu.setText("Execute Script Portion");
        execPortionMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                execPortionMenuMousePressed(evt);
            }
        });
        jMenu2.add(execPortionMenu);

        execAllMenu.setText("Execute all script");
        execAllMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                execAllMenuMousePressed(evt);
            }
        });
        jMenu2.add(execAllMenu);

        newScriptMenu.setText("New urSQL Script");
        newScriptMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                newScriptMenuMousePressed(evt);
            }
        });
        jMenu2.add(newScriptMenu);

        closeScriptMenu.setText("Close urSQL Script");
        closeScriptMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                closeScriptMenuMousePressed(evt);
            }
        });
        jMenu2.add(closeScriptMenu);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Tools");

        refreshMenu.setText("Refresh schemas");
        refreshMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                refreshMenuMousePressed(evt);
            }
        });
        jMenu4.add(refreshMenu);

        getQPlanMenu.setText("Get query plan");
        getQPlanMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                getQPlanMenuMousePressed(evt);
            }
        });
        jMenu4.add(getQPlanMenu);

        jMenuBar1.add(jMenu4);

        jMenu3.setText("Help");

        errorHelpMenu.setText("View code errors");
        errorHelpMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                errorHelpMenuMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                errorHelpMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                errorHelpMenuMouseEntered(evt);
            }
        });
        errorHelpMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                errorHelpMenuActionPerformed(evt);
            }
        });
        jMenu3.add(errorHelpMenu);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(executePortionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(executeAllBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newSQLFileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveFileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loadFileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeScriptTabBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(getPlanBtn))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(executePortionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(executeAllBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(newSQLFileBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(saveFileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(closeScriptTabBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(loadFileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(getPlanBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addComponent(jTabbedPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void executePortionBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_executePortionBtnMouseClicked
        // TODO add your handling code here:
        execPortionCode();
    }//GEN-LAST:event_executePortionBtnMouseClicked

    private void executeAllBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_executeAllBtnMouseClicked
        // TODO add your handling code here:
        execAllCode();
    }//GEN-LAST:event_executeAllBtnMouseClicked

    private void newSQLFileBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newSQLFileBtnMouseClicked
        // TODO add your handling code here:
        newScript();
    }//GEN-LAST:event_newSQLFileBtnMouseClicked

    private void closeScriptTabBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeScriptTabBtnMouseClicked
        // TODO add your handling code here:
        closeScript();
    }//GEN-LAST:event_closeScriptTabBtnMouseClicked

    private void saveFileBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveFileBtnMouseClicked
        // TODO add your handling code here:
        saveFile();

    }//GEN-LAST:event_saveFileBtnMouseClicked

    private void refreshBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshBtnMouseClicked
        refresh();
    }//GEN-LAST:event_refreshBtnMouseClicked

    private void saveFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveFileBtnActionPerformed

    private void loadFileBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadFileBtnMouseClicked
        loadFile();
    }//GEN-LAST:event_loadFileBtnMouseClicked

    private void getPlanBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getPlanBtnMouseClicked
        getPlan();
    }//GEN-LAST:event_getPlanBtnMouseClicked

    private void errorHelpMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_errorHelpMenuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_errorHelpMenuMouseClicked

    private void errorHelpMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_errorHelpMenuMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_errorHelpMenuMouseEntered

    private void errorHelpMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_errorHelpMenuMousePressed
        // TODO add your handling code here:
        //ErrorsWindow errores = new ErrorsWindow();
        //errores.run();
    }//GEN-LAST:event_errorHelpMenuMousePressed

    private void errorHelpMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_errorHelpMenuActionPerformed
        // TODO add your handling code here:
        ErrorsWindow.getObject().setVisible(true);
    }//GEN-LAST:event_errorHelpMenuActionPerformed

    private void exitMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMenuMousePressed
        // TODO add your handling code here:
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_exitMenuMousePressed

    private void saveMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMenuMousePressed
        // TODO add your handling code here:
        saveFile();
    }//GEN-LAST:event_saveMenuMousePressed

    private void loadMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadMenuMousePressed
        // TODO add your handling code here:
        loadFile();
    }//GEN-LAST:event_loadMenuMousePressed

    private void execPortionMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_execPortionMenuMousePressed
        // TODO add your handling code here:
        execPortionCode();
    }//GEN-LAST:event_execPortionMenuMousePressed

    private void execAllMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_execAllMenuMousePressed
        // TODO add your handling code here:
        execAllCode();
    }//GEN-LAST:event_execAllMenuMousePressed

    private void newScriptMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newScriptMenuMousePressed
        // TODO add your handling code here:
        newScript();
    }//GEN-LAST:event_newScriptMenuMousePressed

    private void closeScriptMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeScriptMenuMousePressed
        // TODO add your handling code here:
        closeScript();
    }//GEN-LAST:event_closeScriptMenuMousePressed

    private void refreshMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMenuMousePressed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_refreshMenuMousePressed

    private void getQPlanMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getQPlanMenuMousePressed
        // TODO add your handling code here:
        getPlan();
    }//GEN-LAST:event_getQPlanMenuMousePressed

    @Override
    public void run() {
        this.setVisible(true);
        textAnalizer = new TextAnalysis();
        textAnalizer.addObserver(this);

        String text = null;
        
        while (true) {

            JTextPane tempPane = null;
            int textPaneSelected = jTabbedPane1.getSelectedIndex();
            if (textPaneSelected != -1) {
                tempPane = paneList.get(textPaneSelected);
            }

            if (tempPane != null) {
                text = tempPane.getText();
            }
         
            if (text != null) {

                try {
                    textAnalizer.analizador(text);
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem closeScriptMenu;
    private javax.swing.JButton closeScriptTabBtn;
    private javax.swing.JMenuItem errorHelpMenu;
    private javax.swing.JMenuItem execAllMenu;
    private javax.swing.JMenuItem execPortionMenu;
    private javax.swing.JButton executeAllBtn;
    private javax.swing.JButton executePortionBtn;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.JButton getPlanBtn;
    private javax.swing.JMenuItem getQPlanMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton loadFileBtn;
    private javax.swing.JMenuItem loadMenu;
    private javax.swing.JTextArea logErrorArea;
    private javax.swing.JButton newSQLFileBtn;
    private javax.swing.JMenuItem newScriptMenu;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JMenuItem refreshMenu;
    private javax.swing.JButton saveFileBtn;
    private javax.swing.JMenuItem saveMenu;
    private javax.swing.JTree schemasTree;
    private javax.swing.JTextPane scriptTxtPane;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        updateAux(arg);
    }

    private void updateAux(Object arg) {

        //int compNumb = jTabbedPane1.getComponentCount();
        for (int i = 0; i < paneList.size(); i++) {
            JTextPane paneAux = paneList.get(i);

            if (arg.equals("palabraReservada")) {
                cambiarPalabra(textAnalizer.obtenerInicio(), textAnalizer.obtenerFinal(), new Color(0, 150, 250), paneAux);
            }
            if (arg.equals("palabra1")) {
                cambiarPalabra(textAnalizer.obtenerInicio(), textAnalizer.obtenerFinal(), new Color(242, 153, 0), paneAux);
            }
            if (arg.equals("letraNormal")) {
                cambiarLetra(textAnalizer.obtenerLetra(), paneAux);
            }
        }
    }

    /*
     * Cambia de color una parte del texto mostradae en pantalla
     */
    private void cambiarPalabra(int pInicio, int pFinal, Color pColor, JTextPane pPane) {

        SimpleAttributeSet attrs = new SimpleAttributeSet();
        StyleConstants.setBold(attrs, true);
        StyleConstants.setForeground(attrs, pColor);
        if (pInicio == 0) {
            pPane.getStyledDocument().setCharacterAttributes(pInicio, pFinal + 1, attrs, true);
        } else {
            pPane.getStyledDocument().setCharacterAttributes(pInicio, pFinal, attrs, true);
        }
    }

    /*
     * Cambia de color de un caracter mostradae en pantalla
     */
    private void cambiarLetra(int pLetra, JTextPane pPane) {
        SimpleAttributeSet attrs = new SimpleAttributeSet();
        StyleConstants.setBold(attrs, true);

        pPane.getStyledDocument().setCharacterAttributes(pLetra, pLetra + 1, attrs, true);

    }
}
