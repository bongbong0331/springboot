package decorator;

public class Audi implements ICar{

	private int cost;
	
	
	public Audi(int cost) {
		this.cost = cost;
	}
	
	
	
	
	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return this.cost;
	}

	@Override
	public void showPrice() {
		System.out.println("Audi Base 는 " + cost + " 만원 입니다.");
	}

}
