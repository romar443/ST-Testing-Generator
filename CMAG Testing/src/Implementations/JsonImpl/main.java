package Implementations.JsonImpl;

import ConstraintMultisetAttributeGrammar.CMAGSymbol;
import Implementations.CMAGGenerator;

import java.util.List;

public class main {

    public static void main(String[] args) throws Exception {

        //Initialise Generator
        CMAGGenerator jsonGenerator = new CMAGGenerator();

        //Generate the output JSON
        List<CMAGSymbol> output = jsonGenerator.generate(JsonCmag.getCMAG());

        //Pretty print the output
        StringBuilder formattedJson = new StringBuilder();

        for(CMAGSymbol symbol : output){
            symbol.getAttributes().forEach(attribute -> formattedJson.append(attribute.getValue().toString()));
        }

        System.out.println("\n Final JSON: \n\n" + formattedJson);



    }



}
