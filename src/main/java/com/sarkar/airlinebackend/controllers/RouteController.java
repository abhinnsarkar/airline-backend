package com.sarkar.airlinebackend.controllers;

import com.sarkar.airlinebackend.handlers.Route.GetRoutesHandler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/route")
@Tag(name = "route", description = "Operations related to customers")
public class RouteController {
    @Autowired
    GetRoutesHandler getRoutesHandler;
}
