package peliculas;

import java.util.Comparator;

public class TituloComparator implements Comparator<Pelicula>{

	@Override
	public int compare(Pelicula p0, Pelicula p1) {
		// TODO Auto-generated method stub
		
		return (p0.getTitulo().compareToIgnoreCase(p1.getTitulo()));
	}

}
