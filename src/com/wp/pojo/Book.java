package com.wp.pojo;

public class Book {
        Integer bookId;
        String bookName;
        Float price;
        String title;
        String bookNote;
        Integer typeId;
        String typeName;
        String note;

        public Book() {
                super();
        }




        public Integer getBookId() {
                return bookId;
        }

        public void setBookId(Integer bookId) {
                this.bookId = bookId;
        }

        public String getBookName() {
                return bookName;
        }

        public void setBookName(String bookName) {
                this.bookName = bookName;
        }

        public Float getPrice() {
                return price;
        }

        public void setPrice(Float price) {
                this.price = price;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getBookNote() {
                return bookNote;
        }

        public void setBookNote(String bookNote) {
                this.bookNote = bookNote;
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
                return "Book{" +
                        "bookId=" + bookId +
                        ", bookName='" + bookName + '\'' +
                        ", price=" + price +
                        ", title='" + title + '\'' +
                        ", bookNote='" + bookNote + '\'' +
                        ", typeId=" + typeId +
                        ", typeName='" + typeName + '\'' +
                        ", note='" + note + '\'' +
                        '}';
        }

        public Book(Integer bookId, String bookName, Float price, String title, String bookNote, Integer typeId, String typeName, String note) {
                this.bookId = bookId;
                this.bookName = bookName;
                this.price = price;
                this.title = title;
                this.bookNote = bookNote;
                this.typeId = typeId;
                this.typeName = typeName;
                this.note = note;
        }

        public Book(String bookName, Float price, String title, String bookNote, Integer typeId, String typeName) {
                this.bookName = bookName;
                this.price = price;
                this.title = title;
                this.bookNote = bookNote;
                this.typeId = typeId;
                this.typeName = typeName;
        }

        public Book(String bookName, Float price, String title, String bookNote, Integer typeId) {
                this.bookName = bookName;
                this.price = price;
                this.title = title;
                this.bookNote = bookNote;
                this.typeId = typeId;
        }

        public Book(Integer bookId, String bookName, Float price, String title, String bookNote, Integer typeId) {
                this.bookId = bookId;
                this.bookName = bookName;
                this.price = price;
                this.title = title;
                this.bookNote = bookNote;
                this.typeId = typeId;
        }


}
