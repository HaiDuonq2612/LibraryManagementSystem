/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BillDetail;

import java.util.List;

/**
 *
 * @author Hảii Dươnq
 */
public interface BillDetailDAO {
    public List<BillDetail> getAllBillDetail();
    public List<BillDetail> getOneBillDetail(int Id_Bookdetail, int Id_Bill);
    public int CreateBillDetail(BillDetail bdd);
    public int ReturnBillDetail(BillDetail bdd);
}
