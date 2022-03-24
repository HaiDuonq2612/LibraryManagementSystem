/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookDetail;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hảii Dươnq
 */
public class BookDetailManager implements BookDetailDAO {

    private Connection conn;

    public BookDetailManager() {
        conn = ConnectionMySQL.DbUtil.getConnection();
        if (conn != null) {
            System.out.println("Kết Nối Cơ Sở Dữ Liệu Thư Viện Thành Công !");
        } else {
            System.out.println("Kết Nối Cơ Sở Dữ Liệu Thư Viện Thành Công !");
        }
    }

    List<BookDetail> lst = new ArrayList<BookDetail>();
    static CallableStatement cs;
    static ResultSet rs;

    @Override
    public List<BookDetail> getAllBookDetail() {
        lst.removeAll(lst);
        String sql = "{CALL getAllBookDetail}";
        try {
            cs = conn.prepareCall(sql);
            rs = cs.executeQuery();

            while (rs.next()) {
                BookDetail bd = new BookDetail();
                bd.setId(rs.getInt("Id"));
                bd.setId_Book(rs.getInt("Id_Book"));
                bd.setId_Author(rs.getInt("Id_Author"));
                bd.setId_Type(rs.getInt("Id_Type"));
                bd.setId_Translator(rs.getInt("Id_Translator"));
                bd.setId_Publisher(rs.getInt("Id_Publisher"));
                lst.add(bd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDetailManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    @Override
    public List<BookDetail> getOneBookDetail(String Name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int CreateBookDetail(BookDetail bd) {
        String sql = "{CALL CreateBookDetail(?,?,?,?,?)}";
        try {
            cs = conn.prepareCall(sql);
            cs.setInt(1, bd.getId_Book());
            cs.setInt(2, bd.getId_Author());
            cs.setInt(3, bd.getId_Type());
            cs.setInt(4, bd.getId_Translator());
            cs.setInt(5, bd.getId_Publisher());

            return cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookDetailManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int UpdateBookDetail(BookDetail bd) {
        String sql = "{CALL UpdateBookDetail(?,?,?,?,?,?)}";
        try {
            cs = conn.prepareCall(sql);
            cs.setInt(1, bd.getId());
            cs.setInt(2, bd.getId_Book());
            cs.setInt(3, bd.getId_Author());
            cs.setInt(4, bd.getId_Type());
            cs.setInt(5, bd.getId_Translator());
            cs.setInt(6, bd.getId_Publisher());

            return cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookDetailManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int DeleteBookDetail(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BookDetail> getListAuthorDetail(int id) {
        lst.removeAll(lst);
        String sql = "{CALL getListAuthorDetail(?)}";
        try {
            cs = conn.prepareCall(sql);
            cs.setInt(1, id);
            rs = cs.executeQuery();
            while (rs.next()) {
                BookDetail bd = new BookDetail();
                bd.setId_Author(rs.getInt("Id_Author"));
                lst.add(bd);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BookDetailManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lst;
    }

    @Override
    public List<BookDetail> getListTypeDetail(int id) {
        lst.removeAll(lst);
        String sql = "{CALL getListTypeDetail(?)}";
        try {
            cs = conn.prepareCall(sql);
            cs.setInt(1, id);
            rs = cs.executeQuery();
            while (rs.next()) {
                BookDetail bd = new BookDetail();
                bd.setId_Type(rs.getInt("Id_Type"));
                lst.add(bd);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BookDetailManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lst;
    }

}
