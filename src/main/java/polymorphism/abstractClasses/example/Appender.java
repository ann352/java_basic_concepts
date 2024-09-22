package polymorphism.abstractClasses.example;

abstract class AbstractAppender {
    protected String value = "";

    public abstract void append(String valueToAppend);

    public String getValue(){ //to get value, because of 'protected' modifier
        return value;
    }
}
