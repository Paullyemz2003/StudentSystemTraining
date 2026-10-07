import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty program = new SimpleStringProperty();

    public Student(String name, String program) {
        this.name.set(name);
        this.program.set(program);
    }

    public StringProperty nameProperty() { return name; }
    public StringProperty programProperty() { return program; }
}