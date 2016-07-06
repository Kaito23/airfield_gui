package airfield.application.components;

import java.io.File;

import panda.signer.Generator;
import panda.signer.SignChecker;
import panda.signer.Signer;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lombok.Getter;
import airfield.DataBean;
import airfield.fx.components.SignTabView;

/**
 * Controller for the signing view tab.
 * 
 * @author koetter
 */
public class SignTabVC {

	/** Model */
	private DataBean dataBean;
	/** View */
	@Getter
	private SignTabView view;

	/** Button for creating a keypair */
	private Button buttonCreateKey;
	/** Button for signing an app */
	private Button buttonSign;
	/** Button for testing the signature */
	private Button buttonTestSignature;
	/** Textfield containing the path to the privatekey */
	private TextField textFieldPrivatekeyPath;
	/** Textfield containing the path to the publickey */
	private TextField textFieldPublickeyPath;
	/** Label for displaying that a keypair is created */
	private Label labelKeyPairCreated;
	/** Label with result of signing */
	private Label labelSignResult;
	/** Label with test result */
	private Label labelTestResult;

	/** Textfield containing the local path to the app folder */
	private TextField textFieldLocalFolder;

	/**
	 * Creates a normal tab with the singing view.
	 * 
	 * @param dataBean
	 *            the data
	 * @param headVC
	 *            the headviewcontroller for handling the textfield with the
	 *            local path to the app
	 */
	public SignTabVC(final DataBean dataBean, final HeadVC headVC) {
		this.dataBean = dataBean;
		this.view = new SignTabView();

		this.buttonCreateKey = view.getButtonCreateKey();
		this.buttonSign = view.getButtonSign();
		this.buttonTestSignature = view.getButtonTestSignature();
		this.textFieldPrivatekeyPath = view.getTextFieldPrivatekeyPath();
		this.textFieldPublickeyPath = view.getTextFieldPublickeyPath();
		this.labelKeyPairCreated = view.getLabelKeyPairCreated();
		this.labelSignResult = view.getLabelSignResult();
		this.labelTestResult = view.getLabelTestResult();

		this.textFieldLocalFolder = headVC.getView().getTextFieldLocalFolder();

		addButtonCreateKey();
		addButtonSign();
		addButtonTestSignature();

	}

	/** Adds functionality to the test signature button. */
	private void addButtonTestSignature() {
		buttonTestSignature.setOnAction(event -> {
			SignChecker signChecker = new SignChecker();
			boolean verified = signChecker.verify(textFieldPublickeyPath.getText(), textFieldLocalFolder.getText());
			if (verified) {
				labelTestResult.setText("Test erfolgreich!");
				labelTestResult.setStyle("-fx-background-color: #C6EFCE; -fx-color: #2C612E;");
			} else {
				labelTestResult.setText("Fehler beim Testen!");
				labelTestResult.setStyle("-fx-background-color: #FFC7CE; -fx-color: #AD0031;");
			}
		});
	}

	/** Adds functionality to the sign button */
	private void addButtonSign() {
		buttonSign.setOnAction(event -> {
			String privateKeyFolderPath = textFieldPrivatekeyPath.getText();
			String publicKeyFolderPath = textFieldPublickeyPath.getText();

			Signer signer = new Signer();
			signer.createSignFile(privateKeyFolderPath, publicKeyFolderPath, textFieldLocalFolder.getText());

			System.out.println("signing complete! start checking ...");
			labelSignResult.setText("Signiert!");
			labelSignResult.setStyle("-fx-background-color: #C6EFCE; -fx-color: #2C612E;");
			SignChecker signChecker = new SignChecker();
			boolean verified = signChecker.verify(publicKeyFolderPath, textFieldLocalFolder.getText());
			if (verified) {
				labelTestResult.setText("Erfolgreich!");
				labelTestResult.setStyle("-fx-background-color: #C6EFCE; -fx-color: #2C612E;");
			} else {
				labelTestResult.setText("Fehlerhaft!");
				labelTestResult.setStyle("-fx-background-color: #FFC7CE; -fx-color: #AD0031;");
			}
			System.out.println("checking complete");
		});
	}

	/** Adds functionality to the create keypair button */
	private void addButtonCreateKey() {
		buttonCreateKey.setOnAction(event -> {
			if (!textFieldLocalFolder.getText().isEmpty()) {
				Generator generator = new Generator();
				File keyFolder = generator.generateKeypair(dataBean.getPrimaryStage());
				if (keyFolder != null) {
					textFieldPrivatekeyPath.setText(keyFolder.getAbsolutePath() + File.separator + "priv");
					textFieldPublickeyPath.setText(keyFolder.getAbsolutePath() + File.separator + "pub");
					labelKeyPairCreated.setText("Keypair erstellt!");
					labelKeyPairCreated.setStyle("-fx-background-color: #C6EFCE; -fx-color: #2C612E;");
				}
			} else {
				textFieldLocalFolder.setStyle("-fx-border-color: red;");
			}
		});
	}
}
