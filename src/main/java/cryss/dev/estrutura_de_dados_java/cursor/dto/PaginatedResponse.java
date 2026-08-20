package cryss.dev.estrutura_de_dados_java.cursor.dto;

import java.util.List;

// Resposta da API Envelopada
public record PaginatedResponse<T>(List<T> data, String nextCursor){}