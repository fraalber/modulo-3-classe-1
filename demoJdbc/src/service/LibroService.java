package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Capitoli;
import model.Libro;

public class LibroService {
	
	private Connection connection = null;
	
	public void insertLibro(Libro libro) throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/libreria", "root", "root");
			
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO PUBLISHER (ID, NOME) VALUES (?, ?)");
			stmt.setString(1, libro.getPublisher().getId());
			stmt.setString(2, libro.getPublisher().getNome());
			stmt.executeUpdate();
			
			stmt.close();
			
			stmt = connection.prepareStatement("INSERT INTO LIBRO (ISBN, TITOLO, publisherId) VALUES (?, ?, ?)");
			stmt.setString(1, libro.getIsbn());
			stmt.setString(2, libro.getTitolo());
			stmt.setString(3, libro.getPublisher().getId());
			stmt.executeUpdate();
			
			stmt.close();
			
			stmt = connection.prepareStatement("INSERT INTO CAPITOLI (ID, TITOLO, libroIsbn) VALUES (?, ?, ?)");
			for (Capitoli capitolo : libro.getCapitoli()) {		
					stmt.setString(1, capitolo.getId());
					stmt.setString(2, capitolo.getTitolo());
					stmt.setString(3, libro.getIsbn());
					stmt.executeUpdate();
			}
			
			stmt.close();

			
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	}
}