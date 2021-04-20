package ConstraintMultisetAttributeGrammar;

import java.util.Comparator;

/**
 * A generic attribute, which in formal grammar theory, is either of the type synthesised or inherited.
 * @param <T>
 */
public class Attribute<T> {

    private T value;
    private String name;

    public Attribute(T object, String name){
        this.value = object;
        this.name = name;
    }

    public T getValue(){
        return this.value;
    }

    public String getName(){
        return this.name;
    }

    public void setValue(T object){
        this.value = object;
    }

    public void setName(String name){
        this.name = name;
    }
}
