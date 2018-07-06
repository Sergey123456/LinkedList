package telran.util;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Button;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import javax.swing.JButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.IOP.CodecPackage.InvalidTypeForEncodingHelper;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.TextArea;
import java.awt.Scrollbar;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.Box;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;

public class TestGUI {

	private JFrame frame;
	public LinkedList<Integer> linkedList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestGUI window = new TestGUI();
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
	public TestGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 572, 597);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TextArea textArea = new TextArea();
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		
		
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
		textArea.setRows(150);
		textArea.setMaximumSize(new Dimension(32767, 64767));
		
		Box verticalBox = Box.createVerticalBox();
		frame.getContentPane().add(verticalBox, BorderLayout.NORTH);
		
		Box verticalBox_2 = Box.createVerticalBox();
		verticalBox.add(verticalBox_2);
		verticalBox_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel lblCreateNewLinked = new JLabel("Type Integer:");
		verticalBox_2.add(lblCreateNewLinked);
		
		Box horizontalBox = Box.createHorizontalBox();
		verticalBox_2.add(horizontalBox);
		
		JLabel lblNewLabel = new JLabel("Number of elements:");
		horizontalBox.add(lblNewLabel);
		
		JSpinner spinner_1 = new JSpinner();
		horizontalBox.add(spinner_1);
		spinner_1.setModel(new SpinnerNumberModel(7, 0, 100, 1));
		
		JButton btnNewButton_1 = new JButton("Fill LL");
		horizontalBox.add(btnNewButton_1);
		
		JButton btnClearLinkedList = new JButton("Clear LL");
		horizontalBox.add(btnClearLinkedList);
		
		JButton btnNewButton = new JButton("Print LL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prntLinkedList(linkedList, textArea);
			}
		});
		horizontalBox.add(btnNewButton);
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox_2.add(horizontalBox_3);
		
		JSpinner spinner_5 = new JSpinner();
		horizontalBox_3.add(spinner_5);
		
		JButton btnContainsObject = new JButton("Contains object");
		btnContainsObject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prnt(Boolean.toString(linkedList.contains(spinner_5.getValue())), textArea);
			}
		});
		horizontalBox_3.add(btnContainsObject);
		
		JSpinner spinner_6 = new JSpinner();
		horizontalBox_3.add(spinner_6);
		
		JButton btnAddObject = new JButton("Add object");
		btnAddObject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (linkedList.add((Integer)spinner_6.getValue())) {
					prnt("ok!", textArea);
					prntLinkedList(linkedList, true, textArea);
				}
			}
		});
		horizontalBox_3.add(btnAddObject);
		
		Box verticalBox_4 = Box.createVerticalBox();
		horizontalBox_3.add(verticalBox_4);
		
		Box horizontalBox_7 = Box.createHorizontalBox();
		verticalBox_4.add(horizontalBox_7);
		
		JLabel label_1 = new JLabel("Index:");
		horizontalBox_7.add(label_1);
		
		JSpinner spinner_9 = new JSpinner();
		horizontalBox_7.add(spinner_9);
		
		Box horizontalBox_8 = Box.createHorizontalBox();
		verticalBox_4.add(horizontalBox_8);
		
		JLabel label_2 = new JLabel("Element:");
		horizontalBox_8.add(label_2);
		
		JSpinner spinner_10 = new JSpinner();
		horizontalBox_8.add(spinner_10);
		
		JButton btnNewButton_5 = new JButton("Add element by index");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				linkedList.add((int)spinner_9.getValue(), (Integer)spinner_10.getValue());
				prntLinkedList(linkedList, true, textArea);
			}
		});
		horizontalBox_3.add(btnNewButton_5);
		
		Box horizontalBox_4 = Box.createHorizontalBox();
		verticalBox_2.add(horizontalBox_4);
		
		JSpinner spinner_8 = new JSpinner();
		spinner_8.setModel(new SpinnerNumberModel(5, 0, 100, 1));
		horizontalBox_4.add(spinner_8);
		
		JButton btnNewButton_3 = new JButton("Get by index");
		horizontalBox_4.add(btnNewButton_3);
		
		Box verticalBox_3 = Box.createVerticalBox();
		horizontalBox_4.add(verticalBox_3);
		
		Box horizontalBox_5 = Box.createHorizontalBox();
		verticalBox_3.add(horizontalBox_5);
		
		JLabel lblIndex = new JLabel("Index:");
		horizontalBox_5.add(lblIndex);
		
		JSpinner spinner_7 = new JSpinner();
		spinner_7.setModel(new SpinnerNumberModel(5, 0, 100, 1));
		horizontalBox_5.add(spinner_7);
		
		Box horizontalBox_6 = Box.createHorizontalBox();
		verticalBox_3.add(horizontalBox_6);
		
		JLabel lblElement = new JLabel("Element:");
		horizontalBox_6.add(lblElement);
		
		JSpinner spinner_2 = new JSpinner();
		horizontalBox_6.add(spinner_2);
		
		JButton btnSet = new JButton("Set element by index");
		horizontalBox_4.add(btnSet);
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object object = linkedList.set((int)spinner_7.getValue(), (Integer)spinner_2.getValue());
				if (object == null) {
					prnt("error", textArea);
				} else {
					prnt("ok", textArea);
					prntLinkedList(linkedList, true, textArea);
				}
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int spinnerValue = (int)spinner_8.getValue();
				Object res = linkedList.get(spinnerValue);
				if (res == null) {
					prnt(null, textArea);
				} else {
					prnt("Value: " + res.toString(), textArea);
				}
			}
		});
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox_2.add(horizontalBox_2);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(4, 0, 100, 1));
		horizontalBox_2.add(spinner);
		
		JButton btnRemove = new JButton("Remove by index");
		horizontalBox_2.add(btnRemove);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		horizontalBox_2.add(horizontalStrut_3);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setModel(new SpinnerNumberModel(new Integer(5), null, null, new Integer(1)));
		horizontalBox_2.add(spinner_4);
		
		JButton btnNewButton_4 = new JButton("Remove by Object");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prnt(Boolean.toString(linkedList.remove((Object)spinner_4.getValue())), textArea);
				prntLinkedList(linkedList, true, textArea);
			}
		});
		horizontalBox_2.add(btnNewButton_4);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);
		
		JLabel lblTypeString = new JLabel("Type String:");
		horizontalBox_1.add(lblTypeString);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalBox_1.add(horizontalStrut_1);
		
		JLabel label = new JLabel("Number of elements:");
		horizontalBox_1.add(label);
		
		JSpinner spinner_3 = new JSpinner();
		horizontalBox_1.add(spinner_3);
		
		JButton btnFillLl = new JButton("Fill LL");
		horizontalBox_1.add(btnFillLl);
		
		JButton btnClearLl = new JButton("Clear LL");
		horizontalBox_1.add(btnClearLl);
		
		JButton btnPrintLinkedList = new JButton("Print LL");
		horizontalBox_1.add(btnPrintLinkedList);
		
		JButton btnNewButton_2 = new JButton("Clear scn");
		verticalBox.add(btnNewButton_2);
		btnNewButton_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			textArea.setText("");
			}
		});
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int spinnerValue = (int)spinner.getValue();
				Object res = linkedList.remove(spinnerValue);
				if (res == null) {
					prnt(null, textArea);
				} else {
					prnt("", textArea);
					prnt("Remove element with index " + spinnerValue +
							". Value: " + res.toString(), textArea);
					prntLinkedList(linkedList, false, textArea);
				}
			}
		});
		btnClearLinkedList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				linkedList.clear();
				prntLinkedList(linkedList, textArea);
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				linkedList = new LinkedList<>();
				if (linkedList.isEmpty()) {
					int linkedListSize = (int)spinner_1.getValue();
					for (int i = 0; i < linkedListSize; i++) {
						linkedList.add(i);
					}
					prntLinkedList(linkedList, textArea);
				}
			}
		});
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblCreateNewLinked}));
	}
	
	private <T> void prnt(String str, TextArea textArea) {
		if ("".equals(textArea.getText())) {
			textArea.setText(str);
		} else {
			textArea.setText(textArea.getText() + "\n" + str);
		}
	}
	
	private void prntLinkedList(LinkedList<?> linkedList, Boolean prntSize, 
									Boolean prntIsEmpty, Boolean emptyLine,
									TextArea textArea) {
		if (emptyLine) prnt("", textArea);
		prnt(Arrays.toString(linkedList.toArray()), textArea);
		prnt("Head: " + linkedList.getHeadValue() + ". Tail: " 
				+ linkedList.getTailValue(), textArea);
		if (prntSize && prntIsEmpty) {
			prnt("Size: " 		+ linkedList.size() + ". Is empty?: " 
					+ linkedList.isEmpty(), textArea);
		} else {
			if (prntSize) 		prnt("Size: " 		+ linkedList.size(), 	textArea);
			if (prntIsEmpty) 	prnt("Is empty?: " 	+ linkedList.isEmpty(), textArea);
		}
	}
	
	private void prntLinkedList(LinkedList<?> linkedList, TextArea textArea) {
		prntLinkedList(linkedList, true, true, true, textArea);
	}
	
	private void prntLinkedList(LinkedList<?> linkedList, Boolean emptyLine,
															TextArea textArea) {
		prntLinkedList(linkedList, true, true, emptyLine, textArea);
	}
}
