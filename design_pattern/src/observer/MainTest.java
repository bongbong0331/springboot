package observer;

public class MainTest {

	public static void main(String[] args) {

		Button button = new Button("button");

		button.addListener(new IButtonListener() {

			@Override
			public void clickEvent(String event) {
				System.out.println("event : " + event);
			}
		});

		// button click ....

		button.clickEvent("이밍밍");
		button.clickEvent("드릉드릉");
		button.clickEvent("쑈오오오!! 캍!!!!");

	}// end main

}
