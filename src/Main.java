import java.util.ArrayList;
import java.util.List;

import model.Capitoli;
import model.Libro;
import model.Publisher;
import service.LibroService;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		LibroService libroService = new LibroService();
		Publisher publisher = new Publisher();
		publisher.setId("1");
		publisher.setNome("Mondadori");
		
		Libro libro = new Libro();
		libro.setIsbn("123456");
		libro.setTitolo("Esempio");
		libro.setPublisher(publisher);
		
		List<Capitoli> capitoli = new ArrayList<>();
		Capitoli capitolo1 = new Capitoli();
		capitolo1.setId("1");
		capitolo1.setTitolo("Esempio titolo");
		capitoli.add(capitolo1);
		Capitoli capitolo2 = new Capitoli();
		capitolo2.setId("2");
		capitolo2.setTitolo("Esempio titolo 2");
		capitoli.add(capitolo2);
		
		libro.setCapitoli(capitoli);
		
		libroService.insertLibro(libro);
				
	}

}
