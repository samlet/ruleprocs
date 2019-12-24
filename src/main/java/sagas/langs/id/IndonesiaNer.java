package sagas.langs.id;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import yusufs.nlp.nerid.IndonesiaNER;
import yusufs.nlp.nerid.utils.TextSequence;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class IndonesiaNer {
    private IndonesiaNER iner;
    private Gson gson;
    public IndonesiaNer(){
        iner = new IndonesiaNER(IndonesiaNER.MODEL.YUSUFS);
        gson=new Gson();
    }

    public List<TextSequence.Words> ner(String text){
        List<TextSequence.Words> words= Lists.newArrayList();
        ArrayList<TextSequence.Sentence> predicted = iner.predictWithEmbeddedModel(text, true);
        predicted.forEach(s -> {
            s.getWords().forEach(w -> {
                words.add(w);
            });
        });
        return words;
    }
    public String nerJson(String text){
        // "Jokowi pergi ke Singapura."
        return gson.toJson(ner(text));
    }
}
