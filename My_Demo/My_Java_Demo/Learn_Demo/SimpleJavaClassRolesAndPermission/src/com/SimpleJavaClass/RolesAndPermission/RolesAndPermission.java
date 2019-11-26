package com.SimpleJavaClass.RolesAndPermission;

import java.util.ArrayList;
import java.util.List;

public class RolesAndPermission {
    public static void main(String[] args) {

    }
}

//雇员ID
//雇员姓名
class Employee {
    private int EmployeeID;         //雇员ID
    private String EmployeeName;    //雇员的姓名
    private Department Department;  //一个雇员属于一个部门

    public Employee() {
    }

    public Employee(int employeeID, String employeeName) {
        this.EmployeeID = employeeID;
        this.EmployeeName = employeeName;
    }

    public int getEmployeeID() {
        return this.EmployeeID;
    }

    public String getEmployeeName() {
        return this.EmployeeName;
    }

    public Department getDepartment() {
        return this.Department;
    }

    public void setEmployeeID(int employeeID) {
        this.EmployeeID = employeeID;
    }

    public void setEmployeeName(String employeeName) {
        this.EmployeeName = employeeName;
    }

    public void setDepartment(Department department) {
        this.Department = department;
    }

    public String getInfo() {
        return "员工ID= " + this.EmployeeID + "，员工姓名= " + this.EmployeeName;
    }
}

//部门ID
//部门名称
class Department {
    private int DepartmentID;
    private String DepartmentName;
    private Employee[] EmployeeArry;    //一个部门有多个角色
    private Roles Roles;                //一个部门有一个角色

    public Department() {
    }

    public Department(int departmentID, String departmentName) {
        this.DepartmentID = departmentID;
        this.DepartmentName = departmentName;
    }

    public int getDepartmentID() {
        return this.DepartmentID;
    }

    public String getDepartmentName() {
        return this.DepartmentName;
    }

    public Employee[] getEmployeeArry() {
        return this.EmployeeArry;
    }

    public Roles getRoles() {
        return this.Roles;
    }

    public void setDepartmentID(int departmentID) {
        this.DepartmentID = departmentID;
    }

    public void setDepartmentName(String departmentName) {
        this.DepartmentName = departmentName;
    }

    public void setEmployeeArry(Employee[] employeeArry) {
        this.EmployeeArry = employeeArry;
    }

    public void setRoles(Roles roles) {
        this.Roles = roles;
    }

    public String getInfo() {
        return "部门ID= " + this.DepartmentID + "，部门名称= " + this.DepartmentName;
    }
}

//角色ID
//角色名称
class Roles {
    private int RolesId;
    private String RolesTitle;

    public Roles(int rolesId, String rolesTitle) {
        this.RolesId = rolesId;
        this.RolesTitle = rolesTitle;
    }

    public int getRolesId() {
        return RolesId;
    }

    public String getRolesTitle() {
        return RolesTitle;
    }

    public void setRolesId(int rolesId) {
        RolesId = rolesId;
    }

    public void setRolesTitle(String rolesTitle) {
        RolesTitle = rolesTitle;
    }

    public String grtInfo() {
        return "角色ID= " + this.RolesId + "，角色名称= " + this.RolesTitle;
    }
}


//权限ID
//权限名称
//权限标记
class Permission {
    private int PermissionID;
    private String PermissionTitle;
    private String PermissionFlag;

    public Permission(int permissionID, String permissionTitle, String permissionFlag) {
        this.PermissionID = permissionID;
        this.PermissionTitle = permissionTitle;
        this.PermissionFlag = permissionFlag;
    }

    public int getPermissionID() {
        return PermissionID;
    }

    public String getPermissionTitle() {
        return PermissionTitle;
    }

    public String getPermissionFlag() {
        return PermissionFlag;
    }

    public void setPermissionID(int permissionID) {
        PermissionID = permissionID;
    }

    public void setPermissionTitle(String permissionTitle) {
        PermissionTitle = permissionTitle;
    }

    public void setPermissionFlag(String permissionFlag) {
        PermissionFlag = permissionFlag;
    }

    public String getInfo() {
        return "权限ID= " + this.PermissionID +
                "，权限名称= " + this.PermissionTitle +
                "，权限标志= " + this.PermissionFlag;
    }
}