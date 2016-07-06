package airfield.fx.components;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import lombok.Getter;
import airfield.application.components.TabViewInterface;

/**
 * Head of the app for handling the app folder.
 * 
 * @author koetter
 */
public class HeadView extends HBox implements TabViewInterface {

	/** Textfield displaying the app dir */
	@Getter
	private TextField textFieldLocalFolder;
	/** Button for choosing the appdir */
	@Getter
	private Button buttonChooseLocalFolder;

	/** Normal headview with a textfield displaying the path to the appfolder. */
	public HeadView() {
		super(SPACE);
		this.setPadding(new Insets(SPACE));

		textFieldLocalFolder = new TextField();
		buttonChooseLocalFolder = new Button("Wählen");

		this.getChildren().addAll(new Label("Ordner"), textFieldLocalFolder, buttonChooseLocalFolder);
	}

}
