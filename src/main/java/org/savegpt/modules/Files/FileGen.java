package org.savegpt.modules.Files;
import org.apache.commons.lang3.StringUtils;
import org.savegpt.modules.Runner.GPTConnection;
import org.savegpt.modules.Runner.Main;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileGen {

    private static String PATH = Main.PATH;
    private final String FILE_NAME = "gptFile";
    private static final String[] VALID_LANGS = {"txt", "text","java", "j", "python", "py", "node", "js", "terraform", "tf", "c", "typescript", "ts"};

    public String createFile(String prompt, String fileEx, String fileName, String path){
        String fileExtention;
        String fileContent;
        GPTConnection GPT = new GPTConnection(System.getenv("GPT_TOKEN"));


        try{

            if(prompt.toCharArray().length == 1){
                throw new IllegalArgumentException();
            }

            if(isValidPromptOrFile(fileName)){
            }else{
                fileName = FILE_NAME + "_" + fileEx;
            }

            fileExtention = switch (fileEx) {
                case "java", "j" -> fileName + ".java";
                case "python", "py" -> fileName + ".py";
                case "node", "js" -> fileName + ".js";
                case "terraform", "tf" -> fileName + ".tf";
                case "c" -> fileName + ".c";
                case "ts", "typescript" -> fileName + ".ts";
                default -> fileName + ".txt";
            };

            if(pathIsValid(path)){
                String filePath = path + File.separator + fileExtention;
                if(!fileEx.equalsIgnoreCase("text")) {
                    fileContent = extractString(GPT.authenticateRequest(prompt));
                }else {
                    fileContent = GPT.authenticateRequest(prompt);
                }


                Path pathf = Paths.get(filePath);
                Files.createFile(pathf);
                Files.write(pathf, fileContent.getBytes());

                return "Successfully created File at following PATH:" + filePath;
            }else {
                String filePath = PATH + File.separator + fileExtention;
                if (!fileEx.equalsIgnoreCase("text")) {
                    fileContent = extractString(GPT.authenticateRequest(prompt));
                } else {
                    fileContent = GPT.authenticateRequest(prompt);
                }

                Path paths = Paths.get(filePath);
                Files.createFile(paths);
                Files.write(paths, fileContent.getBytes());

                return "Successfully created File at following PATH:" + filePath;
            }

        }catch (Exception e){

            return e.getMessage();

        }


    }


    private static String extractString(String input) {
        return StringUtils.substringBetween(input, "```", "```");
    }



    private static boolean pathIsValid(String path) {
        try {
            Paths.get(path);
        } catch (InvalidPathException ex) {
            return false;
        }
        return true;
    }


    public static boolean isValidLang(String lang){

        for(String match: VALID_LANGS){
            if(lang.equalsIgnoreCase(match)){
                return true;
            }
        }

        return false;
    }


    public static boolean isValidPromptOrFile(String prompt){

        if(prompt.length() > 0 && !prompt.isBlank()){
             return true;
        }

        return false;

    }








}
