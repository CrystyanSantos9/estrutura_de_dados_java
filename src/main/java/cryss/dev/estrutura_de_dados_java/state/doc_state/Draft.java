package cryss.dev.estrutura_de_dados_java.state.doc_state;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Draft implements DocState {

    private final DocContext context;

    public Draft(DocContext context) {
        this.context = context;
    }

    @Override
    public void publish() {
        try{
            if(context.isAdmin()){
                context.changeState (new Published(context));
            }else{
                context.changeState (new Moderation(context));
            }
        }catch (Exception e){
            log.info ("Error ocurred in method={}, for context={}", "publish", context);
        }
    }
}
