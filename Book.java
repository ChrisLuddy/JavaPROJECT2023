import java.io.Serializable;

import java.io.*;
/**
 
Write a description of class Book here.*
@author (your name)
@version (a version number or a date)
*/
public class Book
{
    private  String title;
    private  String genre;
    private  String writer;

    public Book(String title, String genre, String writer)
    {
        this.title = title;
        this.genre = genre;
        this.writer = writer;
    }

    public String getTitle() {
        return title; // return title 
    }

    public void setTitle(String title) {
        this.title = title; // set title 
    }

    public String getGenre() {
        return genre; // return genre
    }

    public void setGenre(String genre) {
        this.genre = genre; // set genre
    }

    public String getWriter() {
        return writer; // return writer
    }

    public void setWriter(String writer) {
        this.writer = writer; // set writer
    }

    public String toString() // toString
    {
        return " Title: " + title + ",\n Genre: " + genre + ",\n Writer: " + writer;
    }

    public void print() // print
    {
        System.out.println(toString());
    }
}
