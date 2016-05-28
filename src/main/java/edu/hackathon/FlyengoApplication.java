package edu.hackathon;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;



@SpringBootApplication
public class FlyengoApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(FlyengoApplication.class, args);
	}
	
	
	   @Override
	    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	        converters.add(extendedJsonConvertor());
	        super.configureMessageConverters(converters);
	    }


	    @Bean
	    public MappingJackson2HttpMessageConverter extendedJsonConvertor() {
	        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
	        mappingJackson2HttpMessageConverter.setObjectMapper(getNullAndEmptyFilteredObjectMapper());
	        return mappingJackson2HttpMessageConverter;
	    }




	    @Bean
	    public ObjectMapper getNullAndEmptyFilteredObjectMapper() {
	        ObjectMapper objectMapper = new ObjectMapper();
	        objectMapper.setSerializationInclusion(Include.NON_EMPTY);
	        objectMapper.setSerializationInclusion(Include.NON_NULL);        
	        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
	        objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
	        objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);   
	        return objectMapper;
	    }
}
