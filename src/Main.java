import DB.Database;
import accounts.Administator;
import accounts.Komisija;
import accounts.Takmicar;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
                    window.setTitle("Komisija");
                    window.show();
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

        grid.setConstraints(name,0,0);
        grid.setConstraints(txtName,1,0);
        grid.setConstraints(pass,0,1);
        grid.setConstraints(txtPass,1,1);
        grid.setConstraints(loginButton,1,2);
        grid.setConstraints(seeRankListButton,1,3);
        grid.setConstraints(txtArea,1,4);
        grid.getChildren().addAll(name,txtName,pass,txtPass,loginButton,txtArea,seeRankListButton);

        logIn = new Scene(grid, 325,400);
        window.setScene(logIn);
                     //end of scene for login
          //scene for komisija


            Label markWorkHeading = new Label("GIVE A GRADE BY ENTERING A NAME");
            TextField markWork = new TextField();
            markWork.setMaxWidth(400);
            markWork.setPromptText("Enter a grade");
            TextField nameForWork = new TextField();
            nameForWork.setMaxWidth(400);
            nameForWork.setPromptText("Enter a name of competitior");
            Button markWorkButton = new Button("Give a grade");
            markWorkButton.setMaxWidth(400);
            Button listAllExams = new Button("List all of exams");
            listAllExams.setMaxWidth(400);
            TextArea txtAreaforAllExams = new TextArea();

            listAllExams.setOnAction(e->Methods.listAllExams(txtAreaforAllExams));
            txtAreaforAllExams.setMaxWidth(400);

            VBox layoutKomisija = new VBox(10);
            layoutKomisija.setAlignment(Pos.BASELINE_CENTER);

            layoutKomisija.getChildren().addAll(markWorkHeading, markWork, nameForWork,markWorkButton,listAllExams,txtAreaforAllExams);
        komisijaDisplay = new Scene(layoutKomisija,500,500);
             
             //end of scene for komisija



        window.show();
    }





}
