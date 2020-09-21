package com.wp.pojo;

public class BookType {
    Integer typeId;
    String typeName;
    String note;

    public BookType(Integer typeId, String typeName, String note) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.note = note;
    }

    public BookType() {
        super();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "BookType{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
