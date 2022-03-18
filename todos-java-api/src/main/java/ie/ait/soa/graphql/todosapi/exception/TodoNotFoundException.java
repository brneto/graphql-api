package ie.ait.soa.graphql.todosapi.exception;

import graphql.ErrorClassification;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;
import java.util.Map;

public class TodoNotFoundException extends RuntimeException implements GraphQLError {

    private Map<String, Object> extensions;

    public TodoNotFoundException(Long invalidTodoId) {
        this.extensions = Map.of("invalidTodoId", invalidTodoId);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return List.of(SourceLocation.EMPTY);
    }

    @Override
    public ErrorClassification getErrorType() {
        return ErrorType.DataFetchingException;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }
}
