package com.codingmugen.Lifterz.lift;

public class LiftNotFoundException extends RuntimeException{
    public LiftNotFoundException() {
        super("Lift not found");
    }
}
