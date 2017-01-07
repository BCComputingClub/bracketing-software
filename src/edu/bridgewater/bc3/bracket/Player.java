package edu.bridgewater.bc3.bracket;

import java.util.ArrayList;

/**
 * This class represents a player in an event
 * 
 * @author Charles German
 *
 */
public class Player {

	/*
	 * fields
	 */

	private int score, seat;
	private String name;
	private int id;
	private static ArrayList<Integer> usedIDs;

	/*
	 * constructors
	 */

	/**
	 * constructor; sets player score to 0, seat to -1, and assigns an unused ID
	 * 
	 * @param name
	 *            the player's name
	 */
	public Player(String name) {
		setName(name);
		setScore(0);
		setSeat(-1);
		setPlayerId(generateID());
	}

	/*
	 * methods
	 */

	/**
	 * initialize {@code usedIDs} if necessary, and generate an unused id
	 * (sequential integer)
	 * 
	 * @return an unused id
	 */
	private int generateID() {
		// initialize if necessary
		if (usedIDs == null)
			usedIDs = new ArrayList<>();
		int id = 0;
		while (usedIDs.contains(id))
			id++;
		return id;
	}

	/**
	 * drop this player from the event
	 */
	public void drop() {
		// TODO implement this
	}

	/*
	 * getters & setters
	 */

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public int getPlayerId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setPlayerId(int id) {
		this.id = id;
	}

	/**
	 * @return the seat
	 */
	public int getSeat() {
		return seat;
	}

	/**
	 * @param seat
	 *            the seat to set
	 */
	public void setSeat(int seat) {
		this.seat = seat;
	}
}
