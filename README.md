## SAVEGPT

This repo contains Java file that help devs generate
GPT content locally and create code and text files using 
a command line argument class



# How to run



``cd SaveGPT/src/main/java/org/modules/Runner 
javac Main.java
``

# Commands

- help view command help
- create generates GPT content code/text file locally


# Sub Command [Lang]

- lang dev language for generating code files supports following
- Java parameter: java or j
- text parameter: text or txt
- Node parameter: node or js
- Python parameter: python or py
- Terraform parameter: terraform or tf
- C parameter: c
- typescript parameter: typescript or ts

# Sub Command [prompt]

- provide GPT prompt

# Sub Command  [filename]
- pass in any file name

# Sub Command [Config]
- give new path where the file gets created otherwise creates file where the command is ran


# Example 1

``java Main.java create py "write simple py script"
``

# Example 2

``java Main.java create text myText "write a poem" config user/downloads/dirtest``

# Side notes

This tool is made for devs to run GPT locally and avoids copy pasting and allows 
automation if needed (not yet implemented). 

# Author

@jalpp

