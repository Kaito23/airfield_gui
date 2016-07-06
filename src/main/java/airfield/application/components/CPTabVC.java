package airfield.application.components;

import lombok.Getter;
import airfield.DataBean;
import airfield.fx.components.CPTabView;

/**
 * Controller for the commit and push view.
 * 
 * @author koetter
 */
public class CPTabVC {

	/** Model */
	private DataBean dataBean;
	/** The view */
	@Getter
	private CPTabView view;

	/**
	 * Adds default controlling to the commit and push view.
	 * 
	 * @param dataBean
	 *            the model
	 */
	public CPTabVC(final DataBean dataBean) {
		this.dataBean = dataBean;
		this.view = new CPTabView();
	}

}
