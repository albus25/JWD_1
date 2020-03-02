/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletsPack;

import java.sql.*;

/**
 *
 * @author Albus
 */
public class AllMethods {
    public static Connection con(){
        Connection cn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/employeedb","root","toor");
            
            if(cn == null){
                System.out.println("Not Done");
            }
            else{
                System.out.println("Done");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return cn;
    }
    
    public static int AddEmployee(Employee e){
        int sts = 0;
        try {
            Connection cn = AllMethods.con();
            PreparedStatement pst = cn.prepareStatement("insert into tblemployee values(0,?,?,?)");
            
            pst.setString(1, e.getEmpName());
            pst.setInt(2, e.getSalary());
            pst.setInt(3, e.getDeptID());
            
            sts = pst.executeUpdate();
            cn.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        
        return sts;
    }
    
    public static ResultSet ShowEmployee(){
        ResultSet rs = null;
        try {
            Connection cn = AllMethods.con();
            PreparedStatement pst = cn.prepareStatement("select e.*,d.deptName from tblemployee e,tbldepartment d where d.deptID=e.deptID");
            
            rs = pst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return rs;
    }
    
    public static ResultSet GetEmployee(int eid){
        ResultSet rs = null;
        try {
            Connection cn = AllMethods.con();
            PreparedStatement pst = cn.prepareStatement("select * from tblemployee where empID = "+eid);
            
            rs = pst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return rs;        
    }
    
    public static int UpdateEmployee(Employee e,int eid){
        int sts = 0;
        try {
            Connection cn = AllMethods.con();
            PreparedStatement pst = cn.prepareStatement("update tblemployee set empName = ?,salary = ?,deptID = ? where empID = "+eid);
            
            pst.setString(1, e.getEmpName());
            pst.setInt(2, e.getSalary());
            pst.setInt(3, e.getDeptID());
            
            sts = pst.executeUpdate();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        
        return sts;
    }
    
    public static int DeleteEmployee(int eid){
        int sts = 0;
        try {
            Connection cn = AllMethods.con();
            PreparedStatement pst = cn.prepareStatement("delete from tblemployee where empID = "+eid);
            
            sts = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return sts;
    }

    public static int AddDepartment(Department d){
        int sts = 0;
        try {
            Connection cn = AllMethods.con();
            PreparedStatement pst = cn.prepareStatement("insert into tbldepartment values(0,?)");
            
            pst.setString(1, d.getDeptName());
            
            sts = pst.executeUpdate();
            cn.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        
        return sts;
    }
    
    public static ResultSet ShowDepartment(){
        ResultSet rs = null;
        try {
            Connection cn = AllMethods.con();
            PreparedStatement pst = cn.prepareStatement("select * from tbldepartment");
            
            rs = pst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return rs;
    }
    
    public static ResultSet GetDepartment(int did){
        ResultSet rs = null;
        try {
            Connection cn = AllMethods.con();
            PreparedStatement pst = cn.prepareStatement("select * from tbldepartment where deptID = "+did);
            
            rs = pst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return rs;        
    }
    
    public static int UpdateDepartment(Department d,int did){
        int sts = 0;
        try {
            Connection cn = AllMethods.con();
            PreparedStatement pst = cn.prepareStatement("update tbldepartment set deptName = ? where deptID = "+did);

            pst.setString(1, d.getDeptName());
            
            sts = pst.executeUpdate();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        
        return sts;
    }
    
    public static int DeleteDepartment(int did){
        int sts = 0;
        try {
            Connection cn = AllMethods.con();
            PreparedStatement pst = cn.prepareStatement("delete from tbldepartment where deptID = "+did);
            
            sts = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return sts;
    }
    
    public static ResultSet DeptWise(int did){
        ResultSet rs = null;
        try {
            Connection cn = AllMethods.con();
            PreparedStatement pst = cn.prepareStatement("select e.*,d.deptName from tblemployee e,tbldepartment d where e.deptID = d.deptID and d.deptID = "+did);
            
            rs = pst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return rs;
    }
}
