package proxy;


// 관점 지향
// 전처리
// 실제 동작 메서드...
// 후처리



public class BrowserProxy implements IBrowser{

	private String url;
	// 여기서 추가로 
	private Html html;
	
	
	public BrowserProxy(String url) {
		this.url = url;
	}
	
	
	@Override
	public Html show() {
		// 여기에서 캐싱 기능을 추가해 볼까??
		if(html == null) {
			System.out.println("BrowserProxy loding html from : " + url);
			this.html = new Html(url);
		}
		System.out.println(" >>>>>BrowserProxy use chache html : " + url + "<<<<<<");
		return html;
	}
	
	
	
}
