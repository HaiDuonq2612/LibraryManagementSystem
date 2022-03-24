/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TypeBook;

import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hảii Dươnq
 */
public class TypeView extends javax.swing.JInternalFrame implements Delete.CallbackDelete, Search.CallbackSearch {

    List<Type> lst;
    DefaultTableModel model;
    Type type;
    TypeManager manager;

    /**
     * Creates new form CategoryView
     */
    public TypeView() {
        initComponents();
        manager = new TypeManager();
        preapareGUI();
        LoadData();
    }

    public void preapareGUI() {
        model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Name");
        model.addColumn("Description");
        model.addColumn("Status");
        tblType.setModel(model);
    }

    public void LoadData() {
        lst = manager.getAllType();

        for (Type t : lst) {
            Vector v = new Vector();
            v.add(t.getId());
            v.add(t.getName());
            v.add(t.getDescription());
            v.add(t.isStatus() ? "Show" : "Hidden");

            model.addRow(v);

            tblType.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    int pos = tblType.getSelectedRow();
                    if (pos < 0) {
                        pos = 0;
                    }
                    type = lst.get(pos);
                    SetData(type);
                }
            });
        }
        tblType.setModel(model);
    }

    public void SearchData(String Name) {
        model = (DefaultTableModel) tblType.getModel();
        model.setRowCount(0);

        lst = manager.getOneType(Name);

        for (Type t : lst) {
            Vector v = new Vector();
            v.add(t.getId());
            v.add(t.getName());
            v.add(t.getDescription());
            v.add(t.isStatus() ? "Show" : "Hidden");

            model.addRow(v);
        }
        tblType.setModel(model);
    }

    public void SetData(Type t) {
        txtName.setText(t.getName());
        txtDescription.setText(t.getDescription());
        if (t.isStatus() == true) {
            cboStatus.setSelectedItem("Show");
        } else {
            cboStatus.setSelectedItem("Hidden");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        txtDescription = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cboStatus = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblType = new javax.swing.JTable();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(800, 700));

        jPanel2.setPreferredSize(new java.awt.Dimension(400, 35));
        jPanel2.setLayout(new java.awt.CardLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Management Type");
        jLabel3.setToolTipText("");
        jPanel2.add(jLabel3, "card2");

        jPanel1.add(jPanel2);

        jPanel3.setName(""); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(500, 230));

        jPanel10.setPreferredSize(new java.awt.Dimension(350, 65));
        jPanel10.setRequestFocusEnabled(false);
        jPanel10.setLayout(new java.awt.BorderLayout(4, 4));

        txtName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtName.setForeground(new java.awt.Color(255, 0, 0));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPanel10.add(txtName, java.awt.BorderLayout.CENTER);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Name :");
        jLabel4.setPreferredSize(new java.awt.Dimension(42, 25));
        jPanel10.add(jLabel4, java.awt.BorderLayout.PAGE_START);

        jPanel3.add(jPanel10);

        jPanel11.setPreferredSize(new java.awt.Dimension(350, 65));
        jPanel11.setRequestFocusEnabled(false);
        jPanel11.setLayout(new java.awt.BorderLayout(4, 4));

        txtDescription.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDescription.setForeground(new java.awt.Color(255, 0, 0));
        jPanel11.add(txtDescription, java.awt.BorderLayout.CENTER);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Description :");
        jLabel5.setPreferredSize(new java.awt.Dimension(72, 25));
        jLabel5.setRequestFocusEnabled(false);
        jPanel11.add(jLabel5, java.awt.BorderLayout.PAGE_START);

        jPanel3.add(jPanel11);

        jPanel12.setPreferredSize(new java.awt.Dimension(350, 65));
        jPanel12.setRequestFocusEnabled(false);
        jPanel12.setLayout(new java.awt.BorderLayout(4, 4));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Status :");
        jLabel6.setPreferredSize(new java.awt.Dimension(45, 25));
        jPanel12.add(jLabel6, java.awt.BorderLayout.PAGE_START);

        cboStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboStatus.setForeground(new java.awt.Color(255, 0, 0));
        cboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Show", "Hidden" }));
        jPanel12.add(cboStatus, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel12);

        jPanel1.add(jPanel3);

        jPanel4.setPreferredSize(new java.awt.Dimension(712, 35));

        btnAdd.setText("Add New Type");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel4.add(btnAdd);

        btnUpdate.setText("Update Type");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel4.add(btnUpdate);

        btnDelete.setText("Delete Type");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel4.add(btnDelete);

        btnSearch.setText("Search Type");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel4.add(btnSearch);

        btnLoad.setText("Load Type");
        jPanel4.add(btnLoad);

        jPanel1.add(jPanel4);

        jPanel14.setPreferredSize(new java.awt.Dimension(739, 300));
        jPanel14.setLayout(new java.awt.BorderLayout());

        tblType.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tblType.setForeground(new java.awt.Color(255, 0, 0));
        tblType.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblType);

        jPanel14.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel14);

        jInternalFrame1.setClosable(true);
        jInternalFrame1.setIconifiable(true);
        jInternalFrame1.setResizable(true);
        jInternalFrame1.setPreferredSize(new java.awt.Dimension(750, 400));

        jPanel6.setPreferredSize(new java.awt.Dimension(400, 35));

        jLabel2.setText("jLabel1");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jLabel2)
                .addContainerGap(193, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        jPanel5.add(jPanel6);

        jPanel7.setPreferredSize(new java.awt.Dimension(400, 100));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel7);

        jPanel8.setPreferredSize(new java.awt.Dimension(400, 300));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel8);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 761, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 392, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 393, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 332, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 332, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        String name = txtName.getText();
        String des = txtDescription.getText();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Name");
        }
        if (des.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Description");
        }
        String sta = cboStatus.getSelectedItem().toString();

        boolean Status;
        if (sta.equals("Show")) {
            Status = true;
        } else {
            Status = false;
        }
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Name");
            return;
        } else if (name.length() >= 64) {
            JOptionPane.showMessageDialog(this, "Name Length Must Be Less Than 64 Characters");
            return;
        } else if (des.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Description");
            return;
        } else if (cboStatus.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "Must Choose A Status");
            return;
        }

        type = new Type(name, des, Status);
        int row = manager.CreateType(type);
        if (row > 0) {
            JOptionPane.showMessageDialog(this, "Create Type Success !");
        } else {
            JOptionPane.showMessageDialog(this, "Create Type Error !", "Inane error", JOptionPane.ERROR_MESSAGE);
        }
        model = (DefaultTableModel) tblType.getModel();
        model.setRowCount(0);

        LoadData();

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String name = txtName.getText();
        String des = txtDescription.getText();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Name");
        }
        if (des.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Description");
        }
        String sta = cboStatus.getSelectedItem().toString();
        Boolean Status;
        if (sta.equals("Show")) {
            Status = true;
        } else {
            Status = false;
        }
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Name");
            return;
        } else if (name.length() >= 64) {
            JOptionPane.showMessageDialog(this, "Name Length Must Be Less Than 64 Characters");
            return;
        } else if (des.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Description");
            return;
        } else if (cboStatus.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "Must Choose A Status");
            return;
        }

        Type t = new Type(type.getId(), name, des, Status);
        manager = new TypeManager();
        int row = manager.UpdateType(t);
        if (row > 0) {
            JOptionPane.showMessageDialog(this, "Update Type Success !");
        } else {
            JOptionPane.showMessageDialog(this, "Update Type Error !", "Inane error", JOptionPane.ERROR_MESSAGE);
        }

        model = (DefaultTableModel) tblType.getModel();
        model.setRowCount(0);

        LoadData();

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            Delete del = new Delete(new javax.swing.JFrame(), true, (Delete.CallbackDelete) this);
            del.setTitle(type.getId(), txtName.getText());
            del.setVisible(true);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Delete Reader Error !");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        Search s = new Search(new javax.swing.JFrame(), closable, (Search.CallbackSearch) this);
        s.setVisible(true);
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboStatus;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblType;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

    @Override
    public void doDelete(int id) {
        manager.DeleteType(id);

        model = (DefaultTableModel) tblType.getModel();
        model.setRowCount(0);

        LoadData();
    }

    @Override
    public void doAction(String Name) {
        SearchData(Name);
    }
}
