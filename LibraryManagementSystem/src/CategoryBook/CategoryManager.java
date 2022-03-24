/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CategoryBook;

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
public class CategoryManager implements CategoryDAO{
    
    private Connection conn;
    
    public CategoryManager() {
        conn = ConnectionMySQL.DbUtil.getConnection();
        if (conn != null) {
            System.out.println("Kết Nối Cơ Sở Dữ Liệu Thư Viện Thành Công !");
        } else {
            System.out.println("Kết Nối Cơ Sở Dữ Liệu Thư Viện Thành Công !");
        }
    }
    
    List<Category> lst = new ArrayList<>();
    static CallableStatement cs;
    static ResultSet rs;
    
    @Override
    public List<Category> getAllCategory() {
        lst.removeAll(lst);
        String sql = "{CALL getAllCategory}";
        try {
            cs = conn.prepareCall(sql);
            rs = cs.executeQuery();
            
            while (rs.next()) {                
                Category cat = new Category();
                cat.setId(rs.getInt("Id"));
                cat.setName(rs.getString("Name"));
                cat.setDescription(rs.getString("Description"));
                cat.setStatus(rs.getBoolean("Status"));
                lst.add(cat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    @Override
    public List<Category> getOneCategory(String Name) {
        lst.removeAll(lst);
        String sql = "{CALL getOneCategory(?)}";
        try {
            cs = conn.prepareCall(sql);
            cs.setString(1, Name);
            rs = cs.executeQuery();
            
            while (rs.next()) {                
                Category cat = new Category();
                cat.setId(rs.getInt("Id"));
                cat.setName(rs.getString("Name"));
                cat.setDescription(rs.getString("Description"));
                cat.setStatus(rs.getBoolean("Status"));
                lst.add(cat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    @Override
    public int CreateCategory(Category cat) {
        String sql = "{CALL CreateCategory(?,?,?)}";
        try {
            cs = conn.prepareCall(sql);
            cs.setString(1, cat.getName());
            cs.setString(2, cat.getDescription());
            cs.setBoolean(3, cat.isStatus());
            return cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int UpdateCategory(Category cat) {
        String sql = "{CALL UpdateCategory(?,?,?,?)}";
        try {
            cs = conn.prepareCall(sql);
            cs.setInt(1, cat.getId());
            cs.setString(2, cat.getName());
            cs.setString(3, cat.getDescription());
            cs.setBoolean(4, cat.isStatus());
            return cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int DeleteCategory(int id) {
        String sql = "{CALL DeleteCategory(?)}";
        try {
            cs = conn.prepareCall(sql);
            cs.setInt(1, id);
            return cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    
}
