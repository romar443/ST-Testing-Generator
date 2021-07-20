package Implementations.JsonImpl;

import ConstraintMultisetAttributeGrammar.*;
import GeneralComponents.Operators.ArithmeticOperators.RandomIntInRange;
import GeneralComponents.Operators.StringOperators.AssignString;

import java.util.ArrayList;

/**
 * <h1>Json Generation Example</h1>
 * <p></p>
 */
@SuppressWarnings("ALL")
public class JsonExample {

    public static void main(String[] args) {
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

        Attribute separatorAttribute = new Attribute(":", "separatorAttribute");
        CMAGTerminalSymbol separator = new CMAGTerminalSymbol(":", separatorAttribute);

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
        CMAGTerminalSymbol classNameValue = new CMAGTerminalSymbol("\"chatty.util.settings.Setting\"", new ArrayList<>());

        //methodNameValue
        Attribute methodNameValueAttribute = new Attribute("", "methodNameValueAttribute");
        CMAGTerminalSymbol methodNameValue = new CMAGTerminalSymbol("methodNameValue", methodNameValueAttribute);

        AttributeRule methodNameRule = new AttributeRule("\"copyCollection\"", new AssignString(), "methodNameValueAttribute", methodNameValue);
        AttributeRule methodNameRule2 = new AttributeRule("\"getType\"", new AssignString(), "methodNameValueAttribute", methodNameValue);
        AttributeRule methodNameRule3 = new AttributeRule("\"setFile\"", new AssignString(), "methodNameValueAttribute", methodNameValue);


        //Special case (see rule 5. of the grammar)
        CMAGNonTerminalSymbol inputArgsTypesArray = new CMAGNonTerminalSymbol("inputArgsTypesArray", new ArrayList<>());

        //inputArgsTypesValue
        Attribute inputArgsTypesValueAttribute = new Attribute("", "inputArgsTypesValueValueAttribute");
        CMAGTerminalSymbol inputArgsTypesValue = new CMAGTerminalSymbol("inputArgsTypesValue", inputArgsTypesValueAttribute);

        AttributeRule inputArgsTypesRule = new AttributeRule("", new AssignString(), "inputArgsTypesValueValueAttribute", inputArgsTypesValue);
        AttributeRule inputArgsTypesRule2 = new AttributeRule("\"java.lang.String\"", new AssignString(), "inputArgsTypesValueValueAttribute", inputArgsTypesValue);
        AttributeRule inputArgsTypesRule3 = new AttributeRule("\"java.util.Collection\"", new AssignString(), "inputArgsTypesValueValueAttribute", inputArgsTypesValue);


        //Special case (see rule 6. of the grammar)
        CMAGNonTerminalSymbol inputArgsArray = new CMAGNonTerminalSymbol("inputArgsArray", new ArrayList<>());

        //inputArgsValue
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


        //returnValueType
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



//        CMAGProduction rule1 = new CMAGProduction();


    }
}



//  1. start        -> openJsonArray, recursive, closeJsonArray

//  2. recursive    -> jsonObject, comma, recursive

//  3. recursive    -> jsonObject

//  4. jsonObject   ->
//      openJsonObject
//      className, separator, classNameValue, comma,
//              ...
//      inputArgsTypes, separator, openJsonArray, inputArgsTypesArray, closeJsonArray, comma
//      inputArgs, separator, openJsonArray, inputArgsArray, closeJsonArray, comma
//      returnValueBranch, comma
//              ...
//      objectHashCode, separator, objectHashCodeValue,
//      closeJsonObject

//  5. inputArgsTypesArray  -> inputArgsTypesValue, comma, inputArgsTypesArray

//  6. inputArgsTypesArray  -> inputArgsTypesValue

//  7. inputArgsArray       -> inputArgsValue, comma, inputArgsArray

//  8. inputArgsArray       -> inputArgsValue

//  9. returnValueBranch    -> returnValueType, separator, returnValueType_Value, comma

//              A.R =    returnValueType_Value.returnValueType_ValueAttribute = "void"

//  10. returnValueBranch    -> returnValueType, separator, returnValueType_Value, comma
//                             returnValue, separator, returnValue_ValueInt, comma

//              A.R =    returnValueTypeValue.returnValueType_ValueAttribute = "int"

//  11. returnValueBranch    -> returnValueType, separator, returnValueType_Value, comma
//                             returnValue, separator, openJsonArray, returnValueArray, closeJsonArray, comma

//             A.R =     returnValueTypeValue.returnValueType_ValueAttribute = "java.util.Collection"

// 12. returnValueArray     -> returnValue_ValueCollection, comma, returnValueArray

// 13. returnValueArray    ->  returnValue_ValueCollection


