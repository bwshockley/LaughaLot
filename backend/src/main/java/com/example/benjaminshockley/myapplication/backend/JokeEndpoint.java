package com.example.benjaminshockley.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "jokeApi",
        version = "v1",
        resource = "joke",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.benjaminshockley.example.com",
                ownerName = "backend.myapplication.benjaminshockley.example.com",
                packagePath = ""
        )
)
public class JokeEndpoint {

    @ApiMethod(name = "getJoke")
    public Joke getJoke() {
        Joke theJoke = Joke.getRandomJoke();

        return theJoke;
    }
}