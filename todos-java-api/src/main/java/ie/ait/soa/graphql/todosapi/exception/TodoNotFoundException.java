package ie.ait.soa.graphql.todosapi.exception;

import graphql.ErrorClassification;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;

public class TodoNotFoundException extends RuntimeException implements GraphQLError {
    @Override
    public List<SourceLocation> getLocations() {
        return List.of(SourceLocation.EMPTY);
    }

    @Override
    public ErrorClassification getErrorType() {
        return ErrorType.DataFetchingException;
    }
}
