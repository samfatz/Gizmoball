import Model.Model;
import View.BuildGUI;
import View.RunGUI;

public class Main {

	public static void main(String[] args) {
		Model model = new Model();
		new BuildGUI(model);

	}

}