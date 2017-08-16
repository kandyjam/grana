package hu.papai.grana.controller;

import hu.papai.grana.model.DictionaryKey;
import hu.papai.grana.service.DictionaryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dictionary")
public class DictionaryController {

    private final DictionaryService service;

    public DictionaryController(DictionaryService service) {
        this.service = service;
    }

    /**
     * Retrieves all dictionary keys and values from the database. If key param is present, only those values will be
     * retrieved which key is present in the request.
     * @param keys Optional, if present, only those values will be retrieved which belong to the key.
     * @return Map of keys and their corresponding values.
     */
    @GetMapping
    public Map<DictionaryKey, Collection<String>> findAll(@RequestParam(value = "key", required = false) String[] keys) {
        if (keys == null) {
            return service.findAll();
        }
        List<DictionaryKey> dictKeys = Arrays.stream(keys).map(DictionaryKey::valueOf).collect(Collectors.toList());
        return service.findAll(dictKeys);
    }
}
