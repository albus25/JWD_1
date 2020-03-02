/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletsPack;

/**
 *
 * @author Albus
 */
public class Department {
    private int deptID;
    private String deptName;

    public Department() {
    }

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public Department(int deptID, String deptName) {
        this.deptID = deptID;
        this.deptName = deptName;
    }

    public int getDeptID() {
        return deptID;
    }

    public void setDeptID(int deptID) {
        this.deptID = deptID;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
