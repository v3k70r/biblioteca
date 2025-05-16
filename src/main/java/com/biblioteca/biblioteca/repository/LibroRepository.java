package com.biblioteca.biblioteca.repository;

import com.biblioteca.biblioteca.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibroRepository {

    // Arreglo que guardara todos los libros
    private List<Libro> listaLibros = new ArrayList<>();


    public LibroRepository() {
        // Agregar libros por defecto
        listaLibros.add(new Libro(1, "9780307474278", "Cien anios de soledad", "Editorial Sudamericana", 1967, "Gabriel Garcia Marquez"));
        listaLibros.add(new Libro(2, "9780061122415", "El gran Gatsby", "Scribner", 1925, "F. Scott Fitzgerald"));
        listaLibros.add(new Libro(3, "9780451524935", "1984", "Secker & Warburg", 1949, "George Orwell"));
        listaLibros.add(new Libro(4, "9780061120084", "Matar a un ruisenior", "J.B. Lippincott & Co.", 1960, "Harper Lee"));
        listaLibros.add(new Libro(5, "9780140283334", "Orgullo y prejuicio", "T. Egerton", 1813, "Jane Austen"));
        listaLibros.add(new Libro(6, "9780060935467", "El alquimista", "HarperOne", 1988, "Paulo Coelho"));
        listaLibros.add(new Libro(7, "9781400078776", "El código Da Vinci", "Doubleday", 2003, "Dan Brown"));
        listaLibros.add(new Libro(8, "9780345816023", "Los hombres que no amaban a las mujeres", "Norstedts Forlag", 2005, "Stieg Larsson"));
        listaLibros.add(new Libro(9, "9781400032716", "En busca del tiempo perdido", "Grasset", 1913, "Marcel Proust"));
        listaLibros.add(new Libro(10, "9780062457738", "El poder del ahora", "New World Library", 1997, "Eckhart Tolle"));
    }

    // Metodo que retorna todoa los libros
    public List<Libro> obtenerLibros() {
        return listaLibros;
    }

    // Buscar un libro por su id
    public Libro buscarPorId(int id) {
        for (Libro libro : listaLibros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    // Buscar un libro por su isbn
    public Libro buscarPorIsbn(String isbn) {
        for (Libro libro : listaLibros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    public Libro guardar(Libro lib) {
//        Libro libro = new Libro();
//        libro.setId(lib.getId());
//        libro.setIsbn(lib.getIsbn());
//        libro.setTitulo(lib.getTitulo());
//        libro.setAutor(lib.getAutor());
//        libro.setFechaPublicacion(lib.getFechaPublicacion());
//        libro.setEditorial(lib.getEditorial());

        listaLibros.add(lib);
        return lib;
    }

    public Libro actualizar(Libro lib) {
        int id  = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getId() == lib.getId()) {
                id = lib.getId();
                idPosicion = i;
            }
        }

        Libro libro1 = new Libro();
        libro1.setId(id);
        libro1.setTitulo(lib.getTitulo());
        libro1.setAutor(lib.getAutor());
        libro1.setFechaPublicacion(lib.getFechaPublicacion());
        libro1.setEditorial(lib.getEditorial());
        libro1.setIsbn(lib.getIsbn());

        listaLibros.set(idPosicion, libro1);
        return libro1;
    }

    public void eliminar(int id) {
        // alternativa 1
//        Libro libro = buscarPorId(id);
//        if (libro != null) {
//            listaLibros.remove(libro);
//        }
//
//        // alternativa 2
//        int idPosicion = 0;
//        for (int i = 0; i < listaLibros.size(); i++) {
//            if (listaLibros.get(i).getId() == id) {
//                idPosicion = i;
//                break;
//            }
//        }
//        if (idPosicion > 0) {
//            listaLibros.remove(idPosicion);
//        }

        // otra alternativa
        listaLibros.removeIf(x -> x.getId() == id);
    }


    public int totalLibros() {
        return listaLibros.size();
    }
}

