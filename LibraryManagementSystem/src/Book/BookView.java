/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Book;

import CategoryBook.*;
import Author.*;
import BookDetail.*;
import TypeBook.*;
import Translator.*;
import Publisher.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hảii Dươnq
 */
public class BookView extends javax.swing.JInternalFrame implements Delete.CallbackDelete, Search.CallbackSearch {

    DefaultTableModel model;
    Book book;
    BookManager manager;
    List<Book> lstBook;

    /**
     * Creates new form CategoryView
     */
    public BookView() {
        initComponents();
        manager = new BookManager();
        am = new AuthorManager();
        tm = new TypeManager();
        tranm = new TranslatorManager();
        pm = new PublisherManager();
        preapareGUI();
        LoadData();
        getCbox();
        getJlistAuthor();
        getJlistType();

    }

    public void preapareGUI() {
        model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Name");
//        model.addColumn("Author");
//        model.addColumn("Translator");
//        model.addColumn("Publisher");
//        model.addColumn("Type");
        model.addColumn("Price");
        model.addColumn("Quantity");
        model.addColumn("QuantityRemain");
        model.addColumn("DateAdd");
        model.addColumn("Description");
        model.addColumn("Status");
        tblBook.setModel(model);

    }
    CallableStatement cs;
    ResultSet rs;

    CategoryManager cm = new CategoryManager();
    List<Category> lstC = new ArrayList<Category>();

    Author author;
    AuthorManager am = new AuthorManager();
    List<Author> lstA = new ArrayList<Author>();

    Type type;
    TypeManager tm = new TypeManager();
    List<Type> lstT = new ArrayList<Type>();

    Translator translator;
    TranslatorManager tranm = new TranslatorManager();
    List<Translator> lstTran = new ArrayList<Translator>();

    Publisher publisher;
    PublisherManager pm = new PublisherManager();
    List<Publisher> lstP = new ArrayList<Publisher>();

    BookDetail bookDetail;
    BookDetailManager bdm = new BookDetailManager();
    List<BookDetail> lstbd = new ArrayList<BookDetail>();

    // Set JListAuthor
    DefaultListModel<String> JlstModelAuthor;

    public void getJlistAuthor() {
        JlstModelAuthor = new DefaultListModel<>();
        lstA = am.getAllAuthor();
        for (Author author : lstA) {
            JlstModelAuthor.addElement(author.getName());
        }
        JlstAuthor.setModel(JlstModelAuthor);
    }

    // Set JListType
    DefaultListModel<String> JlstModelType;

    public void getJlistType() {
        JlstModelType = new DefaultListModel<>();
        lstT = tm.getAllType();
        for (Type type : lstT) {
            JlstModelType.addElement(type.getName());
        }
        JlstType.setModel(JlstModelType);
    }

    // Set Combobox
    public void getCbox() {
        lstC = cm.getAllCategory();
        for (Category category : lstC) {
            cboCate.addItem(category.getName());
        }

        lstTran = tranm.getAllTranslator();
        for (Translator translator : lstTran) {
            cboTrans.addItem(translator.getName());
        }

        lstP = pm.getAllPublisher();
        for (Publisher publisher : lstP) {
            cboPublisher.addItem(publisher.getName());
        }
    }

