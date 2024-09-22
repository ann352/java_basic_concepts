package polymorphism.abstractClasses.example;

class BackAppender extends AbstractAppender {

    public void append(String valueToAppend) {
        this.value = this.value.concat(valueToAppend);
    }
}
