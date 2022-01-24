package com.gdm.unitbv.bdd.library.domain.entity;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.Hibernate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.*;

import com.gdm.unitbv.bdd.library.domain.util.Genre;

@Entity
@Table(name = "book")

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Book extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "genre")
    @NonNull
    private Genre genre;


    @Column(name = "author")
    @NonNull
    private String author;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Book book = (Book) o;
        return getId() != null && Objects.equals(getId(), book.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
