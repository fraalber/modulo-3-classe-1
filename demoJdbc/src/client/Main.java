package client;

import java.util.ArrayList;
import java.util.List;

import service.LibroService;


import model.Libro;
import model.Chapter;
import model.Publisher;

public class Main {
	public static void main(String[] args) {
		LibroService bookStoreService = new LibroService();

		//persisting object graph
		Publisher publisher = new Publisher("MANN", "Manning Publications Co.");

		Libro book = new Libro("9781617290459", "Java Persistence with Hibernate, Second Edition", publisher);

		List<Chapter> chapters = new ArrayList<Chapter>();
		Chapter chapter1 = new Chapter("Introducing JPA and Hibernate", 1);
		chapters.add(chapter1);
		Chapter chapter2 = new Chapter("Domain Models and Metadata", 2);
		chapters.add(chapter2);

		book.setChapters(chapters);

		bookStoreService.persistObjectGraph(book);

		//Esercizio 1
		//retrieving object graph
		Libro book2 = bookStoreService.retrieveObjectGraph("9781617290459");
		System.out.println(book2);

		//Esercizio 2
		//Update libro con ISBN 9781617290459
		Libro book3 = bookStoreService.retrieveObjectGraph("9781617290459");
		book3.setName("Nuovo Titolo");
		book3.getPublisher().setName("NUOVO NUMERO");

		bookStoreService.updateObjectGraph(book3);
		System.out.println(book3);

		//Esercizio 3
		bookStoreService.deleteObjectGraph(book3);

	}
}