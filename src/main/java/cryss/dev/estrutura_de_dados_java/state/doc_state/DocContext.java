package cryss.dev.estrutura_de_dados_java.state.doc_state;

import lombok.Setter;

import java.util.Objects;

public class DocContext {

    private DocState state;
    private DocUser user;
    @Setter
    private Boolean aprovedByAdmin;

    public DocContext(DocUser user) {
        this.state = new Draft (this);
        this.user = user;
    }

    private void setState(DocState state) {
        this.state = state;
    }

    public void publish(){
        state.publish();
    }

    public Boolean isAdmin() {
        return "ADMIN".equals (user.getRole ());
    }

    public void changeState(DocState newState) {
        this.setState (newState);
    }

    public String getUsarId() {
        return user.getId ();
    }


    public void approveByAdmin(){
         this.setAprovedByAdmin (Boolean.TRUE);
    }

    private Boolean getApprovedByAdmin() {
        return aprovedByAdmin;
    }

    public Boolean isApprovedByAdmin() {
        return Objects.nonNull (this.getApprovedByAdmin ()) ?  this.getApprovedByAdmin () : Boolean.FALSE;
    }

    private DocState getState() {
        return state;
    }

    private String getStateName(){
        return this.getState ().getClass ().getName ();
    }

    public String getCurrentState(){
        return this.getStateName ();
    }
}
