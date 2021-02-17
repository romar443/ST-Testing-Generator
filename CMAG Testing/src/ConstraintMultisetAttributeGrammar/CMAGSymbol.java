package ConstraintMultisetAttributeGrammar;

import GeneralComponents.AbstractSymbol;

import java.util.List;

public abstract class CMAGSymbol extends AbstractSymbol {

    private final List<Attribute> attributes;

    public CMAGSymbol(Object object, List<Attribute> attributes) {
        super(object);
        this.attributes = attributes;
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


