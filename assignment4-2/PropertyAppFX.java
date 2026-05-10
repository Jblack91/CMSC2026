import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PropertyAppFX extends Application
{
	public void start(Stage stage)
	{
		ManagementCompany m = new ManagementCompany("Da Company", "123");
		TextField name = new TextField();
		TextField city = new TextField();
		TextField rent = new TextField();
		TextField owner = new TextField();
		Button add = new Button("Add Property");
		Button total = new Button("Calculate Total Rent");
		TextArea area = new TextArea();
		add.setOnAction(event ->
		{
			try
			{
				String n = name.getText();
				String c = city.getText();
				double r = Double.parseDouble(rent.getText());
				String o = owner.getText();
				Property p = new Property(n, c, r, o);
				m.addProperty(p);
				area.setText(m.toString());
			}
			catch(NumberFormatException e)
			{
				area.setText("Invalid Rent");
			}
		});

		total.setOnAction(event ->
		{
			area.setText("Total Rent: " + m.totalRent());
		});
		VBox v = new VBox();
		v.getChildren().addAll(name, city, rent, owner, add, total, area);
		Scene scene = new Scene(v, 300, 300);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}