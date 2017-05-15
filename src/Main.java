import DB.Database;
import accounts.Administator;
import accounts.Komisija;
import accounts.Takmicar;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {
    Database baza = Database.getInstance();
    Stage window;
    Scene logIn,komisijaDisplay, adminDisplay, takmicarDisplay;
    TextArea txtArea;
    Takmicar t;
    Komisija k;
    Administator admin;





    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Programming Contest - Log in");

        window = primaryStage;
         //scene for login
        Label name = new Label("username");
        TextField txtName = new TextField();
        Label pass = new Label("pass");
        TextField txtPass = new TextField();
        Button loginButton = new Button("Log in");
        loginButton.setMinWidth(175);
        loginButton.setOnAction(e -> {
            boolean ans = Methods.checkWhoIs(txtName.getText(), txtPass.getText());
            System.out.println(ans);
            if(ans) {
                if (txtName.getText().split("")[0].equals("k")) {
                    window.setScene(komisijaDisplay);
                    System.out.println("uradih ovo sa k");

                }
                else if (txtName.getText().split("")[0].equals("t"))
                {
                    window.setScene(takmicarDisplay);
                    System.out.println("uradih ovo sa t");

                }

                else if(txtName.getText().split("")[0].equals("a")) {
                    window.setScene(adminDisplay);
                    System.out.println("uradih ovo sa a");
                }
            }
        });

        txtArea = new TextArea();
        txtArea.setMaxWidth(175);
        Button seeRankListButton = new Button("Rank List");
        seeRankListButton.setMinWidth(175);
        seeRankListButton.setOnAction( e-> Methods.RankList(txtArea));
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        GridPane.setConstraints(name,0,0);
        GridPane.setConstraints(txtName,1,0);
        GridPane.setConstraints(pass,0,1);
        GridPane.setConstraints(txtPass,1,1);
        GridPane.setConstraints(loginButton,1,2);
        GridPane.setConstraints(seeRankListButton,1,3);
        GridPane.setConstraints(txtArea,1,4);
        grid.getChildren().addAll(name,txtName,pass,txtPass,loginButton,txtArea,seeRankListButton);

        logIn = new Scene(grid, 325,400);
        window.setScene(logIn);
                     //end of scene for login
          //scene for komisija


            Label markWorkHeading = new Label("GIVE A GRADE BY ENTERING A NAME");
            TextField markWork = new TextField();
            markWork.setPromptText("Enter a grade");
            TextField nameForWork = new TextField();
            nameForWork.setPromptText("Enter a name of competitioner");
            Button markWorkButton = new Button("Give a grade");
            Button listAllExams = new Button("List all of exams");
            TextArea txtAreaforAllExams = new TextArea();
            listAllExams.setOnAction(e->Methods.listAllExams(txtAreaforAllExams));

            GridPane gridForKomisija = new GridPane();
            gridForKomisija.setPadding(new Insets(10,10,10,10));
            gridForKomisija.setVgap(8);
            gridForKomisija.setHgap(10);

             GridPane.setConstraints(markWorkHeading,0,0);
             GridPane.setConstraints(markWork,1,0);
             GridPane.setConstraints(nameForWork,2,0);

             GridPane.setConstraints(markWorkButton,3,0);
             GridPane.setConstraints(listAllExams,4,0);
             GridPane.setConstraints(txtAreaforAllExams,5,0);

             komisijaDisplay = new Scene(gridForKomisija,500,500);
             
             //end of scene for komisija











        window.show();
    }





}
