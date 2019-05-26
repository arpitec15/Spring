package com.microservice.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservice.moviecatalogservice.models.CatalogItem;
import com.microservice.moviecatalogservice.models.Movie;
import com.microservice.moviecatalogservice.models.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

//	@Autowired
//	RestTemplate restTemplate;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(String userId) {
		RestTemplate restTemplate = new RestTemplate();

		List<Rating> ratings = Arrays.asList(new Rating("1234", 4), new Rating("5678", 3));

		
		  return ratings.stream() .map(rating -> { Movie movie =
		  restTemplate.getForObject("http://localhost:8086/movies/" + rating.getMovieId(), Movie.class); 
		  return new CatalogItem(movie.getName(),"Description", rating.getRating()); 
		  })
				  .collect(Collectors.toList());
		 

//		for each movie id, call movie info service and get details
//		Put them all together

		
//		  return Collections.singletonList( new
//		  CatalogItem("Shri Ramchandra","Fatehgarh" , 4));
		 

	}

}
