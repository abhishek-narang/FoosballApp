package com.foosball.dao;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.foosball.model.TeamMatch;

/*
 * Creating an in-memory database instead of a traditional relational DB
 * */
public class FoosballDAOImpl implements FoosballDAO {
	
	private static FoosballDAO foosballDAO;
	private static Set<String> participants = new LinkedHashSet<String>();
	private static List<TeamMatch> teamMatches = new ArrayList<TeamMatch>();

	private FoosballDAOImpl() {
		
	}
	
	public static FoosballDAO getInstance() {
		if(foosballDAO == null) {
			foosballDAO = new FoosballDAOImpl();
		}
		return foosballDAO;
	}
	
	public void addParticipant(String participant) {
		participants.add(participant);
	}

	public Set<String> getAllParticipants() {
		return participants;
	}


	public void addTeamMatch(TeamMatch teamMatch) {
		teamMatches.add(teamMatch);
	}

	public List<TeamMatch> getAllMatches() {
		return teamMatches;
	}
	
}
