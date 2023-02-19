package com.sh.entities;

import com.sh.util.TodoStatus;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "TODOS")
@Entity
public class Todo implements Serializable {

    private static final long serialVersionUID = -1847970902337355680L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    private TodoStatus status;

    public Todo() {super();}

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


    @Column(name = "status")
    public TodoStatus getStatus() {
        return status;
    }

    public void setStatus(TodoStatus status) {
        this.status = status;
    }
}
