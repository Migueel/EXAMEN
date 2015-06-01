package com.zubiri.examen2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CheckBox extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckBox frame = new CheckBox();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CheckBox() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeportesAElegir = new JLabel("Deportes a elegir: ");
		lblDeportesAElegir.setBounds(71, 51, 139, 15);
		contentPane.add(lblDeportesAElegir);
		
		JCheckBox chckbxFutbol = new JCheckBox("Futbol");

		chckbxFutbol.setBounds(251, 20, 129, 23);
		contentPane.add(chckbxFutbol);
		
		JCheckBox chckbxBaloncesto = new JCheckBox("Baloncesto");
	
		chckbxBaloncesto.setBounds(251, 47, 129, 23);
		contentPane.add(chckbxBaloncesto);
		
		JCheckBox chckbxTenis = new JCheckBox("Tenis");

		chckbxTenis.setBounds(251, 74, 129, 23);
		contentPane.add(chckbxTenis);
		
		JButton btnOk = new JButton("OK");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.out.println("Has seleccionado: ");
				
				if(chckbxFutbol.isSelected()){
					System.out.println("Futbol");
				}
				if(chckbxBaloncesto.isSelected()){
					System.out.println("Baloncesto");
				}
				if(chckbxTenis.isSelected()){
					System.out.println("Tenis");
				}
			}
		});
		btnOk.setBounds(82, 149, 117, 25);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Elección cancelada.");
				chckbxBaloncesto.setSelected(false);
				chckbxFutbol.setSelected(false);
				chckbxTenis.setSelected(false);
			}
		});
		btnCancel.setBounds(224, 149, 117, 25);
		contentPane.add(btnCancel);
		
	}
}
