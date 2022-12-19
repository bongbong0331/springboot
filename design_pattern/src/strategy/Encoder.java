package strategy;

public class Encoder {
	
	private EncodingStrategy encodingStrategy;
	
	public String getMessage(String message) {
		
		return encodingStrategy.encode(message);
	}
	
	// 메서드를 통하여 바꿔치기하는 녀석을 처리
	public void setEncodingStrategy(EncodingStrategy encodingStrategy) {
		this.encodingStrategy = encodingStrategy;
		
		
		
	}
	
}
