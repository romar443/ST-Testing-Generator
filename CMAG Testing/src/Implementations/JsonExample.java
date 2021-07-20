package Implementations;

import ConstraintMultisetAttributeGrammar.*;
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
        Attribute classNameAttribute = new Attribute("className:", "classNameAttribute");
        CMAGTerminalSymbol className = new CMAGTerminalSymbol("className", classNameAttribute);

        Attribute methodNameAttribute = new Attribute("methodName:", "methodNameAttribute");
        CMAGTerminalSymbol methodName = new CMAGTerminalSymbol("methodName", methodNameAttribute);

        Attribute inputArgsTypesAttribute = new Attribute("inputArgsTypes:", "inputArgsTypesAttribute");
        CMAGTerminalSymbol inputArgsTypes = new CMAGTerminalSymbol("inputArgsTypes", inputArgsTypesAttribute);

        Attribute inputArgsAttribute = new Attribute("inputArgs:", "inputArgsAttribute");
        CMAGTerminalSymbol inputArgs = new CMAGTerminalSymbol("inputArgs", inputArgsAttribute);

        Attribute returnValueTypeAttribute = new Attribute("returnValueType:", "returnValueTypeAttribute");
        CMAGTerminalSymbol returnValueType = new CMAGTerminalSymbol("returnValueType", returnValueTypeAttribute);

        Attribute returnValueAttribute = new Attribute("returnValue:", "returnValueAttribute");
        CMAGTerminalSymbol returnValue = new CMAGTerminalSymbol("returnValue", returnValueAttribute);

        Attribute invocationTimeStampAttribute = new Attribute("invocationTimeStamp:", "invocationTimeStampAttribute");
        CMAGTerminalSymbol invocationTimeStamp = new CMAGTerminalSymbol("invocationTimeStamp", invocationTimeStampAttribute);

        Attribute invocationTimeAttribute = new Attribute("invocationTime:", "invocationTimeAttribute");
        CMAGTerminalSymbol invocationTime = new CMAGTerminalSymbol("invocationTime", invocationTimeAttribute);

        Attribute orderIdAttribute = new Attribute("orderId:", "orderIdAttribute");
        CMAGTerminalSymbol orderId = new CMAGTerminalSymbol("orderId", orderIdAttribute);

        Attribute threadIdAttribute = new Attribute("threadId:", "threadIdAttribute");
        CMAGTerminalSymbol threadId = new CMAGTerminalSymbol("threadId", threadIdAttribute);

        Attribute threadNameAttribute = new Attribute("threadName:", "threadNameAttribute");
        CMAGTerminalSymbol threadName = new CMAGTerminalSymbol("threadName", threadNameAttribute);

        Attribute objectHashCodeAttribute = new Attribute("objectHashCode:", "objectHashCodeAttribute");
        CMAGTerminalSymbol objectHashCode = new CMAGTerminalSymbol("objectHashCode", objectHashCodeAttribute);



    //Json Object values
        //Format: Define Attribute, then the symbol itself. After this, all possible values for the attribute are declared in
        //AttributeRules


        CMAGTerminalSymbol classNameValue = new CMAGTerminalSymbol("chatty.util.settings.Setting", new ArrayList<>());


        Attribute methodNameValueAttribute = new Attribute("", "methodNameValueAttribute");
        CMAGTerminalSymbol methodNameValue = new CMAGTerminalSymbol("methodNameValue", methodNameValueAttribute);
        AttributeRule methodNameRule = new AttributeRule("copyCollection", new AssignString(), "methodNameValueAttribute", methodNameValue);
        AttributeRule methodNameRule2 = new AttributeRule("getType", new AssignString(), "methodNameValueAttribute", methodNameValue);
        AttributeRule methodNameRule3 = new AttributeRule("setFile", new AssignString(), "methodNameValueAttribute", methodNameValue);


        Attribute inputArgsTypesValueAttribute = new Attribute("", "inputArgsTypesValueValueAttribute");
        CMAGTerminalSymbol inputArgsTypesValue = new CMAGTerminalSymbol("inputArgsTypesValue", inputArgsTypesValueAttribute);
        AttributeRule inputArgsTypesRule = new AttributeRule("java.lang.String", new AssignString(), "inputArgsTypesValueValueAttribute", inputArgsTypesValue);
        AttributeRule inputArgsTypesRule2 = new AttributeRule("\"java.util.Collection\"", new AssignString(), "inputArgsTypesValueValueAttribute", inputArgsTypesValue);
        AttributeRule inputArgsTypesRule3 = new AttributeRule("setFile", new AssignString(), "inputArgsTypesValueValueAttribute", inputArgsTypesValue);

    }
}



//  1. start        -> openJsonArray, recursive, closeJsonArray
//  2. recursive    -> jsonObject , recursive
//  3. recursive    -> jsonObject
//  4. jsonObject   ->
//      openJsonObject
//      className, separator, classNameValue, comma,
//              ...
//              ...
//              ...
//      objectHashCode, separator, objectHashCode,
//      closeJsonObject, comma
//
