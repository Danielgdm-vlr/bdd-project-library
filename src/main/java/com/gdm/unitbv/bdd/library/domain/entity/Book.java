package com.gdm.unitbv.bdd.library.domain.entity;

import com.gdm.unitbv.bdd.library.domain.util.Genre;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "book")

@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Book extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "name")
    @NonNull
    @Setter
    @Getter
    private String name;

    @Column(name = "genre")
    @NonNull
    @Setter
    @Getter
    private Genre genre;


    @Column(name = "author")
    @NonNull
    @Setter
    @Getter
    private String author;
}
