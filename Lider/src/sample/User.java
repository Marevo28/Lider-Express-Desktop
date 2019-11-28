package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    //Format DateTime = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
    private final StringProperty Number1;
    private final StringProperty Number;
    private final StringProperty DateTime;
    private final StringProperty Run;

    //Defoult constructor
    public User(String Number1, String Number, String DateTime, String Run) {
        this.Number1=new SimpleStringProperty(Number1);
        this.Number=new SimpleStringProperty(Number);
        this.DateTime=new SimpleStringProperty(DateTime);
        this.Run=new SimpleStringProperty(Run);
    }

    //Getters
    public String getNumber1(){return Number1.get();}
    public String getNumber(){return Number.get();}
    public String getDateTime(){return DateTime.get();}
    public String getRun(){return Run.get();}

    //Setters
    public void setNumber1(String value) {Number1.set(value);}
    public void setNumber(String value) {Number.set(value);}
    public void setDateTime(String value) {DateTime.set(value);}
    public void setRun(String value) {Run.set(value);}

    //Property values
    public StringProperty Number1Property() {return Number1;}
    public StringProperty NumberProperty() {return Number;}
    public StringProperty DateTimeProperty() {return DateTime;}
    public StringProperty RunProperty() {return Run;}

}

