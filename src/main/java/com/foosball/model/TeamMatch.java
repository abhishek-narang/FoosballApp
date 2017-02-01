package com.foosball.model;

import java.util.Date;

/**
 * The model class for matches held between participants 
 * (referred to as team1 and team 2 here).
 */
public class TeamMatch {

	private String team1;

	private String team2;

	private String winningTeam;

	private Date matchDate;

	public TeamMatch(String team1, String team2) {
		this.team1 = team1;
		this.team2 = team2;
		this.matchDate = new Date();
	}

	public String getTeam1() {
		return team1;
	}

	public String getTeam2() {
		return team2;
	}

	public String getWinningTeam() {
		return winningTeam;
	}

	public void setWinningTeam(String winningTeam) {
		this.winningTeam = winningTeam;
	}

	public Date getMatchDate() {
		return matchDate;
	}

	/**
	 * Checks whether a team is a part of a particular match  
	 * @param  team  The participant of the match
	 * @return boolean 
	 */
	public boolean isParticipant(String team) {
		return team.equals(team1) || team.equals(team2);
	}
}
