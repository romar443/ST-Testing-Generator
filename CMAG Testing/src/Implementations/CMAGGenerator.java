package Implementations;

import ConstraintMultisetAttributeGrammar.*;
import GeneralComponents.AbstractSymbol;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CMAGGenerator {

    public List<CMAGSymbol> generate(CMAG_Gen cmag) throws Exception {


        List<CMAGProduction> listOfProductions = cmag.getCmagProductions();

        //The list to contain all symbols created during generation,
        List<CMAGSymbol> listOfSymbols = new ArrayList<>();

        //Add the start symbol
        listOfSymbols.add(cmag.getStartSymbol());


        boolean nonTerminalRemains = true;

        //While non-terminal symbols remain in the list, continue
        while(nonTerminalRemains){

            //Second list to used to put the results of generation into and a tracker for position
            List<CMAGSymbol> listOfSymbolsAfterProduction = new ArrayList<>();
            int position = 0;


            //Iterate through list of symbols
            for(CMAGSymbol cmagSymbol : listOfSymbols){

                //If symbols is terminal, add to second list
                if(cmagSymbol instanceof CMAGTerminalSymbol){
                    listOfSymbolsAfterProduction.add(position, cmagSymbol);
                    position++;
                }

                //Else the symbol is a non-terminal and a production rule is applied to it at random
                else{
                    //Cast CMAGSymbol to CMAGNonTerminalSymbol
                    CMAGNonTerminalSymbol nonTerminalSymbol = (CMAGNonTerminalSymbol) cmagSymbol;

                    //List of productions which are applicable to the given non-terminal symbol
                    List<CMAGProduction> listOfApplicableProductions = new ArrayList();

                    for(CMAGProduction production : listOfProductions){
                        if(production.applicable(cmagSymbol)){
                            listOfApplicableProductions.add(production);
                        }
                    }

                    //pick random production from list
                    Random rand = new Random();
                    CMAGProduction randomProduction = listOfApplicableProductions.get(rand.nextInt(listOfApplicableProductions.size()));

                    //get the result of the production (rule body)
                    List<AbstractSymbol> ruleBody = randomProduction.applyProduction(nonTerminalSymbol);


                    //add the symbols from the rule body to the list
                    for(AbstractSymbol abstractSymbol : ruleBody){
                        listOfSymbolsAfterProduction.add(position, (CMAGSymbol) abstractSymbol);
                        position++;
                    }
                }
            }




            //
            //Pretty print the output
            StringBuilder formattedJson = new StringBuilder();

            for(CMAGSymbol symbol : listOfSymbolsAfterProduction){
                symbol.getAttributes().forEach(attribute -> formattedJson.append(attribute.getValue().toString()));
            }

            System.out.println(formattedJson);





            //Update the listOfSymbols with those created from production rules
            listOfSymbols = listOfSymbolsAfterProduction;

            //break randomly to prevent infinite execution
            if(Math.random() > 0.98){
                System.out.println("\n BREAK \n");
                break;
            }

            //Check if any non-terminal symbols remain in the list after production rules
            nonTerminalRemains = nonTerminalRemains(listOfSymbols);
        }


        //Return the result
        return listOfSymbols;

    }


    /**
     * Checks the list for any {@linkplain CMAGNonTerminalSymbol}s
     * @param listOfSymbols {@linkplain List} of {@linkplain CMAGSymbol}s
     * @return boolean
     */
    public boolean nonTerminalRemains(List<CMAGSymbol> listOfSymbols){
        return listOfSymbols.stream().anyMatch(cmagSymbol -> cmagSymbol instanceof CMAGNonTerminalSymbol);
    }
}
