package sagas.rules;

import org.junit.Test;
import sagas.langs.id.IndonesiaNer;
import yusufs.nlp.nerid.IndonesiaNER;
import yusufs.nlp.nerid.utils.TextSequence;

import java.util.ArrayList;

public class IndonesiaTests {
    @Test
    public void testIdNer(){
        IndonesiaNER iner = new IndonesiaNER(IndonesiaNER.MODEL.YUSUFS);
        ArrayList<TextSequence.Sentence> predicted = iner.predictWithEmbeddedModel("Jokowi pergi ke Singapura.", true);
        predicted.forEach(s -> {
            s.getWords().forEach(w -> {
                System.out.println(w);
            });
        });

    }

    @Test
    public void testNerJson(){
        System.out.println(new IndonesiaNer().nerJson("Jokowi pergi ke Singapura."));
    }
}
