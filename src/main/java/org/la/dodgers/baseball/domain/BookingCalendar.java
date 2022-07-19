package org.la.dodgers.baseball.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bookingcalendar")
@ApiModel(description = "Class representing the booking.")
public class BookingCalendar {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
    @ApiModelProperty(notes = "${bookingcalendar.id}", example = "1", required = true, position = 0)
    private int id;

    @ApiModelProperty(notes = "${bookingcalendar.user}", example  = "John", required = true, position = 1)
    @Column(name="user")
    private String user;

    @ApiModelProperty(notes = "${bookingcalendar.fromdate}", example = "07-25-2022", required = true, position = 2)
    @Column(name="from_date")
    private String fromdate;

    @ApiModelProperty(notes = "${bookingcalendar.todate}", example = "07-28-2022", required = true ,position = 3)
    @Column(name="to_date")
    private String todate;

    public BookingCalendar() {
    }

    public BookingCalendar(int id, String user, String fromdate, String todate) {
        this.id = id;
        this.user = user;
        this.fromdate = fromdate;
        this.todate = todate;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getFromdate() {
		return fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	public String getTodate() {
		return todate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}
    
   
}
