package com.foosball.model;

import java.text.DecimalFormat;

/**
 * This class helps in finding out the win/loss percentage
 *  of a particular participant.
 */
public class ParticipantMatchReport {

	private String participant;
	private Integer matchPlayed = new Integer(0);
	private Integer matchWon = new Integer(0);
	
	public ParticipantMatchReport(String participant) {
		this.participant = participant;
	}
	
	public void incrementMatchWon() {
		matchWon++;		
	}
	public void incrementMatchPlayed() {
		matchPlayed++;
	}
	
	/**
	 * Returns the win/loss percentage of a participant
	 * @return Integer 
	 */
	public Integer getWinLossPercentage() {
		Double winRatio = (double)matchWon/matchPlayed;
		DecimalFormat df = new DecimalFormat("#.00");
		return ((Double)(Double.valueOf(df.format(winRatio)) * 100)).intValue();
	}

}
