package com.nnxy.javaweb.entity;

public class EmployeeMove {
    private String id;
    private String name;
    private String oldDepartment;
    private String newDepartment;
    private String because;
    private String time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOldDepartment() {
        return oldDepartment;
    }

    public void setOldDepartment(String oldDepartment) {
        this.oldDepartment = oldDepartment;
    }

    public String getNewDepartment() {
        return newDepartment;
    }

    public void setNewDepartment(String newDepartment) {
        this.newDepartment = newDepartment;
    }

    public String getBecause() {
        return because;
    }

    public void setBecause(String because) {
        this.because = because;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "EmployeeMove{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", oldDepartment='" + oldDepartment + '\'' +
                ", newDepartment='" + newDepartment + '\'' +
                ", because='" + because + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
