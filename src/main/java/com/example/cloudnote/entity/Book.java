package com.example.cloudnote.entity;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class Book implements Serializable {

    private static final long serialVersionUID = 5134829870505507317L;
    private String notebookId;
    private String userId;
    private String notebookTypeId;
    private String notebookName;
    private String notebookDesc;
    private Timestamp notebookCreateTime;


    public String getNotebookId() {
        return notebookId;
    }

    public void setNotebookId(String notebookId) {
        this.notebookId = notebookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNotebookTypeId() {
        return notebookTypeId;
    }

    public void setNotebookTypeId(String notebookTypeId) {
        this.notebookTypeId = notebookTypeId;
    }

    public String getNotebookName() {
        return notebookName;
    }

    public void setNotebookName(String notebookName) {
        this.notebookName = notebookName;
    }

    public String getNotebookDesc() {
        return notebookDesc;
    }

    public void setNotebookDesc(String notebookDesc) {
        this.notebookDesc = notebookDesc;
    }

    public Timestamp getNotebookCreateTime() {
        return notebookCreateTime;
    }

    public void setNotebookCreateTime(Timestamp notebookCreateTime) {
        this.notebookCreateTime = notebookCreateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(notebookId, book.notebookId) && Objects.equals(userId, book.userId) && Objects.equals(notebookTypeId, book.notebookTypeId) && Objects.equals(notebookName, book.notebookName) && Objects.equals(notebookDesc, book.notebookDesc) && Objects.equals(notebookCreateTime, book.notebookCreateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notebookId, userId, notebookTypeId, notebookName, notebookDesc, notebookCreateTime);
    }

    @Override
    public String toString() {
        return "Book{" +
                "notebookId='" + notebookId + '\'' +
                ", userId='" + userId + '\'' +
                ", notebookTypeId='" + notebookTypeId + '\'' +
                ", notebookName='" + notebookName + '\'' +
                ", notebookDesc='" + notebookDesc + '\'' +
                ", notebookCreateTime=" + notebookCreateTime +
                '}';
    }
}


