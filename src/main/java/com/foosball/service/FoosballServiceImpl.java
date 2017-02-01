package com.foosball.service;

import java.util.List;
import java.util.Set;

import com.foosball.dao.FoosballDAO;
import com.foosball.dao.FoosballDAOImpl;
import com.foosball.model.TeamMatch;

public class FoosballServiceImpl implements FoosballService {

	FoosballDAO foosballDAO = FoosballDAOImpl.getInstance();

	/**
	 * Add partipant to in-memory database  
	 *
	 * @param  participant The participant name in String format
	 */
	public void addParticipant(String participant) {
		foosballDAO.addParticipant(participant);
	}

	/**
	 * Get all partipants from in-memory database  
	 *
	 * @return List<String>  The participant names as a List
	 */
	public Set<String> getAllParticipants() {
		
		return foosballDAO.getAllParticipants();
	}

	/**
	 * Add a match held to in-memory database  
	 *
	 * @param  teamMatch The TeamMatch object
	 */
	public void addTeamMatch(TeamMatch teamMatch) {
		foosballDAO.addTeamMatch(teamMatch);
		
	}

	/**
	 * Get all matches held from in-memory database  
	 *
	 * @return List<TeamMatch>  The matches held as a List
	 */
	public List<TeamMatch> getAllMatches() {
		return foosballDAO.getAllMatches();
	}
}
