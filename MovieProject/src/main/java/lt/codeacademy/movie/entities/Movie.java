package lt.codeacademy.movie.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "movies")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String title;

	@Length(min = 1, max = 1000000)
	private String description;

	@ManyToMany(mappedBy = "movies")
    private Set<Theater> theaters;;

	
	
	
	private String length;
	private String balas;
	private String kalba;
	private String rezisierius;

	public Movie() {
	}

	public Movie(long id, String title, @Length(min = 1, max = 1000000) String description, Set<Theater> theaters,
			String length, String balas, String kalba, String rezisierius) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.theaters = theaters;
		this.length = length;
		this.balas = balas;
		this.kalba = kalba;
		this.rezisierius = rezisierius;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Theater> getTheaters() {
		return theaters;
	}

	public void setTheaters(Set<Theater> theaters) {
		this.theaters = theaters;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getBalas() {
		return balas;
	}

	public void setBalas(String balas) {
		this.balas = balas;
	}

	public String getKalba() {
		return kalba;
	}

	public void setKalba(String kalba) {
		this.kalba = kalba;
	}

	public String getRezisierius() {
		return rezisierius;
	}

	public void setRezisierius(String rezisierius) {
		this.rezisierius = rezisierius;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", description=" + description + ", theaters=" + theaters
				+ ", length=" + length + ", balas=" + balas + ", kalba=" + kalba + ", rezisierius=" + rezisierius + "]";
	}

	

	

	

	

	
	
	

	

}
