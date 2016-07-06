package airfield.fx.components;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import lombok.Getter;
import airfield.application.components.TabViewInterface;

/**
 * Tab for commit and push.
 * 
 * @author koetter
 */
public class CPTabView extends Tab implements TabViewInterface {

	/** Textarea for entering the comment */
	@Getter
	private TextArea textAreaComment;

	/** Button for commit and push */
	@Getter
	private Button buttonCommitAndPush;

	/** Checkbox for signing before p & c */
	@Getter
	private CheckBox checkboxDoSign;

	/** TODO */
	public CPTabView() {
		super("C & P");
		this.setClosable(false);
		this.setContent(getCPTab());
	}

	/**
	 * TODO TODO rename
	 * 
	 * @return TODO
	 */
	private GridPane getCPTab() {
		buttonCommitAndPush = new Button("C & P");

		GridPane grid = new GridPane();
		// grid.setHgap(TEN);
		grid.setVgap(TEN);
		grid.setPadding(new Insets(TEN));

		Text textHead = new Text("Commit & Push:");
		textHead.setFont(Font.font("Arial", FontWeight.BOLD, TWENTY));
		grid.add(textHead, 0, 0);

		grid.add(new Label("Kommentar"), 0, 1);

		textAreaComment = new TextArea();
		grid.add(textAreaComment, 0, 2);

		HBox checkboxbox = new HBox(TEN);

		checkboxDoSign = new CheckBox();
		checkboxbox.getChildren().addAll(new Label("Signieren?"), checkboxDoSign);
		grid.add(checkboxbox, 0, THREE);
		grid.add(buttonCommitAndPush, 0, FOUR);

		return grid;
	}
}
