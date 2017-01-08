/*
BC3 Bracketing Software 
Copyright (C) 2017  Bridgewater College Computing Club (BC3)

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>
*/

package edu.bridgewater.bc3.bracket.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import edu.bridgewater.bc3.bracket.Match;
import edu.bridgewater.bc3.bracket.Player;

/**
 * Because I'm lazy, I'm developing a CLI version of this application first,
 * then we can do the whole fancy GUI thing
 * 
 * @author Charles German
 *
 */
public class Application {

	/*
	 * fields
	 */

	private static Player[] players;
	private static Match[] matches;
	private static BufferedReader in;
	private static Stack<String> menuTrail;

	/*
	 * methods
	 */

	/**
	 * follow the breadcrumb trail of menus to return to the previous menu using
	 * menu identifiers
	 * <ul>
	 * <li>MAIN MENU -- mainmenu
	 * <li>PROGRAM SETTINGS MENU -- prsemenu
	 * </ul>
	 * 
	 * @throws IOException
	 */
	private static void followCrumb() throws IOException {
		String prev = menuTrail.pop();
		switch (prev) {
		case "mainmenu":
			processMainMenu();
			break;
		case "prsemenu":
			processProgramSettingsMenu();
			break;
		default:
			// TODO implement something more robust than this
			System.out.println("\n\n\nTHERE WAS A PROBLEM RETURNING TO THE PREVOIUS MENU\n\n\n");
			break;
		}
	}

	/**
	 * add a breadcrumb to the menu trail using menu identifiers
	 * 
	 * @param menuIdentifier
	 *            a valid menu identifier
	 *            <ul>
	 *            <li>MAIN MENU -- mainmenu
	 *            <li>PROGRAM SETTINGS MENU -- prsemenu
	 *            </ul>
	 */
	private static void addCrumb(String menuIdentifier) {
		menuTrail.push(menuIdentifier);
	}

	/**
	 * show and process the main menu
	 * 
	 * @throws IOException
	 */
	private static void processMainMenu() throws IOException {
		System.out.println("MAIN MENU");
		System.out.println("[c]hange program settings");
		System.out.println("create [e]vent");
		System.out.println("view [i]nfo");
		System.out.println("[q]uit");
		System.out.print("\n> "); // prompt
		int input = in.readLine().toLowerCase().charAt(0);
		switch (input) {
		case 'c':
			addCrumb("mainmenu");
			processProgramSettingsMenu();
			break;
		case 'e':
			// TODO create event
			break;
		case 'i':
			System.out
					.println("BC3 Bracketing Software \nCopyright (C) 2017  Bridgewater College Computing Club (BC3)\n"
							+ "\nThis program is free software: you can redistribute it and/or modify\n"
							+ "it under the terms of the GNU General Public License as published by\n"
							+ "the Free Software Foundation, either version 3 of the License, or\n"
							+ "(at your option) any later version.\n\n"
							+ "This program is distributed in the hope that it will be useful,\n"
							+ "but WITHOUT ANY WARRANTY; without even the implied warranty of\n"
							+ "MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the\n"
							+ "GNU General Public License for more details.\n\n"
							+ "You should have received a copy of the GNU General Public License\n"
							+ "along with this program (see LICENSE).  If not, see <http://www.gnu.org/licenses/>\n");
			processMainMenu();
			break;
		case 'q':
			System.exit(0);
			break;
		default:
			System.out.println("INVALID INPUT");
			processMainMenu();
			break;
		}
	}

	/**
	 * show and process the program settings menu
	 * 
	 * @throws IOException
	 */
	private static void processProgramSettingsMenu() throws IOException {
		System.out.println("PROGRAM SETTINGS MENU");
		System.out.println("[r]eturn");
		System.out.print("\n> "); // prompt
		int input = in.readLine().toLowerCase().charAt(0);
		switch (input) {
		case 'r':
			followCrumb();
			break;
		default:
			System.out.println("INVALID INPUT");
			processProgramSettingsMenu();
			break;
		}
	}

	/**
	 * show and process the create event menu
	 * 
	 * @throws IOException
	 */
	private static void processCreateEventMenu() throws IOException {
		System.out.println("CREATE EVENT MENU");
		System.out.println("set event [n]ame");
		System.out.println("view event [i]nfo");
		System.out.println("[a]dd/remove players");
		System.out.println("[p]review bracket");
		System.out.println("[s]tart event");
		System.out.println("[r]eturn");
		System.out.println("\n> ");// prompt
		int input = in.readLine().toLowerCase().charAt(0);
		switch (input) {
		case 'n':
			// TODO set event name
			break;
		case 'i':
			// TODO view event info
			break;
		case 'a':
			// TODO add/remove players
			break;
		case 'p':
			// TODO preview bracket
			break;
		case 's':
			// TODO start event
			break;
		case 'r':
			followCrumb();
			break;
		default:
			System.out.println("INVALID INPUT");
			processCreateEventMenu();
			break;
		}
	}

	/*
	 * main method
	 */

	/**
	 * entry point for the program
	 * 
	 * @param args
	 *            unused
	 * @throws Exception
	 *             because I'm lazy
	 */
	public static void main(String[] args) throws Exception {
		// set up fields
		in = new BufferedReader(new InputStreamReader(System.in));
		menuTrail = new Stack<>();

		// show welcome
		System.out.println(
				"BC3 Bracketing Software \n" + "Copyright (C) 2017  Bridgewater College Computing Club (BC3)\n");

		// here's where stuff starts to happen
		processMainMenu();
	}
}
