package com.coherent.task.tableElements;

public class TableElement {

    private String name;
    private String position;
    private String office;

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    @Override
    public String toString() {
        return "TableElement{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", office='" + office + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}
