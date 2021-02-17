package GeneralComponents;

import ContextFreeGrammar.StartSymbol;

import java.util.List;

public class AbstractSymbol<T> {
    /**
     * The underlying object. Can be an instance of the {@linkplain StartSymbol}, a <b>letter</b> of the <b>alphabet</b> or a <b>sentence</b>
     */
    private final T object;

    /**
     * Constructor
     * @param object {{@link #object}}
     */
    public AbstractSymbol(T object){
        this.object = object;
    }

    /**
     * Getter
     * @return {{@link #object}}
     */
    public T getObject(){
        return this.object;
    }

}
