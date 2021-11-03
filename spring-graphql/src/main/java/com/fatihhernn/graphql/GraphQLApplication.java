package com.fatihhernn.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * {@link com.coxautodev.graphql.tools.GraphQLQueryResolver} //sunucudaki kayıtları sorhulamak için bunu kullanacağız
 * {@link com.coxautodev.graphql.tools.GraphQLMutationResolver} sunucudaki resourceları veriyi değiştirmek üzerine
 *  kurulu olan kayıtları
 */
@SpringBootApplication
public class GraphQLApplication {
        public static void main(String[] args) {
            SpringApplication.run(GraphQLApplication.class,args);
        }
}
