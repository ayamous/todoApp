package com.sh.responses;

import com.sh.util.TodoStatus;

public class TodoInfo {

    private Long id;
    private String title;
    private TodoStatus status;

    public TodoInfo() {super(); }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TodoStatus getStatus() {
        return status;
    }

    public void setStatus(TodoStatus status) {
        this.status = status;
    }
}
