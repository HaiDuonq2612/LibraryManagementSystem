/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reader;

import Publisher.PublisherManager;
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
public class ReaderManager implements ReaderDAO{

    private Connection conn;
    List<Reader> lst = new ArrayList<>();
    static CallableStatement cs;
    static ResultSet rs;
    public ReaderManager() {
        conn = ConnectionMySQL.DbUtil.getConnection();
        if (conn != null) {
            System.out.println("Kết Nối Cơ Sở Dữ Liệu Thư Viện Thành Công !");
        } else {
            System.out.println("Kết Nối Cơ Sở Dữ Liệu Thư Viện Thành Công !");
        }
    }

    @Override
    public List<Reader> getAllReader() {
        lst.removeAll(lst);
        String sql = "{CALL getAllReader}";
        try {
            cs = conn.prepareCall(sql);
            rs = cs.executeQuery();

            while (rs.next()) {
                Reader r = new Reader();
                r.setId(rs.getInt("Id"));
                r.setName(rs.getString("Name"));
                r.setEmail(rs.getString("Email"));
                r.setPhone(rs.getString("Phone"));
                r.setAddress(rs.getString("Address"));
                r.setStatus(rs.getBoolean("Status"));
                lst.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReaderManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    @Override
    public List<Reader> getOneReader(String Name) {
        lst.removeAll(lst);
        String sql = "{CALL getOneReader(?)}";
        try {
            cs = conn.prepareCall(sql);
            cs.setString(1, Name);
            rs = cs.executeQuery();

            while (rs.next()) {
                Reader r = new Reader();
                r.setId(rs.getInt("Id"));
                r.setName(rs.getString("Name"));
                r.setEmail(rs.getString("Email"));
                r.setPhone(rs.getString("Phone"));
                r.setAddress(rs.getString("Address"));
                r.setStatus(rs.getBoolean("Status"));
                lst.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReaderManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    @Override
    public int CreateReader(Reader rea) {
        String sql = "{CALL CreateReader(?,?,?,?,?)}";
        try {
            cs = conn.prepareCall(sql);
            
            
            cs.setString(1, rea.getName());
            
            cs.setString(2, rea.getEmail());

            cs.setString(3, rea.getPhone());
            
            cs.setString(4, rea.getAddress());
            
            cs.setBoolean(5, rea.isStatus());
            
            return cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReaderManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int UpdateReader(Reader rea) {
        String sql = "{CALL UpdateReader(?,?,?,?,?,?)}";
        try {
            cs = conn.prepareCall(sql);
            
            cs.setInt(1, rea.getId());
                    
            
            cs.setString(2, rea.getName());
            
            cs.setString(3, rea.getEmail());

            cs.setString(4, rea.getPhone());
            
            cs.setString(5, rea.getAddress());
            
            cs.setBoolean(6, rea.isStatus());
            
            return cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReaderManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int DeleteReader(int id) {
       String sql = "{CALL DeleteReader(?)}";
        try {
            cs = conn.prepareCall(sql);
            
            cs.setInt(1, id);
            
            return cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReaderManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public List<Reader> getNamePhoneReader(String Name, String Phone) {
        lst.removeAll(lst);
        String sql = "{CALL getNamePhoneReader(?,?)}";
        try {
            cs = conn.prepareCall(sql);
            cs.setString(1, Name);
            cs.setString(2, Phone);
            rs = cs.executeQuery();

            while (rs.next()) {
                Reader r = new Reader();
                r.setId(rs.getInt("Id"));
                r.setName(rs.getString("Name"));
                r.setEmail(rs.getString("Email"));
                r.setPhone(rs.getString("Phone"));
                r.setAddress(rs.getString("Address"));
                r.setStatus(rs.getBoolean("Status"));
                lst.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReaderManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }
    
}
