package com.lmig.moviedb;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.test.context.ContextConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={MovieApp.class})
@RestController
@EnableWebMvc

public class MovieRestControllerTest {
    //private static final String TestUtil = null;
    @Autowired
    private WebApplicationContext wac;
    @InjectMocks
    private MovieRestController movierestcontroller;
     private MockMvc mockMvc;
    private Object action;

      @Before
        public void setup() {
         // Process mock annotations
           MockitoAnnotations.initMocks(this);
            this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        }

    //@Test
    // public void getMovie() throws Exception  {
    //    this.mockMvc.perform(get("/api/addMovie")).andExpect(status().is2xxSuccessful());
        
        //fail("Not yet implemented");
    //}
      @Test 
        public void testMoviePost() throws Exception { 
     
//            int movieId = 1; 
     
            mockMvc.perform( 
                    post("/api/addMovie2")) 
                    .andExpect(MockMvcResultMatchers.status().isOk()) 
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON)) 
                    .andExpect(jsonPath("data.genre", is("documentary"))) 
                    .andExpect(jsonPath("data.language", is("english"))) 
//                    .andExpect(jsonPath("data.id", is(movieId))) 
                    .andExpect(jsonPath("data.movie",is("some other war movie")))
                    .andExpect(jsonPath("data.person",is("someguy")))
                    .andExpect(jsonPath("data.rating",is("PG-13")))
                    .andExpect(jsonPath("data.score",is(7)))
                    .andExpect(jsonPath("data.year",is(2100)))
                    .andExpect(jsonPath("success", is(true))); 
        } 
      
//       @Test 
//        public void testSave() throws Exception { 
//            mockMvc.perform( 
//                post("/api/addMovie") 
//                 //           .contentType(TestUtil.APPLICATION_JSON_UTF8) 
//                   //         .content(TestUtil.convertObjectToJsonBytes(new User())) 
//            ) 
//                    .andExpect(MockMvcResultMatchers.status().isOk()) ;
                  //  .andExpect(content().contentType(MediaType.APPLICATION_JSON)) 
                  //  .andExpect(jsonPath("success", is(true))); 
//        } 
      
    //@Test
    //public void testMoiveDelete() throws Exception {
    //this.mockMvc.perform(
            //    delete("/api/deleteMovie/33"))
            //    .andExpect(MockMvcResultMatchers.status().isOk());
                
                    
    }