package airfield.fx.components;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import lombok.Getter;
import airfield.application.components.TabViewInterface;

/**
 * Tab for initial download of a repo.
 * 
 * @author koetter
 */
public class InitTabView extends Tab implements TabViewInterface {

	/** Init button */
	@Getter
	private Button buttonInit;

	/** Default init tab. */
	public InitTabView() {
		super("Init");
		this.setClosable(false);
		this.setContent(getInitTab());
	}

	/**
	 * Get a gridpane with the elements for initializing a repo.
	 * 
	 * @return gridpane with elements for initializing a repo
	 */
	private GridPane getInitTab() {
		buttonInit = new Button("Init");

		GridPane grid = new GridPane();
		grid.setHgap(TEN);
		grid.setVgap(TEN);
		grid.setPadding(new Insets(TEN));

		Text category = new Text("Init a repo:");
		category.setFont(Font.font("Arial", FontWeight.BOLD, TWENTY));
		grid.add(category, 0, 0);

		Label labelExplain = new Label("Lädt initial das Git-Repo herunter.");
		grid.add(labelExplain, 0, 1);
		grid.add(buttonInit, 0, 2);

		return grid;
	}
}
