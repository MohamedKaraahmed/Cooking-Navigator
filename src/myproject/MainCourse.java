package myproject;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MainCourse extends Course {
	int index = 0;
	
ArrayList<String> stepsList = new ArrayList<>();
ArrayList<String> receiptList = new ArrayList<>();
	
public MainCourse() {
	createStepList();
	createReceiptList();
	MyFrame.getStepLabel().setText(stepsList.get(0));
	showStepImage(0);
	MyFrame.getBackBtn().setEnabled(false);
	MyFrame.getNextBtn().setEnabled(true);
	MyFrame.getReceiptBtn().setEnabled(true);
	}

private void createStepList() {
	stepsList.add("Стъпка 1: Добавете карамфил, сол, червен пипер, кафява захар в купа и разбъркайте.");
	stepsList.add("Стъпка 2: Смесете сместа с месото");
	stepsList.add("Стъпка 3: Добавете лук целина и моркови в купата.");
	stepsList.add("Стъпка 4: Печете 5 часа на 140 градуса.");
	stepsList.add("Стъпка 5: Сервирайте вкусното месо на гостите");		
	}

private void createReceiptList(){
	receiptList.add("1кг телешки гърди");
	receiptList.add("2 карамфила");
	receiptList.add("2 зърна бахар");
	receiptList.add("1 чаена лъжица сол");
	receiptList.add("1 чаена лъжичка червен пипер на зърна");
	receiptList.add("1 чаена лъжичка бяла горчица");
	receiptList.add("1 чаена лъжичка кафява захар");
	receiptList.add("2 скилидки чесън");
	receiptList.add("2 дафинови листа");
	receiptList.add("1 лук");
	receiptList.add("2 мащерка");
	receiptList.add("1 морков");
	}
	
private void showStepImage(int index) {
	JLabel instructionImage = MyFrame.getStepImage();
	ImageIcon image = new javax.swing.ImageIcon("resources/steps/maincourse/StepMeat" + (index + 1) + ".jpg");
	image.setImage(image.getImage().getScaledInstance(580, 328, Image.SCALE_SMOOTH));
	instructionImage.setText("");
	instructionImage.setIcon(image);
	}

public void showReceipt() {
		String receipt = createReceiptString();
		JOptionPane.showMessageDialog(null, receipt, "Рецепта за основното ястие", JOptionPane.INFORMATION_MESSAGE);
	}
	
private String createReceiptString() {
		StringBuilder builder = new StringBuilder();
		
	for (int i = 0; i < receiptList.size(); i++) {
			builder.append(receiptList.get(i));
			builder.append("\n");
		}
		return String.valueOf(builder);
	}

@Override
public void showNextStep() {
	if (index == stepsList.size() - 2){
		MyFrame.getNextBtn().setEnabled(false);
	} else MyFrame.getBackBtn().setEnabled(true);
		index++;
		MyFrame.getStepLabel().setText(stepsList.get(index));
		showStepImage(index);
	}
	
@Override
public void showBackStep() {
	if (index == 1) {
		MyFrame.getBackBtn().setEnabled(false);
	} else {
			MyFrame.getNextBtn().setEnabled(true);
			}
		index--;
		MyFrame.getStepLabel().setText(stepsList.get(index));
		showStepImage(index);
	}

}
