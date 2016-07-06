package airfield;

import javafx.stage.Stage;
import lombok.Getter;

public class DataBean {
	
	/** The primary stage */
	@Getter
	private Stage primaryStage = null;   
	
	private String localAppFolder;
	private String pathToPrivatekey;
	private String pathToPublickey;
	
	public DataBean(final Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

}
