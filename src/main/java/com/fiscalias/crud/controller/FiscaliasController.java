package com.fiscalias.crud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiscalias.crud.model.Fiscalia;
import com.fiscalias.crud.repository.FiscaliaRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class FiscaliasController {
	 /*
    metodos crud
 */
	@Autowired
	FiscaliaRepository fiscaliaRepository;

	@GetMapping("/fiscalias")
	public ResponseEntity<List<Fiscalia>> getAllFiscalias(@RequestParam(required = false) String agencia) {
		try {
			List<Fiscalia> fiscalias = new ArrayList<Fiscalia>();

			if (agencia == null)
				fiscaliaRepository.findAll().forEach(fiscalias::add);
			else
				fiscaliaRepository.findByAgencia(agencia).forEach(fiscalias::add);

			if (fiscalias.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(fiscalias, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/fiscalias/{id}")
	public ResponseEntity<Fiscalia> getFiscaliaById(@PathVariable("id") long id_fiscalia) {
		Optional<Fiscalia> fiscaliaData = fiscaliaRepository.findById(id_fiscalia);

		if (fiscaliaData.isPresent()) {
			return new ResponseEntity<>(fiscaliaData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/fiscalias")
	public ResponseEntity<Fiscalia> createFiscalia(@RequestBody Fiscalia fiscalia) {
		try {
			Fiscalia _fiscalia = fiscaliaRepository.save(new Fiscalia(fiscalia.getAgencia(), fiscalia.getCodigo(),
					fiscalia.getTipo(), fiscalia.getDepartamento(), fiscalia.getMunicipio(), fiscalia.getTelefono(),
					fiscalia.getDatetime()));
			return new ResponseEntity<>(_fiscalia, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PutMapping("/fiscalias/{id}")
	public ResponseEntity<Fiscalia> updateFiscalia(@PathVariable("id") long id, @RequestBody Fiscalia fiscalia) {
		Optional<Fiscalia> data = fiscaliaRepository.findById(id);

		if (data.isPresent()) {
			Fiscalia _fiscalia = data.get();
			_fiscalia.setAgencia(fiscalia.getAgencia());
			_fiscalia.setCodigo(fiscalia.getCodigo());
			_fiscalia.setTipo(fiscalia.getTipo());
			_fiscalia.setDepartamento(fiscalia.getDepartamento());
			_fiscalia.setMunicipio(fiscalia.getMunicipio());
			_fiscalia.setTelefono(fiscalia.getTelefono());
			return new ResponseEntity<>(fiscaliaRepository.save(_fiscalia), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/fiscalias/{id}")
	public ResponseEntity<HttpStatus> deleteFiscalia(@PathVariable("id") long id) {
		try {
			fiscaliaRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@DeleteMapping("/fiscalias")
	public ResponseEntity<HttpStatus> deleteAllFiscalias() {
		try {
			fiscaliaRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}

	}

}