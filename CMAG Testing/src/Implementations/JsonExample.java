package Implementations;

import ConstraintMultisetAttributeGrammar.Attribute;
import ConstraintMultisetAttributeGrammar.CMAGNonTerminalSymbol;
import ConstraintMultisetAttributeGrammar.CMAGProduction;
import ConstraintMultisetAttributeGrammar.CMAGTerminalSymbol;

import java.util.ArrayList;

public class JsonExample {

    public static void main(String[] args) {

    //Terminal symbols for opening and closing arrays and objects as per the json standard
        CMAGTerminalSymbol openJsonArray = new CMAGTerminalSymbol("[", new ArrayList<>());
        CMAGTerminalSymbol closeJsonArray = new CMAGTerminalSymbol("]", new ArrayList<>());

        CMAGTerminalSymbol openJsonObject = new CMAGTerminalSymbol("{", new ArrayList<>());
        CMAGTerminalSymbol closeJsonObject = new CMAGTerminalSymbol("}", new ArrayList<>());

    //Non-terminal Symbols for values
        Attribute string = new Attribute("string", "valueString");
        CMAGNonTerminalSymbol valueIsString = new CMAGNonTerminalSymbol("string", string);

    //Json Object keys
        CMAGTerminalSymbol className = new CMAGTerminalSymbol("className", new ArrayList<>());
        CMAGTerminalSymbol methodName = new CMAGTerminalSymbol("methodName", new ArrayList<>());
        CMAGTerminalSymbol inputArgsTypes = new CMAGTerminalSymbol("inputArgsTypes", new ArrayList<>());
        CMAGTerminalSymbol inputArgs = new CMAGTerminalSymbol("inputArgs", new ArrayList<>());
        CMAGTerminalSymbol returnValueType = new CMAGTerminalSymbol("returnValueType", new ArrayList<>());
        CMAGTerminalSymbol returnValue = new CMAGTerminalSymbol("returnValue", new ArrayList<>());
        CMAGTerminalSymbol invocationTimeStamp = new CMAGTerminalSymbol("invocationTimeStamp", new ArrayList<>());
        CMAGTerminalSymbol invocationTime = new CMAGTerminalSymbol("invocationTime", new ArrayList<>());
        CMAGTerminalSymbol orderId = new CMAGTerminalSymbol("orderId", new ArrayList<>());
        CMAGTerminalSymbol threadId = new CMAGTerminalSymbol("threadId", new ArrayList<>());
        CMAGTerminalSymbol threadName = new CMAGTerminalSymbol("threadName", new ArrayList<>());
        CMAGTerminalSymbol objectHashCode = new CMAGTerminalSymbol("objectHashCode", new ArrayList<>());


    //Json Object values
        //className Values
        CMAGTerminalSymbol classNameSettings = new CMAGTerminalSymbol("chatty.util.settings.Setting", new ArrayList<>());

        CMAGTerminalSymbol methodNameCopyCollection = new CMAGTerminalSymbol("copyCollection", new ArrayList<>());
        CMAGTerminalSymbol methodNameGetType = new CMAGTerminalSymbol("getType", new ArrayList<>());
        CMAGTerminalSymbol methodNameSetFile = new CMAGTerminalSymbol("setFile", new ArrayList<>());
    }







//    Start -> [N]
//    N -> JSONObj , N
//    [ JSONobj , N]
//
//    // JSONObj ->
//        "className": "chatty.util.settings.Setting",
//                "methodName": "NT",
//                "inputArgsTypes": [
//                "NT"
//                ],
//                "inputArgs": [
//                [NT1]
//                ],
//                "returnValueType": NT,
//                "returnValue": [NT1],
//                "invocationTimeStamp": NT,
//                "invocationTime": NT,
//                "orderId": NT,
//                "threadId": NT,
//                "threadName": NT,
//                "objectHashCode": NT
//
//
//
//
}
