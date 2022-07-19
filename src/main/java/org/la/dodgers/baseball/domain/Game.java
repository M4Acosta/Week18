package org.la.dodgers.baseball.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "game_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bbevent_id")
     
    private BaseBallEvent bbEvent;

    @ManyToOne
    @JoinColumn(name = "auditorium_id")
    
    private Auditorium auditorium;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "is_full")
    private Boolean isFull;

    @Column(name = "price")
    private Double price;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<SeatBooked> bookedSeats;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Booking> bookings;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BaseBallEvent getMovie() {
		return bbEvent;
	}

	public void setMovie(BaseBallEvent bbEvent) {
		this.bbEvent = bbEvent;
	}

	public Auditorium getAuditorium() {
		return auditorium;
	}

	public void setAuditorium(Auditorium auditorium) {
		this.auditorium = auditorium;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public Boolean getIsFull() {
		return isFull;
	}

	public void setIsFull(Boolean isFull) {
		this.isFull = isFull;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Set<SeatBooked> getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(Set<SeatBooked> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}
    
    
    
}
