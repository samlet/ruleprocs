package sagas.langs.id;

import com.google.common.collect.Lists;
import yusufs.nlp.nerid.utils.TextSequence;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/ner")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class IndonesiaNerService {
    @Inject
    IndonesiaNer indonesiaNer;

    /**
     * curl -d '{"sents":"Jokowi pergi ke Singapura."}' \
     *         -H "Content-Type: application/json" -X POST \
     *         localhost:8080/ner
     * @param text
     * @return
     */
    @POST
    public List<TextSequence.Words> entities(String text){
        return indonesiaNer.ner(text);
    }

    @Path("/tests")
    @GET
    public List<String> tests(){
        return Lists.newArrayList("hello", "world");
    }
}

