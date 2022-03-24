/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Book;

import BookDetail.BookDetail;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
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
public class BookManager implements BookDAO{

    private Connection conn;

    public BookManager() {
        conn = ConnectionMySQL.DbUtil.getConnection();
        if (conn != null) {
            System.out.println("Kết Nối Cơ Sở Dữ Liệu Thư Viện Thành Công !");
        } else {
            System.out.println("Kết Nối Cơ Sở Dữ Liệu Thư Viện Thành Công !");
        }
    }
    List<Book> lst = new ArrayList<Book>();
    static CallableStatement cs;
    static ResultSet rs;
    @Override
    public List<Book> getAllBook() {
        lst.removeAll(lst);
        String sql = "{CALL getAllBook}";
        try {
            cs = conn.prepareCall(sql);
            rs = cs.executeQuery();

            while (rs.next()) {
                Book b = new Book();
                b.setId(rs.getInt("Id"));
                b.setName(rs.getString("Name"));
                b.setDateAdded(rs.getDate("DateAdded").toLocalDate());
                b.setPrice(rs.getFloat("Price"));
                b.setQuantity(rs.getInt("Quantity"));
                b.setQuantityRemain(rs.getInt("QuantityRemain"));
                b.setCategory_Id(rs.getInt("Category_Id"));
                b.setDescription(rs.getString("Description"));
                b.setStatus(rs.getBoolean("Status"));
                lst.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    @Override
    public List<Book> getOneBook(String Name) {
        lst.removeAll(lst);
        String sql = "{CALL getOneBook(?)}";
        try {
            cs = conn.prepareCall(sql);
            cs.setString(1, Name);
            rs = cs.executeQuery();

            while (rs.next()) {
                Book b = new Book();
                b.setId(rs.getInt("Id"));
                b.setName(rs.getString("Name"));
                b.setDateAdded(rs.getDate("DateAdded").toLocalDate());
                b.setPrice(rs.getFloat("Price"));
                b.setQuantity(rs.getInt("Quantity"));
                b.setQuantityRemain(rs.getInt("QuantityRemain"));
                b.setCategory_Id(rs.getInt("Category_Id"));
                b.setDescription(rs.getString("Description"));
                b.setStatus(rs.getBoolean("Status"));
                lst.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    @Override
    public int CreateBook(Book book) {
        String sql = "{CALL CreateBook(?,?,?,?,?,?,?,?)}";
        try {
            cs = conn.prepareCall(sql);
            cs.setString(1, book.getName());
            cs.setDate(2, Date.valueOf(book.getDateAdded()));
            cs.setFloat(3, book.getPrice());
            cs.setInt(4, book.getQuantity());
            cs.setInt(5, book.getQuantityRemain());
            cs.setInt(6, book.getCategory_Id());
            cs.setString(7, book.getDescription());
            cs.setBoolean(8, book.isStatus());
            return cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int UpdateBook(Book book) {
        String sql = "{CALL UpdateBook(?,?,?,?,?,?,?,?,?)}";
        try {
            cs = conn.prepareCall(sql);
            cs.setInt(1, book.getId());
            cs.setInt(2, book.getCategory_Id());
            cs.setString(3, book.getName());
            cs.setDate(4, Date.valueOf(book.getDateAdded()));
            cs.setFloat(5, book.getPrice());
            cs.setInt(6, book.getQuantity());
            cs.setInt(7, book.getQuantityRemain());
            cs.setString(8, book.getDescription());
            cs.setBoolean(9, book.isStatus());
            return cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int DeleteBook(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int UpdateQuantityRemainBook(Book book) {
        String sql = "{CALL UpdateQuantityRemainBook(?,?)}";
        try {
            cs = conn.prepareCall(sql);
            cs.setInt(1, book.getId());
            cs.setInt(2, book.getQuantityRemain());
            return cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

   
    
}
