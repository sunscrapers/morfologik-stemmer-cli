package morfologik.stemming.polish.cli;


import com.google.gson.Gson;
import morfologik.stemming.WordData;
import morfologik.stemming.polish.PolishStemmer;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class CliTool {

    private final PolishStemmer stemmer;
    private final WoodDataSerializer wordDataSerializer;
    private Reader reader;
    private Writer writer;
    private List<List> tokens;

    public CliTool(PolishStemmer stemmer) {
        this.stemmer = stemmer;
        this.reader = new InputStreamReader(System.in);
        this.writer = new OutputStreamWriter(System.out);
        this.wordDataSerializer = new WoodDataSerializer();
        this.tokens = null;
    }

    public void run() {
        tokens = new LinkedList<>();
        processInput();
        printFormatted();
    }

    public Reader getReader() {
        return reader;
    }

    public Writer getWriter() {
        return writer;
    }

    protected void processInput() {
        BufferedReader reader = new BufferedReader(getReader());
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                processToken(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void processToken(final String token) {
        List<WordData> wordData = stem(token);
        List<Map<String, String>> tokens = wordDataSerializer.serialize(wordData);
        this.tokens.add(tokens);
    }

    protected void printFormatted() {
        PrintWriter writer = new PrintWriter(getWriter());
        Gson gson = new Gson();
        writer.println(gson.toJson(tokens));
        writer.close();
    }

    protected List<WordData> stem(final CharSequence token) {
        return stemmer.lookup(token);
    }
}
