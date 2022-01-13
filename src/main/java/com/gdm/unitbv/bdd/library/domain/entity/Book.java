package com.gdm.unitbv.bdd.library.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "book")

@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    private Long id;

    @Column(name = "name")
    @NonNull
    @Setter
    @Getter
    private String name;

    @Column(name = "genre")
    @NonNull
    @Setter
    @Getter
    private String genre;


    @Column(name = "author")
    @NonNull
    @Setter
    @Getter
    private String author;
}
