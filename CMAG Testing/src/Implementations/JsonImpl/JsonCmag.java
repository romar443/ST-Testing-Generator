package Implementations.JsonImpl;

import ConstraintMultisetAttributeGrammar.*;
import GeneralComponents.AbstractSymbol;
import GeneralComponents.Operators.ArithmeticOperators.RandomIntInRange;
import GeneralComponents.Operators.StringOperators.AssignString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <h1>Json Cmag Definition</h1>
 * <p>
 *  The Grammar: <br><br>
 *  1. start        -> openJsonArray, recursive, closeJsonArray
 *<br><br>
 *  2. recursive    -> jsonObject, comma, recursive
 *<br><br>
 *  3. recursive    -> jsonObject
 *<br><br>
 *  4. jsonObject   ->
 *        openJsonObject <br>
 *        className,  colon, classNameValue, comma <br>
 *        methodName,  colon, methodNameValue, comma <br>
 *        inputArgsTypes,  colon, openJsonArray, inputArgsTypesArray, closeJsonArray, comma <br>
 *        inputArgs,  colon, openJsonArray, inputArgsArray, closeJsonArray, comma <br>
 *        returnValueBranch, comma <br>
 *        invocationTimeStamp,  colon, invocationTimeStampValue, comma <br>
 *        invocationTime,  colon, invocationTimeValue, comma <br>
 *        orderId,  colon, orderIdValue, comma <br>
 *        threadId,  colon, threadIdValue, comma <br>
 *        threadName,  colon, threadNameValue, comma <br>
 *        objectHashCode,  colon, objectHashCodeValue <br>
 *        closeJsonObject
 *<br><br>
 *  5. methodNamePlaceholder -> methodNameValue <br>
 *                              AR: methodNameRule
 *<br><br>
 *  6. methodNamePlaceholder -> methodNameValue <br>
 *                              AR: methodNameRule2
 *<br><br>
 *  7. methodNamePlaceholder -> methodNameValue <br>
 *                              AR: methodNameRule3
 *<br><br>
 *  8. inputArgsTypesArray   -> inputArgsTypesPlaceholder, comma, inputArgsTypesArray
 *<br><br>
 *  9. inputArgsTypesArray   -> inputArgsTypesPlaceholder
 *<br><br>
 *  10. inputArgsTypesPlaceholder -> inputArgsTypesValue <br>
 *                              AR: inputArgsTypesRule
 *<br><br>
 *  11. inputArgsTypesPlaceholder -> inputArgsTypesValue <br>
 *                              AR: inputArgsTypesRule2
 *<br><br>
 *  12. inputArgsTypesPlaceholder -> inputArgsTypesValue <br>
 *                              AR: inputArgsTypesRule3
 *<br><br>
 *  13. inputArgsArray        -> inputArgsPlaceholder, comma, inputArgsArray
 *<br><br>
 *  14. inputArgsArray        -> inputArgsPlaceholder
 *<br><br>
 *  15. inputArgsPlaceholder -> inputArgsTypesValue <br>
 *                              AR: inputArgsRule
 *<br><br>
 *  16. inputArgsPlaceholder -> inputArgsTypesValue <br>
 *                              AR: inputArgsRule2
 *<br><br>
 *  17. inputArgsPlaceholder -> inputArgsTypesValue <br>
 *                              AR: inputArgsRule3
 *<br><br>
 *  18. inputArgsPlaceholder -> inputArgsTypesValue <br>
 *                              AR: inputArgsRule4
 *<br><br>
 *  19. inputArgsPlaceholder -> inputArgsTypesValue <br>
 *                              AR: inputArgsRule5
 *<br><br>
 *  20. inputArgsPlaceholder -> inputArgsTypesValue <br>
 *                              AR: inputArgsRule6
 *<br><br>
 *  21. inputArgsPlaceholder -> inputArgsTypesValue <br>
 *                              AR: inputArgsRule7
 *<br><br>
 *  22. returnValueBranch     -> returnValueType,  colon, returnValueType_Value, comma <br>
 *                              A.R = returnValueType_Rule
 *<br><br>
 *  23. returnValueBranch   -> returnValueType,  colon, returnValueType_Value, comma
 *                             returnValue,  colon, returnValue_ValueInt, comma <br>
 *                              A.R = returnValueRule, returnValueType_Rule2
 *<br><br>
 *  24. returnValueBranch    -> returnValueType,  colon, returnValueType_Value, comma
 *                             returnValue,  colon, openJsonArray, returnValueArray, closeJsonArray, comma <br>
 *                              A.R = returnValueType_Rule3
 *<br><br>
 *  25. returnValueArray     -> returnValue_ValueCollection, comma, returnValueArray <br>
 *                              A.R = returnValueRule2
 *<br><br>
 *  26. returnValueArray    ->  returnValue_ValueCollection <br>
 *                              A.R = returnValueRule2
 *</p>
 * <p>The Non-terminal symbol methodNamePlaceholder exists so that 3 productions for the differing attribute rules
 * may be defined. As the production rules are to be randomly executed, a production rule is needed for each, as these
 * are randomly selected and executed by the generator</p>
 */
