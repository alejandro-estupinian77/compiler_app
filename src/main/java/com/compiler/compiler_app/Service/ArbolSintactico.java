package com.compiler.compiler_app.Service;

import org.antlr.v4.runtime.tree.ParseTree;
import java.util.*;


public class ArbolSintactico {
    
     public static Map<String, Object> toMap(ParseTree node) {
        Map<String, Object> result = new HashMap<>();

        result.put("name", getNodeName(node));

        List<Map<String, Object>> children = new ArrayList<>();
        for (int i = 0; i < node.getChildCount(); i++) {
            ParseTree child = node.getChild(i);
            children.add(toMap(child));
        }

        if (!children.isEmpty()) {
            result.put("children", children);
        }

        return result;
    }

    private static String getNodeName(ParseTree node) {
        // Si es hoja (terminal)
        if (node.getChildCount() == 0) {
            return "\"" + node.getText() + "\"";
        }

        // Si es nodo con nombre (no terminal)
        String name = node.getClass().getSimpleName();
        if (name.endsWith("Context")) {
            return name.replace("Context", "");
        }

        return node.getText(); // fallback
    }
}
