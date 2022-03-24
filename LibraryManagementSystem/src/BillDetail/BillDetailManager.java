/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BillDetail;

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
public class BillDetailManager implements BillDetailDAO{

    private Connection conn;

    public BillDetailManager() {
        conn = ConnectionMySQL.DbUtil.getConnection();
        if (conn != null) {
            System.out.println("Kết Nối Cơ Sở Dữ Liệu Thư Viện Thành Công !");
        } else {
            System.out.println("Kết Nối Cơ Sở Dữ Liệu Thư Viện Thành Công !");
        }
    }
    
    static CallableStatement cs;
    static ResultSet rs;
    List<BillDetail> lst = new ArrayList<BillDetail>();
    
    @Override
    public List<BillDetail> getAllBillDetail() {
        lst.removeAll(lst);
        String sql = "{CALL getAllBillDetail}";
        try {
            cs = conn.prepareCall(sql);
            rs = cs.executeQuery();

            while (rs.next()) {
                BillDetail bd = new BillDetail();
                bd.setId(rs.getInt("Id"));
                bd.setId_Bill(rs.getInt("Id_Bill"));
                bd.setId_BookDetail(rs.getInt("Id_BookDetail"));
                bd.setDateReturn(rs.getDate("DateReturn").toLocalDate());
                bd.setStatus(rs.getBoolean("Status"));
                
                lst.add(bd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDetailManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    @Override
    public List<BillDetail> getOneBillDetail(int Id_Bill,int Id_Bookdetail) {
        lst.removeAll(lst);
        String sql = "{CALL getOneBillDetail(?,?)}";
        try {
            
            cs = conn.prepareCall(sql);
            
            cs.setInt(1, Id_Bill);
            cs.setInt(2, Id_Bookdetail);
            
            rs = cs.executeQuery();

            while (rs.next()) {
                BillDetail bd = new BillDetail();
                bd.setId(rs.getInt("Id"));
                bd.setId_Bill(rs.getInt("Id_Bill"));
                bd.setId_BookDetail(rs.getInt("Id_BookDetail"));
                bd.setStatus(rs.getBoolean("Status"));
                lst.add(bd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDetailManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    @Override
    public int CreateBillDetail(BillDetail bd) {
        String sql = "{CALL CreateBillDetail(?,?,?,?)}";
        try {
            cs = conn.prepareCall(sql);
            
            cs.setInt(1, bd.getId_Bill());
            
            cs.setInt(2, bd.getId_BookDetail());
            
            cs.setDate(3, Date.valueOf(bd.getDateReturn()));
            
            cs.setBoolean(4, bd.isStatus());
            
            return cs.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(BillDetailManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int ReturnBillDetail(BillDetail bdd) {
        
        String sql = "{CALL UpdateBillDetail(?,?,?)}";
        try {
            cs = conn.prepareCall(sql);
            
            cs.setInt(1, bdd.getId());
            cs.setDate(2, Date.valueOf(bdd.getDateReturn()));
            cs.setBoolean(3, bdd.isStatus());
            return cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BillDetailManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
}
