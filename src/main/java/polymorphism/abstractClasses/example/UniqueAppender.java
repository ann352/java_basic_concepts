package polymorphism.abstractClasses.example;

public class UniqueAppender extends AbstractAppender{
    @Override
    public void append(String valueToAppend) {
        if(!this.value.contains(valueToAppend)){
            this.value.concat(valueToAppend);
        }

    }
}
