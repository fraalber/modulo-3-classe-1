package model;

import java.util.List;

public class Libro {
	private String isbn;
	private String titolo;
	private Publisher publisher;
	private List<Capitoli> capitoli;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public List<Capitoli> getCapitoli() {
		return capitoli;
	}
	public void setCapitoli(List<Capitoli> capitoli) {
		this.capitoli = capitoli;
	}
	
	
	
}
