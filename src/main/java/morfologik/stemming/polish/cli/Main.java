package morfologik.stemming.polish.cli;


import morfologik.stemming.polish.PolishStemmer;

public class Main {

    public static void main(String[] args) {
        PolishStemmer stemmer = new PolishStemmer();
        CliTool cliTool = new CliTool(stemmer);
        cliTool.run();
    }
}
