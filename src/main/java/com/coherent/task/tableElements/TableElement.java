package com.coherent.task.tableElements;

public class TableElement {

    private String name;
    private String position;
    private String office;

    public TableElement(String name, String position, String office) {
        this.name = name;
        this.position = position;
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
