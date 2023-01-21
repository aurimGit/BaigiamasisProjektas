package lt.codeacademy.movie.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "theaters")
public class Theater {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String pavadinimas;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
	        name = "theater_movie", 
	        joinColumns = { @JoinColumn(name = "theater_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "movie_id") }
	    )
	
	private Set<Movie> movies;
	
	
	private String city;
	private String address;
	
	
	
	
	public Theater(String pavadinimas) {
		this.pavadinimas = pavadinimas;
	}
	
	public void addMovie(Movie movie) {
		movies.add(movie);
	}

	
	
	
	public Theater() {
	}

	public Theater(long id, String pavadinimas, Set<Movie> movies, String city, String address) {
		super();
		this.id = id;
		this.pavadinimas = pavadinimas;
		this.movies = movies;
		this.city = city;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPavadinimas() {
		return pavadinimas;
	}

	public void setPavadinimas(String pavadinimas) {
		this.pavadinimas = pavadinimas;
	}

	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Theater [pavadinimas=" + pavadinimas + "]";
	}

	

	

	

	
	
}
