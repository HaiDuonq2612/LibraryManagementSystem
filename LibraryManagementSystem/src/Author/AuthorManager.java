/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Author;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hảii Dươnq
 */
public class AuthorManager implements AuthorDAO {

    private Connection conn;

    public AuthorManager() {
        conn = ConnectionMySQL.DbUtil.getConnection();
        if (conn != null) {
            System.out.println("Kết Nối Cơ Sở Dữ Liệu Thư Viện Thành Công !");
        } else {
            System.out.println("Kết Nối Cơ Sở Dữ Liệu Thư Viện Thành Công !");
        }
    }

    List<Author> lst = new ArrayList<Author>();
    static CallableStatement cs;
    static ResultSet rs;

    @Override
    public List<Author> getAllAuthor() {
        lst.removeAll(lst);
        String sql = "{CALL getAllAuthor}";
        try {
            cs = conn.prepareCall(sql);
            rs = cs.executeQuery();

            while (rs.next()) {
                Author a = new Author();
                a.setId(rs.getInt("Id"));
                a.setPseudonym(rs.getString("Pseudonym"));
                a.setName(rs.getString("Name"));
                
                a.setDateBirth(rs.getDate("DateBirth").toLocalDate());
                
                a.setDateLost(rs.getDate("DateLost").toLocalDate());
                
                a.setAddress(rs.getString("Address"));
                a.setDescription(rs.getString("Description"));
                a.setStatus(rs.getBoolean("Status"));
                lst.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    @Override
    public List<Author> getOneAuthor(String Name) {
        lst.removeAll(lst);
        String sql = "{CALL getOneAuthor(?)}";
        try {
            cs = conn.prepareCall(sql);
            cs.setString(1, Name);
            rs = cs.executeQuery();

            while (rs.next()) {
                Author au = new Author();
                au.setId(rs.getInt("Id"));
                au.setPseudonym(rs.getString("Pseudonym"));
                au.setName(rs.getString("Name"));
                
                au.setDateBirth(rs.getDate("DateBirth").toLocalDate());
                
                au.setDateLost(rs.getDate("DateLost").toLocalDate());
                
                au.setAddress(rs.getString("Address"));
                au.setDescription(rs.getString("Description"));
                au.setStatus(rs.getBoolean("Status"));
                lst.add(au);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public int CreateAuthor(Author author) {
        String sql = "{CALL CreateAuthor(?,?,?,?,?,?,?)}";
        try {
            cs = conn.prepareCall(sql);
            
            cs.setString(1, author.getPseudonym());
            
            cs.setString(2, author.getName());
            
            cs.setDate(3, Date.valueOf(author.getDateBirth()));
            
            cs.setDate(4, Date.valueOf(author.getDateLost()));
            
            cs.setString(5, author.getAddress());
            
            cs.setString(6, author.getDescription());
            
            cs.setBoolean(7, author.isStatus());
            
            return cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AuthorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int UpdateAuthor(Author author) {
        String sql = "{CALL UpdateAuthor(?,?,?,?,?,?,?,?)}";
        try {
            cs = conn.prepareCall(sql);
            
            cs.setInt(1, author.getId());
                    
            cs.setString(2, author.getPseudonym());
            
            cs.setString(3, author.getName());
            
            cs.setDate(4, Date.valueOf(author.getDateBirth()));
            
            cs.setDate(5, Date.valueOf(author.getDateLost()));
            
            cs.setString(6, author.getAddress());
            
            cs.setString(7, author.getDescription());
            
            cs.setBoolean(8, author.isStatus());
            
            return cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AuthorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int DeleteAuthor(int id) {
        String sql = "{CALL DeleteAuthor(?)}";
        try {
            cs = conn.prepareCall(sql);
            
            cs.setInt(1, id);
            
            return cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AuthorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }


}
