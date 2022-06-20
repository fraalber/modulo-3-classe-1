package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Chapter;
import model.Libro;
import model.Publisher;

public class LibroService {
    private Connection connection = null;

    public void persistObjectGraph(Libro book) {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //carica la classe del driver JDBC.
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "root"); //DriverManager.getConnection() crea una connessione.
            // Una volta stabilita la connessione, occorre passare una istruzione.
            // Nel prepared statement ps, i punti di domanda denotano le variabili in input,
            // che possono essere passate attraverso una lista di parametri, per esempio.

            // Il codice seguente sostituisce i punti di domanda con stringhe o interi.
            // Il primo parametro indica la posizione in cui il valore va inserito,
            // il secondo parametro è il valore da inserire.
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO PUBLISHER (CODE, PUBLISHER_NAME) VALUES (?, ?)");
            stmt.setString(1, book.getPublisher().getCode());
            stmt.setString(2, book.getPublisher().getName());
            stmt.executeUpdate();

            stmt.close();

            stmt = connection.prepareStatement("INSERT INTO BOOK (ISBN, BOOK_NAME, PUBLISHER_CODE) VALUES (?, ?, ?)");
            stmt.setString(1, book.getIsbn());
            stmt.setString(2, book.getName());
            stmt.setString(3, book.getPublisher().getCode());
            stmt.executeUpdate();

            stmt.close();

            stmt = connection.prepareStatement("INSERT INTO CHAPTER (BOOK_ISBN, CHAPTER_NUM, TITLE) VALUES (?, ?, ?)");
            for (Chapter chapter : book.getChapters()) {
                stmt.setString(1, book.getIsbn());
                stmt.setInt(2, chapter.getChapterNumber());
                stmt.setString(3, chapter.getTitle());
                stmt.executeUpdate();
            }

            stmt.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close(); //CHIUSURA CONNESSIONE
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //ESERCIZIO 1
    public Libro retrieveObjectGraph(String isbn) {
        Libro book = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "root");

            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM BOOK, PUBLISHER WHERE BOOK.PUBLISHER_CODE = PUBLISHER.CODE AND BOOK.ISBN = ?");
            stmt.setString(1, isbn);

            ResultSet rs = stmt.executeQuery(); // Il ResultSet rs riceve la risposta del database.

            book = new Libro();
            if (rs.next()) {
                book.setIsbn(rs.getString("ISBN"));
                book.setName(rs.getString("BOOK_NAME"));

                Publisher publisher = new Publisher();
                publisher.setCode(rs.getString("CODE"));
                publisher.setName(rs.getString("PUBLISHER_NAME"));
                book.setPublisher(publisher);
            }

            rs.close();
            stmt.close();

            List<Chapter> chapters = new ArrayList<>();
            stmt = connection.prepareStatement("SELECT * FROM CHAPTER WHERE BOOK_ISBN = ?");
            stmt.setString(1, isbn);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Chapter chapter = new Chapter();
                chapter.setTitle(rs.getString("TITLE"));
                chapter.setChapterNumber(rs.getInt("CHAPTER_NUM"));
                chapters.add(chapter);
            }
            book.setChapters(chapters);

            rs.close();
            stmt.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return book;
    }

    //ESERCIZIO 2
    public Libro updateObjectGraph(Libro book) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "root");

            PreparedStatement stmt = connection.prepareStatement("UPDATE BOOK SET NAME = ? WHERE BOOK.ISBN = ?");
            stmt.setString(1, book.getName());
            stmt.setString(2, book.getIsbn());
            stmt.executeUpdate();

            stmt.close();

            stmt = connection.prepareStatement("UPDATE PUBLISHER SET PUBLISHER_NAME = ? WHERE PUBLISHER.ISBN = ?");
            stmt.setString(1, book.getPublisher().getCode());
            stmt.setString(2, book.getPublisher().getName());
            stmt.executeUpdate();

            stmt.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return book;
    }

    //ESERCIZIO 3
    public Libro deleteObjectGraph(Libro book) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "root");

            PreparedStatement stmt = connection.prepareStatement("DELETE BOOK WHERE BOOK.ISBN = ?");
            stmt.setString(1    , book.getIsbn());
            stmt.executeUpdate();

            stmt.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return book;
    }

}




