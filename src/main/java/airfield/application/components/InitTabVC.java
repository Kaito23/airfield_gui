package airfield.application.components;

import lombok.Getter;
import airfield.DataBean;
import airfield.fx.components.InitTabView;

/**
 * Controller for the init tab view.
 * 
 * @author koetter
 */
public class InitTabVC {

	/** The model */
	private DataBean dataBean;
	/** The view */
	@Getter
	private InitTabView view;

	/**
	 * TODO
	 * @param dataBean TODO
	 */
	public InitTabVC(final DataBean dataBean) {
		this.dataBean = dataBean;
		this.view = new InitTabView();

		view.getButtonInit().setOnAction(event -> {
			//Test test = new Test();
			// test.test(pwField.getText()); TODO
			System.out.println("TODO");
		});
	}
}
