package GeneralComponents;

import java.util.List;

public class AbstractProduction<T> {

    private T ruleHead;

    private List<T> ruleBody;

    public AbstractProduction(T ruleHead, List<T> ruleBody){
        this.ruleHead = ruleHead;
        this.ruleBody = ruleBody;
    }

    public T getRuleHead() {
        return ruleHead;
    }

    public List<T> getRuleBody() {
        return ruleBody;
    }
}
