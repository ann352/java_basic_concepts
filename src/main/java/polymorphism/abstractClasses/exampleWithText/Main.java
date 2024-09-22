package polymorphism.abstractClasses.exampleWithText;

public class Main {
    public static void main(String[] args) {
        CSVDocument csvDocument = new CSVDocument();
        csvDocument.addNewLine("John","Smith","Warsow");
        csvDocument.addNewLine("Merry","Fox","New York");
        csvDocument.addNewLine("Adam","Lamb","Glasgow");
        System.out.println(csvDocument.asText());
    }
}
