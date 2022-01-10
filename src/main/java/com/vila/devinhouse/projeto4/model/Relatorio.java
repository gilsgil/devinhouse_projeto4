package com.vila.devinhouse.projeto4.model;

import javax.persistence.*;

@Entity
public class Relatorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private double diferenca;
    private double gastoTotal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
