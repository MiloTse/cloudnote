package com.example.cloudnote.entity;

import java.io.Serializable;
import java.util.Objects;


public class Note implements Serializable {

    private static final long serialVersionUID = -2059814026249707482L;

    private String id;
    private String bookId;
    private String userId;
    private String statusId;
    private String typeId;
    private String title;
    private String body;
    private long createTime;
    private long lastModifyTime;


    public Note() {
        super();
    }
    public Note(String id, String bookId, String userId, String statusId, String typeId, String title, String body,
                long createTime, long lastModifyTime) {
        super();
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.statusId = statusId;
        this.typeId = typeId;
        this.title = title;
        this.body = body;
        this.createTime = createTime;
        this.lastModifyTime = lastModifyTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(long lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return createTime == note.createTime && lastModifyTime == note.lastModifyTime && Objects.equals(id, note.id) && Objects.equals(bookId, note.bookId) && Objects.equals(userId, note.userId) && Objects.equals(statusId, note.statusId) && Objects.equals(typeId, note.typeId) && Objects.equals(title, note.title) && Objects.equals(body, note.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookId, userId, statusId, typeId, title, body, createTime, lastModifyTime);
    }


    @Override
    public String toString() {
        return "Note{" +
                "id='" + id + '\'' +
                ", bookId='" + bookId + '\'' +
                ", userId='" + userId + '\'' +
                ", statusId='" + statusId + '\'' +
                ", typeId='" + typeId + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", createTime=" + createTime +
                ", lastModifyTime=" + lastModifyTime +
                '}';
    }
}
