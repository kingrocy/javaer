package com.yunhui.parse.main;
import com.yunhui.parse.generated.test.TestLexer;
import com.yunhui.parse.generated.test.TestParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * @Date : 2020/6/4 3:57 下午
 * @Author : dushaoyun
 */
public class Main {

    public static void main(String[] args) {

        CharStream input = CharStreams.fromString("4");
        TestLexer lexer = new TestLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TestParser parser = new TestParser(tokens);
        ParseTree tree = parser.calc();
        System.out.println(tree.toStringTree(parser));


        TestVisitor eval = new TestVisitor();
        eval.visit(tree);
    }
}
