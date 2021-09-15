/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pratique1.a18;

/**
 *
 * @author Utilisateur
 */
public class Book {

    String id;
    String title;
    String author;
    Boolean available;
    double price;
    int year;

    public Book(String id, String title, String author, Boolean available, double price, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = available;
        this.price = price;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", author=" + author + ", available=" + available + ", price=" + price + ", year=" + year + '}';
    }

}
