package airfield.fx.components;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import lombok.Getter;
import airfield.application.components.TabViewInterface;

/**
 * Tab for signing an app.
 * 
 * @author koetter
 */
public class SignTabView extends Tab implements TabViewInterface {

	/** Button for creating keypair */
	@Getter
	private Button buttonCreateKey;
	/** Button for signing */
	@Getter
	private Button buttonSign;
	/** Button for testing the signature */
	@Getter
	private Button buttonTestSignature;
	/** Textfield containing the path to privatekey */
	@Getter
	private TextField textFieldPrivatekeyPath;
	/** Textfield containing the path to publickey */
	@Getter
	private TextField textFieldPublickeyPath;

	@Getter
	private Label labelKeyPairCreated;

	@Getter
	private Label labelSignResult;

	@Getter
	private Label labelTestResult;

	public SignTabView() {
		super("Sign");
		this.setClosable(false);
		this.setContent(getSignGrid());
	}

	/**
	 * TODO
	 * 
	 * @return TODO
	 */
	private GridPane getSignGrid() {
		labelKeyPairCreated = new Label();
		labelTestResult = new Label();
		labelSignResult = new Label();

		buttonCreateKey = new Button("Keypaar erstellen");
		buttonSign = new Button("Signieren");
		buttonTestSignature = new Button("Test signature");

		textFieldPrivatekeyPath = new TextField();
		textFieldPublickeyPath = new TextField();

		GridPane grid = new GridPane();
		grid.setHgap(TEN);
		grid.setVgap(TEN);
		grid.setPadding(new Insets(INSETS));

		grid.add(new Label("Signkey Private"), 0, 0);
		grid.add(textFieldPrivatekeyPath, 1, 0);
		grid.add(new Button("Key wählen"), 2, 0); // TODO

		grid.add(new Label("Signkey Public"), 0, 1);
		grid.add(textFieldPublickeyPath, 1, 1);
		grid.add(new Button("Key wählen"), 2, 1); // TODO

		grid.add(buttonCreateKey, 0, THREE);
		grid.add(labelKeyPairCreated, 1, THREE);

		grid.add(buttonSign, 0, FOUR);
		grid.add(labelSignResult, 1, FOUR);

		grid.add(buttonTestSignature, 0, FIVE);
		grid.add(labelTestResult, 1, FIVE);

		return grid;
	}

}
