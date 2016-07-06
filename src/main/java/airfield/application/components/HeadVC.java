package airfield.application.components;

import java.io.File;

import javafx.stage.DirectoryChooser;
import lombok.Getter;
import airfield.DataBean;
import airfield.fx.components.HeadView;

/**
 * Controller for the head.
 * @author koetter
 */
public class HeadVC {

	/** The model */
	private DataBean dataBean;
	/** The view */
	@Getter
	private HeadView view;

	/**
	 * TODO everything is wrong
	 * Normal headview with the textfield con
	 * @param dataBean the data
	 */
	public HeadVC(final DataBean dataBean) {
		this.dataBean = dataBean;
		this.view = new HeadView();

		view.getButtonChooseLocalFolder().setOnAction(event -> {
			DirectoryChooser directoryChooser = new DirectoryChooser();
			directoryChooser.setTitle("Zielordner wählen");
			File selectedDirectory = directoryChooser.showDialog(dataBean.getPrimaryStage());
			view.getTextFieldLocalFolder().setText(selectedDirectory.getAbsolutePath());
		});
	}

}
