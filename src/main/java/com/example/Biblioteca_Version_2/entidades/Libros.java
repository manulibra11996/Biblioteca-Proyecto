package com.example.Biblioteca_Version_2.entidades;

import jakarta.persistence.*;


@Entity
@Table(name = "libros")
public class Libros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    @OneToMany
    @JoinColumn(name = "id_autor")
    private Autor autor;

    private Integer numeroPaginas;
    private Boolean disponible;

    @OneToMany
    @JoinTable(
            name= "id_categoria"
    )
    private Categorias categoria;


    public Libros() {
    }

    public Libros(String titulo, Autor autor, Integer numeroPaginas, Boolean disponible, Categorias categoria, String prestamos) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.disponible = disponible;
        this.categoria = categoria;
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

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
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

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

}

