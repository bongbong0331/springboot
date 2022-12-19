package proxy;

public class ChromeBrowser implements IBrowser{

	private String url;
	
	public ChromeBrowser(String url) {
		this.url = url;
	}
	
	@Override
	public Html show() {
		
		System.out.println("chrome browser loding html from : " + url);
		return new Html(url);
	}

	
	
}
