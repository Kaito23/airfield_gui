package airfield;

import javafx.application.Application;
import javafx.stage.Stage;
import airfield.application.AirfieldVC;

/**
 * Starts the application.
 * 
 * @author airhacks.com
 */
public class App extends Application {

	/**
	 * Main
	 * 
	 * @param args
	 *            the overgiven parameters
	 */
	public static final void main(final String[] args) {
		launch(args);
	}

	/** JavaFX starting point */
	@Override
	public final void start(final Stage primaryStage) throws Exception {
		primaryStage.setTitle("airfieldFX GUI"); // TODO
		primaryStage.setResizable(false);
		//primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.sizeToScene();
		DataBean dataBean = new DataBean(primaryStage);
		AirfieldVC airfieldVC = new AirfieldVC(dataBean);

		airfieldVC.show();

	}
}
