package cryss.dev.estrutura_de_dados_java.patterns.revisiting.chainofreponsability.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserProfile {

    private String name;
    private String id;
    private boolean allowsGoogle;
    private boolean allowsEmail;
    private boolean allowsSMS;

    public boolean hasGoogleWalletPass() {
        return allowsGoogle;
    }

    public boolean allowsEmail() {
        return allowsEmail;
    }

    public boolean allowsSMS() {
        return allowsSMS;
    }
}
