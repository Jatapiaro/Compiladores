# To install and be able to run antlr4 command everywhere


1. Open terminal
2. run (`$ cd /usr/local/lib`)
3. run (`sudo curl -O http://www.antlr.org/download/antlr-4.5.3-complete.jar`)
4. Open ~/.bash_profile (`$ vi ~/.bash_profile`)
5. Paste the following at the end of the file
    ```
    export CLASSPATH=".:/usr/local/lib/antlr-4.5.3-complete.jar:$CLASSPATH"
    alias antlr4='java -jar /usr/local/lib/antlr-4.5.3-complete.jar'
    alias grun='java org.antlr.v4.gui.TestRig'
    ```
6. Close and save the file
7. Restart your terminal
