package peliculas;

import java.util.Comparator;

public class DuracionComparator implements Comparator<Pelicula>{

	@Override
	public int compare(Pelicula o1, Pelicula o2) {
		// TODO Auto-generated method stub
		return (int)(o2.getDuracion()-o1.getDuracion());
	}

}
