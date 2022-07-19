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
@Table(name="teams")
@ApiModel(description = "Class representing teams, which user can join.")
public class Team {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
    @ApiModelProperty(notes = "${user.id}", example = "1", required = true, position = 0)
    private int id;

    @ApiModelProperty(notes = "${user.firstname}", example = "John", required = true, position = 1)
    @Column(name="team_name")
    private String teamName;

     

    public Team() {
    }

    public Team(int id, String teamName) {
        this.id = id;
        this.teamName = teamName; 
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
     
	
}
