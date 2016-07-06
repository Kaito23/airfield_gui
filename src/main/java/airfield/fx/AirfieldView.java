package airfield.fx;

import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import lombok.Getter;

/**
 * View for signing, keygeneration and commiting.
 * 
 * @author koetter
 */
public class AirfieldView {

	/** The Scene */
	@Getter
	private Scene scene;
	/** The Tabpane */
	@Getter
	private TabPane tabPane;
	/** Borderpane root */
	@Getter
	private BorderPane root;

	/** Displays the takeoff screen. */
	public AirfieldView() {
		root = new BorderPane();
		tabPane = new TabPane();
		root.setCenter(tabPane);
		scene = new Scene(root);
	}

	/**
	 * Show.
	 * 
	 * @param primaryStage
	 *            tge primary stage
	 */
	public final void show(final Stage primaryStage) {
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
