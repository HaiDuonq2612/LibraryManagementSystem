/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bill;

import java.util.List;

/**
 *
 * @author Hảii Dươnq
 */
public interface BillDAO {
    public List<Bill> getAllBill();
    public List<Bill> getOneBill(int id);
    public int CreateBill(Bill bill);
    public int UpdateBill(Bill bill);
}
