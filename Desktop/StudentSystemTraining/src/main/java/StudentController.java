import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class StudentController {
    @FXML private TextField nameField;
    @FXML private ComboBox<String> programBox;
    @FXML private Button saveButton;
    @FXML private Label messageLabel;

    @FXML private TableView<Student> table;
    @FXML private TableColumn<Student, String> nameCol;
    @FXML private TableColumn<Student, String> programCol;

    private final ObservableList<Student> students = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        programBox.getItems().addAll("Computer Science", "Information Technology", "Business");

        nameCol.setCellValueFactory(d -> d.getValue().nameProperty());
        programCol.setCellValueFactory(d -> d.getValue().programProperty());
        table.setItems(students);

        saveButton.disableProperty().bind(
                nameField.textProperty().isEmpty()
                        .or(programBox.valueProperty().isNull())
        );
    }

    @FXML
    private void saveStudent() {
        students.add(new Student(nameField.getText(), programBox.getValue()));
        messageLabel.setText("Successfully registered: " + nameField.getText());
        messageLabel.setStyle("-fx-text-fill: green;");
        nameField.clear();
        programBox.setValue(null);
    }
}