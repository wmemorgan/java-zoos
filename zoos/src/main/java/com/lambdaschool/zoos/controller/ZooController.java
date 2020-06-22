package com.lambdaschool.zoos.controller;

import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/zoos")
public class ZooController {

    /**
     * Using the Zoo service to process zoo data
     */
    @Autowired
    private ZooService zooService;

    /**
     * List of all zoos
     * <br>Example: <a href="http://localhost:2019/zoos/zoos">http://localhost:2019/zoos/zoos</a>
     *
     * @return JSON List of all the roles and their associated zoos
     * @see ZooService#findAll() ZooService.findAll()
     */
    @GetMapping(value="/zoos", produces = {"application/json"})
    public ResponseEntity<?> listAllZoos() {
        List<Zoo> zooList = zooService.findAll();

        return new ResponseEntity<>(zooList, HttpStatus.OK);
    }

    /**
     * Returns a single user based off a user id number
     * <br>Example: http://localhost:2019/zoos/zoo/3
     *
     * @param zooid The primary key of the user you seek
     * @return JSON object of the user you seek
     * @see ZooService#findZooById(long) (long) ZooService.findZooById(long)
     */
    @GetMapping(value = "/zoo/{zooid}", produces = {"application/json"})
    public ResponseEntity<?> findZooById(@PathVariable long zooid) {
        Zoo z = zooService.findZooById(zooid);

        return new ResponseEntity<>(z, HttpStatus.OK);
    }

    /**
     * Given a complete Zoo Object, create a new Zoo record and accompanying telephone records
     * and animal records.
     * <br> Example: <a href="http://localhost:2019/zoos/zoo">http://localhost:2019/zoos/zoo</a>
     *
     * @param newZoo A complete new zoo to add including telephone numbers and animals.
     *                animals must already exist.
     * @return A location header with the URI to the newly created zoo and a status of CREATED
     * @throws URISyntaxException Exception if something does not work in creating the location header
     * @see ZooService#save(Zoo) ZooService.save(Zoo)
     */
    @PostMapping(value = "/zoo", consumes = {"application/json"})
    public ResponseEntity<?> addZoo(@Valid @RequestBody Zoo newZoo) {
        newZoo.setZooid(0);
        newZoo = zooService.save(newZoo);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newZooURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{newzooid}")
                .buildAndExpand(newZoo.getZooid())
                .toUri();
        responseHeaders.setLocation(newZooURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }


    /**
     * Given a complete Zoo Object
     * Given the zoo id, primary key, is in the Zoo table,
     * replace the Zoo record, telephone records, and animal records.
     * Roles are handled through different endpoints
     * <br> Example: <a href="http://localhost:2019/zoos/zoo/15">http://localhost:2019/zoos/zoo/15</a>
     *
     * @param replacedZoo A complete Zoo including all emails and roles to be used to
     *                   replace the Zoo. Roles must already exist.
     * @param zooid     The primary key of the zoo you wish to replace.
     * @return status of OK
     * @see ZooService#save(Zoo) ZooService.save(Zoo)
     */
    @PutMapping(value = "/zoo/{zooid}", consumes = {"application/json"})
    public ResponseEntity<?> replaceZoo(@Valid @RequestBody Zoo replacedZoo, @PathVariable long zooid) {
        replacedZoo.setZooid(zooid);
        zooService.save(replacedZoo);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Updates the zoo record associated with the given id with the provided data. Only the provided fields are affected.
     * If a telephone list is given, it adds any new records not in the previous list
     * <br> Example: <a href="http://localhost:2019/zoos/zoo/7">http://localhost:2019/zoos/zoo/7</a>
     *
     * @param updatedZoo An object containing values for just the fields that are being updated. All other fields are left NULL.
     * @param zooid         The primary key of the zoo you wish to update.
     * @return A status of OK
     * @see ZooService#update(Zoo, long)  ZooService.update(Zoo, long)
     */
    @PatchMapping(value = "/zoo/{zooid}", consumes = {"application/json"})
    public ResponseEntity<?> updateZoo(@Valid @RequestBody Zoo updatedZoo, @PathVariable long zooid) {
        zooService.update(updatedZoo, zooid);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
