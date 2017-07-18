package listy;

import java.awt.EventQueue;


import javax.swing.JFrame;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;


public class Listy {

	String name = "", last = "";
	String combo;
	
	Integer wordCount = 0;
	int listind, list1ind;
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Listy window = new Listy();
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
	public Listy() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 965, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(302, 60, 201, 174);
		frame.getContentPane().add(scrollPane_1);
		
		JList <String> list_1 = new JList(new AbstractListModel() {
			String[] values = new String[] {"Stark", "Baratheon", "Lannister", "Greyjoy", "Targaryen", "Tyrell"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		scrollPane_1.setViewportView(list_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 203, 176);
		frame.getContentPane().add(scrollPane);
		JList<String> list = new JList<>(new AbstractListModel() {
			String[] values = new String[] {"Tyrion", "Daenerys", "Jaime", "Jon", "Robb", "Bran", "Rickon", "Arya", "Tywin"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		 /*  list.setSelectionModel(new DefaultListSelectionModel(){


			   boolean gestureStarted = false;

			    @Override
			    public void setSelectionInterval(int index0, int index1) {
			        if(!gestureStarted){
			            if (isSelectedIndex(index0)) {
			                super.removeSelectionInterval(index0, index1);
			            } else {
			                super.addSelectionInterval(index0, index1);
			            }
			        }
			        gestureStarted = true;
			    }

			    @Override
			    public void setValueIsAdjusting(boolean isAdjusting) {
			        if (isAdjusting == false) {
			            gestureStarted = false;
			        }
			    }

			});*/
		
		scrollPane.setViewportView(list);
		
		JLabel lblNewLabel = new JLabel("Wybierz imie i nazwisko z listy");
		lblNewLabel.setBounds(585, 64, 302, 101);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Letters");
		lblNewLabel_1.setBounds(585, 188, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(""+wordCount);
		lblNewLabel_2.setBounds(641, 188, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("New button");
	
		btnNewButton.setBounds(24, 285, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				
				if (!list.isSelectionEmpty()) {
				name = list.getSelectedValue();
				combo = name +" "+ last;
				wordCount = name.length()+last.length();
				lblNewLabel_2.setText(wordCount.toString());
				lblNewLabel.setText(combo);
				listind = list.getSelectedIndex();
				}
			}
		});
		
		list_1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				last = list_1.getSelectedValue();
				combo = name +" "+ last;
				wordCount = name.length()+last.length();
				lblNewLabel_2.setText(wordCount.toString());
				lblNewLabel.setText(combo);
				list1ind = list_1.getSelectedIndex();
			}
		});
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				list.clearSelection();
				name = "";
				combo = name + last;
				lblNewLabel.setText(combo);
				wordCount = name.length()+last.length();
				lblNewLabel_2.setText(wordCount.toString());
			}
		});
		
	}
}
