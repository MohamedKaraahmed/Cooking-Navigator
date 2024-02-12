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
	stepsList.add("������ 1: �������� ����, ���������� �������� �� �������� � ��������� �����.");
	stepsList.add("������ 2: �������� ����� � �� �������� �� �������.");
	stepsList.add("������ 3: �������� ������������ � �������� �� �������.");
	stepsList.add("����� 4: �������� ����������� � ����� � �� �����������.");
	stepsList.add("������ 5: ���������� � �����.");		
}

private void createReceiptList(){
	receiptList.add("5 ����� ����");
	receiptList.add("200g ������");
	receiptList.add("100g ����� �������");
	receiptList.add("3 ���� �����");
	receiptList.add("2 ������ ���");
	receiptList.add("2 ������� �����");
	receiptList.add("2 ������ �����");
	receiptList.add("2 ����������");
	receiptList.add("2 ������");
	receiptList.add("100� ��������");
	receiptList.add("��� �� ����");
	receiptList.add("100ml ����");
	receiptList.add("20�� ����� ����");
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
	JOptionPane.showMessageDialog(null, receipt, "������� �� ������", JOptionPane.INFORMATION_MESSAGE);
}

}
