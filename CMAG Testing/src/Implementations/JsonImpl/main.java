package Implementations.JsonImpl;

public class main {

    public static void main(String[] args) {

        //Initialise Generator
        JsonRecursiveDescent generator = new JsonRecursiveDescent();

        //Generate the output JSON
        generator.generate(JsonCmag.getCMAG());
    }
}
