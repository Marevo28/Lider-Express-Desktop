package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class Controller {
    @FXML
    private TableView<User> TableUser;
    @FXML
    private TableColumn<User, String> columnNumber1;
    @FXML
    private TableColumn<User, String> columnNumber;
    @FXML
    private TableColumn<User, String> columnDateTime;
    @FXML
    private TableColumn<User, String> columnRun;
    @FXML
    private Button BattonLoad;

    //Initialize observable list to hold out database data
    private ObservableList<User> data;
    private dbConnection dc;

    public void initialize(URL url, ResourceBundle rb) {
        //TODO
        dc=new dbConnection();
    }

    @FXML
    private void LoadDateFromDataBase(ActionEvent event) {
        try {
            dc=new dbConnection();
            Connection conn = dc.Connect();
            data = FXCollections.observableArrayList();
            //Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT Position, Stolb27, Stolb28, Stolb29 FROM DefectBND");
            while (rs.next()) {
                //get string from db, whichever way
                data.add(new User(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        }
        catch (SQLException ex) {
            System.err.println("Error"+ex);
        }

        //Set cell value factory to Tableview
        //NB.Property Value Factory mast be the same with the one set in model class.
        columnNumber1.setCellValueFactory(new PropertyValueFactory<>("Number1"));
        columnNumber.setCellValueFactory(new PropertyValueFactory<> ("Number"));
        columnDateTime.setCellValueFactory(new PropertyValueFactory<> ("DateTime"));
        columnRun.setCellValueFactory(new PropertyValueFactory<> ("Run"));

        TableUser.setItems(null);
        TableUser.setItems(data);
    }


}