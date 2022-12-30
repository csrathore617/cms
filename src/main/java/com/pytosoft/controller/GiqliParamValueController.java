package com.pytosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pytosoft.model.GiqliParamValue;
import com.pytosoft.service.GiqliParamValueService;

@Controller
@RequestMapping("/giqli")
public class GiqliParamValueController {

	@Autowired
	private GiqliParamValueService giqliParamValueService;
	
	@PostMapping("/updateparams")
	public ResponseEntity<GiqliParamValue> addGiqliParamValue(@RequestBody GiqliParamValue giqliParamValue) {
		GiqliParamValue saved = giqliParamValueService.saveGiqli(giqliParamValue);
		return new ResponseEntity<GiqliParamValue>(saved,HttpStatus.OK);
	}

//	@GetMapping("/params")
//	public ResponseEntity<List<GiqliParamValue>> getAllGiqliParamValue() {
//		List<GiqliParamValue> giqliParams = giqliParamValueService.getAllGiqliParamValue();
//
//		return new ResponseEntity<List<GiqliParamValue>>(HttpStatus.OK);
//	}

	@GetMapping("/paramsvalue/{id}")
	public ResponseEntity<GiqliParamValue> get(@PathVariable Long id) {
		GiqliParamValue giqliParamValue = giqliParamValueService.getGiqliParamValueById(id);
		giqliParamValueService.saveGiqli(giqliParamValue);
		return new ResponseEntity<GiqliParamValue>(giqliParamValue, HttpStatus.NOT_FOUND);
	}

//	@PutMapping("/paramsGiqli")
//	public GiqliParamValue updateGIQLIParamValue(@RequestBody GiqliParamValue giqliParamValue,
//			@PathVariable("id") Long id) {
//		return giqliParamValueService.updateGiqliParamValue(giqliParamValue, id);
//
//	}


	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {

		giqliParamValueService.delete(id);
 
	return new ResponseEntity<String>("deleted"+id,HttpStatus.OK);
	}
}
