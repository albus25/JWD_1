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
public class Employee {
    private int empID,deptID,salary;
    private String empName;

    public Employee() {
    }

    public Employee(int deptID, int salary, String empName) {
        this.deptID = deptID;
        this.salary = salary;
        this.empName = empName;
    }

    public Employee(int empID, int deptID, int salary, String empName) {
        this.empID = empID;
        this.deptID = deptID;
        this.salary = salary;
        this.empName = empName;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public int getDeptID() {
        return deptID;
    }

    public void setDeptID(int deptID) {
        this.deptID = deptID;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
