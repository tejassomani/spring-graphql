package com.tej.gqlservices;

import com.base.process.GqlSchemaGeneratorUtils;
import com.tej.resolvers_fetchers.CourseDataFetcher;
import com.tej.resolvers_fetchers.InstructorDataFetcher;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class SchemaWiringServiceImpl {

    @Autowired
    private InstructorDataFetcher instructorDataFetcher;

    @Autowired
    private CourseDataFetcher courseDataFetcher;

    public ExecutionResult executeQuery(final String query) {
        GraphQL gql = buildGraphQL();
        return gql.execute(query);
    }

    private GraphQL buildGraphQL() {
        //todo get from resource folder the fileName
        //final File schemaFile = new File("src/main/java/com/tej/gqlservices/instructor-class-schema.graphqls");

        //parse schema file and get type definition
        final SchemaParser schemaParser = new SchemaParser();
        String schema = GqlSchemaGeneratorUtils.getInputSchema();
        final TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(schema);

        final GraphQLSchema graphQLSchema = new SchemaGenerator().
                makeExecutableSchema(typeDefinitionRegistry, buildWiring());
        return GraphQL.newGraphQL(graphQLSchema).build();
    }

    private RuntimeWiring buildWiring() {
        return  RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("instructors", instructorDataFetcher)
                        .dataFetcher("instructor", instructorDataFetcher))
                .type("Instructor", typeWiring -> typeWiring
                        .dataFetcher("classes", courseDataFetcher))
                .build();
    }
}
