package Final_immutable_and_Static.FinalExplored.Consumer.Specific;

import Final_immutable_and_Static.FinalExplored.Consumer.Generic.BaseClass;

public class ChildClass extends BaseClass {

    @Override
    protected void optionalMethod() {

        System.out.println("[Child:optionalMethod] EXTRA Stuff Here");
        super.optionalMethod();
    }

//    @Override
//    public void recommendedMethod() {
//
//        System.out.println("[Child:recommendedMethod]: I'll do things my way");
//        optionalMethod();
//    }

    private void mandatoryMethod() {
        System.out.println("[Child:mandatoryMethod]: My own important stuff");
    }

    public static void recommendedStatic() {

        System.out.println("[Child.recommendedStatic] BEST Way to Do it");
        optionalStatic();
//        mandatoryStatic();
    }
}

