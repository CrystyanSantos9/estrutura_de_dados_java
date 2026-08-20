package cryss.dev.estrutura_de_dados_java.cursor.service;

import cryss.dev.estrutura_de_dados_java.cursor.domain.CursorToken;
import cryss.dev.estrutura_de_dados_java.cursor.domain.UserCursor;
import cryss.dev.estrutura_de_dados_java.cursor.dto.PaginatedResponse;
import cryss.dev.estrutura_de_dados_java.cursor.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private static final long CURSOR_EXPIRATION_MS = 60 * 1000; //1 minuto em milessegundos
    private final UserRepository repository;


    public cryss.dev.estrutura_de_dados_java.cursor.dto.PaginatedResponse<UserCursor> getUsers(String cursor, int limit) {
        Long baseId = 0L; //valor padrão para ser usado quando não houver cursor informado

        if(cursor!=null && !cursor.isBlank ()){
            //decodifica para objeto cursor
            CursorToken token = CursorToken.decode (cursor);

            //Validando o valor noce para garantir a integridade da sessão ( integridade temporal )
            long currentTime = System.currentTimeMillis ();
            if(currentTime - token.nonce () > CURSOR_EXPIRATION_MS){
                throw new IllegalStateException("Sua sessão de paginação expirou. Recomece da primeira página.");
            }
            //troca o base id caso a sessão ainda exista
            baseId = token.baseId();
        }

        //limit = quantidade de itens por página = 10 + 1 --> user.id > cursorInformado?
        // Busca um registro a mais (limit + 1) para saber se existe uma próxima página
        List<UserCursor> itens = repository
                .findNextPage(baseId, PageRequest.of(0, limit + 1));

        //checa se a quantidade de itens retornados do banco é maior do que o limit
        boolean temProxima = itens.size () > limit;
        String proximoCursor = null;

        if(temProxima){
            //Remove o registro adicional usado para verificação
            itens.remove (itens.size ()-1);

            //Pega o id que será usado para o novo cursor
            //Esse id será o id do último registro da página consultada
            Long novoBaseId = itens.get (itens.size ()-1).getId ();

// GERA O NOVO NONCE (Timestamp atual) e encapsula no token
            long novoNonce = System.currentTimeMillis();
            proximoCursor = new CursorToken(novoBaseId, novoNonce).encode();
        }
        return new cryss.dev.estrutura_de_dados_java.cursor.dto.PaginatedResponse<> (itens, proximoCursor);
    }
}
