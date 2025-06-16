package com.example.Biblioteca_Version_2.entidades;

import jakarta.persistence.*;


@Entity
@Table(name = "libros")
public class Libros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    //@JoinColumn(name = "id_autor")
    private String autor;

    private Integer numeroPaginas;
    private Boolean disponible;

    //@JoinTable(
    //        name= "id_categoria"
    //)
    private String categoria;

    //@ManytoMany
    //@JoinTable(
    //        name = "libro_prestamo",
    //        joinColumns =
    //        @JoinColumn(name = "libro_id"),
    //       inverseJoinColumns =
    //       @JoinColumn(name = "prestamo_id"))

    private String prestamos;

    public Libros() {
    }

    public Libros(String titulo, String autor, Integer numeroPaginas, Boolean disponible, String categoria, String prestamos) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.disponible = disponible;
        this.categoria = categoria;
        this.prestamos = prestamos;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(String prestamos) {
        this.prestamos = prestamos;
    }
}

