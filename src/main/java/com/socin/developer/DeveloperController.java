package com.socin.developer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

@RestController
public class DeveloperController {
    private static final Logger log = LoggerFactory.getLogger(DeveloperController.class);
    private static final String messageReturn = "Não foi possível retornar as informações dos desenvolvedores.";

    private final DeveloperService developerService;

    @Autowired
    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @RequestMapping(value = "/developers/{page}",
            method = RequestMethod.GET, produces = "application/json" )
    public ResponseEntity<?> findDevelopers(@PathVariable Integer page) {
        try {
            return ResponseEntity.ok(developerService.findDevelopers(page));
        } catch (ClassCastException e) {
            return new ResponseEntity(messageReturn, HttpStatus.BAD_GATEWAY);

        } catch (HttpStatusCodeException e) {
            log.warn(e.getMessage());
            return new ResponseEntity(messageReturn, HttpStatus.BAD_GATEWAY);
        } catch (Exception e) {
            log.warn(e.getMessage());
            return new ResponseEntity(messageReturn, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/developers-custom",
            method = RequestMethod.GET, produces = "application/json" )
    public ResponseEntity<?> findDevelopersCustom(@RequestParam Integer draw,
                                                  @RequestParam("start") Integer startPage,
                                                  @RequestParam("length") Integer lengthPage) {

        try {
            return ResponseEntity.ok(developerService.findCustomDevelopers(draw, startPage, lengthPage));
        } catch (ClassCastException e) {
            return new ResponseEntity(messageReturn, HttpStatus.BAD_GATEWAY);

        } catch (HttpStatusCodeException e) {
            log.warn(e.getMessage());
            return new ResponseEntity(messageReturn, HttpStatus.BAD_GATEWAY);
        } catch (Exception e) {
            log.warn(e.getMessage());
            return new ResponseEntity(messageReturn, HttpStatus.NOT_FOUND);
        }
    }
}
