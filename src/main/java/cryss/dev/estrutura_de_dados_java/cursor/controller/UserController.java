package cryss.dev.estrutura_de_dados_java.cursor.controller;

import cryss.dev.estrutura_de_dados_java.cursor.domain.UserCursor;
import cryss.dev.estrutura_de_dados_java.cursor.dto.PaginatedResponse;
import cryss.dev.estrutura_de_dados_java.cursor.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    public ResponseEntity<PaginatedResponse<UserCursor>> list(
            @RequestParam(required = false) String cursor,
            @RequestParam(defaultValue = "10") int limit
    ){
        return ResponseEntity.ok (service.getUsers(cursor, limit));
    }

}


