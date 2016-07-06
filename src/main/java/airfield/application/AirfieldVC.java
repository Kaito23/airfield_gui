package airfield.application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Tab;
import airfield.DataBean;
import airfield.application.components.CPTabVC;
import airfield.application.components.HeadVC;
import airfield.application.components.InitTabVC;
import airfield.application.components.SignTabVC;
import airfield.fx.AirfieldView;
import airfield.fx.components.RepoPane;

/**
 * Controller for the container view.
 * 
 * @author koetter
 */
public class AirfieldVC {

	/** Model */
	private DataBean dataBean;
	/** View */
	private AirfieldView view;

	/**
	 * 
	 * 
	 * @param dataBean
	 *            the data
	 */
	public AirfieldVC(final DataBean dataBean) {

		HeadVC headVC = new HeadVC(dataBean);
		RepoPane repoPane = new RepoPane(); // TODO vc!

		CPTabVC cpTabVC = new CPTabVC(dataBean);
		InitTabVC initTabVC = new InitTabVC(dataBean);
		SignTabVC signTabVC = new SignTabVC(dataBean, headVC);

		this.dataBean = dataBean;
		this.view = new AirfieldView();
		this.view.getRoot().setTop(headVC.getView());
		this.view.getRoot().setBottom(repoPane);

		view.getTabPane().getTabs().addAll(initTabVC.getView(), signTabVC.getView(), cpTabVC.getView());

		view.getTabPane().getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
			@Override
			public void changed(final ObservableValue<? extends Tab> observable, final Tab oldTab, final Tab newTab) {
				if (newTab == cpTabVC.getView() || newTab == initTabVC.getView()) {
					repoPane.setVisible(true);
					// repoPane.getTextFieldTarget().setText("");
				} else {
					repoPane.setVisible(false);
					// repoPane.getTextFieldTarget().setText("");
				}
			}
		});

	}

	/** Show. */
	public final void show() {
		view.show(dataBean.getPrimaryStage());
	}

}
