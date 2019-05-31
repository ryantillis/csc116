/**
 * Ascii art project
 *
 * @author Thomas Tillis
 */
public class Art {
    /**
     * Starts the program.
     * 
     * @param args command line arguments
     */

    //https://www.asciiart.eu/space/planets
    //https://www.reddit.com/r/rickandmorty/comments/3rmsgf/does_anyone_have_the_ascii_art_of_the_head_saying/
    //https://www.asciiart.eu/weapons/explosives

    public static void main(String[] args) {
        printCromulon("Show me what you got.");
        printEarthPlayingMusic();
        printCromulon("DISQUALIFIED!");
        printExplosion();

    }

    /**
     * Prints a cromulon (big head) with a speech bubble defined by param
     * 
     * @param cromulonSayWhat String that defines what the cromulon (big head) says
     */

    public static void printCromulon(String cromulonSayWhat) {
        System.out.println();
        System.out.println("        ___          ");
        System.out.println("    . -^   `--,      ");
        System.out.println("   /# =========`-_   ");
        System.out.println("  /# (--====___====\\ ");
        System.out.println(" /#   .- --.  . --.| ");
        System.out.println("/##   |  * ) (   * ),");
        System.out.println("|##   \\    /\\ \\   / |");
        System.out.println("|###   ---   \\ ---  |");
        System.out.println("|####      ___)    #|    _______________________");
        System.out.println("|######           ##|  /                        |");
        //Uses printf to ensure that the speech bubble lines up regardless of text
        System.out.printf("%-47s"," \\##### ---------- /  < \"" + cromulonSayWhat + "\"");
        System.out.print(" |\n");
        System.out.println("  \\####           (    \\________________________|");
        System.out.println("   `\\###          |  ");
        System.out.println("     \\###         |  ");
        System.out.println("      \\##        |   ");
        System.out.println("       \\###.    .)   ");
        System.out.println("        `======/     ");
    }

    /**
     * Prints an ascii earth playing music
     */

    public static void printEarthPlayingMusic() {
        System.out.println();
        System.out.println("           _____       ");
        System.out.println("        .-'.  ':'-.    ");
        System.out.println("      .''::: .:    '.  ");
        System.out.println("     /   :::::'      \\ "); 
        System.out.println("    ;.    ':' `       ;    _______________________");
        System.out.println("    |       '..       |   /                       |");
        System.out.println("    ;'        ::::.   ;  <  *Taylor Swift playing |");
        System.out.println("     \\       '::::   /    \\_______________________|");
        System.out.println("      '.      :::  .'  ");
        System.out.println("        '-.___'_.-'    ");
    }
    /**
     * Prints an ascii explosion
     */

    public static void printExplosion(){
        System.out.println();
        System.out.println("       _.-^^---....,,--       ");
        System.out.println("   _--                  --_   ");
        System.out.println("  <                        >) ");
        System.out.println("  |                         | ");
        System.out.println("   \\._                   _./  ");
        System.out.println("      ```--. . , ; .--'''     ");  
        System.out.println("            | |   |           ");
        System.out.println("         .-=||  | |=-.        ");
        System.out.println("         `-=#$%&%$#=-'        ");
        System.out.println("            | ;  :|           ");
        System.out.println("   _____.,-#%&$@%#&#~,._____  ");
        System.out.println();
    }

}