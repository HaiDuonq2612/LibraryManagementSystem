/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TypeBook;


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
public class TypeManager implements TypeDAO {

    private Connection conn;

    public TypeManager() {
        conn = ConnectionMySQL.DbUtil.getConnection();
        if (conn != null) {
            System.out.println("Kết Nối Cơ Sở Dữ Liệu Thư Viện Thành Công !");
        } else {
            System.out.println("Kết Nối Cơ Sở Dữ Liệu Thư Viện Thành Công !");
        }
    }

    List<Type> lst = new ArrayList<>();
    static CallableStatement cs;
    static ResultSet rs;

    @Override
    public List<Type> getAllType() {
        lst.removeAll(lst);
        String sql = "{CALL getAllType}";
        try {
            cs = conn.prepareCall(sql);
            rs = cs.executeQuery();
            
            while (rs.next()) {                
                Type type = new Type();
                type.setId(rs.getInt("Id"));
                type.setName(rs.getString("Name"));
                type.setDescription(rs.getString("Description"));
                type.setStatus(rs.getBoolean("Status"));
                lst.add(type);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TypeManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    @Override
    public List<Type> getOneType(String Name) {
        lst.removeAll(lst);
        String sql = "{CALL getOneType(?)}";
        try {
            cs = conn.prepareCall(sql);
            cs.setString(1, Name);
            rs = cs.executeQuery();
            
            while (rs.next()) {                
                Type t = new Type();
                t.setId(rs.getInt("Id"));
                t.setName(rs.getString("Name"));
                t.setDescription(rs.getString("Description"));
                t.setStatus(rs.getBoolean("Status"));
                lst.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TypeManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    @Override
    public int CreateType(Type type) {
         String sql = "{CALL CreateType(?,?,?)}";
        try {
            cs = conn.prepareCall(sql);
            cs.setString(1, type.getName());
            cs.setString(2, type.getDescription());
            cs.setBoolean(3, type.isStatus());
            return cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TypeManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int UpdateType(Type type) {
        String sql = "{CALL UpdateType(?,?,?,?)}";
        try {
            cs = conn.prepareCall(sql);
            cs.setInt(1, type.getId());
            cs.setString(2, type.getName());
            cs.setString(3, type.getDescription());
            cs.setBoolean(4, type.isStatus());
            return cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TypeManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int DeleteType(int id) {
        String sql = "{CALL DeleteType(?)}";
        try {
            cs = conn.prepareCall(sql);
            cs.setInt(1, id);
            return cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TypeManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
