package ie.ait.soa.graphql.todosapi.exception;

import graphql.GraphQLException;

public class TodoNotFoundException extends GraphQLException {

    public TodoNotFoundException(Long invalidTodoId) {
        super(String.format("Todo id %s not found", invalidTodoId));
    }

}
