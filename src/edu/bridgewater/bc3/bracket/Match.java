package edu.bridgewater.bc3.bracket;

import java.util.ArrayList;

/**
 * This class represents a single match in an event
 * 
 * @author Charles German
 *
 */
public class Match {

	/*
	 * fields
	 */

	private int id;
	private Player[] players;
	private static ArrayList<Integer> usedIDs;

	/*
	 * constructors
	 */

	/**
	 * constructor; sets match players to fit arguments, and assigns an unused
	 * ID
	 * 
	 * @param players
	 *            the players in this match
	 */
	public Match(Player... players) {
		setPlayers(players);
		setMatchId(generateID());
	}

	/*
	 * methods
	 */

	/**
	 * initialize {@code usedIDs} if necessary, and generate an unused id
	 * (sequential integer)
	 * 
	 * @return
	 */
	private int generateID() {
		// initialize if necessary
		if (usedIDs == null)
			usedIDs = new ArrayList<>();
		// get unused id
		int id = 0;
		while (usedIDs.contains(id))
			id++;
		return id;
	}

	/**
	 * score this match
	 */
	public void score() {
		// TODO implement
	}

	/*
	 * getters & setters
	 */

	/**
	 * @return the id
	 */
	public int getMatchId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setMatchId(int id) {
		this.id = id;
	}

	/**
	 * @return the players
	 */
	public Player[] getPlayers() {
		return players;
	}

	/**
	 * @param players
	 *            the players to set
	 */
	public void setPlayers(Player[] players) {
		this.players = players;
	}
}
