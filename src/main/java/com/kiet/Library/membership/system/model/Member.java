package com.kiet.Library.membership.system.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 100)
    private String name;

    @Column(name = "join_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate joinDate;

    @Column(name = "issued_books")
    private int issuedBooks;

    private boolean active;

    public Member() {
    }

    public Member(String name, LocalDate joinDate, int issuedBooks, boolean active) {
        this.name = name;
        this.joinDate = joinDate;
        this.issuedBooks = issuedBooks;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public int getIssuedBooks() {
        return issuedBooks;
    }

    public void setIssuedBooks(int issuedBooks) {
        this.issuedBooks = issuedBooks;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
