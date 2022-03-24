/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bill;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
public class BillManager implements BillDAO{
private Connection conn;
    public BillManager() {
        conn = ConnectionMySQL.DbUtil.getConnection();
        if (conn != null) {
            System.out.println("Kết Nối Cơ Sở Dữ Liệu Thư Viện Thành Công !");
        } else {
            System.out.println("Kết Nối Cơ Sở Dữ Liệu Thư Viện Thành Công !");
        }
        
    }
    static CallableStatement cs;
    static ResultSet rs;
    List<Bill> lst = new ArrayList<Bill>();

    @Override
    public List<Bill> getAllBill() {
        lst.removeAll(lst);
        String sql = "{CALL getAllBill}";
        try {
            cs = conn.prepareCall(sql);
            rs = cs.executeQuery();

            while (rs.next()) {
                Bill b = new Bill();
                b.setId(rs.getInt("Id"));
                b.setId_Reader(rs.getInt("Id_Reader"));
                b.setDateIssue(rs.getDate("DateIssue").toLocalDate());
                b.setDateReturn(rs.getDate("DateReturn").toLocalDate());
                b.setStatus(rs.getBoolean("Status"));
                lst.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    PreparedStatement ps;
    @Override
    public List<Bill> getOneBill(int id) {
        lst.removeAll(lst);
//        String sql = "{CALL getOneBill(?)}";
        String sql = "SELECT * FROM  Bill Where Id_Reader = " + id;
        try {
            ps = conn.prepareCall(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Bill b = new Bill();
                b.setId(rs.getInt("Id"));
                b.setId_Reader(rs.getInt("Id_Reader"));
                b.setDateIssue(rs.getDate("DateIssue").toLocalDate());
                b.setDateReturn(rs.getDate("DateReturn").toLocalDate());
                b.setStatus(rs.getBoolean("Status"));
                lst.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    @Override
    public int CreateBill(Bill bill) {
        String sql = "{CALL CreateBill(?,?,?,?)}";
        
        try {
            cs = conn.prepareCall(sql);
            
            cs.setInt(1, bill.getId_Reader());
            
            cs.setDate(2, Date.valueOf(bill.getDateIssue()));
            
            cs.setDate(3, Date.valueOf(bill.getDateReturn()));
            
            cs.setBoolean(4, bill.isStatus());
            return cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BillManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int UpdateBill(Bill bill) {
        String sql = "{CALL UpdateBill(?,?)}";
        
        try {
            cs = conn.prepareCall(sql);
            
            cs.setInt(1, bill.getId());
            
            cs.setBoolean(2, bill.isStatus());
            return cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BillManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
}
