package com.horn.seed.upload.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import com.mongodb.MongoClient;

/**
 * @author Abhishek
 *
 */

@Configuration
public class MongoDBConfig extends AbstractMongoConfiguration {

	@Value(value = "spring.data.mongodb.host")
	private String host;

	@Value(value = "spring.data.mongodb.database")
	private String dbName;

	@Value(value = "spring.data.mongodb.port")
	private int port;
	
	@Override
	@Bean
	public MongoClient mongoClient() {
		return new MongoClient(host, port);
	}

	@Override
	protected String getDatabaseName() {
		return dbName;
	}

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoClient(), getDatabaseName());
    }

    @Bean
    public GridFsTemplate gridFsTemplate() throws Exception {
        return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
    }
}
