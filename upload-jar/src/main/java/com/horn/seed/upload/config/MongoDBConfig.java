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

	@Value("${spring.data.mongodb.host}")
	private String host;

	@Value("${spring.data.mongodb.database}")
	private String dbName;

	@Value("${spring.data.mongodb.port}")
	private int port;
	
/*	@Value("${spring.data.mongodb.uri}")
	private String uri;*/
	
	@Override
	@Bean
	public MongoClient mongoClient() {
		return new MongoClient(host, port);
		//return new MongoClient(uri);
		
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
