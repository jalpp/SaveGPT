package org.savegpt.modules.Runner;

import org.savegpt.modules.Files.FileGen;

public class Main {
    public static String PATH = System.getProperty("user.dir");
    public static void main(String[] args) {
        FileGen generate = new FileGen();

        switch (args[0]){
            // create python [filename] "prompt"
            case "create":

                if(args.length == 4 || args.length == 6 && FileGen.isValidLang(args[1]) && FileGen.isValidPromptOrFile(args[3]) && FileGen.isValidPromptOrFile(args[2])) {

                    if (args.length == 6 && args[4] != null && args[4].equalsIgnoreCase("config") && args[5] != null && !args[5].equals("")) {
                        System.out.println(generate.createFile(args[3], args[1], args[2], args[5]));
                        System.exit(0);
                    }else {
                        System.out.println(generate.createFile(args[3], args[1], args[2], PATH));
                        System.exit(0);

                    }

                }else {
                    System.out.println("Invalid Params: Please follow java Main.java create [lang] [filename] [prompt] or type java Main.java help for more info");
                    System.exit(1);
                }
            break;



            case "help":
                System.out.println("SaveGPT Commands: " +
                        "\n" +
                        "java Main.java create [lang] [prompt]\n" +
                        "[lang] the prompt's lang type file: ex: java, python, node. default text file." +
                        "\n [promp] enter quoted prompt Ex: \"add 2 + 2 in java\"" +
                        "\n" +
                        "java Main.java create [lang] [prompt] [filename] config [PATH_VALUE]\n" +
                        "[PATH_VALUE] default value set to current path in SaveGPT dir\n" +
                        "change accordingly." +
                        "\n" +
                        "java Main.java help \n" +
                        "View SaveGPT help command");
                System.exit(0);
                break;
        }

    }
}