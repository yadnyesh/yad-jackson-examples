package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

@JsonTest
@Slf4j
class BeerDtoTest extends BaseTest{

	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	void testSerializationDto() throws JsonProcessingException {
		BeerDto beerDto = getDto();
		String jsonString = objectMapper.writeValueAsString(beerDto);
		log.info(jsonString);
	}
	
	@Test
	void TestDeserialize() throws IOException {
		String json = "{\"id\":\"ee3d6198-68f3-4c6e-a11b-54bce228f765\",\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123123123123,\"price\":12.99,\"createdDate\":\"2020-04-04T20:14:37.794006+05:30\",\"lastUpdatedDate\":\"2020-04-04T20:14:37.794068+05:30\"}";
		BeerDto beerDto = objectMapper.readValue(json, BeerDto.class);
		log.info(beerDto.toString());
		
	}
	
}