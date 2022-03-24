/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Translator;

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
public class TranslatorManager implements TranslatorDAO {

    private Connection conn;

    List<Translator> lst = new ArrayList<>();
    static CallableStatement cs;
    static ResultSet rs;

    public TranslatorManager() {
        conn = ConnectionMySQL.DbUtil.getConnection();
        if (conn != null) {
            System.out.println("Kết Nối Cơ Sở Dữ Liệu Thư Viện Thành Công !");
        } else {
            System.out.println("Kết Nối Cơ Sở Dữ Liệu Thư Viện Thành Công !");
        }
    }

    @Override
    public List<Translator> getAllTranslator() {
        lst.removeAll(lst);
        String sql = "{CALL getAllTranslator}";
        try {
            cs = conn.prepareCall(sql);
            rs = cs.executeQuery();

            while (rs.next()) {
                Translator trans = new Translator();
                trans.setId(rs.getInt("Id"));
                trans.setName(rs.getString("Name"));

                trans.setDateBirth(rs.getDate("DateBirth").toLocalDate());

                trans.setAddress(rs.getString("Address"));
                trans.setDescription(rs.getString("Description"));
                trans.setStatus(rs.getBoolean("Status"));
                lst.add(trans);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TranslatorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    @Override
    public List<Translator> getOneTranslator(String Name) {
       lst.removeAll(lst);
        String sql = "{CALL getOneTranslator(?)}";
        try {
            cs = conn.prepareCall(sql);
            cs.setString(1, Name);
            rs = cs.executeQuery();

            while (rs.next()) {
                
                Translator trans = new Translator();
                trans.setId(rs.getInt("Id"));
                trans.setName(rs.getString("Name"));

                trans.setDateBirth(rs.getDate("DateBirth").toLocalDate());

                trans.setAddress(rs.getString("Address"));
                trans.setDescription(rs.getString("Description"));
                trans.setStatus(rs.getBoolean("Status"));
                lst.add(trans);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TranslatorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    @Override
    public int CreateTranslator(Translator trans) {
        String sql = "{CALL CreateTranslator(?,?,?,?,?)}";
        try {
            cs = conn.prepareCall(sql);
            
            
            cs.setString(1, trans.getName());
            
            cs.setDate(2, Date.valueOf(trans.getDateBirth()));

            cs.setString(3, trans.getAddress());
            
            cs.setString(4, trans.getDescription());
            
            cs.setBoolean(5, trans.isStatus());
            
            return cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TranslatorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int UpdateTranslator(Translator trans) {
        String sql = "{CALL UpdateTranslator(?,?,?,?,?,?)}";
        try {
            cs = conn.prepareCall(sql);
            
            cs.setInt(1, trans.getId());
                    
            
            cs.setString(2, trans.getName());
            
            cs.setDate(3, Date.valueOf(trans.getDateBirth()));
            
            cs.setString(4, trans.getAddress());
            
            cs.setString(5, trans.getDescription());
            
            cs.setBoolean(6, trans.isStatus());
            
            return cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TranslatorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int DeleteTranslator(int id) {
        String sql = "{CALL DeleteTranslator(?)}";
        try {
            cs = conn.prepareCall(sql);
            
            cs.setInt(1, id);
            
            return cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TranslatorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
