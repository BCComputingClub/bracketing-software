package edu.bridgewater.bc3.bracket;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
@Deprecated
public class ApplicationGUI {

	private JFrame frame;
	private JTextField txtEventName;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationGUI window = new ApplicationGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("BC3 Bracketing Software");
		frame.setBounds(100, 100, 275, 70);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel pnlMainPage = new JPanel();
		frame.getContentPane().add(pnlMainPage, "pnlMainPage");

		JPanel pnlEventName = new JPanel();
		pnlMainPage.add(pnlEventName);
		pnlEventName.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblEventName = new JLabel("Event Name");
		pnlEventName.add(lblEventName);

		txtEventName = new JTextField();
		pnlEventName.add(txtEventName);
		txtEventName.setText("My Event");
		txtEventName.setColumns(10);

		JPanel pnlButtons = new JPanel();
		pnlMainPage.add(pnlButtons);
		pnlButtons.setLayout(new GridLayout(1, 2, 0, 0));

		JButton btnAddPlayers = new JButton("Add Players");
		btnAddPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
				cl.show(frame.getContentPane(), "pnlAddPlayers");
				// 465x490
				frame.pack();
			}
		});
		pnlButtons.add(btnAddPlayers);

		JButton btnCreateEvent = new JButton("Create Event");
		pnlButtons.add(btnCreateEvent);

		JPanel pnlAddPlayers = new JPanel();
		frame.getContentPane().add(pnlAddPlayers, "pnlAddPlayers");

		table = new JTable();
		table.setModel(
				new DefaultTableModel(
						new Object[][] { { "1", "Bill" }, { "2", "Bob" }, { "3", "Jim" }, { "4", "Sally" },
								{ "5", "John" }, { "6", "Billy" }, { "7", "Jane" }, { "8", null }, },
						new String[] { "ID", "Name" }));
		JScrollPane scrollPane = new JScrollPane(table);
		pnlAddPlayers.add(scrollPane);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
				cl.show(frame.getContentPane(), "pnlMainPage");
			}
		});
		pnlAddPlayers.add(btnConfirm);
	}
}
