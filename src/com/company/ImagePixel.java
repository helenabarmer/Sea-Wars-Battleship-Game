package com.company;

public class ImagePixel {

    // Colours for background
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";
    public static final String BLACK_BACKGROUND = "\033[40m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String RED_BACKGROUND = "\033[41m";

    // Reset colour
    public static final String ANSI_RESET = "\u001B[0m";

    // Colours for String
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK

<<<<<<< HEAD
    public ImagePixel() {
        //menuLogo();
    }





=======
    // Method prints a colorful logo
>>>>>>> master
    public void menuLogo(){

        System.out.println(
                RED_BACKGROUND + BLACK_BOLD +"          WELCOME TO SEA WARS!        " + ANSI_RESET +
                        "\n" +  "\n" +

                        "                     " + ANSI_WHITE_BACKGROUND + "  " +  ANSI_RESET + BLACK_BACKGROUND_BRIGHT + "  " + ANSI_RESET +
                        ANSI_WHITE_BACKGROUND + "  " +  ANSI_RESET +

                        "\n" +
                        "                       " + BLACK_BACKGROUND_BRIGHT + "  " + ANSI_RESET + "\n" +
                        "                       " + BLACK_BACKGROUND_BRIGHT + "  " + ANSI_RESET + "\n" +
                        "                     " + ANSI_WHITE_BACKGROUND + "      " +  ANSI_RESET +
                        "\n" +
                        "                   " + WHITE_BACKGROUND_BRIGHT+ "      " + ANSI_RESET +
                        ANSI_WHITE_BACKGROUND + "  " +  ANSI_RESET +
                        "\n" +
                        "   " + WHITE_BACKGROUND_BRIGHT+ "  " + ANSI_RESET +
                        "      " + WHITE_BACKGROUND_BRIGHT+ "  " + ANSI_RESET +
                        "      " + ANSI_WHITE_BACKGROUND + "        " +  ANSI_RESET +
                        "      " + WHITE_BACKGROUND_BRIGHT+ "  " + ANSI_RESET +

                        "\n" +

                        "     " + WHITE_BACKGROUND_BRIGHT+ "  " + ANSI_RESET +
                        BLACK_BACKGROUND_BRIGHT +  "  " + ANSI_RESET +  "    " +
                        WHITE_BACKGROUND_BRIGHT+ "  " + ANSI_RESET +
                        BLACK_BACKGROUND_BRIGHT +  "  " + ANSI_RESET + "  " +
                        WHITE_BACKGROUND_BRIGHT+ "    " + ANSI_RESET +
                        ANSI_WHITE_BACKGROUND +  "  " + ANSI_RESET +
                        WHITE_BACKGROUND_BRIGHT+ "  " + ANSI_RESET + "  "  +

                        BLACK_BACKGROUND_BRIGHT +  "  " + ANSI_RESET +
                        WHITE_BACKGROUND_BRIGHT+  "  " + ANSI_RESET +
                        "\n" +
                        "   " + BLACK_BACKGROUND_BRIGHT + "      " + ANSI_RESET + "  " + BLACK_BACKGROUND_BRIGHT +"      " +
                        ANSI_RESET  + "  " + ANSI_WHITE_BACKGROUND + "        " +  ANSI_RESET +  "  " + BLACK_BACKGROUND_BRIGHT +
                        "      " + ANSI_RESET + "\n" +
                        " " + BLACK_BACKGROUND   + "                                    " + ANSI_RESET + "\n" +
                        "   " + ANSI_WHITE_BACKGROUND + "        " + ANSI_RESET +"  " +
                        ANSI_WHITE_BACKGROUND + "  " + ANSI_RESET +
                        ANSI_WHITE_BACKGROUND +  ANSI_RESET +"  " +
                        ANSI_WHITE_BACKGROUND + "  " + ANSI_RESET +
                        ANSI_WHITE_BACKGROUND +  ANSI_RESET +"  " +
                        ANSI_WHITE_BACKGROUND + "  " + ANSI_RESET +
                        ANSI_WHITE_BACKGROUND +  ANSI_RESET +"  " +
                        ANSI_WHITE_BACKGROUND +"            " + ANSI_RESET + "\n" +
                        "    " + ANSI_WHITE_BACKGROUND + "                              " + ANSI_RESET + "\n" +
                        "      " + ANSI_WHITE_BACKGROUND + "                            " + ANSI_RESET + "\n" +
                        " " + ANSI_BLUE_BACKGROUND + "                                    " + ANSI_RESET + "\n"
        );
    }



}
