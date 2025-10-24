package pe.upc.edu.notecodeapiplatform.codesharing.domain.services;

import pe.upc.edu.notecodeapiplatform.codesharing.domain.model.aggregates.CodeSnippet;
import pe.upc.edu.notecodeapiplatform.codesharing.domain.model.queries.GetCodeSnippetByIdQuery;
import pe.upc.edu.notecodeapiplatform.codesharing.domain.model.queries.GetCodeSnippetByShareUrlQuery;

import java.util.Optional;

public interface CodeSnippetQueryService {
    Optional<CodeSnippet> handle(GetCodeSnippetByIdQuery query);
    Optional<CodeSnippet> handle(GetCodeSnippetByShareUrlQuery query);
}
