package ConstraintMultisetAttributeGrammar;

import ContextFreeGrammar.CFGSymbol;
import GeneralComponents.AbstractSymbol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Extension of a {@linkplain CFGSymbol} with the addition of containing a set of {@linkplain Attribute}s
 */
public abstract class CMAGSymbol extends CFGSymbol {

    private final List<Attribute> attributes;

    /**
     * Constructor for multiple {@linkplain Attribute}s
     * @param object The object behind the Symbol
     * @param attributes The set of {@linkplain Attribute}s belonging to the symbol
     */
    public CMAGSymbol(Object object, List<Attribute> attributes) {
        super(object);
        this.attributes = attributes;
    }

    /**
     * Constructor for a single {@linkplain Attribute}
     * @param object The object behind the Symbol
     * @param attribute The {@linkplain Attribute} belonging to the symbol
     */
    public CMAGSymbol(Object object, Attribute attribute) {
        super(object);
        this.attributes = Arrays.asList(attribute);
    }

    /**
     * Constructor for multiple {@linkplain Attribute}s
     * @param object The object behind the Symbol
     * @param attributes The set of {@linkplain Attribute}s belonging to the symbol
     * @param id The id (signature of the symbol)
     */
    public CMAGSymbol(Object object, List<Attribute> attributes, UUID id) {
        super(object, id);
        this.attributes = attributes;
    }


    /**
     * Returns all attributes of the symbol
     * @return {@linkplain List} of all {@linkplain Attribute}s
     */
    public List<Attribute> getAttributes() {
        return attributes;
    }

    /**
     * Retrieves an attribute with a given name
     * @param name The name of the {@linkplain Attribute}
     * @return {@linkplain Attribute}
     * @throws ClassNotFoundException Thrown if the {@linkplain Attribute} can't be found by that name
     */
    public Attribute getAttributeWithName(String name) throws ClassNotFoundException {
        for(Attribute a : attributes){
            if(a.getName().equals(name)) return a;
        }
        throw new ClassNotFoundException("The Attribute with name: " + name + " was not found");
    }

    @Override
    public String toString() {
        StringBuilder attributeListString = new StringBuilder();
        for (Attribute a : attributes){
            attributeListString.append(a.getName()).append(" : ").append(a.getValue().toString()).append("; ");
        }
        return "CMAGSymbol{" +
                "attributes=" + attributeListString +
                '}';
    }
}


