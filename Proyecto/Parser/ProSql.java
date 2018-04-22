import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import java.util.*;
import java.io.*;


public class ProSql {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        if ( args.length == 0 ) {
            System.out.println("Error: You need to introduce the path to your file as an argument");
        } else {
            getTokens(args[0]);
        }

    }

    public static void getTokens(String pathToFile) {

        deleteError();
        deleteOutput();

        if ( !isLexerCompiled() ) {
            compileLexer();
            checkSyntaxAndGetTokens(pathToFile);
        } else {
            checkSyntaxAndGetTokens(pathToFile);
        }

        if ( doesFileHasSyntaxError() ) {
            printError();
            deleteError();
            deleteOutput();
        } else {
            deleteError();
            deleteOutput();
        }

    }

    public static void checkSyntaxAndGetTokens(String path) {
        try {
            Runtime rt = Runtime.getRuntime();
            String[] command = {"./mylexer"};
            ProcessBuilder pb = new ProcessBuilder(command);
            pb.directory(new File("../Lexer"));
            pb.redirectInput(new File(path));
            pb.redirectOutput(new File("output.txt"));
            pb.redirectError(new File("error.txt"));
            Process pr = pb.start();
            pr.waitFor();
        }catch(Exception e) {
            System.out.println(e);
        }
    }

    public static String compileLexer() {
        String s = null;
        StringBuilder sb = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            //gcc mylexer.c lex.yy.c -o mylexer
            String[] command = {"gcc", "mylexer.c", "lex.yy.c", "-o", "mylexer"};
            ProcessBuilder pb = new ProcessBuilder(command);
            pb.directory(new File("../Lexer"));
            Process pr = pb.start();
            BufferedReader stdInput = new BufferedReader(new
                 InputStreamReader(pr.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                 InputStreamReader(pr.getErrorStream()));

            // read the output from the command
            //System.out.println("Here is the standard output of the command:\n");
            /*while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }*/

            // read any errors from the attempted command
            //System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                //System.out.println(s);
                sb.append(s+"\n");
            }
        }catch(Exception e) {
            System.out.println(e);
        }
        return (sb.toString().length() > 0)? sb.toString() : "";
    }

    public static boolean isLexerCompiled() {

        File f = new File("../Lexer/mylexer");
        return f.exists();

    }

    public static boolean doesFileHasSyntaxError() {
        boolean b = false;
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("error.txt")));
            String line = null;
            while ((line = br.readLine()) != null) {
              b = true;
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return b;
    }

    public static void deleteError() {
        File f = new File("error.txt");
        if ( f.exists() ) {
            f.delete();
        }
    }

    public static void deleteOutput() {
        File f = new File("output.txt");
        if ( f.exists() ) {
            f.delete();
        }
    }

    public static void printError() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("error.txt")));
            String line = null;
            while ((line = br.readLine()) != null) {
              System.out.println(line);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }

}
