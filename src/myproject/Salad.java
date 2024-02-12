package myproject;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Salad extends Course {
	int index = 0;
	
	ArrayList<String> stepsList = new ArrayList<>();
	ArrayList<String> receiptList = new ArrayList<>();
	
public Salad() {
	createStepList();
	createReceiptList();
	MyFrame.getStepLabel().setText(stepsList.get(0));
	showStepImage(0);
	MyFrame.getBackBtn().setEnabled(false);
	MyFrame.getNextBtn().setEnabled(true);
	MyFrame.getReceiptBtn().setEnabled(true);
}
	
private void createStepList() {
	stepsList.add("Стъпка 1: Нарежете лука, отстранете семената от зелените и червените чушки.");
	stepsList.add("Стъпка 2: Изпечете хляба и го нарежете на кубчета.");
	stepsList.add("Стъпка 3: Нарежете краставиците и доматите на парчета.");
	stepsList.add("Стъка 4: Добавете зеленчуците и хляба и ги разбъркайте.");
	stepsList.add("Стъпка 5: Сервирайте с водка.");		
}

private void createReceiptList(){
	receiptList.add("5 филии хляб");
	receiptList.add("200g сирене");
	receiptList.add("100g черни маслими");
	receiptList.add("3 чили чушки");
	receiptList.add("2 червен лук");
	receiptList.add("2 червени чушки");
	receiptList.add("2 зелени чушки");
	receiptList.add("2 краставици");
	receiptList.add("2 домата");
	receiptList.add("100г магданоз");
	receiptList.add("сол на вкус");
	receiptList.add("100ml олио");
	receiptList.add("20мл винен оцет");
}

	private void showStepImage(int index) {
		JLabel instructionImage = MyFrame.getStepImage();
		ImageIcon image = new javax.swing.ImageIcon("resources/steps/salad/StepSalad" + (index + 1) + ".jpg");
		image.setImage(image.getImage().getScaledInstance(580, 328, Image.SCALE_SMOOTH));
		instructionImage.setText("");
		instructionImage.setIcon(image);
		
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
		MyFrame.getBackBtn().setEnabled(true);
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

@Override
public void showReceipt() {
	String receipt = createReceiptString();
	JOptionPane.showMessageDialog(null, receipt, "Рецепта за салата", JOptionPane.INFORMATION_MESSAGE);
}

}
