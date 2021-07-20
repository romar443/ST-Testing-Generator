package GeneralComponents;

import java.util.UUID;

/**
 * An abstract representation of a grammar symbol.
 * @param <T> Generic of type T
 */
public abstract class AbstractSymbol<T> {
    /**
     * The underlying object. Can be an instance of the {@linkplain StartSymbol}, a <b>letter</b> of the <b>alphabet</b> or a <b>sentence</b>
     */
    private final T object;

    /**
     * The id needed to retrieve the same symbol. Copies are created in productions, so that attributes may be changed, without altering
     * the states of other copies of the same symbol
     */
    private UUID id;

    /**
     * Constructor
     * @param object {{@link #object}}
     */
    public AbstractSymbol(T object){
        this.object = object;
        this.id = UUID.randomUUID();
        System.out.println("New symbol defined with name: " + this.getClass().getName() + " and id: " + this.id);
    }

    public AbstractSymbol(T object, UUID id){
        this.object = object;
        this.id = id;
    }

    /**
     * Getter
     * @return {{@link #object}}
     */
    public T getObject(){
        return this.object;
    }

    /**
     * Getter
     * @return {{@link #id}}
     */
    public UUID getId(){
        return this.id;
    }

    public abstract AbstractSymbol clone();


}
