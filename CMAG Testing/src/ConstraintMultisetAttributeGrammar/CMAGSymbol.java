package ConstraintMultisetAttributeGrammar;

import GeneralComponents.AbstractSymbol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class CMAGSymbol extends AbstractSymbol {

    private final List<Attribute> attributes;

    public CMAGSymbol(Object object, List<Attribute> attributes) {
        super(object);
        this.attributes = attributes;
    }

    public CMAGSymbol(Object object, Attribute attribute) {
        super(object);
        this.attributes = Arrays.asList(attribute);
    }



    public List<Attribute> getAttributes() {
        return attributes;
    }

    public Attribute getAttributeAtPosition(int position){
        return attributes.get(position);
    }

    public Attribute getAttributeWithName(String name){
        for(Attribute a : attributes){
            if(a.getName().equals(name)){
                return a;
            }
        }
        return null;
    }


}


