package org.la.dodgers.baseball.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "seat_booked")
public class SeatBooked {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seat_booked_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    @JsonIgnore
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    @JsonIgnore
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "game_id")
    @JsonIgnore
    private Game game;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
    
    
    
}
