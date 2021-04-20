package GeneralComponents;

import java.util.List;

/**
 * <p>An abstract implementation of a production of the form: </p>
 * RuleHead -> RuleBody
 *
 * <p>Where the RuleBody can be any number finite of symbols</p>
 * <p>A production replaces the RuleHead of the rule with the symbols in the body; it is effectively a state change.</p>
 */
public abstract class AbstractProduction {

    private AbstractSymbol ruleHead;

    private List<AbstractSymbol> ruleBody;

    public AbstractProduction(AbstractSymbol ruleHead, List<AbstractSymbol> ruleBody){
        this.ruleHead = ruleHead;
        this.ruleBody = ruleBody;
    }

    public AbstractSymbol getRuleHead() {
        return ruleHead;
    }

    public List<AbstractSymbol> getRuleBody() {
        return ruleBody;
    }

    public AbstractSymbol getRuleBodySymbol(int position){
        return getRuleBody().get(position);
    }

    /**
     * <p>Applies the production to the symbol passed as an argument. The argument musst match the rule head, for the production to be applicable, as
     * tested for in {@linkplain AbstractProduction#applicable(AbstractSymbol)}</p>
     * @param symbol Some {@linkplain AbstractSymbol}
     * @return The {@linkplain #ruleBody}
     * @Exception When the production is not applicable, an exception is thrown
     */
    public abstract List<AbstractSymbol> applyProduction(AbstractSymbol symbol) throws Exception;

    /**
     * <p>Checks whether the symbol passed as an argument is equal to the rule head. As the symbols differ between CFG's and CMAG's,
     * this method must remain empty and abstract</p>
     * @param symbol Some {@linkplain AbstractSymbol}
     * @return Boolean, indicating whether the production is applicable
     */
    public abstract Boolean applicable(AbstractSymbol symbol);
}
