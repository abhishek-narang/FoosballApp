package com.foosball.model;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * This class helps in finding out the win/loss percentage
 *  of a participant in comparision to another participant.
 */
public class MatchReport {

	private Map<String, Integer> participantWonMap = new HashMap<String, Integer>();
	
	public MatchReport(String participant1, String participant2) {
		participantWonMap.put(participant1, new Integer(0));
		participantWonMap.put(participant2, new Integer(0));
	}
	
	/**
	 * Increments the number of matches won by a participant
	 */
	public void incrementParticipantWonCount(String participant) {
		Integer currentCount = participantWonMap.get(participant);
		participantWonMap.put(participant, ++currentCount);
	}
	
	/**
	 * Returns the win/loss percentage of a participant against another participant
	 * @return Integer 
	 */
	public Integer getWinPercentageFor(String participant1, String participant2) {
		Double winRatio = (double)participantWonMap.get(participant1)/(participantWonMap.get(participant1)+participantWonMap.get(participant2));
		DecimalFormat df = new DecimalFormat("#.00");
		return ((Double)(Double.valueOf(df.format(winRatio)) * 100)).intValue();
	}

}
