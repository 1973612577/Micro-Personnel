package com.nnxy.javaweb.entity;

public class Wages {
    private String id;
    private String name;
    private String basicWage;
    private String matters;
    private String detailed;
    private String operation;
    private String finalWage;
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

    public String getBasicWage() {
        return basicWage;
    }

    public void setBasicWage(String basicWage) {
        this.basicWage = basicWage;
    }

    public String getMatters() {
        return matters;
    }

    public void setMatters(String matters) {
        this.matters = matters;
    }

    public String getDetailed() {
        return detailed;
    }

    public void setDetailed(String detailed) {
        this.detailed = detailed;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getFinalWage() {
        return finalWage;
    }

    public void setFinalWage(String finalWage) {
        this.finalWage = finalWage;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Wages{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", basicWage='" + basicWage + '\'' +
                ", matters='" + matters + '\'' +
                ", detailed='" + detailed + '\'' +
                ", operation='" + operation + '\'' +
                ", finalWage='" + finalWage + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
