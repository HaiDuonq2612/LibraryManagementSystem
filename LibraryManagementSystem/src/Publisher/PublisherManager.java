/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Publisher;

import Translator.Translator;
import Translator.TranslatorManager;
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
public class PublisherManager implements PublisherDAO{

    private Connection conn;
    List<Publisher> lst = new ArrayList<>();
    static CallableStatement cs;
    static ResultSet rs;
    public PublisherManager() {
        conn = ConnectionMySQL.DbUtil.getConnection();
        if (conn != null) {
            System.out.println("Kết Nối Cơ Sở Dữ Liệu Thư Viện Thành Công !");
        } else {
            System.out.println("Kết Nối Cơ Sở Dữ Liệu Thư Viện Thành Công !");
        }
    }
    
    @Override
    public List<Publisher> getAllPublisher() {
        lst.removeAll(lst);
        String sql = "{CALL getAllPublisher}";
        try {
            cs = conn.prepareCall(sql);
            rs = cs.executeQuery();

            while (rs.next()) {
                Publisher p = new Publisher();
                p.setId(rs.getInt("Id"));
                p.setName(rs.getString("Name"));

                p.setDateEstablished(rs.getDate("DateEstablished").toLocalDate());

                p.setAddress(rs.getString("Address"));
                p.setDescription(rs.getString("Description"));
                p.setStatus(rs.getBoolean("Status"));
                lst.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PublisherManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    @Override
    public List<Publisher> getOnePublisher(String Name) {
        lst.removeAll(lst);
        String sql = "{CALL getOnePublisher(?)}";
        try {
            cs = conn.prepareCall(sql);
            cs.setString(1, Name);
            rs = cs.executeQuery();

            while (rs.next()) {
                Publisher p = new Publisher();
                p.setId(rs.getInt("Id"));
                p.setName(rs.getString("Name"));

                p.setDateEstablished(rs.getDate("DateEstablished").toLocalDate());

                p.setAddress(rs.getString("Address"));
                p.setDescription(rs.getString("Description"));
                p.setStatus(rs.getBoolean("Status"));
                lst.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PublisherManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    @Override
    public int CreatePublisher(Publisher pub) {
        String sql = "{CALL CreatePublisher(?,?,?,?,?)}";
        try {
            cs = conn.prepareCall(sql);
            
            
            cs.setString(1, pub.getName());
            
            cs.setDate(2, Date.valueOf(pub.getDateEstablished()));

            cs.setString(3, pub.getAddress());
            
            cs.setString(4, pub.getDescription());
            
            cs.setBoolean(5, pub.isStatus());
            
            return cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PublisherManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int UpdatePublisher(Publisher pub) {
        String sql = "{CALL UpdatePublisher(?,?,?,?,?,?)}";
        try {
            cs = conn.prepareCall(sql);
            
            cs.setInt(1, pub.getId());
                    
            
            cs.setString(2, pub.getName());
            
            cs.setDate(3, Date.valueOf(pub.getDateEstablished()));
            
            cs.setString(4, pub.getAddress());
            
            cs.setString(5, pub.getDescription());
            
            cs.setBoolean(6, pub.isStatus());
            
            return cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PublisherManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int DeletePublisher(int id) {
        String sql = "{CALL DeletePublisher(?)}";
        try {
            cs = conn.prepareCall(sql);
            
            cs.setInt(1, id);
            
            return cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PublisherManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
}
