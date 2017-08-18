package morfologik.stemming.polish.cli;

import morfologik.stemming.WordData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WoodDataSerializer {

    public final List<Map<String, String>> serialize(final List<WordData> wordData) {
        List<Map<String, String>> result = new ArrayList<>(wordData.size());
        for (WordData word : wordData) {
            Map<String, String> data = new HashMap<>();
            data.put("word", word.getWord().toString());
            data.put("stem", word.getStem().toString());
            data.put("tag", word.getTag().toString());
            result.add(data);
        }
        return result;
    }
}
