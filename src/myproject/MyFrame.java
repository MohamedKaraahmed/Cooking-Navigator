package myproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import myproject.MyFrame.backStepAction;
import myproject.MyFrame.receiptAction;

public class MyFrame extends JFrame {
	Course food;

	JPanel upPanel = new JPanel();
	JPanel midPanel = new JPanel();
	JPanel downPanel = new JPanel();
	JPanel stepLabelPanel = new JPanel();
	JPanel stepImagePanel = new JPanel();
	JPanel saladPanel = new JPanel();
	JPanel mainCPanel = new JPanel();
	JPanel saladImage = new JPanel();
	JPanel mainCImage = new JPanel();
	
	JLabel select = new JLabel("Изберете:");
	JLabel saladLabel = new JLabel("Салата");	
	JLabel mainCLabel = new JLabel("Основно ястие");
		
	private static JButton backBtn = new JButton("Назад");
	private static JButton receiptBtn = new JButton("Рецепта");
	private static JButton nextBtn = new JButton("Следващ");
	private static JLabel stepLabel = new JLabel();
	private static JLabel stepImage = new JLabel();

	Border border = BorderFactory.createLineBorder(Color.BLACK);
		
public MyFrame() {
		
	this.setTitle("Ръководство за готвене");
	this.setSize(600, 600);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
	this.add(upPanel, BorderLayout.NORTH);
	this.add(midPanel, BorderLayout.CENTER);
	this.add(downPanel, BorderLayout.PAGE_END);
			
	//UpPanel			
	upPanel.setLayout(new BorderLayout());
	upPanel.add(select, BorderLayout.NORTH);
	select.setHorizontalAlignment(JLabel.CENTER);
			
	JPanel upPanelContainer = new JPanel();
	JPanel downPanelContainer = new JPanel();
	upPanel.add(upPanelContainer, BorderLayout.CENTER);
	upPanel.add (downPanelContainer,BorderLayout.SOUTH);
	
	upPanelContainer.add(saladPanel);
	upPanelContainer.add(mainCPanel);
			
	saladPanel.setLayout(new BorderLayout());
	saladPanel.add(saladImage, BorderLayout.CENTER);
	saladPanel.add(saladLabel, BorderLayout.SOUTH);
			
	createCourse(saladPanel, saladImage, saladLabel, "salad.jpg");
	createCourse(mainCPanel, mainCImage, mainCLabel, "main.jpg");
			
	//MidPanel
	midPanel.setBorder(border);
	midPanel.setLayout(new BorderLayout());
	midPanel.add(stepLabelPanel, BorderLayout.NORTH);
	midPanel.add(stepImagePanel, BorderLayout.CENTER);		   
	stepLabelPanel.add(stepLabel);
	stepImagePanel.add(stepImage);
		    
	//DownPanel	  
	downPanel.add(backBtn);
	downPanel.add(receiptBtn);
	downPanel.add(nextBtn);
			
	backBtn.setEnabled(false);
	nextBtn.setEnabled(false);
	receiptBtn.setEnabled(false);
			
	backBtn.addActionListener(new backStepAction());
	receiptBtn.addActionListener(new receiptAction());
	nextBtn.addActionListener(new nextStepAction());
			
	mainCPanel.addMouseListener(new MouseListener() {
		@Override
		public void mouseReleased(MouseEvent arg0) {	
				}	
		@Override
		public void mousePressed(MouseEvent arg0) {
				}
		@Override
		public void mouseExited(MouseEvent arg0) {
				}
		@Override
		public void mouseEntered(MouseEvent arg0) {
				}	
		@Override
		public void mouseClicked(MouseEvent arg0) {
		food = new MainCourse();
				}
			});
	
	saladPanel.addMouseListener(new MouseListener() {
				
		@Override
		public void mouseReleased(MouseEvent arg0) {
				}
				
		@Override
		public void mousePressed(MouseEvent arg0) {
				}
				
		@Override
		public void mouseExited(MouseEvent arg0) {
				}
				
		@Override
		public void mouseEntered(MouseEvent arg0) {
				}
				
		@Override
		public void mouseClicked(MouseEvent arg0) {
		food = new Salad();
				}
			});
	
	this.setVisible(true);
		}

	private void createCourse(JPanel courseMainPanel, JPanel courseImage, JLabel courseLabel, String imagePath) {
	courseMainPanel.setLayout(new BorderLayout());
			courseMainPanel.add(courseImage, BorderLayout.CENTER);
			courseMainPanel.add(courseLabel, BorderLayout.SOUTH);
			
			ImageIcon image = new javax.swing.ImageIcon(("resources/img/" + imagePath));
			image.setImage(image.getImage().getScaledInstance(130, 100, Image.SCALE_SMOOTH));
			courseImage.add(new JLabel(image));
			courseLabel.setHorizontalAlignment(JLabel.CENTER);
			
			courseMainPanel.setBorder(border);
		}
		
		
		public class backStepAction implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					food.showBackStep();
				} catch (NullPointerException ex) {
					System.out.println("Не сте избрали рецепта!");
				}
				
			}
		}
		
		public class receiptAction implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				food.showReceipt();
			}
		}
		
		public class nextStepAction implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					food.showNextStep();
				} catch (NullPointerException ex) {
					System.out.println("Не сте избрали рецепта!");
				}
				
			}

		}
		
		public static JButton getBackBtn() {
			return backBtn;
		}

		public static void setBackBtn(JButton backBtn) {
			MyFrame.backBtn = backBtn;
		}

		public static JButton getNextBtn() {
			return nextBtn;
		}

		public static void setNextBtn(JButton nextBtn) {
			MyFrame.nextBtn = nextBtn;
		}
		
		public static JLabel getStepLabel() {
			return stepLabel;
		}

		public static void setStepLabel(JLabel stepLabel) {
			MyFrame.stepLabel = stepLabel;
		}

		public static JButton getReceiptBtn() {
			return receiptBtn;
		}
		
		public static JLabel getStepImage() {
			return stepImage;
		}
		
	}
