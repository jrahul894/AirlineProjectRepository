//package com.Airline.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.Airline.Dto.AddRouteDto;
//import com.Airline.Entities.Route;
//import com.Airline.service.RouteService;
//
//@RestController
//@RequestMapping("/route")
//public class RouteController {
//
//	@Autowired
//	private RouteService route;
//	
//	@PostMapping("/add")
//	public ResponseEntity<?> addRoute(@RequestBody AddRouteDto dto ){
//		return ResponseEntity.status(HttpStatus.ACCEPTED).body(route.insertRoute(dto));
//	}
//	@DeleteMapping("/route/{routeId}")
//	public ResponseEntity<?>deleteRoute(@PathVariable Long routeId){
//		return ResponseEntity.status(HttpStatus.OK).body(route.removeRoute(routeId));
//		
//	}
//	@GetMapping("/all/{flightId}") // not working
//	public List<Route>getAllRoute(@PathVariable Long flightId){
//		return route.findAllRoute(flightId);
//		
//	}
//	@PutMapping("/update/{routeId}")
//	public ResponseEntity<?> updateRoute(@RequestBody AddRouteDto dto, @PathVariable Long routeId){
//		route.modifyRoute(dto,routeId);
//		return new ResponseEntity<>("route updated",HttpStatus.CREATED);
//		
//	}
//}