    public void LoadData() {

        model = (DefaultTableModel) tblBook.getModel();
        model.setRowCount(0);

        lstBook = manager.getAllBook();

        lstbd = bdm.getAllBookDetail();

        lstTran.removeAll(lstTran);
        lstTran = tranm.getAllTranslator();

        lstP.removeAll(lstP);
        lstP = pm.getAllPublisher();

        lstA.removeAll(lstA);
        lstA = am.getAllAuthor();

        lstT.removeAll(lstT);
        lstT = tm.getAllType();

        for (Book b : lstBook) {
            Vector v = new Vector();
            v.add(b.getId());
            v.add(b.getName());
//
//            Vector v1 = new Vector();
//            for (Author au : lstA) {
//                for (BookDetail bd : lstbd) {
//                    if (b.getId() == bd.getId_Book() && au.getId() == bd.getId_Translator()) {
//                        v1.add(au.getName());
//                    }
//                }
//            }
//            v.add(v1);
//
//            Vector v2 = new Vector();
//            for (Translator tr : lstTran) {
//                for (BookDetail bd : lstbd) {
//                    if (b.getId() == bd.getId_Book() && tr.getId() == bd.getId_Translator()) {
//                        v2.add(tr.getName());
//                    }
//                }
//            }
//            v.add(v2);
//
//            Vector v3 = new Vector();
//            for (Publisher p : lstP) {
//                for (BookDetail bd : lstbd) {
//                    if (b.getId() == bd.getId_Book() && p.getId() == bd.getId_Publisher()) {
//                        v3.add(p.getName());
//                    }
//                }
//            }
//            v.add(v3);
//
//            Vector v4 = new Vector();
//            for (Type ty : lstT) {
//                for (BookDetail bd : lstbd) {
//                    if (b.getId() == bd.getId_Book() && ty.getId() == bd.getId_Publisher()) {
//                        v4.add(ty.getName());
//                    }
//                }
//            }
//            v.add(v4);

            v.add(b.getPrice());
            v.add(b.getQuantity());
            v.add(b.getQuantityRemain());
            v.add(b.getDateAdded());
            v.add(b.getDescription());
            v.add(b.isStatus() ? "Show" : "Hidden");
            model.addRow(v);
        }

//
        tblBook.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int pos = tblBook.getSelectedRow();
                if (pos < 0) {
                    pos = 0;
                }

                book = lstBook.get(pos);

                translator = lstTran.get(pos);

                publisher = lstP.get(pos);

                bookDetail = lstbd.get(pos);
                SetDataTrans(bookDetail);

                SetDataPubslisher(bookDetail);

                try {
                    SetDataBook(book);

                } catch (ParseException ex) {
                    Logger.getLogger(BookView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        tblBook.setModel(model);
    }

    public void SearchData(String Name) {

        model = (DefaultTableModel) tblBook.getModel();
        model.setRowCount(0);

        lstBook = manager.getOneBook(Name);

        lstbd = bdm.getAllBookDetail();

        lstTran.removeAll(lstTran);
        lstTran = tranm.getAllTranslator();

        lstP.removeAll(lstP);
        lstP = pm.getAllPublisher();

        lstA.removeAll(lstA);
        lstA = am.getAllAuthor();

        lstT.removeAll(lstT);
        lstT = tm.getAllType();

        for (Book b : lstBook) {
            Vector v = new Vector();
            v.add(b.getId());
            v.add(b.getName());
//
//            Vector v1 = new Vector();
//            lstA = am.getAllAuthor();
//            for (Author au : lstA) {
//                for (BookDetail bd : lstbd) {
//                    if (b.getId() == bd.getId_Book() && au.getId() == bd.getId_Translator()) {
//                        v1.add(au.getName());
//                    }
//                }
//            }
//            v.add(v1);

//            Vector v2 = new Vector();
//            for (Translator tr : lstTran) {
//                for (BookDetail bd : lstbd) {
//                    if (b.getId() == bd.getId_Book() && tr.getId() == bd.getId_Translator()) {
//                        v2.add(tr.getName());
//                    }
//                }
//            }
//            v.add(v2);
//            Vector v3 = new Vector();
//            for (Publisher p : lstP) {
//                for (BookDetail bd : lstbd) {
//                    if (b.getId() == bd.getId_Book() && p.getId() == bd.getId_Publisher()) {
//                        v3.add(p.getName());
//                    }
//                }
//            }
//            v.add(v3);
//            Vector v4 = new Vector();
//            for (Type ty : lstT) {
//                for (BookDetail bd : lstbd) {
//                    if (b.getId() == bd.getId_Book() && ty.getId() == bd.getId_Publisher()) {
//                        v4.add(ty.getName());
//                    }
//                }
//            }
//            v.add(v4);
            v.add(b.getPrice());
            v.add(b.getQuantity());
            v.add(b.getQuantityRemain());
            v.add(b.getDateAdded());
            v.add(b.getDescription());
            v.add(b.isStatus() ? "Show" : "Hidden");
            model.addRow(v);
        }
        tblBook.setModel(model);
    }
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public void SetDataBook(Book b) throws ParseException {
        txtName.setText(b.getName());

        txtPrice.setText(String.valueOf(b.getPrice()));

        txtQuantity.setText(String.valueOf(b.getQuantity()));

        DateAdd.setDate(dateFormat.parse(String.valueOf(b.getDateAdded())));

        txtDesc.setText(b.getDescription());
        if (b.isStatus() == true) {
            cboStatus.setSelectedItem("Show");
        } else {
            cboStatus.setSelectedItem("Hidden");
        }
    }

    public void SetDataTrans(BookDetail bd) {
        lstTran.removeAll(lstTran);
        lstTran = tranm.getAllTranslator();
        for (Translator tr : lstTran) {
            if (bd.getId_Translator() == tr.getId()) {
                cboTrans.setSelectedItem(tr.getName());
            }
        }
    }

    public void SetDataPubslisher(BookDetail bd) {
        lstP.removeAll(lstP);
        lstP = pm.getAllPublisher();
        for (Publisher p : lstP) {
            if (bd.getId_Publisher() == p.getId()) {
                cboPublisher.setSelectedItem(p.getName());
            }
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
        jPanel9 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        cboCate = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JlstAuthor = new javax.swing.JList<>();
        jPanel13 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        JlstType = new javax.swing.JList<>();
        jPanel18 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        cboTrans = new javax.swing.JComboBox<>();
        jPanel27 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        cboPublisher = new javax.swing.JComboBox<>();
        jPanel16 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        DateAdd = new com.toedter.calendar.JDateChooser();
        jPanel25 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        cboStatus = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        btnDetailBook = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBook = new javax.swing.JTable();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(1200, 900));

        jPanel2.setPreferredSize(new java.awt.Dimension(600, 35));
        jPanel2.setRequestFocusEnabled(false);
        jPanel2.setLayout(new java.awt.CardLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Management Book");
        jLabel3.setToolTipText("");
        jLabel3.setPreferredSize(new java.awt.Dimension(178, 75));
        jPanel2.add(jLabel3, "card2");

        jPanel1.add(jPanel2);

        jPanel3.setName(""); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 550));
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jPanel9.setForeground(new java.awt.Color(255, 0, 0));
        jPanel9.setPreferredSize(new java.awt.Dimension(400, 500));

        jPanel23.setPreferredSize(new java.awt.Dimension(350, 65));
        jPanel23.setLayout(new java.awt.BorderLayout());

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Category :");
        jPanel23.add(jLabel15, java.awt.BorderLayout.CENTER);

        cboCate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboCate.setForeground(new java.awt.Color(255, 0, 0));
        cboCate.setPreferredSize(new java.awt.Dimension(62, 35));
        jPanel23.add(cboCate, java.awt.BorderLayout.PAGE_END);

        jPanel9.add(jPanel23);

        jPanel10.setPreferredSize(new java.awt.Dimension(350, 65));
        jPanel10.setLayout(new java.awt.BorderLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Name : ");
        jPanel10.add(jLabel4, java.awt.BorderLayout.CENTER);

        txtName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtName.setForeground(new java.awt.Color(255, 0, 0));
        txtName.setPreferredSize(new java.awt.Dimension(69, 35));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPanel10.add(txtName, java.awt.BorderLayout.PAGE_END);

        jPanel9.add(jPanel10);

        jPanel11.setPreferredSize(new java.awt.Dimension(350, 190));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Author :");
        jLabel5.setPreferredSize(new java.awt.Dimension(350, 30));
        jPanel11.add(jLabel5);

        jScrollPane3.setPreferredSize(new java.awt.Dimension(350, 146));

        JlstAuthor.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(JlstAuthor);

        jPanel11.add(jScrollPane3);

        jPanel9.add(jPanel11);

        jPanel13.setPreferredSize(new java.awt.Dimension(350, 190));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Type :");
        jLabel7.setPreferredSize(new java.awt.Dimension(350, 30));
        jPanel13.add(jLabel7);

        jScrollPane4.setPreferredSize(new java.awt.Dimension(350, 146));

        JlstType.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(JlstType);

        jPanel13.add(jScrollPane4);

        jPanel9.add(jPanel13);

        jPanel3.add(jPanel9);

        jPanel18.setPreferredSize(new java.awt.Dimension(400, 450));

        jPanel22.setPreferredSize(new java.awt.Dimension(350, 65));
        jPanel22.setLayout(new java.awt.BorderLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Translator :");
        jPanel22.add(jLabel14, java.awt.BorderLayout.CENTER);

        cboTrans.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboTrans.setForeground(new java.awt.Color(255, 0, 0));
        cboTrans.setPreferredSize(new java.awt.Dimension(62, 35));
        jPanel22.add(cboTrans, java.awt.BorderLayout.PAGE_END);

        jPanel18.add(jPanel22);

        jPanel27.setPreferredSize(new java.awt.Dimension(350, 65));
        jPanel27.setLayout(new java.awt.BorderLayout());

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Publisher :");
        jPanel27.add(jLabel19, java.awt.BorderLayout.CENTER);

        cboPublisher.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboPublisher.setForeground(new java.awt.Color(255, 0, 0));
        cboPublisher.setPreferredSize(new java.awt.Dimension(62, 35));
        jPanel27.add(cboPublisher, java.awt.BorderLayout.PAGE_END);

        jPanel18.add(jPanel27);

        jPanel16.setPreferredSize(new java.awt.Dimension(350, 65));
        jPanel16.setLayout(new java.awt.BorderLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Price :");
        jPanel16.add(jLabel9, java.awt.BorderLayout.CENTER);

        txtPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPrice.setForeground(new java.awt.Color(255, 0, 0));
        txtPrice.setPreferredSize(new java.awt.Dimension(69, 35));
        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });
        jPanel16.add(txtPrice, java.awt.BorderLayout.PAGE_END);

        jPanel18.add(jPanel16);

        jPanel17.setPreferredSize(new java.awt.Dimension(350, 65));
        jPanel17.setLayout(new java.awt.BorderLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Quantity :");
        jPanel17.add(jLabel10, java.awt.BorderLayout.CENTER);

        txtQuantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtQuantity.setForeground(new java.awt.Color(255, 0, 0));
        txtQuantity.setPreferredSize(new java.awt.Dimension(69, 35));
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });
        jPanel17.add(txtQuantity, java.awt.BorderLayout.PAGE_END);

        jPanel18.add(jPanel17);

        jPanel28.setPreferredSize(new java.awt.Dimension(350, 65));
        jPanel28.setLayout(new java.awt.BorderLayout());

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("DateAdd :");
        jPanel28.add(jLabel20, java.awt.BorderLayout.CENTER);

        DateAdd.setPreferredSize(new java.awt.Dimension(100, 35));
        jPanel28.add(DateAdd, java.awt.BorderLayout.PAGE_END);

        jPanel18.add(jPanel28);

        jPanel25.setPreferredSize(new java.awt.Dimension(350, 65));
        jPanel25.setLayout(new java.awt.BorderLayout());

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Description :");
        jPanel25.add(jLabel17, java.awt.BorderLayout.CENTER);

        txtDesc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDesc.setForeground(new java.awt.Color(255, 0, 0));
        txtDesc.setPreferredSize(new java.awt.Dimension(69, 35));
        txtDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescActionPerformed(evt);
            }
        });
        jPanel25.add(txtDesc, java.awt.BorderLayout.PAGE_END);

        jPanel18.add(jPanel25);

        jPanel21.setPreferredSize(new java.awt.Dimension(350, 65));
        jPanel21.setLayout(new java.awt.BorderLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Staus :");
        jLabel13.setPreferredSize(new java.awt.Dimension(30, 20));
        jLabel13.setRequestFocusEnabled(false);
        jPanel21.add(jLabel13, java.awt.BorderLayout.CENTER);

        cboStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboStatus.setForeground(new java.awt.Color(255, 0, 0));
        cboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Show", "Hidden" }));
        cboStatus.setPreferredSize(new java.awt.Dimension(64, 35));
        jPanel21.add(cboStatus, java.awt.BorderLayout.PAGE_END);

        jPanel18.add(jPanel21);

        jPanel3.add(jPanel18);

        jPanel1.add(jPanel3);

        jPanel4.setPreferredSize(new java.awt.Dimension(750, 35));

        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setText("Add New Book");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel4.add(btnAdd);

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setText("Update Book");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel4.add(btnUpdate);

        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setText("Search Book");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel4.add(btnSearch);

        btnLoad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLoad.setText("Load Data");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });
        jPanel4.add(btnLoad);

        btnDetailBook.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDetailBook.setText("Detail Book");
        btnDetailBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailBookActionPerformed(evt);
            }
        });
        jPanel4.add(btnDetailBook);

        jPanel1.add(jPanel4);

        jPanel14.setPreferredSize(new java.awt.Dimension(900, 275));
        jPanel14.setLayout(new java.awt.BorderLayout());

        tblBook.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tblBook.setForeground(new java.awt.Color(255, 0, 0));
        tblBook.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBook.setPreferredSize(new java.awt.Dimension(400, 235));
        jScrollPane2.setViewportView(tblBook);

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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 960, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 492, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 492, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
                .addGap(36, 36, 36))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 453, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 454, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        //Id Cate
        String cate = cboCate.getSelectedItem().toString();
        lstC = cm.getOneCategory(cate);
        int Id_Cate = 0;
        for (Category category : lstC) {
            Id_Cate = category.getId();
        }
        //BookName
        String name = txtName.getText();
        //Date
        String dateadd = dateFormat.format(DateAdd.getDate());
        LocalDate da = LocalDate.parse(dateadd, DateTimeFormatter.ISO_DATE);
        //Quantity
        int quantity = Integer.parseInt(txtQuantity.getText());
        //Price
        float price = Float.parseFloat(txtPrice.getText());
        //Id Trans
        String translator = (String) cboTrans.getSelectedItem();
        int Id_Trans = 0;
        lstTran = tranm.getOneTranslator(translator);
        for (Translator trans : lstTran) {
            Id_Trans = trans.getId();
        }
        //Id Publisher
        String publisher = cboPublisher.getSelectedItem().toString();
        int Id_Pub = 0;
        lstP = pm.getOnePublisher(publisher);
        for (Publisher pub : lstP) {
            Id_Pub = pub.getId();
        }
        //Description
        String des = txtDesc.getText();
        //Status
        String sta = cboStatus.getSelectedItem().toString();
        boolean Status;
        if (sta.equals("Show")) {
            Status = true;
        } else {
            Status = false;
        }
        //Addd Book
        Book b = new Book(name, da, price, quantity, quantity, Id_Cate, des, Status);
        int row = manager.CreateBook(b);

        //Id Book
        lstBook = manager.getOneBook(name);
        int Id_Book = 0;
        for (Book bk : lstBook) {
            Id_Book = bk.getId();
        }

        //Add BookDetail
        //Add AuthorDetail
        int brow = 0;
        int cmJT[] = JlstType.getSelectedIndices();
        int cmJA[] = JlstAuthor.getSelectedIndices();
        lstA = am.getAllAuthor();
        lstT = tm.getAllType();
        for (int i = 0; i < lstA.size(); i++) {
            for (int j : cmJA) {
                for (int m = 0; m < lstT.size(); m++) {
                    for (int n : cmJT) {
                        if (i == j && m == n) {
                            BookDetail bd = new BookDetail(Id_Book, lstA.get(i).getId(), lstT.get(m).getId(), Id_Trans, Id_Pub);
                            brow = bdm.CreateBookDetail(bd);
                        }
                    }
                }
            }
        }

        //Add TypeDetail
        if (row > 0 && brow > 0) {
            JOptionPane.showMessageDialog(this, "Create Book Success !");
        } else {
            JOptionPane.showMessageDialog(this, "Create Book Error !", "Inane error", JOptionPane.ERROR_MESSAGE);
        }
        LoadData();

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String cate = cboCate.getSelectedItem().toString();
        lstC = cm.getOneCategory(cate);
        int Id_Cate = 0;
        for (Category category : lstC) {
            Id_Cate = category.getId();
        }
        //BookName
        String name = txtName.getText();
        //Date
        String dateadd = dateFormat.format(DateAdd.getDate());
        LocalDate da = LocalDate.parse(dateadd, DateTimeFormatter.ISO_DATE);
        //Quantity
        int quantity = Integer.parseInt(txtQuantity.getText());
        //Price
        float price = Float.parseFloat(txtPrice.getText());
        //Id Trans
        String translator = (String) cboTrans.getSelectedItem();
        int Id_Trans = 0;
        lstTran = tranm.getOneTranslator(translator);
        for (Translator trans : lstTran) {
            Id_Trans = trans.getId();
        }
        //Id Publisher
        String publisher = cboPublisher.getSelectedItem().toString();
        int Id_Pub = 0;
        lstP = pm.getOnePublisher(publisher);
        for (Publisher pub : lstP) {
            Id_Pub = pub.getId();
        }
        //Description
        String des = txtDesc.getText();
        //Status
        String sta = cboStatus.getSelectedItem().toString();
        boolean Status;
        if (sta.equals("Show")) {
            Status = true;
        } else {
            Status = false;
        }

        //Addd Book
        Book b = new Book(book.getId(), name, da, price, quantity, quantity, Id_Cate, des, Status);
        int row = manager.UpdateBook(b);

        //Add BookDetail
        if (row > 0) {
            JOptionPane.showMessageDialog(this, "Update Book Success !");
        } else {
            JOptionPane.showMessageDialog(this, "Update Book Error !", "Inane error", JOptionPane.ERROR_MESSAGE);
        }

        LoadData();

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        Search s = new Search(new javax.swing.JFrame(), closable, (Search.CallbackSearch) this);
        s.setVisible(true);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        // TODO add your handling code here:
        model = (DefaultTableModel) tblBook.getModel();
        model.setRowCount(0);
        LoadData();
    }//GEN-LAST:event_btnLoadActionPerformed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescActionPerformed

    private void btnDetailBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailBookActionPerformed
        // TODO add your handling code here:
        try {
            BookDetailView view = new BookDetailView(new javax.swing.JFrame(), true);
            view.setData(book);
            view.setVisible(true);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Please Select A Book For Details !");
        }
    }//GEN-LAST:event_btnDetailBookActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateAdd;
    private javax.swing.JList<String> JlstAuthor;
    private javax.swing.JList<String> JlstType;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDetailBook;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboCate;
    private javax.swing.JComboBox<String> cboPublisher;
    private javax.swing.JComboBox<String> cboStatus;
    private javax.swing.JComboBox<String> cboTrans;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblBook;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables

    @Override
    public void doDelete(int id) {
        manager.DeleteBook(id);

        model = (DefaultTableModel) tblBook.getModel();
        model.setRowCount(0);

        LoadData();
    }

    @Override
    public void doAction(String Name) {
        SearchData(Name);
    }

}
