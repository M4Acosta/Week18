package org.la.dodgers.baseball.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "court")
public class Court {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "court_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "court", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Auditorium> auditoriums;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Auditorium> getAuditoriums() {
		return auditoriums;
	}

	public void setAuditoriums(Set<Auditorium> auditoriums) {
		this.auditoriums = auditoriums;
	}
    
    
    
}
