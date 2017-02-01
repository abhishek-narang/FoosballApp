package com.foosball.dao;

import java.util.List;
import java.util.Set;

import com.foosball.model.TeamMatch;

public interface FoosballDAO {

	public void addParticipant(String participant); 

	public Set<String> getAllParticipants(); 

	public void addTeamMatch(TeamMatch teamMatch);  

	public List<TeamMatch> getAllMatches();

}
