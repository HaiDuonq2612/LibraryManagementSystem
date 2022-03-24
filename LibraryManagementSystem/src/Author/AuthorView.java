/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Author;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hảii Dươnq
 */
public class AuthorView extends javax.swing.JInternalFrame implements Delete.CallbackDelete, Search.CallbackSearch {

    DefaultTableModel model;
    List<Author> lst;
    AuthorManager manager;
    Author author;

    /**
     * Creates new form CategoryView
     */
    public AuthorView() {
        initComponents();
        manager = new AuthorManager();
        preapareGUI();
        LoadData();
        SetDateNow();
    }

    public void preapareGUI() {
        model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Pseudonym");
        model.addColumn("Name");
        model.addColumn("DateBirth");
        model.addColumn("DateLost");
        model.addColumn("Address");
        model.addColumn("Description");
        model.addColumn("Status");
        tblAuthor.setModel(model);
    }

    public void LoadData() {
        
        model = (DefaultTableModel) tblAuthor.getModel();
        model.setRowCount(0);

        lst = manager.getAllAuthor();

        for (Author aut : lst) {
            Vector v = new Vector();
            v.add(aut.getId());
            v.add(aut.getPseudonym());
            v.add(aut.getName());

            v.add(aut.getDateLost());
            v.add(aut.getDateBirth());


            v.add(aut.getAddress());
            v.add(aut.getDescription());
            
            v.add(aut.isStatus() ? "Show" : "Hidden");

            model.addRow(v);
            
        }
        tblAuthor.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int pos = tblAuthor.getSelectedRow();
                if (pos < 0) {
                    pos = 0;
                }
                author = lst.get(pos);
                try {
                    SetData(author);
                } catch (ParseException ex) {
                    Logger.getLogger(AuthorView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        tblAuthor.setModel(model);
    }

    public void SearchData(String Name) {

        model = (DefaultTableModel) tblAuthor.getModel();
        model.setRowCount(0);

        lst = manager.getOneAuthor(Name);

        for (Author aut : lst) {
            Vector v = new Vector();
            v.add(aut.getId());
            v.add(aut.getPseudonym());
            v.add(aut.getName());

            v.add(aut.getDateBirth());

            v.add(aut.getDateLost());

            v.add(aut.getAddress());
            v.add(aut.getDescription());
            v.add(aut.isStatus() ? "Show" : "Hidden");

            model.addRow(v);
        }
        tblAuthor.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int pos = tblAuthor.getSelectedRow();
                if (pos < 0) {
                    pos = 0;
                }
                author = lst.get(pos);
                try {
                    SetData(author);
                } catch (ParseException ex) {
                    Logger.getLogger(AuthorView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        tblAuthor.setModel(model);
    }

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public void SetData(Author a) throws ParseException {
        
        txtPseudonym.setText(a.getPseudonym());
        txtName.setText(a.getName());

        DateBirth.setDate(dateFormat.parse(String.valueOf(a.getDateBirth())));

        DateLost.setDate(dateFormat.parse(String.valueOf(a.getDateLost())));

        txtAddress.setText(a.getAddress());

        txtDescription.setText(a.getDescription());

        if (a.isStatus() == true) {
            cboStatus.setSelectedItem("Show");
        } else {
            cboStatus.setSelectedItem("Hidden");
        }
    }
    public void SetDateNow() {
        LocalDate dateNow = LocalDate.now();
        try {
            DateLost.setDate(dateFormat.parse(String.valueOf(dateNow)));
            DateLost.setDate(dateFormat.parse(String.valueOf(dateNow)));
        } catch (ParseException ex) {
            Logger.getLogger(AuthorView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public void ShowDate(){
//        DateBirth.setDateFormatString("dd-MM-yyyy");
//        DateLost.setDateFormatString("dd-MM-yyyy");
//    }
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
        txtPseudonym = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        DateBirth = new com.toedter.calendar.JDateChooser();
        jPanel13 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        DateLost = new com.toedter.calendar.JDateChooser();
        jPanel15 = new javax.swing.JPanel();
        txtAddress = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        txtDescription = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cboStatus = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAuthor = new javax.swing.JTable();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1000, 900));

        jPanel2.setPreferredSize(new java.awt.Dimension(600, 35));
        jPanel2.setRequestFocusEnabled(false);
        jPanel2.setLayout(new java.awt.CardLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Management Author");
        jLabel3.setToolTipText("");
        jPanel2.add(jLabel3, "card2");

        jPanel1.add(jPanel2);

        jPanel3.setName(""); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(600, 495));

        jPanel10.setPreferredSize(new java.awt.Dimension(350, 65));
        jPanel10.setRequestFocusEnabled(false);
        jPanel10.setLayout(new java.awt.BorderLayout(4, 4));

        txtPseudonym.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPseudonym.setForeground(new java.awt.Color(255, 0, 0));
        txtPseudonym.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPseudonymActionPerformed(evt);
            }
        });
        jPanel10.add(txtPseudonym, java.awt.BorderLayout.CENTER);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Pseudonym :");
        jLabel4.setPreferredSize(new java.awt.Dimension(42, 25));
        jPanel10.add(jLabel4, java.awt.BorderLayout.PAGE_START);

        jPanel3.add(jPanel10);

        jPanel11.setPreferredSize(new java.awt.Dimension(350, 65));
        jPanel11.setRequestFocusEnabled(false);
        jPanel11.setLayout(new java.awt.BorderLayout(4, 4));

        txtName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtName.setForeground(new java.awt.Color(255, 0, 0));
        jPanel11.add(txtName, java.awt.BorderLayout.CENTER);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Name :");
        jLabel5.setPreferredSize(new java.awt.Dimension(72, 25));
        jLabel5.setRequestFocusEnabled(false);
        jPanel11.add(jLabel5, java.awt.BorderLayout.PAGE_START);

        jPanel3.add(jPanel11);

        jPanel12.setPreferredSize(new java.awt.Dimension(350, 65));
        jPanel12.setRequestFocusEnabled(false);
        jPanel12.setLayout(new java.awt.BorderLayout(4, 4));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("DateBirth :");
        jLabel6.setPreferredSize(new java.awt.Dimension(45, 25));
        jPanel12.add(jLabel6, java.awt.BorderLayout.PAGE_START);
        jPanel12.add(DateBirth, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel12);

        jPanel13.setPreferredSize(new java.awt.Dimension(350, 65));
        jPanel13.setRequestFocusEnabled(false);
        jPanel13.setLayout(new java.awt.BorderLayout(4, 4));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("DateLost :");
        jLabel7.setPreferredSize(new java.awt.Dimension(42, 25));
        jPanel13.add(jLabel7, java.awt.BorderLayout.PAGE_START);
        jPanel13.add(DateLost, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel13);

        jPanel15.setPreferredSize(new java.awt.Dimension(350, 65));
        jPanel15.setRequestFocusEnabled(false);
        jPanel15.setLayout(new java.awt.BorderLayout(4, 4));

        txtAddress.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtAddress.setForeground(new java.awt.Color(255, 0, 0));
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });
        jPanel15.add(txtAddress, java.awt.BorderLayout.CENTER);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Address : ");
        jLabel8.setPreferredSize(new java.awt.Dimension(42, 25));
        jPanel15.add(jLabel8, java.awt.BorderLayout.PAGE_START);

        jPanel3.add(jPanel15);

        jPanel16.setPreferredSize(new java.awt.Dimension(350, 65));
        jPanel16.setRequestFocusEnabled(false);
        jPanel16.setLayout(new java.awt.BorderLayout(4, 4));

        txtDescription.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDescription.setForeground(new java.awt.Color(255, 0, 0));
        jPanel16.add(txtDescription, java.awt.BorderLayout.CENTER);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Description :");
        jLabel9.setPreferredSize(new java.awt.Dimension(72, 25));
        jLabel9.setRequestFocusEnabled(false);
        jPanel16.add(jLabel9, java.awt.BorderLayout.PAGE_START);

        jPanel3.add(jPanel16);

        jPanel17.setPreferredSize(new java.awt.Dimension(350, 65));
        jPanel17.setRequestFocusEnabled(false);
        jPanel17.setLayout(new java.awt.BorderLayout(4, 4));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Status :");
        jLabel10.setPreferredSize(new java.awt.Dimension(45, 25));
        jPanel17.add(jLabel10, java.awt.BorderLayout.PAGE_START);

        cboStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboStatus.setForeground(new java.awt.Color(255, 0, 0));
        cboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Show", "Hidden" }));
        jPanel17.add(cboStatus, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel17);

        jPanel1.add(jPanel3);

        jPanel4.setPreferredSize(new java.awt.Dimension(623, 35));

        btnAdd.setText("Add New Author");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel4.add(btnAdd);

        btnUpdate.setText("Update Author");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel4.add(btnUpdate);

        btnDelete.setText("Delete Author");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel4.add(btnDelete);

        btnSearch.setText("Search Author");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel4.add(btnSearch);

        btnLoad.setText("Load Data");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });
        jPanel4.add(btnLoad);

        jPanel1.add(jPanel4);

        jPanel14.setPreferredSize(new java.awt.Dimension(800, 275));
        jPanel14.setLayout(new java.awt.BorderLayout());

        tblAuthor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tblAuthor.setForeground(new java.awt.Color(255, 0, 0));
        tblAuthor.setModel(new javax.swing.table.DefaultTableModel(
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
        tblAuthor.setPreferredSize(new java.awt.Dimension(300, 235));
        jScrollPane2.setViewportView(tblAuthor);

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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 961, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 492, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 493, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 432, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 432, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPseudonymActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPseudonymActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPseudonymActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:

        String pd = txtPseudonym.getText();
        String name = txtName.getText();

        String dbirth = dateFormat.format(DateLost.getDate());
        String dlost = dateFormat.format(DateLost.getDate());

        LocalDate db = LocalDate.parse(dbirth, DateTimeFormatter.ISO_DATE);

        LocalDate dl = LocalDate.parse(dlost, DateTimeFormatter.ISO_DATE);

        String address = txtAddress.getText();
        String des = txtDescription.getText();
        String sta = cboStatus.getSelectedItem().toString();

        boolean Status;
        if (sta.equals("Show")) {
            Status = true;
        } else {
            Status = false;
        }
        if (pd.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Pseudonym");
            return;
        } else if (pd.length() >= 64) {
            JOptionPane.showMessageDialog(this, "Pseudonym Length Must Be Less Than 64 Characters");
            return;
        }if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Name");
            return;
        } else if (name.length() >= 64) {
            JOptionPane.showMessageDialog(this, "Name Length Must Be Less Than 64 Characters");
            return;
        } else if (address.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Address");
            return;
        } else if (address.length() >= 6 && address.length() <= 64) {
            JOptionPane.showMessageDialog(this, "Address Length Greater Must Be Less Than 200 Characters");
            return;
        } else if (des.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Description");
            return;
        } else if (cboStatus.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "Must Choose A Status");
            return;
        }

        Author a = new Author(pd, name, db, dl, address, des, Status);
        int row = manager.CreateAuthor(a);
        if (row > 0) {
            JOptionPane.showMessageDialog(this, "Create Author Success !");
        } else {
            JOptionPane.showMessageDialog(this, "Create Author Error !", "Inane error", JOptionPane.ERROR_MESSAGE);
        }
        model = (DefaultTableModel) tblAuthor.getModel();
        model.setRowCount(0);

        LoadData();

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String pd = txtPseudonym.getText();
        String name = txtName.getText();

        String dbirth = dateFormat.format(DateLost.getDate());
        String dlost = dateFormat.format(DateLost.getDate());

        LocalDate db = LocalDate.parse(dbirth, DateTimeFormatter.ISO_DATE);

        LocalDate dl = LocalDate.parse(dlost, DateTimeFormatter.ISO_DATE);

        String address = txtAddress.getText();
        String des = txtDescription.getText();
        String sta = cboStatus.getSelectedItem().toString();

        boolean Status;
        if (sta.equals("Show")) {
            Status = true;
        } else {
            Status = false;
        }
        if (pd.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Pseudonym");
            return;
        } else if (pd.length() >= 64) {
            JOptionPane.showMessageDialog(this, "Pseudonym Length Must Be Less Than 64 Characters");
            return;
        }if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Name");
            return;
        } else if (name.length() >= 64) {
            JOptionPane.showMessageDialog(this, "Name Length Must Be Less Than 64 Characters");
            return;
        } else if (address.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Address");
            return;
        } else if (address.length() >= 6 && address.length() <= 64) {
            JOptionPane.showMessageDialog(this, "Address Length Greater Must Be Less Than 200 Characters");
            return;
        } else if (des.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Description");
            return;
        } else if (cboStatus.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "Must Choose A Status");
            return;
        }

        Author a = new Author(author.getId(), pd, name, db, dl, address, des, Status);
        int row = manager.UpdateAuthor(a);
        if (row > 0) {
            JOptionPane.showMessageDialog(this, "Update Author Success !");
        } else {
            JOptionPane.showMessageDialog(this, "Update Author Error !", "Inane error", JOptionPane.ERROR_MESSAGE);
        }
        model = (DefaultTableModel) tblAuthor.getModel();
        model.setRowCount(0);

        LoadData();

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
        Delete del = new Delete(new javax.swing.JFrame(), true, (Delete.CallbackDelete) this);
        del.setTitle(author.getId(), txtPseudonym.getText());
        del.setVisible(true);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Delete Author Error !");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        Search s = new Search(new javax.swing.JFrame(), closable, (Search.CallbackSearch) this);
        s.setVisible(true);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        // TODO add your handling code here:
        model = (DefaultTableModel) tblAuthor.getModel();
        model.setRowCount(0);
        LoadData();
    }//GEN-LAST:event_btnLoadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateBirth;
    private com.toedter.calendar.JDateChooser DateLost;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboStatus;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblAuthor;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPseudonym;
    // End of variables declaration//GEN-END:variables

    @Override
    public void doDelete(int id) {
        manager.DeleteAuthor(id);
        
        model = (DefaultTableModel) tblAuthor.getModel();
        model.setRowCount(0);

        LoadData();
    }

    @Override
    public void doAction(String Name) {
        SearchData(Name);
    }
}