@SuppressWarnings("ALL")
public class JsonCmag {

    public static CMAG_Gen getCMAG(){

    //Non-terminal Symbols (these have no attributes and are therefore initialised with empty ArrayLists
        CMAGNonTerminalSymbol start = new CMAGNonTerminalSymbol("startSymbol", new ArrayList<>());
        CMAGNonTerminalSymbol recursive = new CMAGNonTerminalSymbol("recursive", new ArrayList<>());
        CMAGNonTerminalSymbol jsonObject = new CMAGNonTerminalSymbol("jsonObject", new ArrayList<>());


    //Terminal symbols for opening and closing arrays and objects as per the json standard
        Attribute openJsonArrayAttribute = new Attribute("[", "openJsonArrayAttribute");
        CMAGTerminalSymbol openJsonArray = new CMAGTerminalSymbol("[", openJsonArrayAttribute);
        Attribute closeJsonArrayAttribute = new Attribute("]", "closeJsonArrayAttribute");
        CMAGTerminalSymbol closeJsonArray = new CMAGTerminalSymbol("]", closeJsonArrayAttribute);

        Attribute openJsonObjectAttribute = new Attribute("{", "openJsonObjectAttribute");
        CMAGTerminalSymbol openJsonObject = new CMAGTerminalSymbol("{", openJsonObjectAttribute);
        Attribute closeJsonObjectAttribute = new Attribute("}", "closeJsonObjectAttribute");
        CMAGTerminalSymbol closeJsonObject = new CMAGTerminalSymbol("}", closeJsonObjectAttribute);

        Attribute colonAttribute = new Attribute(":", " colonAttribute");
        CMAGTerminalSymbol  colon = new CMAGTerminalSymbol(":",  colonAttribute);

        Attribute commaAttribute = new Attribute(",", "commaAttribute");
        CMAGTerminalSymbol comma = new CMAGTerminalSymbol(",", commaAttribute);


    //Json Object keys
        Attribute classNameAttribute = new Attribute("\"className\"", "classNameAttribute");
        CMAGTerminalSymbol className = new CMAGTerminalSymbol("className", classNameAttribute);

        Attribute methodNameAttribute = new Attribute("\"methodName\"", "methodNameAttribute");
        CMAGTerminalSymbol methodName = new CMAGTerminalSymbol("methodName", methodNameAttribute);

        Attribute inputArgsTypesAttribute = new Attribute("\"inputArgsTypes\"", "inputArgsTypesAttribute");
        CMAGTerminalSymbol inputArgsTypes = new CMAGTerminalSymbol("inputArgsTypes", inputArgsTypesAttribute);

        Attribute inputArgsAttribute = new Attribute("\"inputArgs\"", "inputArgsAttribute");
        CMAGTerminalSymbol inputArgs = new CMAGTerminalSymbol("inputArgs", inputArgsAttribute);

        Attribute returnValueTypeAttribute = new Attribute("\"returnValueType\"", "returnValueTypeAttribute");
        CMAGTerminalSymbol returnValueType = new CMAGTerminalSymbol("returnValueType", returnValueTypeAttribute);

        Attribute returnValueAttribute = new Attribute("\"returnValue\"", "returnValueAttribute");
        CMAGTerminalSymbol returnValue = new CMAGTerminalSymbol("returnValue", returnValueAttribute);

        Attribute invocationTimeStampAttribute = new Attribute("\"invocationTimeStamp\"", "invocationTimeStampAttribute");
        CMAGTerminalSymbol invocationTimeStamp = new CMAGTerminalSymbol("invocationTimeStamp", invocationTimeStampAttribute);

        Attribute invocationTimeAttribute = new Attribute("\"invocationTime\"", "invocationTimeAttribute");
        CMAGTerminalSymbol invocationTime = new CMAGTerminalSymbol("invocationTime", invocationTimeAttribute);

        Attribute orderIdAttribute = new Attribute("\"orderId\"", "orderIdAttribute");
        CMAGTerminalSymbol orderId = new CMAGTerminalSymbol("orderId", orderIdAttribute);

        Attribute threadIdAttribute = new Attribute("\"threadId\"", "threadIdAttribute");
        CMAGTerminalSymbol threadId = new CMAGTerminalSymbol("threadId", threadIdAttribute);

        Attribute threadNameAttribute = new Attribute("\"threadName\"", "threadNameAttribute");
        CMAGTerminalSymbol threadName = new CMAGTerminalSymbol("threadName", threadNameAttribute);

        Attribute objectHashCodeAttribute = new Attribute("\"objectHashCode\"", "objectHashCodeAttribute");
        CMAGTerminalSymbol objectHashCode = new CMAGTerminalSymbol("objectHashCode", objectHashCodeAttribute);



    //Json Object values
        //Format: Define Attribute, then the symbol itself. After this, all possible values for the attribute
        // are declared in AttributeRules


        //classNameValue
        Attribute classNameValueAttribute = new Attribute("\"chatty.util.settings.Setting\"", "classNameValueAttribute");
        CMAGTerminalSymbol classNameValue = new CMAGTerminalSymbol("\"chatty.util.settings.Setting\"", classNameValueAttribute);

        //methodNameValue
        CMAGNonTerminalSymbol methodNamePlaceholder = new CMAGNonTerminalSymbol("methodNamePlaceholder", new ArrayList<>());

        Attribute methodNameValueAttribute = new Attribute("", "methodNameValueAttribute");
        CMAGTerminalSymbol methodNameValue = new CMAGTerminalSymbol("methodNameValue", methodNameValueAttribute);

        AttributeRule methodNameRule = new AttributeRule("\"copyCollection\"", new AssignString(), "methodNameValueAttribute", methodNameValue);
        AttributeRule methodNameRule2 = new AttributeRule("\"getType\"", new AssignString(), "methodNameValueAttribute", methodNameValue);
        AttributeRule methodNameRule3 = new AttributeRule("\"setFile\"", new AssignString(), "methodNameValueAttribute", methodNameValue);


        //Special case (see rule 5. of the grammar)
        CMAGNonTerminalSymbol inputArgsTypesArray = new CMAGNonTerminalSymbol("inputArgsTypesArray", new ArrayList<>());

        //inputArgsTypesValue
        CMAGNonTerminalSymbol inputArgsTypesValuePlaceholder = new CMAGNonTerminalSymbol("inputArgsTypesValuePlaceholder", new ArrayList<>());

        Attribute inputArgsTypesValueAttribute = new Attribute("", "inputArgsTypesValueValueAttribute");
        CMAGTerminalSymbol inputArgsTypesValue = new CMAGTerminalSymbol("inputArgsTypesValue", inputArgsTypesValueAttribute);

        AttributeRule inputArgsTypesRule = new AttributeRule("", new AssignString(), "inputArgsTypesValueValueAttribute", inputArgsTypesValue);
        AttributeRule inputArgsTypesRule2 = new AttributeRule("\"java.lang.String\"", new AssignString(), "inputArgsTypesValueValueAttribute", inputArgsTypesValue);
        AttributeRule inputArgsTypesRule3 = new AttributeRule("\"java.util.Collection\"", new AssignString(), "inputArgsTypesValueValueAttribute", inputArgsTypesValue);


        //Special case (see rule 6. of the grammar)
        CMAGNonTerminalSymbol inputArgsArray = new CMAGNonTerminalSymbol("inputArgsArray", new ArrayList<>());

        //inputArgsValue
        CMAGNonTerminalSymbol inputArgsValuePlaceholder = new CMAGNonTerminalSymbol("methodNamePlaceholder", new ArrayList<>());

        Attribute inputArgsValueAttriubte = new Attribute("", "inputArgsValueAttriubte");
        CMAGTerminalSymbol inputArgsValue = new CMAGTerminalSymbol("inputArgsValue", inputArgsValueAttriubte);

        AttributeRule inputArgsRule = new AttributeRule("", new AssignString(), "inputArgsTypesValueValueAttribute", inputArgsValue);
        AttributeRule inputArgsRule2 = new AttributeRule("\"\"", new AssignString(), "inputArgsTypesValueValueAttribute", inputArgsValue);
        AttributeRule inputArgsRule3 = new AttributeRule("\"login\"", new AssignString(), "inputArgsTypesValueValueAttribute", inputArgsValue);
        AttributeRule inputArgsRule4 = new AttributeRule("\"some string\"", new AssignString(), "inputArgsTypesValueValueAttribute", inputArgsValue);
        AttributeRule inputArgsRule5 = new AttributeRule("false", new AssignString(), "inputArgsTypesValueValueAttribute", inputArgsValue);
        AttributeRule inputArgsRule6 = new AttributeRule("6697", new AssignString(), "inputArgsTypesValueValueAttribute", inputArgsValue);
        AttributeRule inputArgsRule7 = new AttributeRule("443", new AssignString(), "inputArgsTypesValueValueAttribute", inputArgsValue);


        //Special case (see rule 7. - 9. of the grammar)
        CMAGNonTerminalSymbol returnValueBranch = new CMAGNonTerminalSymbol("returnValueArray", new ArrayList<>());

        //Special case (see rule 10. of the grammar)
        CMAGNonTerminalSymbol returnValueArray = new CMAGNonTerminalSymbol("inputArgsArray", new ArrayList<>());

        //returnValueType
        Attribute returnValueType_ValueAttribute = new Attribute("", "returnValueTypeValueAttribute");
        CMAGTerminalSymbol returnValueType_Value = new CMAGTerminalSymbol("returnValueTypeValue", returnValueType_ValueAttribute);

        AttributeRule returnValueType_Rule = new AttributeRule("\"void\"", new AssignString(), "returnValueTypeValueAttribute", returnValueType_Value);
        AttributeRule returnValueType_Rule2 = new AttributeRule("\"int\"", new AssignString(), "returnValueTypeValueAttribute", returnValueType_Value);
        AttributeRule returnValueType_Rule3 = new AttributeRule("\"java.util.Collection\"", new AssignString(), "returnValueTypeValueAttribute", returnValueType_Value);


        //returnValue
        Attribute returnValue_ValueAttribute = new Attribute(500, "returnValue_ValueAttribute");
        CMAGTerminalSymbol returnValue_ValueInt = new CMAGTerminalSymbol("returnValueValue", returnValue_ValueAttribute);
        CMAGTerminalSymbol returnValue_ValueCollection = new CMAGTerminalSymbol("returnValueValue", returnValue_ValueAttribute);

        AttributeRule returnValueRule = new AttributeRule(500, new RandomIntInRange(), "returnValue_ValueAttribute", returnValue_ValueInt);
        AttributeRule returnValueRule2 = new AttributeRule(500, new RandomIntInRange(), "returnValue_ValueAttribute", returnValue_ValueCollection);


        //invocationTimeStamp
        Attribute invocationTimeStampValueAttribute = new Attribute(600000000, "invocationTimeStampValueAttribute");
        CMAGTerminalSymbol invocationTimeStampValue = new CMAGTerminalSymbol("invocationTimeStampValue", invocationTimeStampValueAttribute);
        AttributeRule invocationTimeStampRule = new AttributeRule(1000000, new RandomIntInRange(), "invocationTimeStampValue", invocationTimeStampValue);


        //invocationTime
        Attribute invocationTimeValueAttribute = new Attribute(900, "invocationTimeValueAttribute");
        CMAGTerminalSymbol invocationTimeValue = new CMAGTerminalSymbol("invocationTimeValue", invocationTimeValueAttribute);
        AttributeRule invocationTimeRule = new AttributeRule(1000, new RandomIntInRange(), "invocationTimeValue", invocationTimeValue);


        //orderId
        Attribute orderIdValueAttribute = new Attribute(100, "orderIdValueAttribute");
        CMAGTerminalSymbol orderIdValue = new CMAGTerminalSymbol("orderIdValue", orderIdValueAttribute);
        AttributeRule orderIdValueRule = new AttributeRule(50, new RandomIntInRange(), "orderIdValue", orderIdValue);


        //threadId
        Attribute threadIdValueAttribute = new Attribute(1, "threadIdValueAttribute");
        CMAGTerminalSymbol threadIdValue = new CMAGTerminalSymbol("threadIdValue", threadIdValueAttribute);


        //threadName
        Attribute threadNameValueAttribute = new Attribute("", "threadNameValueAttribute");
        CMAGTerminalSymbol threadNameValue = new CMAGTerminalSymbol("threadNameValue", threadNameValueAttribute);
        AttributeRule threadNameRule = new AttributeRule("\"main\"", new AssignString(), "threadNameValue", threadNameValue);


        //objectHashCode
        Attribute objectHashCodeValueAttribute = new Attribute(1735853116, "objectHashCodeValueAttribute");
        CMAGTerminalSymbol objectHashCodeValue = new CMAGTerminalSymbol("objectHashCodeValue", objectHashCodeValueAttribute);
        AttributeRule objectHashCodeRule = new AttributeRule(10000000, new RandomIntInRange(), "objectHashCodeValue", objectHashCodeValue);


    //Production Rules

        //Rule 1
        CMAGProduction rule1 = new CMAGProduction(start, Arrays.asList(openJsonArray, recursive, closeJsonArray));

        //Rule 2
        CMAGProduction rule2 = new CMAGProduction(recursive, Arrays.asList(jsonObject, comma, recursive));

        //Rule 3
        CMAGProduction rule3 = new CMAGProduction(recursive, Collections.singletonList(jsonObject));

        //Rule 4
        List<AbstractSymbol> jsonObjectBody= new ArrayList<>();

        jsonObjectBody.add(openJsonObject);
        jsonObjectBody.addAll(Arrays.asList(className,  colon, classNameValue, comma));
        jsonObjectBody.addAll(Arrays.asList(methodName,  colon, methodNameValue, comma));
        jsonObjectBody.addAll(Arrays.asList(inputArgsTypes,  colon, openJsonArray, inputArgsTypesArray, closeJsonArray, comma));
        jsonObjectBody.addAll(Arrays.asList(inputArgs,  colon, openJsonArray, inputArgsArray, closeJsonArray, comma));
        jsonObjectBody.addAll(Arrays.asList(returnValueBranch, comma));
        jsonObjectBody.addAll(Arrays.asList(invocationTimeStamp,  colon, invocationTimeStampValue, comma));
        jsonObjectBody.addAll(Arrays.asList(invocationTime,  colon, invocationTimeValue, comma));
        jsonObjectBody.addAll(Arrays.asList(orderId,  colon, orderIdValue, comma));
        jsonObjectBody.addAll(Arrays.asList(threadId,  colon, threadIdValue, comma));
        jsonObjectBody.addAll(Arrays.asList(threadName,  colon, threadNameValue, comma));
        jsonObjectBody.addAll(Arrays.asList(objectHashCode,  colon, objectHashCodeValue));
        jsonObjectBody.add(closeJsonObject);

        CMAGProduction rule4 = new CMAGProduction(jsonObject, jsonObjectBody);

        //Rule 5
        CMAGProduction rule5 = new CMAGProduction(methodNamePlaceholder, Collections.singletonList(methodNameValue), new ArrayList<>(), methodNameRule);

        //Rule 6
        CMAGProduction rule6 = new CMAGProduction(methodNamePlaceholder, Collections.singletonList(methodNameValue), new ArrayList<>(), methodNameRule2);

        //Rule 7
        CMAGProduction rule7 = new CMAGProduction(methodNamePlaceholder, Collections.singletonList(methodNameValue), new ArrayList<>(), methodNameRule3);

        //Rule 8
        CMAGProduction rule8 = new CMAGProduction(inputArgsTypesArray, Arrays.asList(inputArgsTypesValuePlaceholder, comma, inputArgsTypesArray));

        //Rule 9
        CMAGProduction rule9 = new CMAGProduction(inputArgsTypesArray, Collections.singletonList(inputArgsTypesValuePlaceholder));

        //Rule 10
        CMAGProduction rule10 = new CMAGProduction(inputArgsTypesValuePlaceholder, Collections.singletonList(inputArgsTypesValue), new ArrayList<>(), inputArgsTypesRule);

        //Rule 11
        CMAGProduction rule11 = new CMAGProduction(inputArgsTypesValuePlaceholder, Collections.singletonList(inputArgsTypesValue), new ArrayList<>(), inputArgsTypesRule2);

        //Rule 12
        CMAGProduction rule12 = new CMAGProduction(inputArgsTypesValuePlaceholder, Collections.singletonList(inputArgsTypesValue), new ArrayList<>(), inputArgsTypesRule3);

        //Rule 13
        CMAGProduction rule13 = new CMAGProduction(inputArgsArray, Arrays.asList(inputArgsValuePlaceholder, comma,  inputArgsArray));

        //Rule 14
        CMAGProduction rule14 = new CMAGProduction(inputArgsArray, Collections.singletonList(inputArgsValuePlaceholder));

        //Rule 15
        CMAGProduction rule15 = new CMAGProduction(inputArgsValuePlaceholder, Collections.singletonList(inputArgsValue), new ArrayList<>(), inputArgsRule);

        //Rule 16
        CMAGProduction rule16 = new CMAGProduction(inputArgsValuePlaceholder, Collections.singletonList(inputArgsValue), new ArrayList<>(), inputArgsRule2);

        //Rule 17
        CMAGProduction rule17 = new CMAGProduction(inputArgsValuePlaceholder, Collections.singletonList(inputArgsValue), new ArrayList<>(), inputArgsRule3);

        //Rule 18
        CMAGProduction rule18 = new CMAGProduction(inputArgsValuePlaceholder, Collections.singletonList(inputArgsValue), new ArrayList<>(), inputArgsRule4);

        //Rule 19
        CMAGProduction rule19 = new CMAGProduction(inputArgsValuePlaceholder, Collections.singletonList(inputArgsValue), new ArrayList<>(), inputArgsRule5);

        //Rule 20
        CMAGProduction rule20 = new CMAGProduction(inputArgsValuePlaceholder, Collections.singletonList(inputArgsValue), new ArrayList<>(), inputArgsRule6);

        //Rule 21
        CMAGProduction rule21 = new CMAGProduction(inputArgsValuePlaceholder, Collections.singletonList(inputArgsValue), new ArrayList<>(), inputArgsRule7);

        //Rule 22
        CMAGProduction rule22 = new CMAGProduction(returnValueBranch, Arrays.asList(returnValueType,  colon, returnValueType_Value, comma), new ArrayList<>(), returnValueType_Rule);

        //Rule 23
        CMAGProduction rule23 = new CMAGProduction(returnValueBranch, Arrays.asList(returnValueType,  colon, returnValueType_Value, comma, returnValue,  colon, returnValue_ValueInt, comma), new ArrayList<>(), Arrays.asList(returnValueRule, returnValueType_Rule2));

        //Rule 24
        CMAGProduction rule24 = new CMAGProduction(returnValueBranch, Arrays.asList(returnValueType,  colon, returnValueType_Value, comma, returnValue,  colon, openJsonArray, returnValueArray, closeJsonArray, comma), new ArrayList<>(), returnValueType_Rule3);

        //Rule 25
        CMAGProduction rule25 = new CMAGProduction(returnValueArray, Arrays.asList(returnValue_ValueCollection, comma, returnValueArray), new ArrayList<>(), returnValueRule2);

        //Rule 26
        CMAGProduction rule26 = new CMAGProduction(returnValueArray, Collections.singletonList(returnValue_ValueCollection), new ArrayList<>(), returnValueRule2);




        //Define CMAG
        List<CMAGProduction> productions= new ArrayList<>();
        productions.addAll(Arrays.asList(rule1, rule2, rule3, rule4, rule5, rule6, rule7, rule8, rule9, rule10, rule11, rule12,
                rule13, rule14, rule15, rule16, rule17, rule18, rule19, rule20, rule21, rule22, rule23, rule24, rule25, rule26));

        CMAG_Gen jsonCmag = new CMAG_Gen(start, productions);

        return jsonCmag;
    }
}
