package polymorphism.abstractClasses;

public class AbstractClassesDemo {
    //in abstract classes we can have unimplemented methods
    //we used them to store elements of classes with similar behavior in one place
    //They are a kind of container for common code
    //IMPORTANT Due to the fact that they may have an unimplemented method,
    //it is not possible to create object of such a class, we can only create instances of its children - polimorphism

    //that is uncorrect:
    //AbstractAppender appender = new AbstractAppender();

    //that is correct:
    //AbstractAppender appender1 = new BackAppender();
    //BackAppender appender2 = new BackAppender();

}
