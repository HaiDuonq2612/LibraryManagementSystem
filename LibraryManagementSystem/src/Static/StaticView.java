/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Static;

import Bill.Bill;
import Bill.BillManager;
import BillDetail.BillDetail;
import BillDetail.BillDetailManager;
import Book.Book;
import Book.BookManager;
import BookDetail.BookDetail;
import BookDetail.BookDetailManager;
import Reader.Reader;
import Reader.ReaderManager;
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
public class StaticView extends javax.swing.JInternalFrame {

    List<Reader> lstReader;
    Reader reader;
    ReaderManager readerManager;

    List<Bill> lstBill;
    Bill bill;
    BillManager billManager;

    List<BillDetail> lstBillDetail;
    BillDetail billD;
    BillDetailManager billDetailManager;

    List<Book> lstBook;
    Book book;
    BookManager bookManager;

    List<BookDetail> lstBookDetail;
    BookDetail bookDetail;
    BookDetailManager bookDetailManager;

    /**
     * Creates new form CategoryView
     */
    public StaticView() {
        initComponents();
        preapareGUII();
        preapareGUIR();
        readerManager = new ReaderManager();
        billManager = new BillManager();
        billDetailManager = new BillDetailManager();
        bookManager = new BookManager();
        bookDetailManager = new BookDetailManager();
        LoadData();
    }
    DefaultTableModel modelI;
    DefaultTableModel modelR;

    public void preapareGUII() {
        modelI = new DefaultTableModel();
        modelI.addColumn("Id");
        modelI.addColumn("Name Reader");
        modelI.addColumn("Name Book");
        modelI.addColumn("IssueDate");
        modelI.addColumn("Return Appointment Date");
        modelI.addColumn("Status");
        jTable1.setModel(modelI);
    }

    public void preapareGUIR() {
        modelR = new DefaultTableModel();
        modelR.addColumn("Id");
        modelR.addColumn("Name Reader");
        modelR.addColumn("Name Book");
        modelR.addColumn("IssueDate");
        modelR.addColumn("Return Appointment Date");
        modelR.addColumn("ReturnDate");
        modelR.addColumn("Status");
        tblTrans.setModel(modelR);
    }

    public void LoadData() {

        lstReader = readerManager.getAllReader();
        lstBill = billManager.getAllBill();
        lstBillDetail = billDetailManager.getAllBillDetail();
        lstBook = bookManager.getAllBook();
        lstBookDetail = bookDetailManager.getAllBookDetail();

        for (Bill bill1 : lstBill) {
            for (BillDetail billDetail : lstBillDetail) {
                if (bill1.getId() == billDetail.getId_Bill()) {
                    if (billDetail.isStatus() == true) {
                        Vector v = new Vector();

                        v.add(bill1.getId());
                        String NameR;
                        Vector v1 = new Vector();
                        for (Reader reader1 : lstReader) {
                            if (bill1.getId_Reader() == reader1.getId()) {
                                v.add(reader1.getName());
                            }
                        }
                        for (BookDetail bookDetail1 : lstBookDetail) {
                            if (billDetail.getId_BookDetail() == bookDetail1.getId()) {
                                for (Book book1 : lstBook) {
                                    if (bookDetail1.getId_Book() == book1.getId()) {
                                        v.add(book1.getName());
                                    }
                                }
                            }
                        }
                        v.add(bill1.getDateIssue());
                        v.add(bill1.getDateReturn());
                        v.add(billDetail.isStatus() ? "Unpaid" : "Paid");
                        modelI.addRow(v);
                    } else {
                        Vector v = new Vector();

                        v.add(bill1.getId());

                        Vector v1 = new Vector();
                        for (Reader reader1 : lstReader) {
                            if (bill1.getId_Reader() == reader1.getId()) {
                                v.add(reader1.getName());
                            }
                        }
                        for (BookDetail bookDetail1 : lstBookDetail) {
                            if (billDetail.getId_BookDetail() == bookDetail1.getId()) {
                                for (Book book1 : lstBook) {
                                    if (bookDetail1.getId_Book() == book1.getId()) {
                                        v.add(book1.getName());
                                    }
                                }
                            }
                        }
                        v.add(bill1.getDateIssue());
                        v.add(bill1.getDateReturn());
                        v.add(billDetail.getDateReturn());
                        v.add(billDetail.isStatus() ? "Unpaid" : "Paid");
                        modelR.addRow(v);
                    }
                }
            }

        }
        jTable1.setModel(modelI);
        tblTrans.setModel(modelR);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTrans = new javax.swing.JTable();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(1000, 900));

        jPanel2.setPreferredSize(new java.awt.Dimension(600, 35));
        jPanel2.setRequestFocusEnabled(false);
        jPanel2.setLayout(new java.awt.CardLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Management Issue Book");
        jLabel3.setToolTipText("");
        jPanel2.add(jLabel3, "card2");

        jPanel1.add(jPanel2);

        jPanel3.setName(""); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 250));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(500, 402));

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
        jTable1.setPreferredSize(new java.awt.Dimension(400, 500));
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3);

        jPanel4.setPreferredSize(new java.awt.Dimension(623, 35));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Management Return Book");
        jPanel4.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel4);

        jPanel14.setPreferredSize(new java.awt.Dimension(800, 275));
        jPanel14.setLayout(new java.awt.BorderLayout());

        tblTrans.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tblTrans.setForeground(new java.awt.Color(255, 0, 0));
        tblTrans.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTrans.setPreferredSize(new java.awt.Dimension(300, 500));
        jScrollPane2.setViewportView(tblTrans);

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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 961, Short.MAX_VALUE)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblTrans;
    // End of variables declaration//GEN-END:variables

}
