package myproject;

public abstract class Course implements Showsteps {

	@Override
	public abstract void showNextStep();

	@Override
	public abstract void showBackStep();
	
	@Override
	public abstract void showReceipt();
}
