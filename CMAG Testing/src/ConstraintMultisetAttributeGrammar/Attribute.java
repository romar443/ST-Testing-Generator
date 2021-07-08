package ConstraintMultisetAttributeGrammar;

import java.util.Comparator;

/**
 * Attributes are a defining aspect of CMAG's, alongside the concept of {@linkplain Constraint}s, which differentiate CMAG's from CFG's.
 * A generic attribute, which in formal grammar theory is either of the type synthesised or inherited.
 * @param <T> Generic of type T
 */
public class Attribute<T> {

    private T value;
    private String name;

    public Attribute(T value, String name){
        this.value = value;
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

    public Attribute clone(){
        return new Attribute(this.value, this.name);
    }
}
