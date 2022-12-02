package adapter;

public class MyHouse {

	public static void main(String[] args) {
		// 청소기
		// 드라이기
		
		AirConditioner airConditioner = new AirConditioner();
		HairDryer dryer = new HairDryer();
		
		Cleaner cleaner = new Cleaner();
		
		
		// 전기연결 
		connect(airConditioner);
		connect(dryer);
		
		// 어댑터 사와야 한다. 
		ElectronicAdapter adapter = new ElectronicAdapter(cleaner);
		connect(adapter);
	}
	
	
	//전기 콘센트
	public static void connect(Electronic220v electronic220v) {
		electronic220v.connect();
	}
}
