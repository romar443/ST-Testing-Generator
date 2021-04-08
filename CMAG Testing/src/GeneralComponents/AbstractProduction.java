package GeneralComponents;

import java.util.List;

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

    public abstract List<AbstractSymbol> applyProduction(AbstractSymbol nonTerminal) throws Exception;

    public abstract Boolean applicable(AbstractSymbol nonTerminal);
}
