package org.la.dodgers.baseball.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "event")
public class BaseBallEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "sponsorer")
    private String sponsorer; 
  

    @OneToMany(mappedBy = "bbEvent", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Game> games;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
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


	public String getSponsorer() {
		return sponsorer;
	}


	public void setSponsorer(String sponsorer) {
		this.sponsorer = sponsorer;
	}


	public Set<Game> getGames() {
		return games;
	}


	public void setGames(Set<Game> games) {
		this.games = games;
	}

 

	 
    
    
}
